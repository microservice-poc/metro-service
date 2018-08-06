package com.metroservice.schedule.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Schedule implements Serializable {

	/**
	 * Gangadhar M
	 */
	private static final long serialVersionUID = -7893012101494913224L;

	@Override
	public String toString() {
		return "Scheduler [scheduleId=" + scheduleId + ", routeId=" + routeId + ", trainId=" + trainId + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}

	@Id
	@Column(name = "SCHEDULE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHEDULER_SEQ")
	@SequenceGenerator(sequenceName = "schedule_sequence", allocationSize = 1, name = "SCHEDULER_SEQ")
	private Integer scheduleId;
	@Column(name = "ROUTE_ID")
	private Integer routeId;
	@Column(name = "TRAIN_ID")
	private Integer trainId;
	@Column(name = "START_TIME", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	@Column(name = "END_TIME", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
