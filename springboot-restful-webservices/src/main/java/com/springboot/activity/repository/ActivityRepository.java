package com.springboot.activity.repository;

import com.springboot.activity.entity.ActivityEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository {
    Integer calculateTotalValueForSpecificActivity(String key);
    Boolean addValueForSpecificActivity(ActivityEntity activityEntity);
}
