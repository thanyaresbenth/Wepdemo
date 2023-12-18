package com.wepdemo.controller;

import com.wepdemo.entities.Topic;
import com.wepdemo.request.TopicRequest;
import com.wepdemo.request.TopicTypeRequest;
import com.wepdemo.service.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping( "/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/find-all")
    public List<Topic>findAll(){

        List<Topic> listTopic = topicService.finAll();
        return listTopic;
    }

    @GetMapping("/find-by-id")
    public Topic getTopicById(@RequestParam Long topicId){
        System.out.println("test");
        Topic topic = topicService.findById(topicId);
        return  topic;

    }
    @PostMapping("/update-topic")
    public String updateTopic(@RequestBody TopicRequest topicRequest){
        topicService.updateTopic(topicRequest);
        return "topic";
    }
    @PostMapping("/create-topic")
    public String createTopic(@RequestBody TopicRequest topicRequest){
        topicService.createTopic(topicRequest);
        return "topic";
    }
    @PostMapping("/delete-topic")
    public String deleteTopic(@RequestBody TopicRequest topicRequest){
        topicService.deleteTopic(topicRequest.getTopicId());
        return "Topic";
    }
}
