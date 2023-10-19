package com.example.costcatcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
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
    private ChoiceBox<?> payeCHoiceBox;

    @FXML
    private Label respLabel;

    @FXML
    void backToExpenseTableBtn(ActionEvent event) {

    }

    @FXML
    void submitExpenseBtn(ActionEvent event) {

    }

    @FXML
    void toCreatePayeeProfilebtn(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"insert-expenseview.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        respLabel.setText("");
        
    }

    public void clearInputs(){

        amountDueTextField.clear();
        expNameTxtField.clear();
        recurrencePeriodTextField.clear();
    }
}
