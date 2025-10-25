package net.biliarski.razhodi.repository;

import net.biliarski.razhodi.dto.ExpenseDto;
import net.biliarski.razhodi.util.FileReadWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ExpenseRepository {


    private FileReadWriter fileReadWriter;

    @Autowired
    public ExpenseRepository(FileReadWriter fileReadWriter) {
        this.fileReadWriter = fileReadWriter;
    }


    public ArrayList<ExpenseDto> getAll() {
        ArrayList<ExpenseDto> expenses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/data/expenses.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
                ExpenseDto expense = fromLine(line);
                if (expense != null) {
                    expenses.add(expense);
                    System.out.println("Added expense: " + expense);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total lines: " + expenses.size());
        return expenses;
    }



public ExpenseDto save(ExpenseDto expense){
        fileReadWriter.fileWriteContents("src/main/data/expenses.txt", toLine(expense) );
        System.out.println("Expense saved: " + expense);
        return expense;
    }

    public String toLine(ExpenseDto expense){

        String line = "";
        String separator = "|";

        line +=

                 expense.getId()
                + separator + expense.getName()
                + separator + expense.getAmount()
                + separator + expense.getCategory()
                + separator + expense.getDate()
                + separator + expense.getDescription()
                + separator + expense.getUserId()
                + "\n";


        return line;

    }
    public ExpenseDto fromLine(String lineString) {
        String separator = "\\|"; // escape pipe for regex split
        String[] parts = lineString.split(separator);

        ExpenseDto expense = new ExpenseDto();

        expense.setId( parts[0] );
        expense.setName(parts[1]);
        expense.setAmount(Double.parseDouble(parts[2]));
        expense.setCategory(parts[3]);
        expense.setDate(parts[4]);
        expense.setDescription(parts[5]);
        expense.setUserId(parts[6]);

        return expense;
    }



//    String fileGetContents(String file){
//        StringBuilder out = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//                out.append(line);
//            }
//            return out.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }




}
