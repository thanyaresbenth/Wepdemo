package com.wepdemo.entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "topic_detail")
@Data
public class TopicDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicDetailId;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @Column
    private String topicEpUrl;


    @Column
    private String detailName;
}
