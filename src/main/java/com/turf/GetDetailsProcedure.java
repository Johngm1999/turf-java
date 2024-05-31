package com.turf;





import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;



@Component
public class GetDetailsProcedure extends StoredProcedure {
    private static final String GetDetailsProcedure = "GetBookingDetails"; // Change to your stored procedure name

    public GetDetailsProcedure(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate,GetDetailsProcedure);

        // Register the parameters for the stored procedure
        declareParameter(new SqlParameter("user_id", Types.INTEGER)); // Assuming user_id is of type VARCHAR in your stored procedure
       
        // Compile the stored procedure
        compile();
    }

    public Map<String, Object> execute(Int user_id) {
        Map<String, Object> inParams = new HashMap<>();

        inParams.put("user_id", user_id);


        return execute(inParams);
    }
}