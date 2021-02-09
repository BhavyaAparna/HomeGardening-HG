package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class CategoryDetails {
	@Id@GeneratedValue
	private int categoryId;
	private String name;
	private String email;
	private String date;
	private String time;
	private String userMail;
	private String status;
		
	@OneToMany(mappedBy="categoryDetails",fetch = FetchType.LAZY)
	private List<ItemDetails> itemDetails = new ArrayList<ItemDetails>();
	
	@ManyToMany(mappedBy="categoryDetails")
	private List<GardenerDetails> gardenerDetails	= new ArrayList<GardenerDetails>();

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<ItemDetails> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(List<ItemDetails> itemDetails) {
		this.itemDetails = itemDetails;
	}

	public List<GardenerDetails> getGardenerDetails() {
		return gardenerDetails;
	}

	public void setGardenerDetails(List<GardenerDetails> gardenerDetails) {
		this.gardenerDetails = gardenerDetails;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CategoryDetails [categoryId=" + categoryId + ", name=" + name + ", email=" + email + ", date=" + date
				+ ", time=" + time + ", userMail=" + userMail + ", status=" + status + ", itemDetails=" + itemDetails
				+ ", gardenerDetails=" + gardenerDetails + "]";
	}

	
	

	
}

	
