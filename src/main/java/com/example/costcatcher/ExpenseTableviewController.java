package com.example.costcatcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ExpenseTableviewController implements Initializable {

    ArrayList<Expense> allExpenses;
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
    private CheckBox isPaidCheckBox;
    @FXML
    private CheckBox notPaidCheckBox;

    @FXML
    private Label totalLabel;
    @FXML
    private TextField filterTextField;


    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void insertExp(ActionEvent event) throws IOException {

        SceneChanger.changeScenes(event,"insert-expenseview.fxml");



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        allExpenses = DbUtility.getExpenses();
        amountDueColumn.setCellValueFactory( new PropertyValueFactory<>("amountDue"));
        payeeEmailColumn.setCellValueFactory( new PropertyValueFactory<>("payeeEmailProxy"));
        exenseIdColumn.setCellValueFactory( new PropertyValueFactory<>("expenseId"));
        expenseCreationColumn.setCellValueFactory( new PropertyValueFactory<>("creationDate"));
        isPaidColumn.setCellValueFactory( new PropertyValueFactory<>("paid"));
        expenseDueDateColumn.setCellValueFactory( new PropertyValueFactory<>("dueDate"));
        payeeNameColumn.setCellValueFactory( new PropertyValueFactory<>("payeeNameProxy"));
        payeeAddressColumn.setCellValueFactory(new PropertyValueFactory<>("payeeAddressProxy"));
        expenseNameColumn.setCellValueFactory(new PropertyValueFactory<>("expenseName"));
        ExpenseTableView.getItems().addAll(allExpenses);

        updateLabels();

        // initially check all the checkboxes to true
        isPaidCheckBox.setSelected(true);
        notPaidCheckBox.setSelected(true);

        // add event handlers
        isPaidCheckBox.addEventHandler(ActionEvent.ACTION,event ->{applyFilters(filterTextField.getText());});
        notPaidCheckBox.addEventHandler(ActionEvent.ACTION,event ->{applyFilters(filterTextField.getText());});
        filterTextField.textProperty().addListener((observableValue,oldValue,newValue)->applyFilters(newValue));
    }

    private void applyFilters(String searchTerm){

        ExpenseTableView.getItems().clear();

        ExpenseTableView.getItems().addAll(allExpenses.stream().filter(expense -> expense.contains(searchTerm,isPaidCheckBox.isSelected(),
                notPaidCheckBox.isSelected())).toList());

        updateLabels();

    }

    private void updateLabels(){
        double total = 0;

        for( Expense expense: ExpenseTableView.getItems()){
            total +=expense.getAmountDue();
        }

        totalLabel.setText(String.format("Total amount is: $%.2f",total));
    }
}
