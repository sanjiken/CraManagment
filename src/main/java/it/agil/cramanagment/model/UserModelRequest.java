package it.agil.cramanagment.model;

public class UserModelRequest {

	private String emailUser;
	private String pswUser;

	public UserModelRequest() {
		super();
	}

	public UserModelRequest(final String emailUser, final String pswUser) {
		super();
		this.emailUser = emailUser;
		this.pswUser = pswUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(final String emailUser) {
		this.emailUser = emailUser;
	}

	public String getPswUser() {
		return pswUser;
	}

	public void setPswUser(final String pswUser) {
		this.pswUser = pswUser;
	}

}
