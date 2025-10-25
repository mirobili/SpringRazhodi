package net.biliarski.razhodi.controller;

import jakarta.validation.Valid;
import net.biliarski.razhodi.dto.ExpenseDto;
import net.biliarski.razhodi.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/expenses")
public class ExperimentController {

    private final ExpenseService expenseService;

    public ExperimentController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Create expense
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@Valid @RequestBody ExpenseDto expenseDto) {
        ExpenseDto saved = expenseService.save(expenseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Retrieve all expenses
    @GetMapping
    public List<ExpenseDto> getAllExpenses() {
        return expenseService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable String id) {
        Optional<ExpenseDto> expense = expenseService.findById(id);
        return expense.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
