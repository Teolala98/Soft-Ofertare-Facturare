package Materiale;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/com/example/View/logIn.fxml"));
        Parent loginRoot = loginLoader.load();
        Scene loginScene = new Scene(loginRoot);


        Stage loginStage = new Stage();
        loginStage.setTitle("Login");
        loginStage.setScene(loginScene);


        LoginController loginController = loginLoader.getController();


        loginController.setOnLoginSuccess(new Runnable() {
            @Override
            public void run() {
                loginStage.close();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/View/profile-view.fxml"));
                    Parent root = fxmlLoader.load();

                    Scene mainScene = new Scene(root, 900, 1000);
                    primaryStage.setTitle("Calcul Materiale");
                    primaryStage.setScene(mainScene);

                    primaryStage.setOnCloseRequest(event -> System.exit(0));

                    primaryStage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        loginStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
