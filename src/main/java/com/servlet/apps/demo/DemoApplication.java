package com.servlet.apps.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.servlet.apps.demo.model.Schedule;
import com.servlet.apps.demo.model.User;
import com.servlet.apps.demo.repository.DemoScheduleRepository;
import com.servlet.apps.demo.repository.DemoUserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private DemoUserRepository repository;
	@Autowired
	private DemoScheduleRepository repositorySchedule;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
    public void run(String... strings) throws Exception {
		
		List<String> topicList = new ArrayList<String>();
		List<String> dateList = new ArrayList<String>();
		List<String> fullNameList = new ArrayList<String>();
		List<String> emailList = new ArrayList<String>();
		List<String> gradeList = new ArrayList<String>();
		
		topicList.add("English Communication");
		topicList.add("Software Engineer");
		topicList.add("Software Testing");
		topicList.add("Business Communication");
		
		dateList.add("2017-08-22");
		dateList.add("2017-08-30");
		dateList.add("2017-09-06");
		dateList.add("2017-10-17");
		
		fullNameList.add("Taufik Andrian");
		fullNameList.add("Ibnu Prayogi");
		fullNameList.add("Wimba Agra");
		fullNameList.add("Sopyan Mulyana");
		emailList.add("TaufikAndrian@gmail.com");
		emailList.add("IbnuPrayogi@gmail.com");
		emailList.add("WimbaAgra@gmail.com");
		emailList.add("SopyanMulyana@gmail.com");
		gradeList.add("JP");
		gradeList.add("PG");
		gradeList.add("AP");
		gradeList.add("AN");
		
		for(int i = 0; i < 4;i++){
			repository.save(new User(fullNameList.get(i),emailList.get(i),gradeList.get(i)));
		}
		for(int i = 0; i < 4;i++){
			repositorySchedule.save(new Schedule(topicList.get(i), dateList.get(i)));
		}
    }
}
