package com.metro.user.registration.model;

import javax.persistence.*;

@Entity
@Table(name = "USER_DETAIL")
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@SequenceGenerator(sequenceName = "USERDET_SQ", allocationSize = 1, name = "USER_SEQ")
	Long id;

	@Column(name = "userid")
	private String userid;

	@Column(name = "password")
	private int password;

	@Column(name = "email")
	private String email;

	@Column(name = "username")
	private String username;

	@Column(name = "gender")
	private char gender;

	public UserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetail(String userid, int password, String email, String username, char gender) {
		super();
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.username = username;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", userid=" + userid + ", password=" + password + ", email=" + email
				+ ", username=" + username + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + gender;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + password;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetail other = (UserDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

}
