package com.example.demo_pf;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private Button btnSignin;

    @FXML
    private Label labelErrorMessage;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfUsername;
    private boolean isError = false;

    @FXML
    public void initialize(){
        labelErrorMessage.setVisible(false);
        labelErrorMessage.setManaged(false);
    }

    @FXML
    public void clearError(){
        if(isError){
            labelErrorMessage.setVisible(false);
            labelErrorMessage.setManaged(false);
            isError = false;
        }
    }


    public void onSigninButtonClick(MouseEvent mouseEvent) {

        if(tfUsername.getText().isEmpty() || tfPassword.getText().isEmpty()){
            labelErrorMessage.setVisible(true);
            labelErrorMessage.setManaged(true);
            labelErrorMessage.setText("Fields cannot be empty!");
            isError = true;
        } else{
            labelErrorMessage.setVisible(true);
            labelErrorMessage.setManaged(true);
            labelErrorMessage.setText("Wala pa na implement ma fren");
            isError = true;
        }
    }
}