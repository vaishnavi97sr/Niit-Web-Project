package com.niiit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class User {
	@Id
private String email;
private String password;
private boolean enabled;
@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
private Authorities authorities;
@OneToOne(mappedBy="user")
private Customer customer;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
public Authorities getAuthorities() {
	return authorities;
}
public void setAuthorities(Authorities authorities) {
	this.authorities = authorities;
}

}