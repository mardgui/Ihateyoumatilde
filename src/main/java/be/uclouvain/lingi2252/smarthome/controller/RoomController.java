package be.uclouvain.lingi2252.smarthome.controller;


import be.uclouvain.lingi2252.groupN.Room;
import be.uclouvain.lingi2252.groupN.actuators.Actuator;
import be.uclouvain.lingi2252.groupN.actuators.Conditioners;
import be.uclouvain.lingi2252.groupN.actuators.Heaters;
import be.uclouvain.lingi2252.groupN.actuators.Lights;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class RoomController {

    @FXML
    private Label name;
    @FXML
    private Rectangle lightON;
    @FXML
    private Rectangle lightOFF;
    @FXML
    private Rectangle conditionerON;
    @FXML
    private Rectangle conditionerOFF;
    @FXML
    private Rectangle heaterON;
    @FXML
    private Rectangle heaterOFF;
    private Room room;


    @FXML
    public void initialize(Room room) {
        this.room = room;
        lightON.setVisible(false);
        lightOFF.setVisible(false);
        conditionerON.setVisible(false);
        conditionerOFF.setVisible(false);
        heaterON.setVisible(false);
        heaterOFF.setVisible(false);
        fill();

    }

    private void fill() {
        for (Actuator actuator : room.getActuatorList()) {
            if (actuator instanceof Lights) {
                lightON.setVisible(actuator.checkStatus());
                lightOFF.setVisible(!actuator.checkStatus());
            }
            if (actuator instanceof Conditioners) {
                conditionerON.setVisible(actuator.checkStatus());
                conditionerOFF.setVisible(!actuator.checkStatus());
            }
            if (actuator instanceof Heaters) {
                heaterON.setVisible(actuator.checkStatus());
                heaterOFF.setVisible(!actuator.checkStatus());
            }
        }
        name.setText(room.getName());
    }

    public void lightOffClicked(MouseEvent mouseEvent) {
        lightOFF.setVisible(false);
        lightON.setVisible(true);
        room.getActuatorList().stream()
                .filter(actuator -> actuator instanceof Lights)
                .forEach(actuator -> actuator.set(true));
    }

    public void lightOnClicked(MouseEvent mouseEvent) {
        lightON.setVisible(false);
        lightOFF.setVisible(true);
        room.getActuatorList().stream()
                .filter(actuator -> actuator instanceof Lights)
                .forEach(actuator -> actuator.set(false));
    }

    public void heaterOnClicked(MouseEvent mouseEvent) {
        heaterON.setVisible(false);
        heaterOFF.setVisible(true);
        room.getActuatorList().stream()
                .filter(actuator -> actuator instanceof Heaters)
                .forEach(actuator -> actuator.set(false));
    }

    public void conditionerOnClicked(MouseEvent mouseEvent) {
        conditionerON.setVisible(false);
        conditionerOFF.setVisible(true);
        room.getActuatorList().stream()
                .filter(actuator -> actuator instanceof Conditioners)
                .forEach(actuator -> actuator.set(false));
    }

    public void heaterOffClicked(MouseEvent mouseEvent) {
        heaterOFF.setVisible(false);
        heaterON.setVisible(true);
        room.getActuatorList().stream()
                .filter(actuator -> actuator instanceof Heaters)
                .forEach(actuator -> actuator.set(true));
    }

    public void conditionerOffClicked(MouseEvent mouseEvent) {
        conditionerOFF.setVisible(false);
        conditionerON.setVisible(true);
        room.getActuatorList().stream()
                .filter(actuator -> actuator instanceof Conditioners)
                .forEach(actuator -> actuator.set(true));
    }


    //TODO methods to turn on / off actuators
}
