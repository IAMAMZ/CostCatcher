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

    public static String saveExpense(String expenseName, LocalDate dueDate, boolean paid, double amountDue, Payee payee,boolean isRecurring, int recurrencePeriod) throws SQLException {

        String responseMsg = "Something Went Wrong";

        String sql = "INSERT INTO Expense  (expenseName, dueDate, creationDate, paid, amountDue, isRecurring, recurrencePeriodDays, payeeId)VALUES (?,?,?,?,?,?,?,?);";

        try(
                Connection conn = DriverManager.getConnection(connectUrl,user,password);
                PreparedStatement ps = conn.prepareStatement(sql);
                )
        {
            // add the values
            ps.setString(1,expenseName);
            ps.setString(2,dueDate.toString());
            ps.setString(3,LocalDate.now().toString());
            ps.setString(4, paid?"TRUE":"FALSE");
            ps.setString(5,String.valueOf(amountDue));
            ps.setString(6,isRecurring?"TRUE":"FALSE");
            ps.setString(7,String.valueOf(recurrencePeriod));
            ps.setString(8,String.valueOf(payee.getPayeeId()));

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



}
