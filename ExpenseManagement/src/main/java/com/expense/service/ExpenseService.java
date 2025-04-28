package com.expense.service;

import java.time.LocalDate;
import java.util.List;

import com.expense.entity.Expense;

public interface ExpenseService {
	public Expense addExpense(Long userId, Expense expense);
	public List<Expense> getAllExpenses(Long userId);
	public List<Expense> filterByCategory(Long userId, String category);
	public List<Expense> filterByDateRange(Long userId, LocalDate from, LocalDate to);
	public Expense updateExpense(Long expenseId, Expense updatedExpense);
	public void deleteExpense(Long expenseId);
}
