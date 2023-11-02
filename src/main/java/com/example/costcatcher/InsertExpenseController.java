package com.example.costcatcher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InsertExpenseController implements Initializable {

    @FXML
    private TextField expNameTxtField;

    @FXML
    private TextField recurrencePeriodTextField;

    @FXML
    private TextField amountDueTextField;

    @FXML
    private DatePicker dueDateDatePicker;

    @FXML
    private RadioButton isPaidRadio;

    @FXML
    private CheckBox isReccuringCheckBox;

    @FXML
    private RadioButton notPaidRadio;

    @FXML
    private ChoiceBox<Payee> payeeChoiceBox;

    @FXML
    private Label respLabel;

    @FXML
    void backToExpenseTableBtn(ActionEvent event) throws IOException {
    SceneChanger.changeScenes(event,"expense-tableview.fxml");
    }

    @FXML
    void submitExpenseBtn(ActionEvent event) {

    }
    private void loadPayeesIntoChoiceBox(){

        ArrayList<Payee> payees = DbUtility.getPayees();
        // Convert the List to an ObservableList
        ObservableList<Payee> observablePayees = FXCollections.observableArrayList(payees);

        // Set the ObservableList into the ChoiceBox
        payeeChoiceBox.setItems(observablePayees);
    }

    @FXML
    void toCreatePayeeProfilebtn(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"create-payeeview.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        respLabel.setText("");
        loadPayeesIntoChoiceBox();
        
    }

    public void clearInputs(){

        amountDueTextField.clear();
        expNameTxtField.clear();
        recurrencePeriodTextField.clear();
    }
}
