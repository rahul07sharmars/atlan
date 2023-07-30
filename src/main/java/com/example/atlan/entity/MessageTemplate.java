package com.example.atlan.entity;

public class MessageTemplate {

	private String mobileNumber;
	private String messgeBody;
	@Override
	public String toString() {
		return "Message "+ messgeBody+ "Sended to"+mobileNumber;
	}
	public MessageTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMessgeBody() {
		return messgeBody;
	}
	public void setMessgeBody(String messgeBody) {
		this.messgeBody = messgeBody;
	}
	public MessageTemplate(String mobileNumber, String messgeBody) {
		super();
		this.mobileNumber = mobileNumber;
		this.messgeBody = messgeBody;
	}
	
}
