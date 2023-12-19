package com.wepdemo.service;

import com.wepdemo.entities.Topic;
import com.wepdemo.entities.TopicDetail;
import com.wepdemo.repository.TopicDetailRepository;
import com.wepdemo.repository.TopicRepository;
import com.wepdemo.request.TopicDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TopicDetailService {
    @Autowired
    private TopicDetailRepository topicDetailRepository;
    @Autowired
    private TopicRepository topicRepository;

    public List<TopicDetail> findAll(){
        List<TopicDetail>listTopicDetail = topicDetailRepository.findAll();
        return listTopicDetail;
    }
    public TopicDetail findById(Long topicId){
        TopicDetail topicDetail = topicDetailRepository.findById(topicId).orElse(null);
        return topicDetail;
    }
    public TopicDetail updateTopicDetail(TopicDetailRequest topicDetailRequest){
        Long topicId = topicDetailRequest.getTopicId();
        Long topicDetailId = topicDetailRequest.getTopicDetailId();
        TopicDetail topicDetail = topicDetailRepository.findById(topicDetailId).orElse(null);
      
        if(topicId != null){
            Topic topic = topicRepository.findById(topicId).orElse(null);
            topicDetail.setTopic(topic);
        }

        if(!StringUtils.isEmpty(topicDetailRequest.getTopicEpUrl())){
        topicDetail.setTopicEpUrl(topicDetailRequest.getTopicEpUrl());
        }
        if(!StringUtils.isEmpty(topicDetailRequest.getDetailName())){
        topicDetail.setDetailName(topicDetailRequest.getDetailName());
        }
        topicDetailRepository.save(topicDetail);
        return topicDetail;
    }
    public  TopicDetail cerateTopicDetail(TopicDetailRequest topicDetailRequest){
        TopicDetail topicDetail =new TopicDetail();
        Long topicId = topicDetailRequest.getTopicId();
        Topic topic = topicRepository.findById(topicId).orElse(null);
        topicDetail.setTopic(topic);
        topicDetail.setTopicDetailId(topicDetailRequest.getTopicDetailId());
        topicDetail.setTopicEpUrl(topicDetailRequest.getTopicEpUrl());
        topicDetail.setDetailName(topicDetailRequest.getDetailName());
        topicDetailRepository.save(topicDetail);
        return topicDetail;
    }
    public void  deleteTopicDetial(Long topicDetailId){
        topicDetailRepository.deleteById(topicDetailId);
    }
}
