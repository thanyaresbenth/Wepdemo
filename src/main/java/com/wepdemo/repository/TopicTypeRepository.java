package com.wepdemo.repository;

import com.wepdemo.entities.TopicType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicTypeRepository extends JpaRepository<TopicType,Long> {
}
