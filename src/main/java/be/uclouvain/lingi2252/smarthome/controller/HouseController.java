package be.uclouvain.lingi2252.smarthome.controller;

import be.uclouvain.lingi2252.groupN.House;
import be.uclouvain.lingi2252.groupN.Room;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
import org.controlsfx.control.GridView;
import org.controlsfx.control.GridCell;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HouseController implements Initializable {

    @FXML private AnchorPane housePane;
    private ObservableList<Room> roomList = FXCollections.observableArrayList();
    @FXML private GridView<Room> roomGridView;
    private House house;
    private String houseName;
    @FXML private Rectangle room_box;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*for (Room room : this.house.getRooms()){
            room_box = new Rectangle( 10, 10, 10, 10);
            roomList.add(room_box);
        }*/

        /*GridView<Color> myGrid = new GridView<>(list_room);
        myGrid.setCellFactory(new Callback<GridView<Color>, GridCell<Color>>() {
            public GridCell<Color> call(GridView<Color> gridView) {
                return new ColorGridCell();
            }
        });

        Random r = new Random(System.currentTimeMillis());
        for(int i = 0; i < 500; i++) {
            list_room.add(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), 1.0));
        }
        */
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


    }
}
