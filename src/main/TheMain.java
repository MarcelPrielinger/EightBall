package main;

import controllerview.login.LoginC;
import javafx.application.Application;
import javafx.stage.Stage;

public class TheMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        LoginC.show(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
