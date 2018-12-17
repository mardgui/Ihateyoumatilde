package be.uclouvain.lingi2252.smarthome;
import be.uclouvain.lingi2252.groupN.House;
import be.uclouvain.lingi2252.groupN.Room;
import be.uclouvain.lingi2252.groupN.parameterization.Parameterization;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import java.util.List;


public class GridDisplay {

    private static final double ELEMENT_SIZE = 100;
    private static final double GAP = ELEMENT_SIZE / 10;

    private TilePane tilePane = new TilePane();
    private Group display = new Group(tilePane);
    private int nRows;
    private int nCols;
    private int roomNum;
    private ReadOnlyDoubleProperty heightProperty;
    private ReadOnlyDoubleProperty widthProperty;

    /*
    public void updateDisplay() {
        gridPane.getChildren().clear();
        for (int i = 0; i < nbColumn; i++) {
            for (int j = 0; j < nbRow; j++) {
                Rectangle rectangle = new Rectangle(100, 100);
                //Binding the fraction of the grid size to the width
                //and heightProperty of the child
                rectangle.widthProperty().bind(widthProperty.divide(nbColumn));
                rectangle.heightProperty().bind(heightProperty.divide(nbRow));
                gridPane.add(rectangle, i, j);
            }
        }
    }
    */

    public GridDisplay(int nRows, int nCols) {
        tilePane.setStyle("-fx-background-color: rgba(255, 215, 0, 0.1);");
        tilePane.setHgap(GAP);
        tilePane.setVgap(GAP);
        setColumns(nCols);
        setRows(nRows);
    }

    public void setColumns(int newColumns) {
        nCols = newColumns;
        tilePane.setPrefColumns(nCols);
        createElements();
    }

    public void setRows(int newRows) {
        nRows = newRows;
        tilePane.setPrefRows(nRows);
        createElements();
    }

    public Group getDisplay() {
        return display;
    }

    private void createElements() {
        tilePane.getChildren().clear();
        for (int i = 0; i < nCols; i++) {
            for (int j = 0; j < nRows; j++) {
                tilePane.getChildren().add(createElement());
            }
        }
    }

    private Rectangle createElement() {
        Rectangle rectangle = new Rectangle(ELEMENT_SIZE, ELEMENT_SIZE);
        rectangle.setStroke(Color.ORANGE);
        rectangle.setFill(Color.STEELBLUE);

        return rectangle;
    }

}