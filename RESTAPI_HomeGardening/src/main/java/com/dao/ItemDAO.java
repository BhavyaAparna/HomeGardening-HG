package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dto.ItemDetails;
import com.dto.StoreDetails;
import com.dto.UserDetails;
import com.ts.db.HibernateTemplate;

public class ItemDAO {
private SessionFactory factory = null;
	
	public List<ItemDetails> getAllItemDetailsByImage() {
		List<ItemDetails> itemDetails=(List)HibernateTemplate.getObjectByitemImage("From ItemDetails");
		return itemDetails;	
	}
	
	public List<ItemDetails> getAllItemDetailsByVideo() {
		List<ItemDetails> itemDetails=(List)HibernateTemplate.getObjectListVideo("From ItemDetails");
		return itemDetails;	
	}
	public List<ItemDetails> getItemByType(String itemType) {
		List<ItemDetails> itemDetails=(List)HibernateTemplate.getImageByItemType(itemType);
		return itemDetails;	
	}
	
	public int additem(ItemDetails item) {
		System.out.println(item); 
		return HibernateTemplate.addObject(item);
	}
	
}
