package com.expense.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.repo.ExpenseRepository;
import com.expense.repo.UserRepository;

@Service
public class ExpressServiceImpl implements ExpenseService{

	
	@Autowired
	private ExpenseRepository expenserepo;
	
	@Autowired
	private UserRepository userrepo;

	@Override
	public Expense addExpense(Long userId, Expense expense) {
		User user = userrepo.findById(userId).orElseThrow();
        expense.setUser(user);
        return expenserepo.save(expense);
	}

	@Override
	public List<Expense> getAllExpenses(Long userId) {
		User user = userrepo.findById(userId).orElseThrow();
		return expenserepo.findByUser(user);
	}

	@Override
	public List<Expense> filterByCategory(Long userId, String category) {
		User user = userrepo.findById(userId).orElseThrow();
		return expenserepo.findByUserAndCategory(user, category);
	}

	@Override
	public List<Expense> filterByDateRange(Long userId, LocalDate from, LocalDate to) {
		User user = userrepo.findById(userId).orElseThrow();
		return expenserepo.findByUserAndDateBetween(user, from, to);
	}

	@Override
	public Expense updateExpense(Long expenseId, Expense updatedExpense) {
		Expense existing = expenserepo.findById(expenseId).orElseThrow();
		existing.setTitle(updatedExpense.getTitle());
		existing.setCategory(updatedExpense.getCategory());
		existing.setAmount(updatedExpense.getAmount());
		existing.setDate(updatedExpense.getDate());
		
		return expenserepo.save(existing);
	}

	@Override
	public void deleteExpense(Long expenseId) {
        expenserepo.deleteById(expenseId);
    }

}
