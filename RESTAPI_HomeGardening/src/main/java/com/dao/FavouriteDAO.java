package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dto.FavouriteDetails;
import com.dto.GardenerDetails;
import com.dto.ItemDetails;
import com.ts.db.HibernateTemplate;

public class FavouriteDAO {
	private SessionFactory factory = null;
	
	public List<FavouriteDetails> getAllFavourites(String email) {
		List<FavouriteDetails> favouriteDetails = (List)HibernateTemplate.getAllFavourites(email);
		return favouriteDetails;	
	}
	public int register(FavouriteDetails favourite) {
		System.out.println(favourite); 
		return HibernateTemplate.addObject(favourite);
	}
	
}
