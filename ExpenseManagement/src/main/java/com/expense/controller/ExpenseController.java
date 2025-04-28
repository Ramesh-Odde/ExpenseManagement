package com.expense.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.entity.Expense;
import com.expense.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
	@Autowired
    private ExpenseService expenseService;

    @PostMapping("/{userId}/add")
    public ResponseEntity<Expense> addExpense(@PathVariable Long userId, @RequestBody Expense expense) {
        return ResponseEntity.ok(expenseService.addExpense(userId, expense));
    }

    @GetMapping("/{userId}/all")
    public ResponseEntity<List<Expense>> getAll(@PathVariable Long userId) {
        return ResponseEntity.ok(expenseService.getAllExpenses(userId));
    }

    @GetMapping("/{userId}/filter/category")
    public ResponseEntity<List<Expense>> filterByCategory(@PathVariable Long userId, @RequestParam String category) {
        return ResponseEntity.ok(expenseService.filterByCategory(userId, category));
    }

    @GetMapping("/{userId}/filter/date")
    public ResponseEntity<List<Expense>> filterByDate(
        @PathVariable Long userId,
        @RequestParam String from,
        @RequestParam String to) {
        LocalDate start = LocalDate.parse(from);
        LocalDate end = LocalDate.parse(to);
        return ResponseEntity.ok(expenseService.filterByDateRange(userId, start, end));
    }

    @PutMapping("/update/{expenseId}")
    public ResponseEntity<Expense> update(@PathVariable Long expenseId, @RequestBody Expense expense) {
        return ResponseEntity.ok(expenseService.updateExpense(expenseId, expense));
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity<Void> delete(@PathVariable Long expenseId) {
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.noContent().build();
    }

}
