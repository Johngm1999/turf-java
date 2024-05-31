package com.turf;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Component
public class RegisterUserStoredProcedure extends StoredProcedure {
    private static final String REGISTER_PROCEDURE_NAME = "spinsert_user_19787";

    public RegisterUserStoredProcedure(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, REGISTER_PROCEDURE_NAME);

        // Register the parameters for the stored procedure
        // declareParameter(new SqlParameter("userId", Types.BIGINT));
        declareParameter(new SqlParameter("p_first_name", Types.VARCHAR));
        declareParameter(new SqlParameter("p_last_name", Types.VARCHAR));
        declareParameter(new SqlParameter("p_phone", Types.VARCHAR));
        declareParameter(new SqlParameter("p_email", Types.VARCHAR));
        declareParameter(new SqlParameter("p_password", Types.VARCHAR));
        

        // Compile the stored procedure
        compile();
    }

    public Map<String, Object> executeRegisterUser( String userFirstName, String userLastName, long userPhone, String userEmail, String userPassword) {
        Map<String, Object> inParams = new HashMap<>();
       // inParams.put("userId", userId);
        inParams.put("p_first_name", userFirstName);
        inParams.put("p_last_name", userLastName);
        inParams.put("p_phone", userPhone);
        inParams.put("p_email", userEmail);
        inParams.put("p_password", userPassword);

        return execute(inParams);
    }

   

   
}
