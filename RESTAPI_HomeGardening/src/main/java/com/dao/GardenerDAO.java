package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dto.GardenerDetails;
import com.dto.UserDetails;
import com.ts.db.HibernateTemplate;

public class GardenerDAO {
private SessionFactory factory = null;
	
	public GardenerDetails getGardenerByUserPass(String gardenerEmail,String gardenerPassword) {

		return (GardenerDetails)HibernateTemplate.getObjectByUserPassGardener(gardenerEmail,gardenerPassword);
	}
	
	public int register(GardenerDetails gardener) {
		System.out.println(gardener); 
		return HibernateTemplate.addObject(gardener);
	}
	
	public List<GardenerDetails> getAllGardeners() {
		List<GardenerDetails> gardeners = (List)HibernateTemplate.getObjectListByQuery("From GardenerDetails");
		System.out.println("Inside All Gardeners ..."+gardeners);
		return gardeners;
	}

	public GardenerDetails getGardener(int id) {
		return (GardenerDetails)HibernateTemplate.getObject(GardenerDetails.class,id);
	}

	public GardenerDetails getGardenerByEmail(String email) {
		return (GardenerDetails)HibernateTemplate.getObjectByEmail(email);
	}
	public int update(GardenerDetails editGardener) {
		System.out.println(editGardener); 
		return HibernateTemplate.updateObject(editGardener);
	}

}
