package com.example.costcatcher;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestingDbUtility {


    public static void main(String[] args) throws SQLException {


        //System.out.println(DbUtility.getExpenses());

     /*   Payee myPayee = new Payee(4,"AMD","23223232","Amd@amd.com","15 belfast road",
                "M2J CL5","CANADA");

        //System.out.println(DbUtility.insertPayeeToDb(myPayee));

        Expense myExpense = new Expense(10,"Buy gpu", LocalDate.of(2023,8,9),LocalDate.now(),true,1200,myPayee);

        System.out.println(DbUtility.insertExpenseToDb(myExpense,false,0));

        System.out.println(LocalDate.now().toString());*/


        ArrayList<Payee> payees = DbUtility.getPayees();

    }
}
