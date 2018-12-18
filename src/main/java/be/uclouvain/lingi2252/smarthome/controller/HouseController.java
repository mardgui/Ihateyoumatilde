package be.uclouvain.lingi2252.smarthome.controller;

import be.uclouvain.lingi2252.groupN.House;
import be.uclouvain.lingi2252.groupN.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Callback;
import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;

import java.io.IOException;

public class HouseController {
    private ObservableList<Room> roomList = FXCollections.observableArrayList();
    @FXML
    private GridView<Room> roomGridView;
    private House house = House.getInstance();

    @FXML
    public void initialize() {
        roomList.clear();
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
                                        Parent gridElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((RoomController) loader.getController()).initialize(item);
                                        // Display content of the fxml file
                                        this.setGraphic(gridElement);

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

        roomGridView.setCellHeight(200.0);
        roomGridView.setCellWidth(200.0);
        roomGridView.setHorizontalCellSpacing(10.0);
        roomGridView.setVerticalCellSpacing(10.0);

    }
}
