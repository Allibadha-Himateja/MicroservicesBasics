package com.iss.kafkamessaging.Services;

import com.iss.kafkamessaging.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

//    @KafkaListener(topics = "Chat")
//    public void recieveMessage(String message)
//    {
//        System.out.println("Recieved Message: " + message);
//    }

    @KafkaListener(topics="Chat")
    public void receiveProduct(Product product)
    {
        System.out.println("Received product "+product);
    }
}
