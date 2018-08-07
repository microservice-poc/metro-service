package com.metroservice.train.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAIN")
public class Train {

	@Id
    @Column(name="TRAIN_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
	
	
	@Column(name="TRAIN_NAME")
	private String trainName;
	
	
	@Column(name="TRAIN_NUMBER")
    private long trainNumber;
	
	@Column(name="LAST_SERVICED_DATE")
    private Date lastServicedDate;
    
	
	@Column(name="LAST_MODIFIED_DATETIME")
    private Date lastModifiedDate;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTrainName() {
		return trainName;
	}


	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}


	public long getTrainNumber() {
		return trainNumber;
	}


	public void setTrainNumber(long trainNumber) {
		this.trainNumber = trainNumber;
	}


	public Date getLastServicedDate() {
		return lastServicedDate;
	}


	public void setLastServicedDate(Date lastServicedDate) {
		this.lastServicedDate = lastServicedDate;
	}


	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
}
