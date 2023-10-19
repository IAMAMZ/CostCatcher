package com.example.costcatcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreatePayeeProfileController implements Initializable {

    @FXML
    private TextField payeeContactNTextField;
    @FXML
    private TextField payeeCountryTextField;

    @FXML
    private TextField pCodeTextField;


    @FXML
    private TextField payeeEmailTextField;

    @FXML
    private TextField payeeNameTextField;

    @FXML
    private TextField payeeStAdressTextField;
    @FXML
    private Label respLabel;

    @FXML
    void backToExpenseTableBtn(ActionEvent event) throws IOException {

        SceneChanger.changeScenes(event, "expense-tableview.fxml");

    }

    @FXML
    void submitExpenseBtn(ActionEvent event) {

        try{
            Payee payee = new Payee(payeeNameTextField.getText(),payeeContactNTextField.getText(),payeeEmailTextField.getText(),
                    payeeStAdressTextField.getText(),pCodeTextField.getText(),payeeCountryTextField.getText());

             respLabel.setText(DbUtility.insertPayeeToDb(payee));
            clearInputs();
            ;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalArgumentException e){
            respLabel.setText(e.getMessage());
        }
    }
    @FXML
    void toInsertExpenseBtn(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "insert-expenseview.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        respLabel.setText("");
    }

    private  void clearInputs(){
        payeeCountryTextField.clear();;
        payeeContactNTextField.clear();
        payeeEmailTextField.clear();
        payeeNameTextField.clear();
        pCodeTextField.clear();
        payeeStAdressTextField.clear();


    }
}
