package com.turf.controller;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turf.dto.BookSlotDTO;
import com.turf.dto.LoginDTO;
import com.turf.dto.PaymentDTO;
import com.turf.dto.UserDTO;

// import com.turf.entity.Payment;
import com.turf.entity.User;
import com.turf.service.BookingService;
import com.turf.service.UserService;

@RestController
@RequestMapping(value="/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	private static final com.turf.dto.UserDTO UserDTO = null;

	@Autowired
	UserService userService;
	
	@Autowired
	BookingService bookingService;
	
	// @PostMapping("/add") 
	// public int addUser(@RequestBody UserDTO userDto) {
	// 	return userService.addUser(userDto);
	// }


	@PostMapping("/login")
	public User validateUser(@RequestBody LoginDTO loginDto) {
		return userService.validateUser(loginDto);
	}
	
	
	@PostMapping("/register") 
	public Map<String, Object> addUser(@RequestBody UserDTO userDto) {
		return userService.registerUser(userDto);
	}

	
	//  @PostMapping("/register")
    // public ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserDTO userDto) {
    //     Map<String, Object> response = userService.registerUser(userDto);

    //     boolean success = (boolean) response.getOrDefault("success", false);
    //     String message = (String) response.getOrDefault("message", "");

    //     if (success) {
    //         return ResponseEntity.status(HttpStatus.CREATED).body(response);
    //     } else {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    //     }
    // }


	// @PostMapping("/verifyslot")
	// public boolean verifySlot(@RequestBody BookSlotDTO bookSlotDto) {
	// 	return bookingService.verifySlot(bookSlotDto);
	// }
	
	// @PostMapping("/bookslot") 
	// public int bookSlot(@RequestBody BookSlotDTO bookSlotDto) {
	// 	return bookingService.addBookingSlot(bookSlotDto);
	// }
	@PostMapping("/bookslot")
    public ResponseEntity<Map<String, Object>> bookSlot(@RequestBody Map<String, Object> bookSlotDto) {
        Map<String, Object> response = new HashMap<>();
		System.out.println("-------------------------re---------"+response);
		System.out.println(bookSlotDto);
        try {
			return ResponseEntity.ok(bookingService.bookslot(bookSlotDto));
        } catch (Exception e) {
            response.put("message", "An error occurred while processing your request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

 

	
	// @GetMapping("/getbookingdetails/{userId}")
	// public List<BookedSlots> getBookingDetails(@PathVariable long userId){
	// 	return bookingService.getBookingDetails(userId);
	// }
	
	@PostMapping("/payment") 
	public Map<String, Object> payment(@RequestBody PaymentDTO paymentDto) {
		return bookingService.paymentslot(paymentDto);
	}

	// @GetMapping("/getbookingdetails/{userId}") 
	// public Map<String, Object> getdetails(@RequestBody UserDTO userDTO) {
	// 	return bookingService.findBookingByUserId(UserDTO);
	// }
	@GetMapping("/getbookingdetails/{userId}")
public Map<String, Object> getdetails(@PathVariable int userId) {
    // Create a new UserDTO object with the provided userId
    UserDTO userDTO = new UserDTO();
    userDTO.setUserId(userId);
    
    // Call the service method to fetch booking details
    return userService.findBookingByUserId(userDTO);
}

}