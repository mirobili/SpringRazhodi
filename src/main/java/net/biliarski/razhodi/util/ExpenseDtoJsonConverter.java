package net.biliarski.razhodi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.biliarski.razhodi.dto.ExpenseDto;

public class ExpenseDtoJsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(ExpenseDto expense) {
        try {
            return objectMapper.writeValueAsString(expense);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ExpenseDto fromJson(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, ExpenseDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}