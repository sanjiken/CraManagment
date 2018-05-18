package it.agil.cramanagment.entity;

import java.time.DayOfWeek;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DayActivity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private DayOfWeek craDay;

	private DayActiviyType activiyType;

	private double dayActivityValue;

	public DayActivity(final DayOfWeek craDay, final DayActiviyType activiyType) {
		this.craDay = craDay;
		this.activiyType = activiyType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getCraDay() {
		return craDay;
	}

	public void setCraDay(DayOfWeek craDay) {
		this.craDay = craDay;
	}

	public DayActiviyType getActiviyType() {
		return activiyType;
	}

	public void setActiviyType(DayActiviyType activiyType) {
		this.activiyType = activiyType;
	}

	public double getDayActivityValue() {
		return dayActivityValue;
	}

	public void setDayActivityValue(double dayActivityValue) {
		this.dayActivityValue = dayActivityValue;
	}

}
