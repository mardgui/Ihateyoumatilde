package be.uclouvain.lingi2252.smarthome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "/fxml/sample.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = (Parent) fxmlLoader.load(getClass().getResourceAsStream(fxmlFile));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(rootNode, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
