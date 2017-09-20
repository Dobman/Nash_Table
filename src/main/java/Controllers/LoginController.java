package Controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class LoginController {
    @FXML
    TextField user;
    @FXML
    TextField password;
    @FXML
    CheckBox adminCheckBox;
    @FXML
    Button loginButton;

    private static final String LOGIN = "admin";
    private static final String PASSWORD ="password";

    public void initialize(){
        loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if(user.getText().equals(LOGIN) && password.getText().equals(PASSWORD)){
                        if(adminCheckBox.isSelected()){

                        }
                }
            }
        });

    }
    public void setController(){

    }


}
