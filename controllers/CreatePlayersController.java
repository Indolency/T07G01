package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.Country;
import logic.Driver;
import logic.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *Controls the createPlayers FXML, handles events to set up and start the game.
 * Sets up the game board and changes the scene to the main play window.
 * @author T07G01
 * @since 2019-03-23
 */
public class CreatePlayersController implements Initializable {

    @FXML
    private VBox welcomeVBox;

    private Driver driver;
    private ArrayList<TextField> texts = new ArrayList<TextField>();
    private ArrayList<ChoiceBox> choices = new ArrayList<ChoiceBox>();


    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void fillWelcomeVBox(int num){
        HBox header = new HBox();
        Label left = new Label("Player Name");
        Label right = new Label("Player Type");
        header.getChildren().addAll(left, right); // Adds the player name and type label
        header.setSpacing(150);

        ArrayList<String> playerTypes = new ArrayList<String>();

        welcomeVBox.getChildren().add(header);
        /* Loops through the number of players and makes a textfield and dropdown menu
        matching the number of players. */
        for (int i=0; i<num; i++){
            HBox player = new HBox();
            TextField name = new TextField();
            texts.add(name);

            ChoiceBox<String> type = new ChoiceBox<String>();
            ObservableList<String> playerTypeList = FXCollections.observableArrayList("HUMAN", "AI");
            type.setValue("HUMAN");
            type.setItems(playerTypeList);
            choices.add(type);

            player.getChildren().addAll(name, type);
            player.setSpacing(50);
            player.setAlignment(Pos.CENTER);
            welcomeVBox.getChildren().add(player);
            playerTypes.add(type.getValue());
        }
        System.out.println(playerTypes.get(0) + playerTypes.get(1));
        welcomeVBox.setSpacing(20);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * Clicking the play button will set up the game and change the scene to the main play
     * area.
     * @param mouseEvent takes in a mouse click
     */
    public void playButtonClicked(MouseEvent mouseEvent) throws IOException {
        ArrayList<String> players = new ArrayList<String>();
        for (TextField text: texts){
            players.add(text.getText());
        }

        ArrayList<String> types = new ArrayList<String>();
        for (ChoiceBox box: choices){
            types.add(box.getSelectionModel().getSelectedItem().toString());
        }

        getDriver().getGameConfig().createPlayers(players, types); // Create players and their types based off of selection
        getDriver().getGameConfig().boardSetup(); // Sets up the board
        getDriver().getGameConfig().getBoard().showBoard(); // Shows board in text

        // Loads the map FXML and changes scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/map.fxml"));
        Parent mapParent = loader.load();
        MapController controller = loader.getController();
        controller.setDriver(getDriver());
        Player currentPlayer = getDriver().getGameConfig().getListOfPlayers().get(0);
        getDriver().getGameConfig().setCurrentPlayer(currentPlayer);
        getDriver().getGameConfig().getCurrentPlayer().setDraftNumLeft(getDriver().getGameConfig().getCurrentPlayer().draftNum());

        Scene mapScene = new Scene(mapParent);
        Stage createPlayerStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        controller.updatePlayerName(currentPlayer);


        // Loops through visually set up the map with colours
        for (int i=0; i<41; i++){
            Country country = getDriver().getGameConfig().getBoard().getCountriesList().get(i); // Gets the current country to colour
            String countryName = country.getCountryName();
            int numOfTroops = country.getNumOfTroops();
            int num = getDriver().getGameConfig().getListOfPlayers().indexOf(country.getPlayerPossession()); // Gets current player number
            controller.updateCountry(countryName, numOfTroops, num); // Depending on the country and current player, will colour
        }

        createPlayerStage.setScene(mapScene);
        createPlayerStage.setMaximized(true);
    }
}
