package it.agil.cramanagment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class CraUser implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String pwd;
	private String firstName;
	private String lastName;
	@Column(nullable = false)
	private String email;
	private String telS;
	private String telM;
	@Column(nullable = false)
	private Role role;
	
	

	public CraUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CraUser(final String username, final String pwd, final String email, final Role role) {
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(final String pwd) {
		this.pwd = pwd;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getTelS() {
		return telS;
	}

	public void setTelS(final String telS) {
		this.telS = telS;
	}

	public String getTelM() {
		return telM;
	}

	public void setTelM(final String telM) {
		this.telM = telM;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(final Role role) {
		this.role = role;
	}
}
