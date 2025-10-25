package net.biliarski.razhodi.controller;

import net.biliarski.razhodi.dto.ExpenseDto;
import net.biliarski.razhodi.dto.PersonDto;
import net.biliarski.razhodi.dto.UserDto;
import net.biliarski.razhodi.dto.response.UserResponse;
import net.biliarski.razhodi.service.ExpenseService;
import net.biliarski.razhodi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    private final UserService userService;

    @Autowired
    public ExpenseController(UserService userService, ExpenseService expenseService) {

        this.userService = userService;
        this.expenseService = expenseService;
    }

    // Dummy method to get a list of expenses
    @GetMapping
    public List<String> getTestList() {
        // Returning dummy data
        return Arrays.asList("Expense 1", "Expense 2", "Expense 3");
    }

    @GetMapping("/expenses")
    public List<ExpenseDto> getExpenses() {

        return expenseService.getExpenses();
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {

        return userService.getUsers();
    }

    @GetMapping("/usersCapitalized")
    public List<UserDto> getUsersCapitalized() {

        return userService.getUsersWithCapitalizedNamesAndMd5();
    }

    @GetMapping("/usersWithAddress")
    public List<UserResponse> getUsersResponse() {

        return userService.getUsersWithAddress();
    }

    @GetMapping("/usersDummy")
    public List<PersonDto> getDummy() {

        return userService.getDummyData();

    }


    @GetMapping({"/saveExpense", "/add"})
    public List<ExpenseDto> saveExpense(@RequestParam String name, @RequestParam double amount, @RequestParam String category, @RequestParam String date, @RequestParam String description, @RequestParam String userId) {

        // ExpenseDto expense = dummyExpense();
        ExpenseDto expense = new ExpenseDto();
        expense.setName(name);
        expense.setAmount(amount);
        expense.setCategory(category);
        expense.setDate(date);
        expense.setDescription(description);
        expense.setUserId(userId);
        expenseService.save(expense);

        return expenseService.getAll();
    }

//    private static ExpenseDto dummyExpense() {
//        ExpenseDto expense = new ExpenseDto();
//        expense.setName("Expense 1");
//        expense.setAmount(100);
//        expense.setCategory("Category 1");
//        expense.setDate("2022-01-01");
//        expense.setDescription("Description 1");
//        expense.setUserId(UUID.randomUUID().toString());
//        return expense;
//    }

    /******************** POST ****************************/

}
