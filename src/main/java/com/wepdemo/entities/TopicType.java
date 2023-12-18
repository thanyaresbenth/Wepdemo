package com.wepdemo.entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "topic_type")
@Data
public class TopicType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicTypeId;

    @Column
    private String topicTypeName;
}
