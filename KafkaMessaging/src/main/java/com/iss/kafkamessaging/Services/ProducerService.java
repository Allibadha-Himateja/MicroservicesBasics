package com.iss.kafkamessaging.Services;
import com.iss.kafkamessaging.Models.Product;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.boot.json.JsonParser;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    //key and value(topic and message)
    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

//    public void sendMessage(String topic, String message) {
//        kafkaTemplate.send(topic, message);
//    }

    public void sendProduct(String topic,Product product)
    {
        kafkaTemplate.send(topic,product);
    }
}
