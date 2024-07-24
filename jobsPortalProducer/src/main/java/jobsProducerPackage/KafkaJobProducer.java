package jobsProducerPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaJobProducer {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void sendJobToKafka(Job job) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(job);
    kafkaTemplate.send("jobsportal", json);
  }
}

