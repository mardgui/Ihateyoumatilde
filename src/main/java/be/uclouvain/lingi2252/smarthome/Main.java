package be.uclouvain.lingi2252.smarthome;

import be.uclouvain.lingi2252.groupN.House;
import be.uclouvain.lingi2252.groupN.Room;
import be.uclouvain.lingi2252.groupN.parameterization.Parameterization;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parameterization.getInstance().initialize(Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "middleclassHouse.json").toString());

        String fxmlFile = "/fxml/house.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = (Parent) fxmlLoader.load(getClass().getResourceAsStream(fxmlFile));

        House house = House.getInstance();
        /*GridPane grid = new GridPane();

        List roomList = house.getRooms();

        System.out.println(roomList.size());

        for (int i = 0; i < roomList.size(); i++){
            Rectangle rect = new Rectangle(i+1, i+2, 50, 50 );
            rect.setFill(Color.WHITE);
            grid.add(rect, 1, i, 1, 1);
            System.out.println("Print one rect");
        }

        grid.setAlignment(Pos.CENTER);
        */

        primaryStage.setTitle("GUI");
        primaryStage.setScene(new Scene(rootNode, 400, 400));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}