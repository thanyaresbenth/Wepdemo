package com.wepdemo.controller;

import com.wepdemo.entities.Topic;
import com.wepdemo.entities.TopicDetail;
import com.wepdemo.request.TopicDetailRequest;
import com.wepdemo.service.TopicDetailService;
import com.wepdemo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/topicDetail")
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
    @PostMapping("/detail-update")
    public  TopicDetail  updateTopicDetail(@RequestBody TopicDetailRequest topicDetailRequest){
        TopicDetail topicDetail =topicDetailService.updateTopicDetail(topicDetailRequest);
        return  topicDetail;

    }
    @PostMapping("/detail-create")
    public  TopicDetail  createTopicDetail(@RequestBody TopicDetailRequest topicDetailRequest){
        TopicDetail topicDetail = topicDetailService.cerateTopicDetail(topicDetailRequest);
        return  topicDetail;
    }
    @PostMapping("/detail-delete")
    public  String  deleteTopicDetial(@RequestBody  TopicDetailRequest topicDetailRequest){
        topicDetailService.deleteTopicDetial(topicDetailRequest.getTopicDetailId());
        return "delete succes";

    }

}
