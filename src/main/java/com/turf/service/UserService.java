package com.turf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.jdbc.core.JdbcTemplate;
import com.turf.dao.UserDao;
import com.turf.dto.LoginDTO;
import com.turf.dto.UserDTO;
import com.turf.entity.User;
import com.turf.RegisterUserStoredProcedure;

import com.turf.GetDetailsProcedure;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private RegisterUserStoredProcedure registerUserStoredProcedure;
    
	@Autowired
	private JdbcTemplate jdbcTemplate;

    public User validateUser(LoginDTO loginDto) {
        String userEmail = loginDto.getEmail();
        String userPassword = loginDto.getPassword();
        
        // Retrieve the user from the database based on the email
        User user = userDao.findByUserEmail(userEmail);
        // System.out.println("user"+  user.getUserPassword()+"kkk"+(BCrypt.hashpw(userPassword, BCrypt.gensalt())));
        // Check if the user exists and if the password matches
        // System.out.println("user"+user);
        if (user != null && user.getUserPassword().equals(userPassword)) {
            // if (user != null && BCrypt.checkpw(userPassword, user.getUserPassword())) {
            return user; // Return the user if both conditions are met
        } else {
            return null; // Return null if user does not exist or password does not match
        }
    }
    



    public UserService(RegisterUserStoredProcedure registerUserStoredProcedure) {
        this.registerUserStoredProcedure = registerUserStoredProcedure;
    }

    public Map<String, Object> registerUser(UserDTO userDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Call the stored procedure for user registration
            Map<String, Object> output = registerUserStoredProcedure.executeRegisterUser(
                userDto.getFname(),
                userDto.getLname(),
                userDto.getPhone(),
                userDto.getEmail(),
                userDto.getPassword()
            );
            
            // Log the response
            System.out.println("User registration response: " + output);

            response.put("success", true);
            response.put("message", "User registered successfully.");
        } catch (Exception e) {
            // Log any exceptions
            System.err.println("Error registering user: " + e.getMessage());
            response.put("success", false);
            response.put("message", "Failed to register user.");
        }
        return response;
    }



           
            // int addUserResult = addUser(userDto);
            // if (addUserResult != 1) {
            //     response.put("errorCode", 1);
            //     response.put("errorMessage", "Failed to add user");
            //     return response;
            // }
          


 
    public int addUser(UserDTO userDto) {
        User user = new User();
        user.setUserFirstName(userDto.getFname());
        user.setUserLastName(userDto.getLname());
        user.setUserEmail(userDto.getEmail());
        user.setUserPhone(userDto.getPhone());
        // String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        user.setUserPassword(userDto.getPassword());        
        userDao.save(user);
        return 1;
    }




public Map<String, Object> findBookingByUserId(UserDTO userdto) {
    GetDetailsProcedure getDetailsProcedure = new GetDetailsProcedure(jdbcTemplate) ;
    Map<String, Object> response = new HashMap<>();

    try {
        // Call the stored procedure for booking a slot
        Map<String, Object> output = getDetailsProcedure.execute(
            
            userdto.getUserId()			
            
        );

         // Log the response
         System.out.println("sucessfully fetched response: " + output);

         response.put("success", true);
         response.put("message", "fetched successfully.");
         response.put("res", output.get("#result-set-1"));
     } catch (Exception e) {
         // Log any exceptions
         System.err.println("Error fetched: " + e.getMessage());
         response.put("success", false);
         response.put("message", "Failed to fetched.");
     }
     return response;
 }
}