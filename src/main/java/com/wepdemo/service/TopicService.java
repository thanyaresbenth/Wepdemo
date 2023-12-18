package com.wepdemo.service;

import com.wepdemo.entities.Topic;
import com.wepdemo.entities.TopicType;
import com.wepdemo.repository.TopicRepository;
import com.wepdemo.repository.TopicTypeRepository;
import com.wepdemo.request.TopicRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private TopicTypeRepository topicTypeRepository;

    public List<Topic> finAll(){
        List<Topic> listTopic = topicRepository.findAll();
        return listTopic;
    }
    public Topic findById(Long topicId){
        Topic topic = topicRepository.findById(topicId).orElse(null);
        return topic;

    }
    public Topic updateTopic(TopicRequest topicRequest){
        Long topicId = topicRequest.getTopicId();
        Long topicTypeId = topicRequest.getTopicTypeId();
        Topic topic = topicRepository.findById(topicId).orElse(null);
        System.out.println(topicTypeId);

        if(topicTypeId != null){
            TopicType topicType = topicTypeRepository.findById(topicTypeId).orElse(null);
            topic.setTopicType(topicType);
        }
        if(!StringUtils.isEmpty(topicRequest.getTopicUrlImage())){
            topic.setTopicUrlImage(topicRequest.getTopicUrlImage());
        }
        if(!StringUtils.isEmpty(topicRequest.getTopicName())){
        topic.setTopicName(topicRequest.getTopicName());
        }

        topicRepository.save(topic);
        return topic;
    }
    public Topic createTopic(TopicRequest  topicRequest){
        Topic topic = new Topic();
        Long topicTypeId = topicRequest.getTopicTypeId();

        if(topicTypeId  !=  null){
        TopicType topicType = topicTypeRepository.findById(topicTypeId).orElse(null);
        topic.setTopicType(topicType);
        }
        topic.setTopicId(topicRequest.getTopicId());
        topic.setTopicName(topicRequest.getTopicName());
        topic.setTopicUrlImage(topicRequest.getTopicUrlImage());

        topicRepository.save(topic);
        return topic;

    }
    public void deleteTopic(Long topicId){
        topicRepository.deleteById(topicId);
    }




}
