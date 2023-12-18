package com.wepdemo.controller;

import com.wepdemo.entities.TopicType;
import com.wepdemo.request.TopicTypeRequest;
import com.wepdemo.service.TopicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic-type")
public class TopicTypeController {
    @Autowired
    private TopicTypeService topicTypeService;

    @GetMapping("/type-find-all")
    public List<TopicType> findAll(){
        List<TopicType> listTopicType = topicTypeService.findAll();
        return listTopicType;

    }
    @GetMapping("/type-find-id")
    public TopicType getTopicTypById(@RequestParam Long topicTypeId){
       TopicType topicType = topicTypeService.findById(topicTypeId);
       return topicType;
    }
    @PostMapping("/type-update")
    public TopicType updateTopicType(@RequestBody TopicTypeRequest topicTypeRequest){
        TopicType topicType = topicTypeService.updateTopicType(topicTypeRequest);
        return topicType;
    }
    @PostMapping("/type-create")
    public  TopicType createTopicType(@RequestBody TopicTypeRequest topicTypeRequest){
        TopicType topicType = topicTypeService.createTopictype(topicTypeRequest);
        return topicType;
    }
    @PostMapping("/type-delete")
    public String deleteTopicType(@RequestBody TopicTypeRequest topicTypeRequest){
        topicTypeService.deleteTopicType(topicTypeRequest.getTopicTypeId());
        return "TopicType";
    }


}
