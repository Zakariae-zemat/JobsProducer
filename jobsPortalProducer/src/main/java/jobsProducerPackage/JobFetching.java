package jobsProducerPackage;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class JobFetching {

    private final String API_URL = "https://api.adzuna.com/v1/api/jobs/us/search/1";
    private final String APP_ID = "ad87cad3"; 
    private final String APP_KEY = "0fc28f1da5e87ef57328c6b5496ce0e4";

    @Autowired
    private RestTemplate restTemplate;

    public List<Job> fetchJobs() throws Exception {
        String url = API_URL + "?app_id=" + APP_ID + "&app_key=" + APP_KEY + "&results_per_page=50";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = mapper.readValue(response.getBody(), Map.class);
        List<Job> jobs = new ArrayList<>();
        List<Map<String, Object>> results = (List<Map<String, Object>>) data.get("results");
        for (Map<String, Object> jobMap : results) {
            Job job = new Job();
            job.setId((String) jobMap.get("id"));
            job.setTitle((String) jobMap.get("title"));
            job.setDescription((String) jobMap.get("description"));
            job.setLocation((String) ((Map<String, Object>) jobMap.get("location")).get("display_name"));
            job.setCompany((String) ((Map<String, Object>) jobMap.get("company")).get("display_name"));
            job.setSalary_min((Number) jobMap.get("salary_min"));
            job.setSalary_max((Number) jobMap.get("salary_max"));
            job.setCreated((String) jobMap.get("created"));
            job.setCategory((String) ((Map<String, Object>) jobMap.get("category")).get("tag"));
            jobs.add(job);
        }
        return jobs;
    }
}
