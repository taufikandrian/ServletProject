package com.servlet.apps.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 private String username;
	 private String password;
	 private String fullname;
	 private String email;
	 private String grade;
	 
	 
	public User(){
    }

    public User(String fullname,String email,String grade){
        this.fullname = fullname;
        this.email = email;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }
	 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
