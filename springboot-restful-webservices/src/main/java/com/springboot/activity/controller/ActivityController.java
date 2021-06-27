package com.springboot.activity.controller;

import java.sql.Timestamp;

import com.springboot.activity.entity.ActivityEntity;
import com.springboot.activity.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private ActivityRepository activityRepository;
	
	@PostMapping("/{key}")
	public Boolean addPair(@PathVariable (value = "key") String key,@RequestBody ActivityEntity activityEntity) {
		activityEntity.setKey(key);
		activityEntity.setRequestTime(new Timestamp(System.currentTimeMillis()));
		return this.activityRepository.addValueForSpecificActivity(activityEntity);
	}
	
	@GetMapping("/{key}/total")
	public Integer getTotal(@PathVariable (value = "key") String key){
		return this.activityRepository.calculateTotalValueForSpecificActivity(key);
	}

}
