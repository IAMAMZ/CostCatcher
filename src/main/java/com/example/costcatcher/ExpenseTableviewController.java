package com.example.costcatcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ExpenseTableviewController implements Initializable {

    @FXML
    private TableView<Expense> ExpenseTableView;

    @FXML
    private TableColumn< Expense, String> payeeAddressColumn;

    @FXML
    private TableColumn<Expense, Float> amountDueColumn;

    @FXML
    private TableColumn<Expense, Integer> exenseIdColumn;

    @FXML
    private TableColumn<Expense, LocalDate> expenseCreationColumn;

    @FXML
    private TableColumn<Expense, LocalDate> expenseDueDateColumn;

    @FXML
    private TableColumn<Expense, String> expenseNameColumn;

    @FXML
    private TableColumn<Expense, Boolean> isPaidColumn;

    @FXML
    private TableColumn<Expense, String> payeeEmailColumn;

    @FXML
    private TableColumn<Expense, String> payeeNameColumn;

    @FXML
    void insertExp(ActionEvent event) {



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        amountDueColumn.setCellValueFactory( new PropertyValueFactory<>("amountDue"));
        payeeEmailColumn.setCellValueFactory( new PropertyValueFactory<>("payeeEmailProxy"));
        exenseIdColumn.setCellValueFactory( new PropertyValueFactory<>("expenseId"));
        expenseCreationColumn.setCellValueFactory( new PropertyValueFactory<>("creationDate"));
        isPaidColumn.setCellValueFactory( new PropertyValueFactory<>("paid"));
        expenseDueDateColumn.setCellValueFactory( new PropertyValueFactory<>("dueDate"));
        payeeNameColumn.setCellValueFactory( new PropertyValueFactory<>("payeeNameProxy"));
        payeeAddressColumn.setCellValueFactory(new PropertyValueFactory<>("payeeAddressProxy"));
        expenseNameColumn.setCellValueFactory(new PropertyValueFactory<>("expenseName"));
        ExpenseTableView.getItems().addAll(DbUtility.getExpenses());
    }
}
