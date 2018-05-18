package it.agil.cramanagment.entity;

import java.io.Serializable;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cra implements Serializable {

	private static final long serialVersionUID = 1L;

	public final static double MAX_DAY_VALUE = 1;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private Month craDate;
	private Year craYear;
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true)
	private List<DayActivity> dayActivities = new ArrayList<>();
	private Client client;
	private CraUser craUser;

	public Cra(Month craDate, Year craYear, List<DayActivity> dayActivities) {
		this.craDate = craDate;
		this.craYear = craYear;
		this.dayActivities = dayActivities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Month getCraDate() {
		return craDate;
	}

	public void setCraDate(Month craDate) {
		this.craDate = craDate;
	}

	@OneToMany
	public List<DayActivity> getDayActivities() {
		return dayActivities;
	}

	public void setDayActivities(List<DayActivity> dayActivities) {
		this.dayActivities = dayActivities;
	}

	public Year getCraYear() {
		return craYear;
	}

	public void setCraYear(Year craYear) {
		this.craYear = craYear;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CraUser getCraUser() {
		return craUser;
	}

	public void setCraUser(CraUser craUser) {
		this.craUser = craUser;
	}

}
