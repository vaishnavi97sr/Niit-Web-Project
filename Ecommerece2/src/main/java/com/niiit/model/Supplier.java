package com.niiit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Supplier {
@Id
private int sup_id;
private String sup_name;
private String sup_add;

public int getSup_id() {
	return sup_id;
}
public void setSup_id(int sup_id) {
	this.sup_id = sup_id;
}
public String getSup_name() {
	return sup_name;
}
public void setSup_name(String sup_name) {
	this.sup_name = sup_name;
}
public String getSup_add() {
	return sup_add;
}
public void setSup_add(String sup_add) {
	this.sup_add = sup_add;
}

}
