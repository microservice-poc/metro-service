package com.metroservice.oauth2.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USER_DET")
public class User implements UserDetails {

	private static final long serialVersionUID = -7151882782041042203L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERDET_SEQ")
	@SequenceGenerator(sequenceName = "USERDET_SEQ", allocationSize = 1, name = "USERDET_SEQ")
	@Column(name = "user_id")
	Long id;

	private String username;

	private String password;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private boolean enabled;

	@Column(name = "account_locked")
	private boolean accountNonLocked;

	@Column(name = "account_expired")
	private boolean accountNonExpired;

	@Column(name = "credentials_expired")
	private boolean credentialsNonExpired;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !accountNonExpired;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !credentialsNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !accountNonLocked;
	}

	/*
	 * Get roles and permissions and add them as a Set of GrantedAuthority
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		roles.forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getRole()));
			r.getPermissions().forEach(p -> {
				authorities.add(new SimpleGrantedAuthority(p.getName()));
			});
		});

		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEnabled(Object enabled) {
		if(enabled instanceof Integer) {
			this.enabled = (((Integer)enabled).equals(1));
		}
		if(enabled instanceof Long) {
			this.enabled = (((Long)enabled).equals(1L));
		} else {
			this.enabled = Boolean.parseBoolean(enabled.toString());
		}
	}

	public void setAccountNonLocked(Object accountNonLocked) {
		if(accountNonLocked instanceof Integer) {
			this.accountNonLocked = (((Integer)accountNonLocked).equals(1));
		}
		if(accountNonLocked instanceof Long) {
			this.accountNonLocked = (((Long)accountNonLocked).equals(1L));
		} else {
			this.accountNonLocked = Boolean.parseBoolean(accountNonLocked.toString());
		}
	}

	public void setAccountNonExpired(Object accountNonExpired) {
		if(accountNonExpired instanceof Integer) {
			this.accountNonExpired = (((Integer)accountNonExpired).equals(1));
		}
		if(accountNonExpired instanceof Long) {
			this.accountNonExpired = (((Long)accountNonExpired).equals(1L));
		} else {
			this.accountNonExpired = Boolean.parseBoolean(accountNonExpired.toString());
		}
	}

	public void setCredentialsNonExpired(Object credentialsNonExpired) {
		if(credentialsNonExpired instanceof Integer) {
			this.credentialsNonExpired = (((Integer)credentialsNonExpired).equals(1));
		}
		if(credentialsNonExpired instanceof Long) {
			this.credentialsNonExpired = (((Long)credentialsNonExpired).equals(1L));
		} else {
			this.credentialsNonExpired = Boolean.parseBoolean(credentialsNonExpired.toString());
		}
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

}