package be.uclouvain.lingi2252.smarthome;

import be.uclouvain.lingi2252.groupN.House;
import be.uclouvain.lingi2252.groupN.Interpreter;
import be.uclouvain.lingi2252.groupN.parameterization.Parameterization;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "/fxml/gui_1.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = (Parent) fxmlLoader.load(getClass().getResourceAsStream(fxmlFile));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(rootNode, 300, 275));
        primaryStage.show();

        Parameterization.getInstance().initialize(Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "middleclassHouse.json").toString());
        House house = House.getInstance();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
