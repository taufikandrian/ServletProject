package com.servlet.apps.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.servlet.apps.demo.model.User;
import com.servlet.apps.demo.repository.DemoUserRepository;

@Controller
public class PostServletController {
	
	@Autowired
	private DemoUserRepository repository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String listPosts(Model model) {
        return "login/index";
    }
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam("fuser") String user,@RequestParam("fpass") String pass) {
		if(user.equals("admin") && pass.equals("admin")) {
	        return new ModelAndView("redirect:/home");
		}else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String listHome(Model model) {
        return "posts/new";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("users", repository.findAll());
        return "posts/users";
	}
	@RequestMapping(value = "/users-create", method = RequestMethod.GET)
	public String listCreateUsers(Model model) {
        return "posts/users-create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createUser(@RequestParam("ffullname") String fullname,@RequestParam("fmail") String email,@RequestParam("fgrade") String grade) {
        repository.save(new User(fullname,email,grade));
        return new ModelAndView("redirect:/users");
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("user_id") long id,@RequestParam("ffullname") String fullname,@RequestParam("fmail") String email,@RequestParam("fgrade") String grade) {
        User user = repository.findOne(id);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setGrade(grade);
        repository.save(user);
        return new ModelAndView("redirect:/users");
    }
	
	@RequestMapping(value = "/{id}/users-edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id,Model model) {
        User user = repository.findOne(id);
        model.addAttribute("user", user);
        return "posts/users-edit";
    }
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/users");
    }
	@RequestMapping(value="/searchname", method = RequestMethod.POST)
	public String searchName(@RequestParam("ffullname") String fullname, Model model)
	{
		model.addAttribute("users", repository.findByFullname(fullname));
		return "posts/users";
	}
    
    @RequestMapping(value="/searchemail", method = RequestMethod.POST)
	public String searchEmail(@RequestParam("fmail") String email, Model model)
	{
		model.addAttribute("users", repository.findByEmail(email));
		return "posts/users";
	}
}
