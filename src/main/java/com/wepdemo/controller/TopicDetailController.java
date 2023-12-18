package com.wepdemo.controller;

import com.wepdemo.entities.Topic;
import com.wepdemo.entities.TopicDetail;
import com.wepdemo.service.TopicDetailService;
import com.wepdemo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/TopicDetail")
public class TopicDetailController {
    @Autowired
    private TopicDetailService topicDetailService;

    @GetMapping("/detail-find-all")
    public List<TopicDetail> findAll(){

        List<TopicDetail> listTopicDetail = topicDetailService.findAll();
        return listTopicDetail;
    }

    @GetMapping("/detail-find-by-id")
    public TopicDetail getTopicDetailById(@RequestParam Long topicDetailId){
        TopicDetail topicDetail = topicDetailService.findById(topicDetailId);
        return  topicDetail;
    }
}
