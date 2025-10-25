package net.biliarski.razhodi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ExpenseDto {

    public String id;
    public String userId;
    @NotNull(message = "Name is mandatory")
    public String name;
    public double amount;
    public String category;
    public String date;

    @NotNull(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    public String description;

    /***********************
     * Validation annotations like @NotNull and @Size are used in Java to declare rules on the fields of your DTO or entity classes. These rules define what values are considered valid before an object can be accepted or processed.
     * Explanation:
     *
     *     @NotNull
     *     Ensures the annotated field is not null. It means a value must be provided but allows empty values like empty strings ("") or empty collections.
     *
     *     @Size(min=, max=)
     *     Applies to strings, collections, arrays, etc. It restricts the size or length of the annotated element. For example, @Size(min=2, max=30) means the string or collection must have between 2 and 30 characters/items.
     *
     * Example:
     *
     * java
     * public class UserDto {
     *
     *     @NotNull(message = "Name is mandatory")
     *     @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
     *     private String name;
     *
     *     @NotNull(message = "Email is mandatory")
     *     @Email(message = "Invalid email format")
     *     private String email;
     *
     *     // getters and setters
     * }
     *
     * What this does:
     *
     *     If name is null or shorter than 2 or longer than 50, validation fails.
     *
     *     If email is null or not a valid email format, validation fails.
     *
     *     Validation errors can be captured and sent back as error responses to the client.
*
     * Other common annotations:
     *     @NotEmpty: Not null and not empty (empty collections/strings disallowed)
     *     @NotBlank: Only for strings; not null, not empty, and not whitespace only
     *     @Min, @Max: For numeric range constraints
     *     @Pattern: For regex pattern matching
     * Using these annotations with @Valid lets Spring automatically validate input DTOs before your code processes them, helping catch errors early and improve robustness.
     *
     * If you want, I can help you add these validations to your DTO or show how to handle validation errors gracefully in Spring Boot.************************/

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        //this.userId = String.valueOf(UUID.fromString(userId));
        this.userId =  userId ;
    }

    public ExpenseDto() {
    }

    public ExpenseDto(String id , String name, double amount, String category, String date, String description, String userId) {

        this.id = id;
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
