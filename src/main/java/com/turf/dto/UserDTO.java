package com.turf.dto;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

public class UserDTO {
	
	private String fname;
	private String lname;
	public String email;
	private long phone;
	private String password;
	private int user_id;
	private List<Item> items;

    // other getter/setter

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getUserId() {
        return user_id;
    }
	public void setUserId(int userId) {
        this.user_id = userId;
    }
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDTO(String fname, String lname, String email, long phone, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFirstname() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getFirstname'");
	}
    public String getLastname() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastname'");
    }
	

	

}
