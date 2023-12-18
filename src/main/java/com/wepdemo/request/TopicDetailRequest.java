package com.wepdemo.request;

import lombok.Data;

@Data
public class TopicDetailRequest {
    private Long topicDetailId;
    private String topicEpUrl;
    private String detailName;
}
