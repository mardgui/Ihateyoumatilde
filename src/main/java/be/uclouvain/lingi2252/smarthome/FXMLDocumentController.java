package be.uclouvain.lingi2252.smarthome;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

/**
 *
 * @author MB
 */
public class FXMLDocumentController implements Initializable {

    //These items are for the ListView and TextArea example
    @FXML private ListView<String> listView;
    @FXML private TextArea golfTextArea;

    /**
     * When this method is called, it will change the Scene to
     * a TableView example
     */

    /**
     * This method will copy the Strings from the ListView and put them in the text area
     */
    public void listViewButtonPushed()
    {
        String textAreaString = "";

        ObservableList<String> listOfItems = listView.getSelectionModel().getSelectedItems();

        for (Object item : listOfItems)
        {
            textAreaString += String.format("%s%n",(String) item);
        }

        this.golfTextArea.setText(textAreaString);
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //These items are for configuring the ListArea
        listView.getItems().addAll("Golf Balls","Wedges","Irons","Tees","Driver","Putter");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

}