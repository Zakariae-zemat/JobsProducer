package jobsProducerPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private JobFetching jobFetching;
    @Autowired
    private KafkaJobProducer kafkaJobProducer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Job> jobs = jobFetching.fetchJobs();
        ObjectMapper mapper = new ObjectMapper();
        for (Job job : jobs) {
            String jobJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(job);
            System.out.println(jobJson);
            kafkaJobProducer.sendJobToKafka(job);
            System.out.println("Job sent to Kafka topic 'jobsportal' successfully!");
        }
    }
}
