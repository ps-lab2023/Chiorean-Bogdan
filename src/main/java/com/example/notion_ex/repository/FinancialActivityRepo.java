package com.example.notion_ex.repository;

import com.example.notion_ex.model.FinancialActivity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialActivityRepo extends CrudRepository<FinancialActivity, Long> {
    FinancialActivity findFirstByExpense(String expense);
}
