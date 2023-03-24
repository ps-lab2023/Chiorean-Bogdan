package com.example.notion_ex.service;

import com.example.notion_ex.model.FinancialActivity;
import org.springframework.stereotype.Component;

@Component
public interface FinancialActivityService {
    //READ
    FinancialActivity getActivity(Long id);
    FinancialActivity findByExpense(String expense);
    //UPDATE
    FinancialActivity updateFinancial(FinancialActivity fActivity);
    //DELETE
    String deleteFinancialById(Long id);
}
