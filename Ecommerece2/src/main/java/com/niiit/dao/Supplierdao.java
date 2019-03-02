package com.niiit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niiit.model.Supplier;
@Repository("supplierDao")

public interface Supplierdao {
	public void addSupplier(Supplier c);

	public List<Supplier> getAllSupplier();

	public void deleteSupplier(int SupplierId);

	public Supplier getSupplier(int SupplierId);
}
