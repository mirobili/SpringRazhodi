package net.biliarski.razhodi.service;


import net.biliarski.razhodi.dto.ExpenseDto;
import net.biliarski.razhodi.repository.ExpenseRepository;
import net.biliarski.razhodi.util.ExpenseDtoJsonConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExpenseService {


    private ExpenseRepository expenseRepository;


    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<ExpenseDto> getExpenses() {

        return expenseRepository.getAll();
    }
    public List<ExpenseDto> getAll() {

        return expenseRepository.getAll();
    }


    public ExpenseDto save(ExpenseDto expense){
        if(expense.getId()==null){
            expense.setId(UUID.randomUUID().toString());
        }
        ExpenseDto saved = expenseRepository.save(expense);
        return saved;
    }




    public String toJson(ExpenseDto expense){
        return ExpenseDtoJsonConverter.toJson(expense);
    }

    public ExpenseDto fromJson(String jsonString){
        return ExpenseDtoJsonConverter.fromJson(jsonString);
    }


    public Optional<ExpenseDto> findById(String id) {
        ArrayList<ExpenseDto> expenses = expenseRepository.getAll();
        for(ExpenseDto  ex : expenses ){
            System.out.println("current id :|"+ex.getId()+"|");
            System.out.println("Search for :|"+id+"|");
            if(ex.getId().equals(id)){
                return Optional.of(ex);
            }
        }
        throw new RuntimeException("Expense not found");
    }
}
