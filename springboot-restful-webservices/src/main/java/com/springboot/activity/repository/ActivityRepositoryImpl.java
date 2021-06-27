package com.springboot.activity.repository;

import com.springboot.activity.entity.ActivityEntity;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ActivityRepositoryImpl implements ActivityRepository {

    public static List<ActivityEntity> activityEntityList = new ArrayList<>();
    
    @Override
    public Integer calculateTotalValueForSpecificActivity(String key) {
      
        activityEntityList = activityEntityList.stream().filter(
            activityEntity -> activityEntity
                .getRequestTime().after(new Timestamp(System.currentTimeMillis() - ( 60 * 1000)))).collect(
            Collectors.toList());
        
        Integer total= activityEntityList
            .stream().filter(activityEntity -> activityEntity.getKey().equals(key)).mapToInt(element->element.getValue()).sum();
       
        return total;
    }
    
    @Override
    public Boolean addValueForSpecificActivity(ActivityEntity activityEntity) {
        return activityEntityList.add(activityEntity);
    }
}
