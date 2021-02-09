package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class FavouriteDetails {
	
	@Id@GeneratedValue
	private int itemId;
	private String itemName;
	private String itemType;
	private String itemDescription;
	private String itemImage;
	private String itemVideo;
	private String itemEmail;
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
	public String getItemEmail() {
		return itemEmail;
	}
	public void setItemEmail(String itemEmail) {
		this.itemEmail = itemEmail;
	}
	@Override
	public String toString() {
		return "FavouriteDetails [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType
				+ ", itemDescription=" + itemDescription + ", itemImage=" + itemImage + ", itemVideo=" + itemVideo
				+ ", itemEmail=" + itemEmail + "]";
	}
	

}
