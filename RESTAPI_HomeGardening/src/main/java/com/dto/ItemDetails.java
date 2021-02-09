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
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class ItemDetails {
	
	@Id@GeneratedValue
	private int itemId;
	private String itemName;
	private String itemType;
	private String itemDescription;
	private String itemImage;
	private String itemVideo;
	 
	
	
	@ManyToOne
	private UserDetails userDetails;
	
	@ManyToOne
	private CategoryDetails categoryDetails;
	
	@ManyToMany(mappedBy="itemDetails")
	private List<StoreDetails> storeDetails = new ArrayList<StoreDetails>();

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getItemVideo() {
		return itemVideo;
	}

	public void setItemVideo(String itemVideo) {
		this.itemVideo = itemVideo;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}

	public void setCategoryDetails(CategoryDetails categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

	public List<StoreDetails> getStoreDetails() {
		return storeDetails;
	}

	public void setStoreDetails(List<StoreDetails> storeDetails) {
		this.storeDetails = storeDetails;
	}

	@Override
	public String toString() {
		return "ItemDetails [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType
				+ ", itemDescription=" + itemDescription + ", itemImage=" + itemImage + ", itemVideo=" + itemVideo
				+ ", userDetails=" + userDetails + ", categoryDetails=" + categoryDetails + ", storeDetails="
				+ storeDetails + "]";
	}
	

	
	

	

	}
