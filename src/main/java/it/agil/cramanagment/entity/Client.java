package it.agil.cramanagment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String tel;
	private String responsable;

	public Client() {
		super();
	}

	public Client(final Long id, final String name, final String tel) {
		this.id = id;
		this.name = name;
		this.tel = tel;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(final String tel) {
		this.tel = tel;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(final String responsable) {
		this.responsable = responsable;
	}

}
