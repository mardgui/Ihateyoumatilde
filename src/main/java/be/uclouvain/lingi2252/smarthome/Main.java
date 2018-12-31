package be.uclouvain.lingi2252.smarthome;

import be.uclouvain.lingi2252.groupN.parameterization.Parameterization;
import be.uclouvain.lingi2252.smarthome.controller.HouseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {
    private static HouseController houseController;

    public static HouseController getHouseController() {
        return houseController;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parameterization.getInstance().initialize(Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "richHouse.json").toString());

        String fxmlFile = "/fxml/house.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = (Parent) fxmlLoader.load(getClass().getResourceAsStream(fxmlFile));
        houseController = fxmlLoader.getController();

        primaryStage.setTitle("Home Automation System - Group N FTW");
        primaryStage.setScene(new Scene(rootNode, 1200, 800));
        primaryStage.show();
    }
}
