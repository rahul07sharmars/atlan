package com.example.atlan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDetails {

	@Id
	private Integer clientID;
	private String clientEmail;
	private String clientName;
	private Double incomePerAnnum;
	private Double savingsPerAnnum;
	private String mobileNumber;

	public ClientDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getClientID() {
		return clientID;
	}

	public void setClientID(Integer client_id) {
		this.clientID = client_id;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String client_email) {
		this.clientEmail = client_email;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String client_name) {
		this.clientName = client_name;
	}

	public Double getIncomePerAnnum() {
		return incomePerAnnum;
	}

	public void setIncomePerAnnum(Double income_per_annum) {
		this.incomePerAnnum = income_per_annum;
	}

	public Double getSavingsPerAnnum() {
		return savingsPerAnnum;
	}

	public void setSavingsPerAnnum(Double savings_per_annum) {
		this.savingsPerAnnum = savings_per_annum;
	}

	@Override
	public String toString() {
		return "ClientDetails [client_id=" + clientID + ", client_email=" + clientEmail + ", client_name="
				+ clientName + ", income_per_annum=" + incomePerAnnum + ", savings_per_annum=" + savingsPerAnnum
				+ ", mobile_number=" + mobileNumber + "]";
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobile_number) {
		this.mobileNumber = mobile_number;
	}

	public ClientDetails(Integer client_id, String client_email, String client_name, Double income_per_annum,
			Double savings_per_annum, String mobile_number) {
		super();
		this.clientID = client_id;
		this.clientEmail = client_email;
		this.clientName = client_name;
		this.incomePerAnnum = income_per_annum;
		this.savingsPerAnnum = savings_per_annum;
		this.mobileNumber = mobile_number;
	}
}
