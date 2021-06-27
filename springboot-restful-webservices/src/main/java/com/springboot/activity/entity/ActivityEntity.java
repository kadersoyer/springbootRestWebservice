package com.springboot.activity.entity;

import java.sql.Timestamp;

public class ActivityEntity {
	String key;
	Integer value;
	Timestamp requestTime;
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public Timestamp getRequestTime() {
		return requestTime;
	}
	
	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}
	
}
