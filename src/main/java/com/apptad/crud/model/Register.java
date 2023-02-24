package com.apptad.crud.model;

public class Register {
private Integer id;
private String  firstname;
private String  lastname;
private String  address;
private long contact;
private String  email;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
//@NotBlank(message="Please enter name!")
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
//@NotBlank(message="Please enter name!")
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
//@NotBlank(message="Please enter your contact number!")
public long getContact() {
	return contact;
}
public void setContact(long contact) {
	this.contact = contact;
}
//@NotBlank(message="Please enter your email address!")
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Register [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
			+ ", contact=" + contact + ", email=" + email + "]";
}


}
