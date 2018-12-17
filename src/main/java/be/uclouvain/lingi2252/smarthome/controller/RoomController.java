package be.uclouvain.lingi2252.smarthome.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import be.uclouvain.lingi2252.groupN.Room;
import be.uclouvain.lingi2252.groupN.actuators.Actuator;
import be.uclouvain.lingi2252.groupN.actuators.Conditioners;
import be.uclouvain.lingi2252.groupN.actuators.Heaters;
import be.uclouvain.lingi2252.groupN.actuators.Lights;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RoomController {

    private String room_name;
    private Label room_label;
    @FXML private CheckBox room_checker;
    @FXML private Rectangle lightON;
    @FXML private Rectangle lightOFF;
    @FXML private Rectangle conditionerON;
    @FXML private Rectangle conditionerOFF;
    @FXML private Rectangle heaterON;
    @FXML private Rectangle heaterOFF;
    private Room room;
    @FXML private Rectangle room_box;


    @FXML
    public void initialize(Room room) {
        this.room = room;
        this.room_box = new Rectangle(1,1,50, 50);
        lightON.setVisible(false);
        lightOFF.setVisible(false);
        conditionerON.setVisible(false);
        conditionerOFF.setVisible(false);
        heaterON.setVisible(false);
        heaterOFF.setVisible(false);
        fill();

    }

    private void fill(){
        for (Actuator actuator : room.getActuatorList()) {
            if (actuator instanceof Lights) {
                lightOFF.setVisible(true);
                this.lightOFF = new Rectangle(10,10,10,10);
            }
            if (actuator instanceof Conditioners) {
                conditionerOFF.setVisible(true);
                this.conditionerOFF = new Rectangle(10,10,10,10);
            }
            if (actuator instanceof Heaters) {
                heaterOFF.setVisible(true);
                this.heaterOFF = new Rectangle(10,10,10,10);
            }
        }
        //room_label.setText("");
    }

    //TODO methods to turn on / off actuators
}