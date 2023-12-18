package com.wepdemo.request;


import lombok.Data;

@Data
public class TopicRequest {
    private Long topicId;
    private String topicName;
    private String topicUrlImage;
    private Long topicTypeId;
}
