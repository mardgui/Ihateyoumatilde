package be.uclouvain.lingi2252.smarthome.controller;

import be.uclouvain.lingi2252.groupN.House;
import be.uclouvain.lingi2252.groupN.Room;
import be.uclouvain.lingi2252.smarthome.GridDisplay;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.GridView;
import org.controlsfx.control.GridCell;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HouseController {

    @FXML private AnchorPane housePane;
    private ObservableList<Room> roomList = FXCollections.observableArrayList();
    @FXML private GridView<Room> roomGridView;
    private House house = House.getInstance();
    private String houseName;
    private GridDisplay gridDisplay;
    @FXML private Rectangle room_box;

    private void buildTextFieldActions(final TextField rowField, final TextField columnField) {
        rowField.focusedProperty().addListener((ov, t, t1) -> {
            if (!t1) {
                if (!rowField.getText().equals("")) {
                    try {
                        int nbRow = Integer.parseInt(rowField.getText());
                        gridDisplay.setRows(nbRow);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Please enter a valid number.");
                    }
                }
            }
        });

        columnField.focusedProperty().addListener((ov, t, t1) -> {
            if (!t1) {
                if (!columnField.getText().equals("")) {
                    try {
                        int nbColumn = Integer.parseInt(columnField.getText());
                        gridDisplay.setColumns(nbColumn);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Please enter a valid number.");
                    }
                }
            }
        });
    }


    @FXML
    public void initialize() {



        /*
        roomList.addAll(house.getRooms());
        roomGridView.setItems(roomList);


        this.roomGridView.setCellFactory(
                new Callback<GridView<Room>, GridCell<Room>>() {
                    @Override
                    public GridCell<Room> call(GridView<Room> gridView) {
                        return new GridCell<Room>() {
                            @Override
                            protected void updateItem(Room item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    try {
                                        String fxmlFile = "/fxml/room.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((RoomController) loader.getController()).initialize(item); //TODO
                                        // Display content of the fxml file
                                        this.setGraphic(listElement);

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    this.setGraphic(null);
                                    this.setText(null);
                                }
                            }
                        };
                    }
                });

    */






        List roomList = house.getRooms();
        System.out.println("roomList = " + roomList + "\n roomList size = " + roomList.size());
        //List<String> roomNames = roomList.stream().map(room -> room.getName()).collect(Collectors.toList());

        if ( (roomList.size() & 1) == 0 ) {
            System.out.println("Even");
            System.out.println("Rooms:\n");
            for (int i = 0; i < roomList.size(); i++){
                System.out.println();
            }
            gridDisplay = new GridDisplay(roomList.size()/2,roomList.size()/2);
        }
        else{
            System.out.println("Odd");
            int numRow = Math.round(roomList.size()/2);
            int numCol = roomList.size() - numRow;
            System.out.println("Num row = " + numRow + "\n Num col = " + numCol);
            gridDisplay = new GridDisplay(numRow,numCol);
        }
        //Fields to specify number of rows/columns
        TextField rowField = new TextField("2");
        TextField columnField = new TextField("4");

        //Function to set an action when text field loses focus
        buildTextFieldActions(rowField, columnField);

        HBox fields = new HBox(10);
        fields.getChildren().add(rowField);
        fields.getChildren().add(new Label("x"));
        fields.getChildren().add(columnField);

        BorderPane mainPanel = new BorderPane();
        mainPanel.setCenter(gridDisplay.getDisplay());
        mainPanel.setTop(fields);
        Scene scene = new Scene(mainPanel, 1000, 800);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Test grid display");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}