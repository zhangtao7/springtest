package com.springtest.chapter6.thymeleaf;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


public class User {

	 @NotNull(message = "{user.id.null}")  
	 private Long id;  
	  
    @NotEmpty(message = "{user.username.null}")  
    @Length(min = 5, max = 20, message = "{user.username.length.illegal}")  
    @Pattern(regexp = "[a-zA-Z]{5,20}", message = "{user.username.illegal}")  
    private String username;  
  
    @NotNull(message = "{user.password.null}")  
    private String password;
    
    
    private Date ctime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}  
	
	
}
