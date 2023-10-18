package com.example.costcatcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class InsertExpenseController {

    @FXML
    private TextField ExpNameTxtField;

    @FXML
    private TextField PayeeContactNTextField;

    @FXML
    private TextField amountDueTextField;

    @FXML
    private DatePicker dueDateDatePicker;

    @FXML
    private ChoiceBox<?> isPaidChoiceBox;

    @FXML
    private TextField pCodeTextField;

    @FXML
    private TextField payeeCityAddressTextField;

    @FXML
    private TextField payeeEmailTextField;

    @FXML
    private TextField payeeNameTextField;

    @FXML
    private TextField payeeStAdressTextField;
    @FXML
    private TextField RecurrencePeriodTextFiedl;
    @FXML
    private RadioButton notPaidRadio;
    @FXML
    private RadioButton isPaidRadio;

    @FXML
    private CheckBox isReccuringCheckBox;



    @FXML
    void backToExpenseTableBtn(ActionEvent event) throws IOException {

        SceneChanger.changeScenes(event,"expense-tableview.fxml");

    }

    @FXML
    void submitExpenseBtn(ActionEvent event) {

    }

}
