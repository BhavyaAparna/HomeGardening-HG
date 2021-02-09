package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dto.CategoryDetails;
import com.dto.ItemDetails;
import com.dto.UserDetails;
import com.ts.db.HibernateTemplate;

public class CategoryDAO {
	private SessionFactory factory = null;
	
	public List<CategoryDetails> getAllCategoryDetails() {
		List<CategoryDetails> categoryDetails=(List)HibernateTemplate.getObjectListByQuery("From CategoryDetails");
		return categoryDetails;	
	}
	public int register(CategoryDetails category) {
		System.out.println(category); 
		return HibernateTemplate.addObject(category);
	}
	public List<CategoryDetails> getGardenerById(String email) {
		List<CategoryDetails> categoryDetails=(List)HibernateTemplate.getGardenerById(email);
		return categoryDetails;	
	}
	
	
}
