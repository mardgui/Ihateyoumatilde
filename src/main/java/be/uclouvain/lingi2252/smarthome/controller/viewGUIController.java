package be.uclouvain.lingi2252.smarthome.controller;

//import fr.polytech.ihm.JsonManager;
//import fr.polytech.ihm.model.Incident;
import be.uclouvain.lingi2252.groupN.House;
import be.uclouvain.lingi2252.groupN.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class viewGUIController {
    private ObservableList<Room> roomList = FXCollections.observableArrayList();
    /*
    private boolean orderedByCat;
    private boolean orderedByLieu;
    private boolean orderedByDate;
    private boolean orderedByUrgence;
    */

    private House house = House.getInstance();
    @FXML
    private TextField typeCommand;

    @FXML
    private Button enterCommand;

    @FXML
    private ListView<Room> listViewRooms;

    @FXML
    void updateConfiguration(MouseEvent event) {
        try {
            /*Stage stage = (Stage) typeCommand.getScene().getWindow();

            Parent root = FXMLLoader.load(
                    getClass().getResource("/fxml/enterCommand.fxml"));
            Scene s = new Scene(root);
            stage.setScene(s);
            s.getStylesheets().add("/styles/styles.css");
            stage.setTitle("Entered Command");
            stage.show();
            */
            System.out.println("Close the window and reopen with the update configuration");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        /*
        this.orderedByCat = true;
        this.orderedByDate = true;
        this.orderedByLieu = true;
        this.orderedByUrgence = true;
        showArrow(this.catImageV);
        showArrow(this.dateImageV);
        showArrow(this.lieuImageV);
        showArrow(this.urgenceImageV);
        */


        roomList.addAll(house.getRooms());
        /*
        listeViewIncidents.setItems(sortedData);

        this.listeViewIncidents.setCellFactory(
                new Callback<ListView<Incident>, ListCell<Incident>>() {
                    @Override
                    public ListCell<Incident> call(ListView<Incident> listView) {
                        return new ListCell<Incident>() {
                            @Override
                            protected void updateItem(Incident item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    try {
                                        String fxmlFile = "/fxml/incidents.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((IncidentController) loader.getController()).initialize(item); //TODO
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

        this.trieCat.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    catImageV.getTransforms().add(new Rotate(180, 5, 5));
                    if (orderedByCat) {
                        incidentList.sort(comparatorIncident_byCat);
                        orderedByCat = false;

                    } else {
                        incidentList.sort(comparatorIncident_byCat);
                        Collections.reverse(incidentList);
                        orderedByCat = true;
                    }
                    disabledArrow(catImageV);
                });

        this.trieDate.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    dateImageV.getTransforms().add(new Rotate(180, 5, 5));
                    if (orderedByDate) {
                        incidentList.sort(comparatorIncident_byDate);
                        orderedByDate = false;
                    } else {
                        incidentList.sort(comparatorIncident_byDate);
                        Collections.reverse(incidentList);
                        orderedByDate = true;
                    }
                    disabledArrow(dateImageV);
                });

        this.trieLieu.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    lieuImageV.getTransforms().add(new Rotate(180, 5, 5));
                    if (orderedByLieu) {
                        incidentList.sort(comparatorIncident_byLieu);
                        orderedByLieu = false;
                    } else {
                        incidentList.sort(comparatorIncident_byLieu);
                        Collections.reverse(incidentList);
                        orderedByLieu = true;
                    }
                    disabledArrow(lieuImageV);
                });

        this.trieUrgence.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    urgenceImageV.getTransforms().add(new Rotate(180, 5, 5));
                    if (orderedByUrgence) {
                        incidentList.sort(comparatorIncident_byUrgence);
                        orderedByUrgence = false;
                    } else {
                        incidentList.sort(comparatorIncident_byUrgence);
                        Collections.reverse(incidentList);
                        orderedByUrgence = true;
                    }
                    disabledArrow(urgenceImageV);

                });

        //Found on http://code.makery.ch/blog/javafx-8-tableview-sorting-filtering/
        this.rechercherIncident.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(incident -> {
            // If filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowCase = newValue.toLowerCase();
            return incident.getTitle().contains(lowCase) || incident.getEmail().contains(lowCase) || incident.getEmailDomain().contains(lowCase) || incident.getLocationDetail().contains(lowCase);
        }));
    }

    private void disabledArrow(ImageView image) {
        if (!image.equals(catImageV) && !orderedByCat) {
            catImageV.getTransforms().add(new Rotate(180, 5, 5));
            orderedByCat = true;
        }
        if (!image.equals(dateImageV) && !orderedByDate) {
            dateImageV.getTransforms().add(new Rotate(180, 5, 5));
            orderedByDate = true;
        }
        if (!image.equals(lieuImageV) && !orderedByLieu) {
            lieuImageV.getTransforms().add(new Rotate(180, 5, 5));
            orderedByLieu = true;
        }
        if (!image.equals(urgenceImageV) && !orderedByUrgence) {
            urgenceImageV.getTransforms().add(new Rotate(180, 5, 5));
            orderedByUrgence = true;
        }
    }

    private void showArrow(ImageView view) {
        try {
            Image image = new Image("images" + File.separator + "arrow.png");
            view.setImage(image);
            view.setCache(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


    }
}