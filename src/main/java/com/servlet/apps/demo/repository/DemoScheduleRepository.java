package com.servlet.apps.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.servlet.apps.demo.model.Schedule;

public interface DemoScheduleRepository extends CrudRepository<Schedule, Long> {
	List<Schedule> findByTopic(String topic);
}
