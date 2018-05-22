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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cra implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final double MAX_DAY_VALUE = 1;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private Month craDate;
	private Year craYear;
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DayActivity> dayActivities = new ArrayList<>();
	@ManyToOne(fetch = FetchType.LAZY)
	private Client client;
	private CraUser craUser;

	public Cra(final Month craDate, final Year craYear) {
		this.craDate = craDate;
		this.craYear = craYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Month getCraDate() {
		return craDate;
	}

	public void setCraDate(final Month craDate) {
		this.craDate = craDate;
	}

	@OneToMany
	public List<DayActivity> getDayActivities() {
		return dayActivities;
	}

	public void setDayActivities(final List<DayActivity> dayActivities) {
		this.dayActivities = dayActivities;
	}

	public Year getCraYear() {
		return craYear;
	}

	public void setCraYear(final Year craYear) {
		this.craYear = craYear;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(final Client client) {
		this.client = client;
	}

	public CraUser getCraUser() {
		return craUser;
	}

	public void setCraUser(final CraUser craUser) {
		this.craUser = craUser;
	}

}
