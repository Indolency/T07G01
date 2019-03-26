package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import logic.Driver;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeWindowController implements Initializable {

    @FXML
    private ChoiceBox<Integer> numOfPlayersChoiceBox;

    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void OKbButtonClicked(ActionEvent event) throws IOException {
        Object num = numOfPlayersChoiceBox.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/createPlayers.fxml"));
        Parent createPlayersParent = loader.load();
        CreatePlayersController controller = loader.getController();
        controller.fillWelcomeVBox((int) num);
        controller.setDriver(getDriver());

        Scene createPlayerScene = new Scene(createPlayersParent);
        Stage createPlayerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        createPlayerStage.setScene(createPlayerScene);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Integer> numOfPlayersList = FXCollections.observableArrayList(2,3,4,5,6);
        numOfPlayersChoiceBox.setValue(2);
        numOfPlayersChoiceBox.setItems(numOfPlayersList);
    }

}