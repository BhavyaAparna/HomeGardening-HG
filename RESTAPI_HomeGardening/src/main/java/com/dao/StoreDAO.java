package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dto.ItemDetails;
import com.dto.StoreDetails;
import com.ts.db.HibernateTemplate;

public class StoreDAO {
private SessionFactory factory = null;
	
	public List<StoreDetails> getAllStoreDetails() {
		List<StoreDetails> storeDetails=(List)HibernateTemplate.getObjectListByQuery("From StoreDetails");
		return storeDetails;	
	}
	public int additem(StoreDetails item) {
		System.out.println(item); 
		return HibernateTemplate.addObject(item);
	}
}
