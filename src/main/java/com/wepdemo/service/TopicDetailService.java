package com.wepdemo.service;

import com.wepdemo.entities.Topic;
import com.wepdemo.entities.TopicDetail;
import com.wepdemo.repository.TopicDetailRepository;
import com.wepdemo.repository.TopicRepository;
import com.wepdemo.request.TopicDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TopicDetailService {
    @Autowired
    private TopicDetailRepository topicDetailRepository;

    public List<TopicDetail> findAll(){
        List<TopicDetail>listTopicDetail = topicDetailRepository.findAll();
        return listTopicDetail;
    }
    public TopicDetail findById(Long topicId){
        TopicDetail topicDetail = topicDetailRepository.findById(topicId).orElse(null);
        return topicDetail;
    }
    public TopicDetail updateTopicDetail(TopicDetailRequest topicDetailRequest){


    }
}
