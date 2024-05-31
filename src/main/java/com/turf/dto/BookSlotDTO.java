package com.turf.dto;

import java.sql.Date;
import java.sql.Time;

public class BookSlotDTO {
	
	private Date date;
    private Time time;
    private String user_email;
    private int userId;
    private int paymentId;
    private String euser;

    // Getters and setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }
    public String getEmail() {
        return user_email;
    }
    public void setEmail(String user_email) {
        this.user_email = user_email;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
    public String geteuser() {
        return euser;
    }

    public void seteuser(int userId) {
        this.euser = euser;
    }

    
}
