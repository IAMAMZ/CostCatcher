package com.example.costcatcher;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class DbUtility {

    private static Properties properties = new Properties();

    static {
        try {
            // Load the properties from the config.properties file
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String user = properties.getProperty("db.username");

    private static String password = properties.getProperty("db.password");

    private static String connectUrl = properties.getProperty("db.connURL");


    public static ArrayList<Expense> getExpenses(){

        ArrayList<Expense> expenses = new ArrayList<>();

        String sql = "select * from Expense LEFT JOIN Payee on Expense.payeeId = Payee.PayeeId";

        try(
                //make a connection
                Connection conn = DriverManager.getConnection(connectUrl,user,password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

        ) {
            while(resultSet.next())
            {
                int expenseId = resultSet.getInt("expenseId");
                String expenseName = resultSet.getString("expenseName");

                // Convert SQL Date to LocalDate
                Date sqlDueDate = resultSet.getDate("dueDate");
                LocalDate dueDate = sqlDueDate.toLocalDate();

                Date sqlCreationDate = resultSet.getDate("creationDate");
                LocalDate creationDate = sqlCreationDate.toLocalDate();

                boolean paid = resultSet.getBoolean("paid");
                double amountDue = resultSet.getDouble("amountDue");
                int payeeId = resultSet.getInt("payeeId");
                String payeeName = resultSet.getString("payeeName");
                String contactNumber = resultSet.getString("contactNumber");
                String email = resultSet.getString("email");
                String streetAddress = resultSet.getString("streetAddress");
                String postalCode = resultSet.getString("postalCode");
                String country = resultSet.getString("country");

                try{
                    Payee payee = new Payee(payeeId,payeeName,contactNumber,email,streetAddress,postalCode,country);
                    Expense expense = new Expense(expenseId,expenseName,dueDate,creationDate,paid,amountDue,payee);
                    expenses.add(expense);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return expenses;
    }

    public static String insertExpenseToDb(Expense expense,boolean isRecurring,int recurringPeriod) throws SQLException {

        String responseMsg = "Something Went Wrong";

        String sql = "INSERT INTO Expense  (expenseName, dueDate, creationDate, paid, amountDue, isRecurring, recurrencePeriodDays, payeeId)VALUES (?,?,?,?,?,?,?,?);";

        try(
                Connection conn = DriverManager.getConnection(connectUrl,user,password);
                PreparedStatement ps = conn.prepareStatement(sql);
                )
        {
            // add the values
            ps.setString(1,expense.getExpenseName());
            ps.setString(2,expense.getDueDate().toString());
            ps.setString(3,LocalDate.now().toString());
            ps.setString(4, expense.isPaid() ? String.valueOf(1):String.valueOf(0));
            ps.setString(5,String.valueOf(expense.getAmountDue()));
            ps.setString(6,isRecurring? String.valueOf(1):String.valueOf(0));
            ps.setString(7,String.valueOf(recurringPeriod));
            ps.setString(8,String.valueOf(expense.getPayee().getPayeeId()));

            // execute the update
            ps.executeUpdate();

            responseMsg = "Expense Added successfully";


        }
        catch (SQLIntegrityConstraintViolationException e){
            responseMsg = "Something wrong with the data";
        }
        catch (Exception e){
            responseMsg = e.getMessage();
        }


        return responseMsg;
    }

    public static String insertPayeeToDb(Payee payee) throws SQLException {

        String responseMsg = "Something went wrong";


        String sql = "INSERT INTO Payee ( payeeName, contactNumber, email, streetAddress, postalCode, country) VALUES (?,?,?,?,?,?)";

        try(
                Connection conn = DriverManager.getConnection(connectUrl,user,password);
                PreparedStatement  ps = conn.prepareStatement(sql);
                )
        {
            ps.setString(1,payee.getPayeeName());
            ps.setString(2,payee.getContactNumber());
            ps.setString(3,payee.getContactNumber());
            ps.setString(4,payee.getStreetAddress());
            ps.setString(5,payee.getPostalCode());
            ps.setString(6,payee.getCountry());

            ps.executeUpdate();

        }
        catch (SQLException e){
            responseMsg = "Something went wrong payee not saved";

        }
        catch (Exception e ){
            responseMsg = e.getMessage();
        }



        responseMsg = "Success Payee profile created";

        return responseMsg;


    }



}
