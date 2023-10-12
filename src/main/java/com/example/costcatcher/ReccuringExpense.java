package com.example.costcatcher;

import java.time.LocalDate;
import java.time.Period;

public class ReccuringExpense extends Expense {

    private Period recurrencePeriod;
    public ReccuringExpense(int expenseId, String expenseName, LocalDate dueDate, LocalDate creationDate, boolean paid, double amountDue, Payee payee, Period reccurencePeriod) {
        super(expenseId, expenseName, dueDate, creationDate, paid, amountDue, payee);
        this.recurrencePeriod = reccurencePeriod;
    }

    public Period getRecurrencePeriod() {
        return recurrencePeriod;
    }

    public void setRecurrencePeriod(Period recurrencePeriod) {
        this.recurrencePeriod = recurrencePeriod;
    }
}
