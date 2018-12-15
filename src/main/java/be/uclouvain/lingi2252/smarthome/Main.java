package be.uclouvain.lingi2252.smarthome;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.layout.*;




public class Main extends Application implements EventHandler<ActionEvent>{

    private Button button;


    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "/fxml/gui_3.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = (Parent) fxmlLoader.load(getClass().getResourceAsStream(fxmlFile));

        primaryStage.setTitle("Title of the Window");
        Scene scene = new Scene(rootNode, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();




        /* Button */
        /*
        button = new Button("Click me");
        //button = new Button(); button.setText("Click me");

        // The code to handle the event when user click on button is in "this" class
        // for the handle method
        button.setOnAction(this);


        /* Layout */
        // button in the center
        /*
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        /* Scene = content inside a window*/
        /*
        Scene scene = new Scene(layout,300, 250);
        primaryStage.setScene(scene);
        //primaryStage.setScene(new Scene(rootNode, 300, 275));


        primaryStage.show();
        */
    }




    // Method called whenever the user calls the button == event
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==button){
            System.out.println("You just clicked me!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}