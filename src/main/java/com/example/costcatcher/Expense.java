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

    /**
     * Expense Id must be an a real number i.e larger than 0
     * @param expenseId
     */
    public void setExpenseId(int expenseId) {
        if ( expenseId<0 )
            throw new IllegalArgumentException("number cannot be negative");
        this.expenseId = expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    /**
     * Expense name must not be empty or null, and must start with a letter
     * @param expenseName
     */
    public void setExpenseName(String expenseName) {

        if ((expenseName==null) || (!expenseName.matches("^[A-Za-z].*")))
            throw new IllegalArgumentException("Expense name must not be null or start with a digit");
        this.expenseName = expenseName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * due date must not be after the creation date
     * @param dueDate
     */
    public void setDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(creationDate))
            throw new IllegalArgumentException("Due date cannot be before creation date");
        this.dueDate = dueDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Creation date must not be very old like before 1970
     * @param creationDate
     */
    public void setCreationDate(LocalDate creationDate) {
        if ( creationDate.isBefore(LocalDate.of(1970,01,01)))
            throw new IllegalArgumentException("Creation date cannot be before 1970");
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

    public boolean contains(String searchTerm, boolean isPaid,boolean notPaid){
        // lowercase search term to remove case sensitivity
        searchTerm = searchTerm.toLowerCase();
        return (
                (
                Integer.toString(expenseId).contains(searchTerm) ||
                        expenseName.trim().toLowerCase().contains(searchTerm)||
                    payee.getEmail().trim().toLowerCase().contains(searchTerm) ||
                payee.getPayeeName().trim().toLowerCase().contains(searchTerm)||
                payee.getContactNumber().trim().toLowerCase().contains(searchTerm)
                ) && ( paid && isPaid || !paid && notPaid));

    }
}
