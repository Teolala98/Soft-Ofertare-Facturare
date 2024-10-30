package Materiale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private Runnable onLoginSuccess;

    private final String correctUsername = "ClaraPisuc";
    private final String correctPassword = "123";

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (correctUsername.equals(username) && correctPassword.equals(password)) {

            if (onLoginSuccess != null) {
                onLoginSuccess.run();
            }
        } else {
            errorLabel.setText("Username sau parola incorectă!");
        }
    }


    public void setOnLoginSuccess(Runnable onLoginSuccess) {
        this.onLoginSuccess = onLoginSuccess;
    }
}
