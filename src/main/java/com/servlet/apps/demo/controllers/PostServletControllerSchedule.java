package com.servlet.apps.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.servlet.apps.demo.model.Schedule;
import com.servlet.apps.demo.repository.DemoScheduleRepository;

@Controller
public class PostServletControllerSchedule {

	@Autowired
	private DemoScheduleRepository repository;
	
	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public String listSchedule(Model model) {
		model.addAttribute("schedules", repository.findAll());
        return "posts/schedule";
	}
	@RequestMapping(value = "/schedule-create", method = RequestMethod.GET)
	public String listCreateSchedule(Model model) {
        return "posts/schedule-create";
	}
	@RequestMapping(value = "/createSchedule", method = RequestMethod.POST)
    public ModelAndView createSchedule(@RequestParam("ftopic") String topic,@RequestParam("fdate") String date) {
        repository.save(new Schedule(topic,date));
        return new ModelAndView("redirect:/schedule");
    }
	@RequestMapping(value = "/{id}/schedule-edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id,Model model) {
        Schedule schedule = repository.findOne(id);
        model.addAttribute("schedules", schedule);
        return "posts/schedule-edit";
    }
	@RequestMapping(value = "/updateSchedule", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("schedules_id") long id,@RequestParam("ftopic") String topic,@RequestParam("fdate") String date) {
        Schedule schedule = repository.findOne(id);
        schedule.setTopic(topic);
        schedule.setDate(date);
        repository.save(schedule);
        return new ModelAndView("redirect:/schedule");
    }
	@RequestMapping(value = "/{id}/deleteSchedule", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/schedule");
    }
	@RequestMapping(value="/searchtopic", method = RequestMethod.POST)
	public String searchTopic(@RequestParam("ftopic") String topic, Model model)
	{
		model.addAttribute("schedules", repository.findByTopic(topic));
		return "posts/schedule";
	}
}
