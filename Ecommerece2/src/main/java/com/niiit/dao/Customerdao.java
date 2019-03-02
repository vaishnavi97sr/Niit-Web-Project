package com.niiit.dao;

import com.niiit.model.Customer;

public interface Customerdao {

	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email);

}
