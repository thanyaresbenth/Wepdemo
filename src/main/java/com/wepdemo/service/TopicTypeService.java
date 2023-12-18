package com.wepdemo.service;

import com.wepdemo.entities.TopicType;
import com.wepdemo.repository.TopicTypeRepository;
import com.wepdemo.request.TopicTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TopicTypeService {
    @Autowired
    private TopicTypeRepository topicTypeRepository;

    public List<TopicType> findAll(){
        List<TopicType> listTopicType = topicTypeRepository.findAll();
        return listTopicType;
    }
    public TopicType findById(Long topicTypeId){
        TopicType topicType =topicTypeRepository.findById(topicTypeId).orElse(null);
        return topicType;
    }
    public TopicType updateTopicType(TopicTypeRequest topicTypeRequest){
        Long topicTypeId = topicTypeRequest.getTopicTypeId();
        TopicType topicType = topicTypeRepository.findById(topicTypeId).orElse(null);
        topicType.setTopicTypeName(topicTypeRequest.getTopicTypeName());
        topicTypeRepository.save(topicType);
        return topicType;
    }
    public  TopicType createTopictype(TopicTypeRequest  topicTypeRequest){
        TopicType topicType = new TopicType();
        topicType.setTopicTypeName(topicTypeRequest.getTopicTypeName());
        topicType.setTopicTypeId(topicTypeRequest.getTopicTypeId());
        topicTypeRepository.save(topicType);
        return topicType;
    }
    public  void deleteTopicType(Long topicTypeId){
        topicTypeRepository.deleteById(topicTypeId);
    }
}
