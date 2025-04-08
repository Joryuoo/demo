package com.example.demo_pf;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public AnchorPane apSigninPane;
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

    public void showError(String errorMessage){
        labelErrorMessage.setVisible(true);
        labelErrorMessage.setManaged(true);
        labelErrorMessage.setText(errorMessage);
        isError = true;
    }


    public void onSigninButtonClick(MouseEvent mouseEvent) throws IOException {

        if(tfUsername.getText().isEmpty() || tfPassword.getText().isEmpty()){
            showError("Fields cannot be empty!");
        } else{
            String username = tfUsername.getText().trim();
            String password = tfPassword.getText().trim();
            if((DatabaseManager.getInstance().search(username)) > -1){
                int result = DatabaseManager.getInstance().verifyUser(username, password);

                if(result == 0){
                    System.out.println(SessionUser.getInstance().toString());
                    loadStudentInterface();
                } else if( result == 1){
                    System.out.println(SessionUser.getInstance().toString());
                } else {
                    showError("Incorrect Password");
                }
            } else{
                showError("User does not exist");
            }
        }
    }

    public void loadStudentInterface() throws IOException {
        Stage stage = (Stage) apSigninPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("student-interface-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 474);
        stage.setResizable(false);
        stage.setTitle("Student");
        stage.setScene(scene);
        stage.show();
    }
}