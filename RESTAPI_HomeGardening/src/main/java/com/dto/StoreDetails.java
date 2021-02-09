package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class StoreDetails {
	@Id@GeneratedValue
	private int storeId;
	private String name;
	private String review;
	private String picture;
	
	
	@ManyToMany
	private List<ItemDetails> itemDetails = new ArrayList<ItemDetails>();


	public int getStoreId() {
		return storeId;
	}


	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public List<ItemDetails> getItemDetails() {
		return itemDetails;
	}


	public void setItemDetails(List<ItemDetails> itemDetails) {
		this.itemDetails = itemDetails;
	}


	@Override
	public String toString() {
		return "StoreDetails [storeId=" + storeId + ", name=" + name + ", review=" + review + ", picture=" + picture
				+ ", itemDetails=" + itemDetails + "]";
	}


	
	
	
	

}
