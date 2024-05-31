package com.turf;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;



@Component
public class PaymentUserStoredProcedure extends StoredProcedure {
    private static final String PAYMENT_PROCEDURE_NAME = "InsertPaymentDetailsbooks_19787"; // Change to your stored procedure name

    public PaymentUserStoredProcedure(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, PAYMENT_PROCEDURE_NAME);

        // Register the parameters for the stored procedure
        declareParameter(new SqlParameter("user_id", Types.INTEGER)); // Assuming user_id is of type VARCHAR in your stored procedure
       
        declareParameter(new SqlParameter("card_number", Types.VARCHAR)); // Assuming card_number is of type VARCHAR in your stored procedure

        // Compile the stored procedure
        compile();
    }

    public Map<String, Object> execute(Int user_id, String card_number) {
        Map<String, Object> inParams = new HashMap<>();

        inParams.put("user_id", user_id);
 
        inParams.put("card_number", card_number);

        return execute(inParams);
    }
}

   
    
    





