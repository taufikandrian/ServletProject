package com.servlet.apps.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String topic;
	private String date;
	
	public Schedule(){
    }

    public Schedule(String topic,String date){
        this.topic = topic;
        this.date = date;
    }
	
	public long getId() {
        return id;
    }
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
