package it.agil.cramanagment.model;

public class UserModelRequest {

	private String emailUser;
	private String pswUser;
	public UserModelRequest() {
		super();
	}
	public UserModelRequest(String emailUser, String pswUser) {
		super();
		this.emailUser = emailUser;
		this.pswUser = pswUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public String getPswUser() {
		return pswUser;
	}
	public void setPswUser(String pswUser) {
		this.pswUser = pswUser;
	}
	
	
	
	
	
}
