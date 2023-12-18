package com.wepdemo.repository;

import com.wepdemo.entities.TopicDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicDetailRepository extends JpaRepository<TopicDetail,Long> {
}
