package com.example.costcatcher;

import java.time.LocalDate;

public class Expense {

    private int expenseId;

    private String  expenseName;

    private LocalDate dueDate;

    private LocalDate creationDate;

    private boolean paid;

    private double amountDue;

    private Payee payee;

    public Expense(int expenseId, String expenseName, LocalDate dueDate, LocalDate creationDate, boolean paid, double amountDue, Payee payee) {
        this.expenseId = expenseId;
        this.expenseName = expenseName;
        this.dueDate = dueDate;
        this.creationDate = creationDate;
        this.paid = paid;
        this.amountDue = amountDue;
        this.payee = payee;
    }


    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }

    // proxy methods
    public String getPayeeNameProxy() {
        return this.payee.getPayeeName();
    }

    public String getPayeeEmailProxy() {
        return this.payee.getEmail();
    }

    public String getPayeeAddressProxy() {
        return this.payee.getStreetAddress();
    }
    @Override
    public String toString(){
        return this.expenseId + this.expenseName;
    }
}
