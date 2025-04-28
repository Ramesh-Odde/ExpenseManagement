package com.expense.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.entity.Expense;
import com.expense.entity.User;

public interface ExpenseRepository  extends JpaRepository<Expense, Long>{
	List<Expense> findByUser(User user);
	List<Expense> findByUserAndCategory(User user, String category);
	List<Expense> findByUserAndDateBetween(User user, LocalDate startDate, LocalDate endDate);
}
