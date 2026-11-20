package org.example.javafxtableviewframework;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TableviewController implements Initializable {
    @FXML
    public TableView<ObservableList<String>> tableView;
    @FXML
    public TableColumn<ObservableList<String>, String> tableColumn0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
