package com.metro.user.registration.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity(name = "UserDetail")
@Table(name = "USER_DET")
public class UserDetail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERDET_SEQ")
    @SequenceGenerator(sequenceName = "USERDET_SEQ", allocationSize = 1, name = "USERDET_SEQ")
	@Column(name="USER_ID")
    Long id;
	
	@Column(name = "EMAIL")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
	@Column(name = "PASSWORD")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String password;
	
	@Column(name = "USERNAME")
	@NotEmpty(message = "*Please provide your name")
	private String username;
	
	@Column(name = "FIRST_NAME")
	@NotEmpty(message = "*Please provide your first name")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;
	
	@Column(name = "ACCOUNT_LOCKED")
	private int active;
	
//	@ManyToMany(cascade = CascadeType.MERGE)
//	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> roles;
	
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
	public String getUserName() {
		return username;
	}
	public void setUserName(String name) {
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active + "]";
	}
	
}
