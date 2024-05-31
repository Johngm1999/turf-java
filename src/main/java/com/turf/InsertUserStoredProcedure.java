package com.turf;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import java.sql.Time;
import java.sql.Types;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class InsertUserStoredProcedure extends StoredProcedure {

    private static final String INSERT_PROCEDURE_NAME = "InsertBooking_19787";

    public InsertUserStoredProcedure(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, INSERT_PROCEDURE_NAME);

        // Register the parameters for the stored procedure
        declareParameter(new SqlParameter("user_email", Types.VARCHAR));
        declareParameter(new SqlParameter("euser", Types.VARCHAR));
        declareParameter(new SqlParameter("slot_date", Types.DATE));
        declareParameter(new SqlParameter("slot_time", Types.TIME));
      
        
        
        // Compile the stored procedure
        compile();
    }

    public Map<String, Object> execute(Date slotDate, Time slotTime, String userEmail, String euser) {
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("slot_time", slotTime);
        inParams.put("euser", euser);
        inParams.put("slot_date", slotDate);
        inParams.put("user_email", userEmail);
       
        return execute(inParams);
    }

    // If you have other methods or additional functionality, you can add them here
}
