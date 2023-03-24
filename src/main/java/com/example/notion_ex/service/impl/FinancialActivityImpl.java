package com.example.notion_ex.service.impl;

import com.example.notion_ex.model.FinancialActivity;
import com.example.notion_ex.repository.FinancialActivityRepo;
import com.example.notion_ex.service.FinancialActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialActivityImpl implements FinancialActivityService {
    @Autowired
    private FinancialActivityRepo financialActivityRepo;

    public FinancialActivityImpl(FinancialActivityRepo finActRepo) {
        this.financialActivityRepo = finActRepo;
    }


    //READ
    @Override
    public FinancialActivity getActivity(Long id){
        return financialActivityRepo.findById(id).orElse(null);
    }

    @Override
    public FinancialActivity findByExpense(String expense) {
        return financialActivityRepo.findFirstByExpense(expense);
    }

    //UPDATE
    @Override
    public FinancialActivity updateFinancial(FinancialActivity fActivity) {
        FinancialActivity existActivity = financialActivityRepo.findById(fActivity.getId()).orElse(null);
        existActivity.setExpense(fActivity.getExpense());
        existActivity.setAmount(fActivity.getAmount());
        existActivity.setCategory(fActivity.getCategory());
        //to be added: existActivity.setDate(fActivity.getDate());
        //existingAdmin.;

        return financialActivityRepo.save(existActivity);
    }

    //DELETE
    @Override
    public String deleteFinancialById(Long id) {
        financialActivityRepo.deleteById(id);
        return "The financial activity with id " + id + " was deleted from the database";
    }
}
