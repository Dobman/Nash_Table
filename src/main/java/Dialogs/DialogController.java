package Dialogs;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import javafx.scene.control.Dialog;
import java.util.Optional;

public class DialogController {
   private static final String LOGIN = "admin";
   private static final String PASSWORD ="password";
    public DialogController() {
    }

    public static void loginD(){

    // Create the custom dialog.
    Dialog<Pair<String, String>> dialog = new Dialog<>();

dialog.setTitle("Login ");
dialog.setHeaderText("Please type your login and password");



    // Set the button types.
    ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

    // Create the username and password labels and fields.
    GridPane grid = new GridPane();
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(20, 150, 10, 10));

    TextField username = new TextField();
username.setPromptText("Username");
    PasswordField password = new PasswordField();
password.setPromptText("Password");

grid.add(new Label("Username:"), 0, 0);
grid.add(username, 1, 0);
grid.add(new Label("Password:"), 0, 1);
grid.add(password, 1, 1);
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

    if(username.getText().equals(LOGIN) && password.getText().equals(PASSWORD)){

      loginButton.setDisable(false);
    }


// Do some validation (using the Java 8 lambda syntax).


dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
dialog.setResultConverter(dialogButton -> {
        if (dialogButton == loginButtonType) {
            return new Pair<>(username.getText(), password.getText());
        }
        return null;
    });

    Optional<Pair<String, String>> result = dialog.showAndWait();

result.ifPresent(usernamePassword -> {
        System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
    });
    }
}
