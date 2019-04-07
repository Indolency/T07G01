package controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.effect.*;
import javafx.stage.Stage;
import logic.Country;
import logic.Driver;
import logic.Player;

import java.util.*;
import java.net.*;

/**
 * Controls the map FXML, visually updates the colours and troops.
 * @author T07G01
 * @since 2019-03-23
 */
public class MapController implements Initializable {

    @FXML private ImageView ADImage;
    @FXML private Image ADscale = new Image("images/ADscale.png");
    @FXML private Label AD;
    @FXML private Label ADTroops;
    @FXML private ImageView APTSImage;
    @FXML private Image APTSscale = new Image("images/APTSscale.png");
    @FXML private Label APTS;
    @FXML private Label APTSTroops;
    @FXML private ImageView ARTSPARKImage;
    @FXML private Image ARTSPARKscale = new Image("images/ARTSPARKscale.png");
    @FXML private Label ARTSPARK;
    @FXML private Label ARTSPARKTroops;
    @FXML private ImageView BSImage;
    @FXML private Image BSscale = new Image("images/BSscale.png");
    @FXML private Label BS;
    @FXML private Label BSTroops;
    @FXML private ImageView CCITImage;
    @FXML private Image CCITscale = new Image("images/CCITscale.png");
    @FXML private Label CCIT;
    @FXML private Label CCITTroops;
    @FXML private ImageView CHCImage;
    @FXML private Image CHCscale = new Image("images/CHCscale.png");
    @FXML private Label CHC;
    @FXML private Label CHCTroops;
    @FXML private ImageView CHGImage;
    @FXML private Image CHGscale = new Image("images/CHGscale.png");
    @FXML private Label CHG;
    @FXML private Label CHGTroops;
    @FXML private ImageView DCImage;
    @FXML private Image DCscale = new Image("images/DCscale.png");
    @FXML private Label DC;
    @FXML private Label DCTroops;
    @FXML private ImageView EDUCImage;
    @FXML private Image EDUCscale = new Image("images/EDUCscale.png");
    @FXML private Label EDUC;
    @FXML private Label EDUCTroops;
    @FXML private ImageView EEELImage;
    @FXML private Image EEELscale = new Image("images/EEELscale.png");
    @FXML private Label EEEL;
    @FXML private Label EEELTroops;
    @FXML private ImageView ENAImage;
    @FXML private Image ENAscale = new Image("images/ENAscale.png");
    @FXML private Label ENA;
    @FXML private Label ENATroops;
    @FXML private ImageView ENBImage;
    @FXML private Image ENBscale = new Image("images/ENBscale.png");
    @FXML private Label ENB;
    @FXML private Label ENBTroops;
    @FXML private ImageView ENCImage;
    @FXML private Image ENCscale = new Image("images/ENCscale.png");
    @FXML private Label ENC;
    @FXML private Label ENCTroops;
    @FXML private ImageView ENDImage;
    @FXML private Image ENDscale = new Image("images/ENDscale.png");
    @FXML private Label END;
    @FXML private Label ENDTroops;
    @FXML private ImageView ENFImage;
    @FXML private Image ENFscale = new Image("images/ENFscale.png");
    @FXML private Label ENF;
    @FXML private Label ENFTroops;
    @FXML private ImageView ESImage;
    @FXML private Image ESscale = new Image("images/ESscale.png");
    @FXML private Label ES;
    @FXML private Label ESTroops;
    @FXML private ImageView HYBRIDImage;
    @FXML private Image HYBRIDscale = new Image("images/HYBRIDscale.png");
    @FXML private Label HYBRID;
    @FXML private Label HYBRIDTroops;
    @FXML private ImageView ICTImage;
    @FXML private Image ICTscale = new Image("images/ICTscale.png");
    @FXML private Label ICT;
    @FXML private Label ICTTroops;
    @FXML private ImageView IHImage;
    @FXML private Image IHscale = new Image("images/IHscale.png");
    @FXML private Label IH;
    @FXML private Label IHTroops;
    @FXML private ImageView KNAImage;
    @FXML private Image KNAscale = new Image("images/KNAscale.png");
    @FXML private Label KNA;
    @FXML private Label KNATroops;
    @FXML private ImageView KNBImage;
    @FXML private Image KNBscale = new Image("images/KNBscale.png");
    @FXML private Label KNB;
    @FXML private Label KNBTroops;
    @FXML private ImageView MACHALLImage;
    @FXML private Image MACHALLscale = new Image("images/MACHALLscale.png");
    @FXML private Label MACHALL;
    @FXML private Label MACHALLTroops;
    @FXML private ImageView MBImage;
    @FXML private Image MBscale = new Image("images/MBscale.png");
    @FXML private Label MB;
    @FXML private Label MBTroops;
    @FXML private ImageView MFHImage;
    @FXML private Image MFHscale = new Image("images/MFHscale.png");
    @FXML private Label MFH;
    @FXML private Label MFHTroops;
    @FXML private ImageView MSImage;
    @FXML private Image MSscale = new Image("images/MSscale.png");
    @FXML private Label MS;
    @FXML private Label MSTroops;
    @FXML private ImageView MSCImage;
    @FXML private Image MSCscale = new Image("images/MSCscale.png");
    @FXML private Label MSC;
    @FXML private Label MSCTroops;
    @FXML private ImageView MTImage;
    @FXML private Image MTscale = new Image("images/MTscale.png");
    @FXML private Label MT;
    @FXML private Label MTTroops;
    @FXML private ImageView OOImage;
    @FXML private Image OOscale = new Image("images/OOscale.png");
    @FXML private Label OO;
    @FXML private Label OOTroops;
    @FXML private ImageView PFImage;
    @FXML private Image PFscale = new Image("images/PFscale.png");
    @FXML private Label PF;
    @FXML private Label PFTroops;
    @FXML private ImageView RCImage;
    @FXML private Image RCscale = new Image("images/RCscale.png");
    @FXML private Label RC;
    @FXML private Label RCTroops;
    @FXML private ImageView RTImage;
    @FXML private Image RTscale = new Image("images/RTscale.png");
    @FXML private Label RT;
    @FXML private Label RTTroops;
    @FXML private ImageView SAImage;
    @FXML private Image SAscale = new Image("images/SAscale.png");
    @FXML private Label SA;
    @FXML private Label SATroops;
    @FXML private ImageView SBImage;
    @FXML private Image SBscale = new Image("images/SBscale.png");
    @FXML private Label SB;
    @FXML private Label SBTroops;
    @FXML private ImageView SCURFImage;
    @FXML private Image SCURFscale = new Image("images/SCURFscale.png");
    @FXML private Label SCURF;
    @FXML private Label SCURFTroops;
    @FXML private ImageView SSImage;
    @FXML private Image SSscale = new Image("images/SSscale.png");
    @FXML private Label SS;
    @FXML private Label SSTroops;
    @FXML private ImageView SSEImage;
    @FXML private Image SSEscale = new Image("images/SSEscale.png");
    @FXML private Label SSE;
    @FXML private Label SSETroops;
    @FXML private ImageView STImage;
    @FXML private Image STscale = new Image("images/STscale.png");
    @FXML private Label ST;
    @FXML private Label STTroops;
    @FXML private ImageView TFDLImage;
    @FXML private Image TFDLscale = new Image("images/TFDLscale.png");
    @FXML private Label TFDL;
    @FXML private Label TFDLTroops;
    @FXML private ImageView TIImage;
    @FXML private Image TIscale = new Image("images/TIscale.png");
    @FXML private Label TI;
    @FXML private Label TITroops;
    @FXML private ImageView TRImage;
    @FXML private Image TRscale = new Image("images/TRscale.png");
    @FXML private Label TR;
    @FXML private Label TRTroops;
    @FXML private ImageView TRADImage;
    @FXML private Image TRADscale = new Image("images/TRADscale.png");
    @FXML private Label TRAD;
    @FXML private Label TRADTroops;
    @FXML private ImageView console;//Will be used for final project
    @FXML private VBox draftBox;
    @FXML private Label playerName;
    @FXML private Label phase;
    @FXML private Label draftOutputToUser;
    @FXML private Label draftConfirmation;
    @FXML private ChoiceBox<Integer> draftNumBox;
    @FXML private ChoiceBox<Integer> fortifyNumBox;
    @FXML private Label chooseAttackFrom;
    @FXML private ImageView imageAttackFrom;//Will be used for final project
    @FXML private Label chooseAttack;
    @FXML private ImageView imageAttack;//Will be used for final project
    @FXML private ImageView attackRoll1;
    @FXML private Label attackRollNum1;
    @FXML private ImageView attackRoll2;
    @FXML private Label attackRollNum2;
    @FXML private ImageView attackRoll3;
    @FXML private Label attackRollNum3;
    @FXML private ImageView defendRoll1;
    @FXML private Label defendRollNum1;
    @FXML private ImageView defendRoll2;
    @FXML private Label defendRollNum2;
    @FXML private HBox firstAttackBox;
    @FXML private HBox secondAttackBox;
    @FXML private Label attackResultFrom;
    @FXML private Label attackResultTo;
    @FXML private ImageView imageFortifyFrom;//Will be used for final project
    @FXML private ImageView imageFortify;//Will be used for final project
    @FXML private Label chooseFortifyFrom;
    @FXML private Label chooseFortify;
    @FXML private VBox fortifyTroopsVBox;

    //Instance variables of phase containers on console
    @FXML private VBox draftPhaseContainer;
    @FXML private HBox attackConfirmationContainer;
    @FXML private StackPane attackPhaseContainer;
    @FXML private HBox fortifyConfirmationContainer;
    @FXML private HBox fortifyPhaseContainer;
    @FXML private HBox gameWonContainer;
    @FXML private HBox endGameScreen;


    private double hue1 = -0.96; // orange
    private double hue2 = 0.2; // dark blue
    private double hue3 = 0.5; //purple
    private double hue4 = 0.8; //pink
    private double hue5 = 1.0; //red
    private double hue6 = -0.4; //green

    private ArrayList<Double> hues = new ArrayList<Double>();
    private ArrayList<Label> labels = new ArrayList<Label>();
    private ArrayList<ImageView> images = new ArrayList<ImageView>();
    private ArrayList<Image> scaleImages = new ArrayList<Image>();
    private Image imageToSet;
    private ArrayList<Label> troops = new ArrayList<Label>();
    private ArrayList<StackPane> stacks = new ArrayList<StackPane>();
    private Driver driver;
    private boolean buttonClicked = false;
    private String countryFrom;

    public boolean isButtonClicked() {
        return buttonClicked;
    }

    public void setButtonClicked(boolean buttonClicked) {
        this.buttonClicked = buttonClicked;
    }

    public void setCountryFrom(String countryFrom) {
        this.countryFrom = countryFrom;
    }

    public void setCountryTo(String countryTo) {
        this.countryTo = countryTo;
    }

    private String countryTo;


    /**
     * Setter and Getters necessary
     */
    public void setDriver(Driver driver){
        this.driver = driver;
    }

    public ArrayList<Label> getTroops() {
        return troops;
    }

    public Driver getDriver(){
        return driver;
    }

    /**
     * Constructs the labels ArrayList<Label> instance variable in Controller
     * Each label contains the label for the building name
     */

    public void createLabels(){
        Label[] names = {AD, APTS, ARTSPARK, BS, CCIT, CHC, CHG, DC, EDUC, EEEL,
                ENA, ENB, ENC, END, ENF, ES, HYBRID, ICT, IH, KNA, KNB, MACHALL, MB, MFH,
                MS, MSC, MT, OO, PF, RC, RT, SA, SB, SCURF, SS, SSE, ST, TFDL,
                TI, TR, TRAD};
        for(int i=0; i<41; i++){
            labels.add(names[i]);
        }
    }

    /**
     * Constructs the troops ArrayList<Label> instance variable in Controller
     * Each label contains the number of troops in the building
     */

    public void createTroops(){
        Label[] names = {ADTroops, APTSTroops, ARTSPARKTroops, BSTroops, CCITTroops, CHCTroops, CHGTroops, DCTroops, EDUCTroops, EEELTroops,
                ENATroops, ENBTroops, ENCTroops, ENDTroops, ENFTroops, ESTroops, HYBRIDTroops, ICTTroops, IHTroops, KNATroops, KNBTroops, MACHALLTroops, MBTroops, MFHTroops,
                MSTroops, MSCTroops, MTTroops, OOTroops, PFTroops, RCTroops, RTTroops, SATroops, SBTroops, SCURFTroops, SSTroops, SSETroops, STTroops, TFDLTroops,
                TITroops, TRTroops, TRADTroops};
        for(int i=0; i<41; i++){
            troops.add(names[i]);
        }
    }

    /**
     * Constructs the images ArrayList<ImageView> in Controller
     * Each ImageView contains the image from the images folder
     */
    public void createImages(){
        ImageView[] names = {ADImage, APTSImage, ARTSPARKImage, BSImage, CCITImage, CHCImage, CHGImage,
                DCImage, EDUCImage, EEELImage, ENAImage, ENBImage, ENCImage, ENDImage, ENFImage, ESImage,
                HYBRIDImage, ICTImage, IHImage, KNAImage, KNBImage, MACHALLImage, MBImage, MFHImage, MSImage,
                MSCImage, MTImage, OOImage, PFImage, RCImage, RTImage, SAImage, SBImage, SCURFImage, SSImage,
                SSEImage, STImage, TFDLImage, TIImage, TRImage, TRADImage};
        for(int i=0; i<41; i++){
            images.add(names[i]);
        }
    }

    /**
     * Constructs the scaleImages ArrayList<ImageView> in Controller
     * Each ImageView contains the scaled country image from the images folder
     */
    public void createScaleImages(){
        Image[] names = {ADscale, APTSscale, ARTSPARKscale, BSscale, CCITscale, CHCscale, CHGscale,
                DCscale, EDUCscale, EEELscale, ENAscale, ENBscale, ENCscale, ENDscale, ENFscale, ESscale,
                HYBRIDscale, ICTscale, IHscale, KNAscale, KNBscale, MACHALLscale, MBscale, MFHscale, MSscale,
                MSCscale, MTscale, OOscale, PFscale, RCscale, RTscale, SAscale, SBscale, SCURFscale, SSscale,
                SSEscale, STscale, TFDLscale, TIscale, TRscale, TRADscale};
        for(int i=0; i<41; i++){
            scaleImages.add(names[i]);
        }
    }

    /**
     * This is part of the setup for the updateCountry method that creates the hues
     * for the different players.
     */
    public void setupHues(){
        hues.add(hue1);
        hues.add(hue2);
        hues.add(hue3);
        hues.add(hue4);
        hues.add(hue5);
        hues.add(hue6);
    }


    /**
     * Visually updates the map (by colouring) and sets the number of troops.
     * @param countryName to update the colour/troops
     * @param playerNum which player's turn it is
     */
    @FXML
    public void updateCountry(String countryName, int numOfTroops, int playerNum){
        setupHues();
        Double hue = hues.get(playerNum); //Gets color of player
        createImages();
        createLabels();
        createTroops();

        for (int i = 0; i<41; i++){
            Label label = labels.get(i);
            String imageName = label.getText();
            ImageView image = images.get(i);
            Label troopsBubble = troops.get(i);
            if(countryName.equalsIgnoreCase(imageName)){
                image.setEffect(new ColorAdjust(hue, 0,0,0));
                String num = Integer.toString(numOfTroops);
                troopsBubble.setText(num);
            }
        }
    }

    public void updatePlayerName(Player currentPlayer){
        int num = getDriver().getGameConfig().getListOfPlayers().indexOf(currentPlayer); // Gets current player number
        setupHues();
        Double hue = hues.get(num); //Gets color of player
        //playerName.setTextFill();
        playerName.setText(currentPlayer.getPlayerName().toUpperCase() + "'S TURN");

    }

    /**
     * After the user selects a country that is valid to draft to,
     * this method fills the draftNumBox ChoiceBox to the appropriate number of troops
     * the user still have left.
     */
    public void fillDraftNumBox(){
        int n =  getDriver().getGameConfig().getCurrentPlayer().getDraftNumLeft();
        ObservableList<Integer> list = FXCollections.observableArrayList();
        for (int i=1; i<=n; i++){
            list.add(i);
        }
        draftNumBox.setItems(list);
    }

    /**
     * After the user selects a country that is valid to draft to,
     * this method fills the fortifyNumBox ChoiceBox to the appropriate number of troops
     * the user has in that country available to fortify.
     */
    public void fillFortifyNumBox(String countryName){
        int n =  (getDriver().getGameConfig().getBoard().countryNameToCountry(countryName).getNumOfTroops())-1;
        ObservableList<Integer> list = FXCollections.observableArrayList();
        for (int i=1; i<=n; i++){
            list.add(i);
        }
        fortifyNumBox.setItems(list);
    }


    /**
     * After the user drafts a country, this method empties the draftNumBox ChoiceBox back to 0.
     * It also empties the choiceBox if the country the user chooses is invalid.
     */
    public void emptyDraftNumBox() {
        int n =  getDriver().getGameConfig().getCurrentPlayer().getDraftNumLeft();
        ObservableList<Integer> list = FXCollections.observableArrayList(0);
        draftNumBox.setItems(list);
    }


    /**
     * After checking if the draft move is valid, this initiates the draft in the backend, updates the board,
     * and displays to the user how many troops are left to draft.
     * If the number of drafting troops is equal to 0, then this also loads and displays the confirmation scene to
     * proceed to attack.
     */
    @FXML
    public void draftButtonClicked(){
        getDriver().getGameConfig().getCurrentPlayer().setDraftNum(draftNumBox.getValue());
        emptyDraftNumBox();
        getDriver().getGameConfig().getCurrentPlayer().draft();
        Player p = getDriver().getGameConfig().getCurrentPlayer();
        updateCountry(p.getCountryClicked(), getDriver().getGameConfig().getBoard().countryNameToCountry(p.getCountryClicked()).getNumOfTroops() ,getDriver().getGameConfig().getListOfPlayers().indexOf(p)); //****************** NEEDS TO BE FIGURED OUT **************************


        // If there are no more troops to draft, it loads the confirmation FXML file
        if(getDriver().getGameConfig().getCurrentPlayer().getDraftNumLeft() == 0) {
            draftPhaseContainer.setVisible(false);
            draftConfirmation.setText(null);

            //shows attackConfirmation
            attackConfirmationContainer.setVisible(true);
            phase.setText("Would you like to continue to the attack phase?");
        }
        // otherwise, it continues to ask the user to draft
        else{
            draftOutputToUser.setText("You still have "+getDriver().getGameConfig().getCurrentPlayer().getDraftNumLeft()+" troops left. Choose another country.");
        }
    }





    /**
     * Displays the proper window if the user decides to continue to attack or fortify.
     * This method loads the proper fxml files and sets the scene of the window stage.
     */
    public void attackYesBtnClicked() {
        //sets the console to the attack phase
        attackConfirmationContainer.setVisible(false);
        attackPhaseContainer.setVisible(true);
        playerName.setText(getDriver().getGameConfig().getCurrentPlayer().getPlayerName().toUpperCase()+"'S TURN");
        phase.setText("ATTACK PHASE");
        firstAttackBox.setVisible(true);
        secondAttackBox.setVisible(false);
    }


    /**
     * Displays and loads the proper scenes when the user declines to attack.
     * This method loads the proper fxml file and sets the scene of the window stage.
     */
    public void attackNoBtnClicked() {
        attackConfirmationContainer.setVisible(false);
        fortifyConfirmationContainer.setVisible(true);
        phase.setText("Would you like to continue to the fortify phase?");
    }

    public void continueButtonAttackClicked() {
        if (countryFrom == null) {
            chooseAttackFrom.setText("Move is not valid.");
        }
        else {
            setButtonClicked(true);
            chooseAttack.setText("Please choose a country to attack");
            chooseAttack.setVisible(true);
        }
    }

    @FXML
    public void attackButtonClicked(){
        if (countryTo!=null) {
            firstAttackBox.setVisible(false);
            secondAttackBox.setVisible(true);
            Player p = getDriver().getGameConfig().getCurrentPlayer();
            p.setCountryClicked(countryFrom);
            p.setNextCountryClicked(countryTo);
            p.attack();
            displayDice();
            Country from = getDriver().getGameConfig().getBoard().countryNameToCountry(countryFrom);
            Country to = getDriver().getGameConfig().getBoard().countryNameToCountry(countryTo);
            updateCountry(countryFrom, from.getNumOfTroops(), getDriver().getGameConfig().getListOfPlayers().indexOf(from.getPlayerPossession()));
            updateCountry(countryTo, to.getNumOfTroops(), getDriver().getGameConfig().getListOfPlayers().indexOf(to.getPlayerPossession()));


            if (from.getPlayerPossession() == to.getPlayerPossession() && getDriver().getGameConfig().getBoard().checkWinner()) {
                boolean winner = p.getWinner(); // Checks if the current player has won
                if (winner) {
                    // set player name as the winner
                    attackPhaseContainer.setVisible(false);
                    playerName.setText("CONGRATULATIONS!");
                    playerName.setText(p.getPlayerName().toUpperCase() + " has conquered U of C!");
                    gameWonContainer.setVisible(true);
                }
            }

            else if (from.getPlayerPossession() == to.getPlayerPossession()) {
                attackPhaseContainer.setVisible(false);
                attackConfirmationContainer.setVisible(true);
                playerName.setText(getDriver().getGameConfig().getCurrentPlayer().getPlayerName() + " has conquered " + countryTo + "!");
                phase.setText("Would you like to continue to the attack phase?");
                setCountryFrom(null);
                setCountryTo(null);
                setButtonClicked(false);
                secondAttackBox.setVisible(false);
                firstAttackBox.setVisible(true);
                chooseAttackFrom.setText("Choose a country you would like to attack from.");
                chooseAttackFrom.setText("Choose a country to attack from");
                imageAttackFrom.setVisible(false);
                imageAttack.setVisible(false);
                chooseAttackFrom.setVisible(true);
                chooseAttack.setText(null);

            }

        }
    }


    public void continueAttackClicked() {
        setCountryFrom(null);
        setCountryTo(null);
        setButtonClicked(false);
        secondAttackBox.setVisible(false);
        firstAttackBox.setVisible(true);
        chooseAttackFrom.setText("Choose a country you would like to attack from.");
        chooseAttackFrom.setText("Choose a country to attack from");
        imageAttackFrom.setVisible(false);
        imageAttack.setVisible(false);
        chooseAttackFrom.setVisible(true);
        chooseAttack.setText(null);
    }

    public void notContinueAttackClicked() {
        setCountryFrom(null);
        setCountryTo(null);
        setButtonClicked(false);
        chooseAttackFrom.setText("Choose a country you would like to attack from.");
        chooseAttackFrom.setText("Choose a country to attack from");
        imageAttackFrom.setVisible(false);
        imageAttack.setVisible(false);
        chooseAttackFrom.setVisible(true);
        chooseAttack.setText(null);
        secondAttackBox.setVisible(false);
        firstAttackBox.setVisible(true);
        attackPhaseContainer.setVisible(false);
        fortifyConfirmationContainer.setVisible(true);
        phase.setText("Would you like to continue to the fortify phase?");
    }


    public void fortifyYesBtnClicked() {
        fortifyConfirmationContainer.setVisible(false);
        fortifyPhaseContainer.setVisible(true);
        phase.setText("FORTIFY PHASE");
        chooseFortifyFrom.setText("Choose country to fortify from");


    }


    /**
     * Displays and loads the proper scenes when the user declines to fortify.
     * This method loads the proper fxml file, changes to the next player, and sets the scene of the window stage.
     */
    public void fortifyNoBtnClicked() {
        //Sets the new current player
        Player currentPlayer = getDriver().getGameConfig().getCurrentPlayer();
        int numOfNewPlayer;

        if(getDriver().getGameConfig().getListOfPlayers().size() == getDriver().getGameConfig().getListOfPlayers().indexOf(currentPlayer)+1)
            numOfNewPlayer = 0;
        else
            numOfNewPlayer = getDriver().getGameConfig().getListOfPlayers().indexOf(currentPlayer)+1;

        Player newCurrentPlayer = getDriver().getGameConfig().getListOfPlayers().get(numOfNewPlayer);
        getDriver().getGameConfig().setCurrentPlayer(newCurrentPlayer);
        getDriver().getGameConfig().getCurrentPlayer().setDraftNumLeft(getDriver().getGameConfig().getCurrentPlayer().draftNum());


        //sets the console back to the Draft phase
        fortifyConfirmationContainer.setVisible(false);
        draftPhaseContainer.setVisible(true);
        playerName.setText(newCurrentPlayer.getPlayerName().toUpperCase() + "'S TURN");
        phase.setText("DRAFT PHASE");
        if(getDriver().getGameConfig().getListOfPlayerTypes().get(numOfNewPlayer).equalsIgnoreCase("ai")) {
            AIturn(newCurrentPlayer);
        }
    }


    public void continueButtonFortifyClicked() {
        if (countryFrom == null) {
            chooseFortifyFrom.setText("Move is not valid. \nPick a country to fortify from.");
        }
        else {
            setButtonClicked(true);
            chooseFortify.setText("Please choose a country to fortify");
            chooseFortify.setVisible(true);
        }
    }

    @FXML
    public void fortifyButtonClicked(){
        if (countryTo!=null) {
            Player currentPlayer = getDriver().getGameConfig().getCurrentPlayer();
            currentPlayer.setCountryClicked(countryFrom);
            currentPlayer.setNextCountryClicked(countryTo);
            int num = fortifyNumBox.getValue();
            currentPlayer.fortify(num);
            Country from = getDriver().getGameConfig().getBoard().countryNameToCountry(countryFrom);
            Country to = getDriver().getGameConfig().getBoard().countryNameToCountry(countryTo);
            updateCountry(countryFrom, from.getNumOfTroops(), getDriver().getGameConfig().getListOfPlayers().indexOf(from.getPlayerPossession()));
            updateCountry(countryTo, to.getNumOfTroops(), getDriver().getGameConfig().getListOfPlayers().indexOf(to.getPlayerPossession()));

            //Sets the new current player
            int numOfNewPlayer;

            if(getDriver().getGameConfig().getListOfPlayers().size() == getDriver().getGameConfig().getListOfPlayers().indexOf(currentPlayer)+1)
                numOfNewPlayer = 0;
            else
                numOfNewPlayer = getDriver().getGameConfig().getListOfPlayers().indexOf(currentPlayer)+1;

            Player newCurrentPlayer = getDriver().getGameConfig().getListOfPlayers().get(numOfNewPlayer);
            getDriver().getGameConfig().setCurrentPlayer(newCurrentPlayer);
            getDriver().getGameConfig().getCurrentPlayer().setDraftNumLeft(getDriver().getGameConfig().getCurrentPlayer().draftNum());

            //sets the console back to the Draft phase
            fortifyPhaseContainer.setVisible(false);
            setCountryFrom(null);
            setCountryTo(null);
            setButtonClicked(false);
            chooseFortifyFrom.setText("Choose a country to fortify from");
            imageFortifyFrom.setVisible(false);
            imageFortify.setVisible(false);
            chooseFortifyFrom.setVisible(true);
            chooseFortify.setText(null);
            draftPhaseContainer.setVisible(true);
            playerName.setText(newCurrentPlayer.getPlayerName().toUpperCase() + "'S TURN");
            phase.setText("DRAFT PHASE");
            if(getDriver().getGameConfig().getListOfPlayerTypes().get(numOfNewPlayer).equalsIgnoreCase("ai")){
                AIturn(newCurrentPlayer);
            }
        }
    }


    /**
     * Displays the dice rolled on screen.
     */
    public void displayDice(){
        Player p = getDriver().getGameConfig().getCurrentPlayer();
        int a = p.getAttackerRoll().size();
        int d = p.getDefenderRoll().size();
        ArrayList<Integer> list = p.getComparisonRoll();

        // Sets label text for attacker
        if (list.get(0) == 0)
            attackResultFrom.setText("You did not lose troops.");
        else if (list.get(0) <= 1)
            attackResultFrom.setText("You lost "+Math.abs(list.get(0))+" troop.");

        // Sets label text for defender
        if (list.get(1) == 0)
            attackResultTo.setText("Your opponent did not \nlose any troops");
        else if (list.get(1) <= 1)
            attackResultTo.setText("Your opponent lost\n"+Math.abs(list.get(1))+" troop.");

        if (a==3 && d==2){
            defendRoll1.setVisible(true);
            defendRoll2.setVisible(true);
            attackRoll1.setVisible(true);
            attackRoll2.setVisible(true);
            attackRoll3.setVisible(true);

            defendRollNum1.setText(Integer.toString(p.getDefenderRoll().get(0)));
            defendRollNum2.setText(Integer.toString(p.getDefenderRoll().get(1)));
            attackRollNum1.setText(Integer.toString(p.getAttackerRoll().get(0)));
            attackRollNum2.setText(Integer.toString(p.getAttackerRoll().get(1)));
            attackRollNum3.setText(Integer.toString(p.getAttackerRoll().get(2)));
        }
        else if (a==2 && d==2) {
            defendRoll1.setVisible(true);
            defendRoll2.setVisible(true);
            attackRoll1.setVisible(true);
            attackRoll2.setVisible(true);

            defendRollNum1.setText(Integer.toString(p.getDefenderRoll().get(0)));
            defendRollNum2.setText(Integer.toString(p.getDefenderRoll().get(1)));
            attackRollNum1.setText(Integer.toString(p.getAttackerRoll().get(0)));
            attackRollNum2.setText(Integer.toString(p.getAttackerRoll().get(1)));
        }
        else if (a==2 && d==1) {
            defendRoll1.setVisible(true);
            attackRoll1.setVisible(true);
            attackRoll2.setVisible(true);

            defendRollNum1.setText(Integer.toString(p.getDefenderRoll().get(0)));
            attackRollNum1.setText(Integer.toString(p.getAttackerRoll().get(0)));
            attackRollNum2.setText(Integer.toString(p.getAttackerRoll().get(1)));
        }
        else if (a==3 && d==1) {
            defendRoll1.setVisible(true);
            attackRoll1.setVisible(true);
            attackRoll2.setVisible(true);
            attackRoll3.setVisible(true);

            defendRollNum1.setText(Integer.toString(p.getDefenderRoll().get(0)));
            attackRollNum1.setText(Integer.toString(p.getAttackerRoll().get(0)));
            attackRollNum2.setText(Integer.toString(p.getAttackerRoll().get(1)));
            attackRollNum3.setText(Integer.toString(p.getAttackerRoll().get(2)));
        }
    }



    /**
     * MouseEvent that displays if the country the user chooses to draft is valid
     * or not. Displays to the user if valid or not.
     * @param event takes a mouse event.
     */
    @FXML
    public void countryClicked(MouseEvent event) {
        if (phase.getText().equalsIgnoreCase("draft phase")){
            buttonIsDraft(event);
        }
        if (phase.getText().equalsIgnoreCase("attack phase")){
            buttonIsAttack(event);
        }
        if (phase.getText().equalsIgnoreCase("fortify phase")){
            buttonIsFortify(event);
        }
    }

    /**
     * Button that allows user to draft with their country choices.
     * @param event takes a mouse event.
     */
    public void buttonIsDraft(MouseEvent event){
        Label label = (Label) event.getSource();
        String labelText = label.getText();
        getDriver().getGameConfig().getCurrentPlayer().setCountryClicked(labelText);
        if (getDriver().getGameConfig().getCurrentPlayer().checkDraftValid(labelText)){
            draftConfirmation.setText("You chose: "+labelText);
            fillDraftNumBox();
        }
        else{
            draftConfirmation.setText("Please choose a country that you own.");
            emptyDraftNumBox();
        }
    }

    public void setImageToSet(String countryName){
        createScaleImages();
        createLabels();

        //Finds the scaled image to display
        for (int i = 0; i<41; i++){
            Label label = labels.get(i);
            String imageName = label.getText();
            Image image = scaleImages.get(i);
            if(countryName.equalsIgnoreCase(imageName)){
                imageToSet = image;
            }
        }
    }

    public Image getImageToSet(){
        return imageToSet;
    }

    @FXML
    public void buttonIsAttack(MouseEvent event) {
        String countryName = ((Label) event.getSource()).getText();
        Player p = getDriver().getGameConfig().getCurrentPlayer();
        //Commented out will maybe be added later
        //setupHues();
        //Double hue = hues.get(getDriver().getGameConfig().getListOfPlayers().indexOf(p));
        setImageToSet(countryName);
        //ImageView imageViewToSet = new ImageView(imageToSet);


        if (!isButtonClicked()){
            if (p.checkValidAttackFrom(countryName)){
                chooseAttackFrom.setVisible(false);
                imageAttackFrom.setImage(getImageToSet());
                //imageViewToSet.setEffect(new ColorAdjust(hue, 0,0,0));
                imageAttackFrom.setVisible(true);
                setCountryFrom(countryName);

            }
            else{
                imageAttackFrom.setVisible(false);
                chooseAttackFrom.setText(countryName+ " is not valid");
                chooseAttackFrom.setVisible(true);
                setButtonClicked(false);
            }
        }
        else{
            if (countryFrom == null) {
                setButtonClicked(false);
            }
            if (p.checkValidAttackTo(countryFrom, countryName)){
                chooseAttack.setVisible(false);
                imageAttack.setImage(getImageToSet());
                imageAttack.setVisible(true);
                setCountryTo(countryName);
            }
            else{
                imageAttack.setVisible(false);
                chooseAttack.setText(countryName+ " is not valid");
                chooseAttack.setVisible(true);
            }
        }
    }

    public void buttonIsFortify(MouseEvent event){
        String countryName = ((Label) event.getSource()).getText();
        Player p = getDriver().getGameConfig().getCurrentPlayer();
        setImageToSet(countryName);

        if (!isButtonClicked()){
            if (p.checkValidFortifyFrom(countryName)){
                chooseFortifyFrom.setVisible(false);
                imageFortifyFrom.setImage(getImageToSet());
                imageFortifyFrom.setVisible(true);
                setCountryFrom(countryName);
            }
            else{
                imageFortifyFrom.setVisible(false);
                chooseFortifyFrom.setText(countryName+ " is not valid. \nPick a country to fortify from.");
                chooseFortifyFrom.setVisible(true);
                setButtonClicked(false);
            }
        }
        else{
            if (countryFrom == null) {
                setButtonClicked(false);
            }
            if (p.checkValidFortifyTo(countryFrom, countryName)){
                chooseFortify.setVisible(false);
                imageFortify.setImage(getImageToSet());
                imageFortify.setVisible(true);
                setCountryTo(countryName);
                fortifyTroopsVBox.setVisible(true);
                fillFortifyNumBox(countryFrom);
            }
            else{
                imageFortify.setVisible(false);
                chooseFortify.setText(countryName+ " is not valid");
                chooseFortify.setVisible(true);
                fortifyTroopsVBox.setVisible(false);
            }
        }
    }








    public void AIturn(Player currentPlayer){
        updatePlayerName(currentPlayer);
        currentPlayer.draft();
        currentPlayer.attack();
        currentPlayer.fortify(2);


        // Loops through visually set up the map with colours
        for (int i=0; i<41; i++){
            Country country = getDriver().getGameConfig().getBoard().getCountriesList().get(i); // Gets the current country to colour
            String countryName = country.getCountryName();
            int numOfTroops = country.getNumOfTroops();
            int num = getDriver().getGameConfig().getListOfPlayers().indexOf(country.getPlayerPossession()); // Gets current player number
            updateCountry(countryName, numOfTroops, num); // Depending on the country and current player, will colour
        }

        if (getDriver().getGameConfig().getBoard().checkWinner()) {
            boolean winner = currentPlayer.getWinner(); // Checks if the current player has won
            if (winner) {
                // set player name as the winner
                attackPhaseContainer.setVisible(false);
                draftPhaseContainer.setVisible(false);
                playerName.setText("CONGRATULATIONS!");
                playerName.setText(currentPlayer.getPlayerName().toUpperCase() + " has conquered U of C!");
                gameWonContainer.setVisible(true);
            }
        }

        //Sets up the next player's turn
            else {
            int numOfNewPlayer;

            if (getDriver().getGameConfig().getListOfPlayers().size() == getDriver().getGameConfig().getListOfPlayers().indexOf(currentPlayer) + 1)
                numOfNewPlayer = 0;
            else
                numOfNewPlayer = getDriver().getGameConfig().getListOfPlayers().indexOf(currentPlayer) + 1;

            Player newCurrentPlayer = getDriver().getGameConfig().getListOfPlayers().get(numOfNewPlayer);
            getDriver().getGameConfig().setCurrentPlayer(newCurrentPlayer);
            getDriver().getGameConfig().getCurrentPlayer().setDraftNumLeft(getDriver().getGameConfig().getCurrentPlayer().draftNum());


            //sets the console back to the Draft phase
            fortifyConfirmationContainer.setVisible(false);
            draftPhaseContainer.setVisible(true);
            playerName.setText(newCurrentPlayer.getPlayerName().toUpperCase() + "'S TURN");

            if (getDriver().getGameConfig().getListOfPlayerTypes().get(numOfNewPlayer).equalsIgnoreCase("ai")) {
                AIturn(newCurrentPlayer);
            }
        }
    }


    /**
     * This method will be connected to the button that indicates yes for t
     */
    public void playAgainYesClicked() throws Exception{
        Stage primaryStage = new Stage();
        getDriver().restart(primaryStage);
    }

    /**
     * This method will be connected to the yes button for asking if the player would want to play play again
     * and changes the playing instance variable to true.
     */
    public void playAgainNoClicked() {
        gameWonContainer.setVisible(false);
        endGameScreen.setVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
