package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class GardenerDetails {
	
	@Id@GeneratedValue
	private int gardenerId;
	private String gardenerFirstName;
	private String gardenerLastName;
	private String gardenerPhoneNumber;
	private String gardenerEmail;
	private String gardenerPassword;
	private String gardenerStreet;
	private String gardenerCity;
	private String gardenerState;
	
	@ManyToMany
		private List<CategoryDetails> categoryDetails = new ArrayList<CategoryDetails>();

	public int getGardenerId() {
		return gardenerId;
	}

	public void setGardenerId(int gardenerId) {
		this.gardenerId = gardenerId;
	}

	public String getGardenerFirstName() {
		return gardenerFirstName;
	}

	public void setGardenerFirstName(String gardenerFirstName) {
		this.gardenerFirstName = gardenerFirstName;
	}

	public String getGardenerLastName() {
		return gardenerLastName;
	}

	public void setGardenerLastName(String gardenerLastName) {
		this.gardenerLastName = gardenerLastName;
	}

	public String getGardenerPhoneNumber() {
		return gardenerPhoneNumber;
	}

	public void setGardenerPhoneNumber(String gardenerPhoneNumber) {
		this.gardenerPhoneNumber = gardenerPhoneNumber;
	}

	public String getGardenerEmail() {
		return gardenerEmail;
	}

	public void setGardenerEmail(String gardenerEmail) {
		this.gardenerEmail = gardenerEmail;
	}

	public String getGardenerPassword() {
		return gardenerPassword;
	}

	public void setGardenerPassword(String gardenerPassword) {
		this.gardenerPassword = gardenerPassword;
	}

	public String getGardenerStreet() {
		return gardenerStreet;
	}

	public void setGardenerStreet(String gardenerStreet) {
		this.gardenerStreet = gardenerStreet;
	}

	public String getGardenerCity() {
		return gardenerCity;
	}

	public void setGardenerCity(String gardenerCity) {
		this.gardenerCity = gardenerCity;
	}

	public String getGardenerState() {
		return gardenerState;
	}

	public void setGardenerState(String gardenerState) {
		this.gardenerState = gardenerState;
	}

	public List<CategoryDetails> getCategoryDetails() {
		return categoryDetails;
	}

	public void setCategoryDetails(List<CategoryDetails> categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

	@Override
	public String toString() {
		return "GardenerDetails [gardenerId=" + gardenerId + ", gardenerFirstName=" + gardenerFirstName
				+ ", gardenerLastName=" + gardenerLastName + ", gardenerPhoneNumber=" + gardenerPhoneNumber
				+ ", gardenerEmail=" + gardenerEmail + ", gardenerPassword=" + gardenerPassword + ", gardenerStreet="
				+ gardenerStreet + ", gardenerCity=" + gardenerCity + ", gardenerState=" + gardenerState
				+ ", categoryDetails=" + categoryDetails + "]";
	}
	
	
	
	
	
}
