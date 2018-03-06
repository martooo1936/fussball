package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller.getInstance().setStage(primaryStage);
        primaryStage.setTitle("Fusball project");
        Controller.getInstance().loadLoginPage();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    }

