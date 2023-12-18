package com.wepdemo.entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name ="topic")
@Data
public class Topic {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long topicId;

      @ManyToOne
      @JoinColumn(name = "topic_type_id")
      private TopicType topicType;

      @Column
      private String topicName;

      @Column
      private String topicUrlImage;

}
