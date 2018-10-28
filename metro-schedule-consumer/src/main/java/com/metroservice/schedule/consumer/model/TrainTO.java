package com.metroservice.schedule.consumer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="TRAIN")
public class TrainTO {
	@Id
    @Column(name="TRAIN_ID")
	private Long   trainId             ;
	@Column(name="TRAIN_NAME")
    private String trainName           ;
	@Column(name="TRAIN_NUMBER")
    private Long   trainNumber         ;
	@Column(name="LAST_SERVICED_DATE")
    private Date   lastServicedDate    ;
	@Column(name="LAST_MODIFIED_DATETIME")
    private Date   lastModifiedDate    ;
    
	public Long getTrainId() {
		return trainId;
	}
	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public Long getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(Long trainNumber) {
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
