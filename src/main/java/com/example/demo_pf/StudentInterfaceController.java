package com.example.demo_pf;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StudentInterfaceController {

    @FXML
    private Button btnLogOut;

    @FXML
    private TextField tfStudentName;

    @FXML
    public void initialize(){
        String fname = SessionUser.getInstance().logged_in_user.firstname;
        String lname = SessionUser.getInstance().logged_in_user.lastname;
        tfStudentName.setText(fname + " " + lname);
    }

}
