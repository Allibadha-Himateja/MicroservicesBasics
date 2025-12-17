package com.iss.kafkamessaging.Controllers;

import com.iss.kafkamessaging.Models.Product;
import com.iss.kafkamessaging.Services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private ProducerService producerService;

//    @PostMapping("/send/{message}")
//    public void sendMessage(@PathVariable String message)
//    {
//        producerService.sendMessage("Chat", message);
//    }

    @PostMapping("/sendProduct")
    public void sendProduct(@RequestBody Product product)
    {
        System.out.println(product);
        producerService.sendProduct("Chat",product);
    }
}
