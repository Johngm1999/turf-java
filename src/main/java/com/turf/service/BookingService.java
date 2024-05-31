package com.turf.service;


import java.sql.Date;
import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Service;

import com.turf.InsertUserStoredProcedure;
import com.turf.PaymentUserStoredProcedure;
import com.turf.dao.BookingDao;
import com.turf.dao.PaymentDao;
import com.turf.dao.UserDao;
import com.turf.dto.BookSlotDTO;
import com.turf.dto.PaymentDTO;
import com.turf.dto.UserDTO;
import java.time.LocalTime;

// import com.turf.entity.Payment;
// import com.turf.entity.User;
import java.sql.Time;
@Service
public class BookingService {
	
	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PaymentDao paymentDao;
	

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> bookslot(Map<String, Object> bookDto) {
		InsertUserStoredProcedure insertUserStoredProcedure = new InsertUserStoredProcedure (jdbcTemplate);
		Map<String, Object> response = new HashMap<>();
		try {
			String dateString = (String) bookDto.get("date");
            Date date = Date.valueOf(dateString);
			String timeString = (String) bookDto.get("time");
			Time time = Time.valueOf(LocalTime.parse(timeString));
			// Call the stored procedure for booking a slot
			// Map<String, Object> output = insertUserStoredProcedure.execute(
				
			// 	bookDto.getEmail(),
			// 	bookDto.getDate(), 
			// 	 bookDto.getTime(),
			// 	 bookDto.geteuser()
			// );
			Map<String, Object> output=insertUserStoredProcedure.execute(bookDto.get("email"),date,bookDto.get("time"),bookDto.get("euser"));
			 // Log the response
			 System.out.println("sucessfully booked response: " + output);

			 response.put("success", true);
			 response.put("message", "Booked successfully.");
		 } catch (Exception e) {
			 // Log any exceptions
			 System.out.println(e);
			 System.err.println("Error registering user: " + e.getMessage());
			 response.put("success", false);
			 response.put("message", "Failed to Booked.");
		 }
		 return response;
	 }
	
	 public Map<String, Object> paymentslot(PaymentDTO paymentDto) {
		PaymentUserStoredProcedure paymentUserStoredProcedure = new PaymentUserStoredProcedure(jdbcTemplate) ;
		Map<String, Object> response = new HashMap<>();
		System.out.println(paymentDto.getCardNumber());
		System.out.println(paymentDto.getUserId()*5);
		try {
			// Call the stored procedure for booking a slot
			Map<String, Object> output = paymentUserStoredProcedure.execute(
				
				paymentDto.getUserId(),
				paymentDto.getCardNumber()
				
				
			);

			 // Log the response
			 System.out.println("sucessfully PAYMENT response: " + output);

			 response.put("success", true);
			 response.put("message", "PAYMENT successfully.");
		 } catch (Exception e) {
			 // Log any exceptions
			 System.err.println("Error PAYMENT: " + e.getMessage());
			 response.put("success", false);
			 response.put("message", "Failed to PAYMENT.");
		 }
		 return response;
	 }
	// public int addBookingSlot(BookSlotDTO bookSlotDto) {
	// 	System.out.println("-------------------------------" + bookSlotDto);

	public int addBookingSlot(BookSlotDTO bookSlotDto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addBookingSlot'");
	}



	// 	// Define the date and time formatters
    //     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //     DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    //     // Parse the date and time strings to LocalDate and LocalTime
    //     LocalDate parsedDate = LocalDate.parse(bookSlotDto.getDate(), dateFormatter);
    //     LocalTime parsedTime = LocalTime.parse(bookSlotDto.getTime(), timeFormatter);
     
    //     	LocalDateTime currentDateTime = LocalDateTime.now();
            
    //         BookedSlots bookedSlots = new BookedSlots();
            
    //         User user = userDao.findByUserId(bookSlotDto.getUserId());
            
    //         Payment payment = PaymentDao.findByPaymentId(bookSlotDto.getPaymentId());
            
    //         bookedSlots.setSlotDate(parsedDate);
    //         bookedSlots.setSlotTime(parsedTime);
    //         bookedSlots.setCurrentDateAndTime(currentDateTime);
    //         bookedSlots.setUser(user);
    //         bookedSlots.setPayment(payment);
            
    //         bookingDao.save(bookedSlots);
    //         return 1;        
	// }

	// public List<BookedSlots> getBookingDetails(long userId) {
	// 	return bookingDao.findBookingByUserId(userId);
	// }

	



	// public boolean verifySlot(BookSlotDTO bookSlotDto) {
	// 	// Define the date and time formatters
    //     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //     DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    //     // Parse the date and time strings to LocalDate and LocalTime
    //     LocalDate parsedDate = LocalDate.parse(bookSlotDto.getDate(), dateFormatter);
    //     LocalTime parsedTime = LocalTime.parse(bookSlotDto.getTime(), timeFormatter);
        
    //     int slotAlreadyBooked = bookingDao.slotAlreadyBooked(parsedDate, parsedTime);
        
    //     if(slotAlreadyBooked>0) {
    //     	return false;
    //     }
    //     else {
    //     	return true;
    //     }
	// }

	// public Payment addPayment(PaymentDTO paymentDto) {
	// 	Payment payment = new Payment();
	// 	payment.setCardNumber(paymentDto.getCardNumber());
	// 	payment.setCustomerName(paymentDto.getCustomerName());
	// 	payment.setMonth(paymentDto.getMonth());
	// 	payment.setSecurityCode(paymentDto.getSecurityCode());
	// 	User user = userDao.findByUserId(paymentDto.getUserId());
	// 	payment.setUser(user);
	// 	Payment savedPayment = paymentDao.save(payment);
	// 	return savedPayment;
	// }

}
	

