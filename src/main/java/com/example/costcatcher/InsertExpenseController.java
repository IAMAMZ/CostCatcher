package com.example.costcatcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class InsertExpenseController {

    @FXML
    private TextField ExpNameTxtField;

    @FXML
    private TextField RecurrencePeriodTextField;

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
    private ChoiceBox<?> payeCHoiceBox;

    @FXML
    void backToExpenseTableBtn(ActionEvent event) {

    }

    @FXML
    void submitExpenseBtn(ActionEvent event) {

    }

    @FXML
    void toCreatePayeeProfilebtn(ActionEvent event) {

    }

}
