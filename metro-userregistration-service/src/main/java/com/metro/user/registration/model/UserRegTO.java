package com.metro.user.registration.model;

import java.util.Date;
import java.util.Set;


//import lombok.Data;

//@Data
public class UserRegTO {
	private Long id;
	private String email;
	private String password;
	private String username;
	private String firstName;
	private String lastName;
	private int active;
	//private Set<Role> roles;
    private Date   lastModifiedDate ;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		this.username = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
//	public Set<Role> getRoles() {
//		return roles;
//	}
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	@Override
	public String toString() {
		return "UserRegTO [id=" + id + ", email=" + email + ", password=" + password + ", name=" + username + ", lastName="
				+ lastName + ", active=" + active + ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
