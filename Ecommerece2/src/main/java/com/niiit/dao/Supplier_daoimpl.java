package com.niiit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niiit.model.Supplier;

@Repository("supplierDao")
@Transactional
public class Supplier_daoimpl implements Supplierdao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addSupplier(Supplier c) {
	sessionFactory.getCurrentSession().saveOrUpdate(c);
	}
	
	public void deleteSupplier(int SupplierId) {
		Supplier supplier = (Supplier) sessionFactory.getCurrentSession().load(
				Supplier.class, SupplierId);
	if (null != supplier) {
		this.sessionFactory.getCurrentSession().delete(supplier);
		}
	}
	
	public Supplier getSupplier(int Supplierid) {
	return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, Supplierid);
	}

	@Override
	public List<Supplier> getAllSupplier() {
	return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}
}