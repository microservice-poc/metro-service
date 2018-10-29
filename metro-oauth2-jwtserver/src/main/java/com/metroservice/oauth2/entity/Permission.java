package com.metroservice.oauth2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISSION")
public class Permission implements Serializable{
	
	private static final long serialVersionUID = -376099300265738262L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERM_SEQ")
    @SequenceGenerator(sequenceName = "PERM_SEQ", allocationSize = 1, name = "PERM_SEQ")
	@Column(name="permission_id")
    Long id;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
