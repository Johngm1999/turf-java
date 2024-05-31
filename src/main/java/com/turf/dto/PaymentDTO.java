package com.turf.dto;

import java.time.YearMonth;

public class PaymentDTO {
    
    private String cardNumber;
    private YearMonth month;
    private String customerName;
    private String securityCode;
    private int userId;
    private int bookingId; // Corrected method name to follow Java conventions

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public YearMonth getMonth() {
        return month;
    }

    public void setMonth(YearMonth month) {
        this.month = month;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookingId() { // Corrected method name to follow Java conventions
        return bookingId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBookingId(int bookingId) { // Corrected method name to follow Java conventions
        this.bookingId = bookingId;
    }

    public PaymentDTO(String cardNumber, YearMonth month, String customerName, String securityCode, int userId) {
        super();
        this.cardNumber = cardNumber;
        this.month = month;
        this.customerName = customerName;
        this.securityCode = securityCode;
        this.userId = userId;
    }

    public PaymentDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDate'");
    }

    public String getTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTime'");
    }

    public String getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }
}
