package controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.effect.*;
import javafx.stage.Stage;
import logic.Country;
import logic.Driver;
import logic.Player;

import java.io.IOException;
import java.util.*;
import java.net.*;

/**
 * Controls the map FXML, visually updates the colours and troops.
 * @author T07G01
 * @since 2019-03-23
 */
public class MapController implements Initializable {

    @FXML private BorderPane gameWindow;
    @FXML private StackPane stackpane;
    @FXML private StackPane stackBackground;
    @FXML private ImageView background;
    @FXML private StackPane stackAD;
    @FXML private ImageView ADImage;
    @FXML private Label AD;
    @FXML private Label ADTroops;
    @FXML private StackPane stackAPTS;
    @FXML private ImageView APTSImage;
    @FXML private Label APTS;
    @FXML private Label APTSTroops;
    @FXML private StackPane stackARTSPARK;
    @FXML private ImageView ARTSPARKImage;
    @FXML private Label ARTSPARK;
    @FXML private Label ARTSPARKTroops;
    @FXML private StackPane stackBS;
    @FXML private ImageView BSImage;
    @FXML private Label BS;
    @FXML private Label BSTroops;
    @FXML private StackPane stackCCIT;
    @FXML private ImageView CCITImage;
    @FXML private Label CCIT;
    @FXML private Label CCITTroops;
    @FXML private StackPane stackCHC;
    @FXML private ImageView CHCImage;
    @FXML private Label CHC;
    @FXML private Label CHCTroops;
    @FXML private StackPane stackCHG;
    @FXML private ImageView CHGImage;
    @FXML private Label CHG;
    @FXML private Label CHGTroops;
    @FXML private StackPane stackDC;
    @FXML private ImageView DCImage;
    @FXML private Label DC;
    @FXML private Label DCTroops;
    @FXML private StackPane stackEDUC;
    @FXML private ImageView EDUCImage;
    @FXML private Label EDUC;
    @FXML private Label EDUCTroops;
    @FXML private StackPane stackEEEL;
    @FXML private ImageView EEELImage;
    @FXML private Label EEEL;
    @FXML private Label EEELTroops;
    @FXML private StackPane stackENA;
    @FXML private ImageView ENAImage;
    @FXML private Label ENA;
    @FXML private Label ENATroops;
    @FXML private StackPane stackENB;
    @FXML private ImageView ENBImage;
    @FXML private Label ENB;
    @FXML private Label ENBTroops;
    @FXML private StackPane stackENC;
    @FXML private ImageView ENCImage;
    @FXML private Label ENC;
    @FXML private Label ENCTroops;
    @FXML private StackPane stackEND;
    @FXML private ImageView ENDImage;
    @FXML private Label END;
    @FXML private Label ENDTroops;
    @FXML private StackPane stackENF;
    @FXML private ImageView ENFImage;
    @FXML private Label ENF;
    @FXML private Label ENFTroops;
    @FXML private StackPane stackES;
    @FXML private ImageView ESImage;
    @FXML private Label ES;
    @FXML private Label ESTroops;
    @FXML private StackPane stackHYBRID;
    @FXML private ImageView HYBRIDImage;
    @FXML private Label HYBRID;
    @FXML private Label HYBRIDTroops;
    @FXML private StackPane stackICT;
    @FXML private ImageView ICTImage;
    @FXML private Label ICT;
    @FXML private Label ICTTroops;
    @FXML private StackPane stackIH;
    @FXML private ImageView IHImage;
    @FXML private Label IH;
    @FXML private Label IHTroops;
    @FXML private StackPane stackKNA;
    @FXML private ImageView KNAImage;
    @FXML private Label KNA;
    @FXML private Label KNATroops;
    @FXML private StackPane stackKNB;
    @FXML private ImageView KNBImage;
    @FXML private Label KNB;
    @FXML private Label KNBTroops;
    @FXML private StackPane stackMACHALL;
    @FXML private ImageView MACHALLImage;
    @FXML private Label MACHALL;
    @FXML private Label MACHALLTroops;
    @FXML private StackPane stackMB;
    @FXML private ImageView MBImage;
    @FXML private Label MB;
    @FXML private Label MBTroops;
    @FXML private StackPane stackMFH;
    @FXML private ImageView MFHImage;
    @FXML private Label MFH;
    @FXML private Label MFHTroops;
    @FXML private StackPane stackMS;
    @FXML private ImageView MSImage;
    @FXML private Label MS;
    @FXML private Label MSTroops;
    @FXML private StackPane stackMSC;
    @FXML private ImageView MSCImage;
    @FXML private Label MSC;
    @FXML private Label MSCTroops;
    @FXML private StackPane stackMT;
    @FXML private ImageView MTImage;
    @FXML private Label MT;
    @FXML private Label MTTroops;
    @FXML private StackPane stackOO;
    @FXML private ImageView OOImage;
    @FXML private Label OO;
    @FXML private Label OOTroops;
    @FXML private StackPane stackPF;
    @FXML private ImageView PFImage;
    @FXML private Label PF;
    @FXML private Label PFTroops;
    @FXML private StackPane stackRC;
    @FXML private ImageView RCImage;
    @FXML private Label RC;
    @FXML private Label RCTroops;
    @FXML private StackPane stackRT;
    @FXML private ImageView RTImage;
    @FXML private Label RT;
    @FXML private Label RTTroops;
    @FXML private StackPane stackSA;
    @FXML private ImageView SAImage;
    @FXML private Label SA;
    @FXML private Label SATroops;
    @FXML private StackPane stackSB;
    @FXML private ImageView SBImage;
    @FXML private Label SB;
    @FXML private Label SBTroops;
    @FXML private StackPane stackSCURF;
    @FXML private ImageView SCURFImage;
    @FXML private Label SCURF;
    @FXML private Label SCURFTroops;
    @FXML private StackPane stackSS;
    @FXML private ImageView SSImage;
    @FXML private Label SS;
    @FXML private Label SSTroops;
    @FXML private StackPane stackSSE;
    @FXML private ImageView SSEImage;
    @FXML private Label SSE;
    @FXML private Label SSETroops;
    @FXML private StackPane stackST;
    @FXML private ImageView STImage;
    @FXML private Label ST;
    @FXML private Label STTroops;
    @FXML private StackPane stackTFDL;
    @FXML private ImageView TFDLImage;
    @FXML private Label TFDL;
    @FXML private Label TFDLTroops;
    @FXML private StackPane stackTI;
    @FXML private ImageView TIImage;
    @FXML private Label TI;
    @FXML private Label TITroops;
    @FXML private StackPane stackTR;
    @FXML private ImageView TRImage;
    @FXML private Label TR;
    @FXML private Label TRTroops;
    @FXML private StackPane stackTRAD;
    @FXML private ImageView TRADImage;
    @FXML private Label TRAD;
    @FXML private Label TRADTroops;
    @FXML private ImageView console;
    @FXML private VBox draftBox;
    @FXML private Label playerName;
    @FXML private Label phase;
    @FXML private Label draftOutputToUser;
    @FXML private Label draftConfirmation;
    @FXML private Button draftButton;
    @FXML private ChoiceBox<Integer> draftNumBox;
    @FXML private VBox attackBox;
    @FXML private Label attackOutputToUser;
    @FXML private Label attackConfirmation;
    @FXML private Label attackFromConfirmation;
    @FXML private Button attackButton;
    @FXML private VBox fortifyBox;
    @FXML private Label outputToUser;
    @FXML private Label fortifyConfirmation;
    @FXML private Button fortifyButton;
    @FXML private ChoiceBox<Integer> fortifyNumBox;
    @FXML private Label phaseLabel;
    @FXML private ScrollPane scrollpane;
    @FXML private Label chooseAttackFrom;
    @FXML private ImageView imageAttackFrom;
    @FXML private Button continueButton;
    @FXML private Label chooseAttack;
    @FXML private ImageView imageAttack;
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
    @FXML private StackPane attackStack;
    @FXML private HBox firstAttackBox;
    @FXML private HBox secondAttackBox;
    @FXML private Label attackResultFrom;
    @FXML private Label attackResultTo;
    @FXML private Button attackContinueBtn;
    @FXML private Button attackNotContinueBtn;
    @FXML private Label conqueredTerritoryLab;
    @FXML private Button attackYesBtn;
    @FXML private Button attackNoBtn;
    @FXML private Button fortifyYesBtn;
    @FXML private Button fortifyNoBtn;
    @FXML private VBox fortifyVBox;
    @FXML private ImageView imageFortifyFrom;
    @FXML private ImageView imageFortify;
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

    public String getCountryFrom() {
        return countryFrom;
    }

    public void setCountryFrom(String countryFrom) {
        this.countryFrom = countryFrom;
    }

    public String getCountryTo() {
        return countryTo;
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

    public ArrayList<Double> getHues() {
        return hues;
    }

    public ArrayList<Label> getLabels() {
        return labels;
    }

    public ArrayList<ImageView> getImages() {
        return images;
    }

    public ArrayList<Label> getTroops() {
        return troops;
    }

    public ArrayList<StackPane> getStacks() {
        return stacks;
    }

    public Driver getDriver(){
        return driver;
    }

    /**
     * Constructs the stacks ArrayList<StackPane> instance variable in Controller
     * Each StackPane contains 2 labels and an ImageView of each building
     */
    public void createStacks(){
        StackPane[] names = {stackAD, stackAPTS, stackARTSPARK, stackBS, stackCCIT, stackCHC, stackCHG, stackDC, stackEDUC, stackEEEL,
                stackENA, stackENB, stackENC, stackEND, stackENF, stackES, stackHYBRID, stackICT, stackIH, stackKNA, stackKNB, stackMACHALL, stackMB, stackMFH,
                stackMS, stackMSC, stackMT, stackOO, stackPF, stackRC, stackRT, stackSA, stackSB, stackSCURF, stackSS, stackSSE, stackST, stackTFDL,
                stackTI, stackTR, stackTRAD};
        for(int i=0; i<41; i++){
            stacks.add(names[i]);
        }
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
     * After checking if the draft move is valid, this initiates the draft in the backend, updates the board,
     * and displays to the user how many troops are left to draft.
     * If the number of drafting troops is equal to 0, then this also loads and displays the confirmation scene to
     * proceed to attack.
     * @param event
     */
    @FXML
    public void draftButtonClicked(MouseEvent event){
        getDriver().getGameConfig().getCurrentPlayer().setDraftNum(draftNumBox.getValue());
        emptyDraftNumBox();
        getDriver().getGameConfig().getCurrentPlayer().draft();
        Player p = getDriver().getGameConfig().getCurrentPlayer();
        updateCountry(p.getCountryClicked(), getDriver().getGameConfig().getBoard().countryNameToCountry(p.getCountryClicked()).getNumOfTroops() ,getDriver().getGameConfig().getListOfPlayers().indexOf(p)); //****************** NEEDS TO BE FIGURED OUT **************************


        // if there are no more troops to draft, it loads the confirmation FXML file
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



    public void buttonIsAttack(MouseEvent event) {
        String countryName = ((Label) event.getSource()).getText();
        Player p = getDriver().getGameConfig().getCurrentPlayer();

        if (!isButtonClicked()){
            if (p.checkValidAttackFrom(countryName)){
                chooseAttackFrom.setText(countryName);
                setCountryFrom(countryName);
            }
            else{
                chooseAttackFrom.setText(countryName+ " is not valid");
                setButtonClicked(false);
            }
        }
        else{
            if (countryFrom == null) {
                setButtonClicked(false);
            }
            if (p.checkValidAttackTo(countryFrom, countryName)){
                chooseAttack.setText(countryName);
                setCountryTo(countryName);
            }
            else{
                chooseAttack.setText(countryName+ " is not valid");
            }
        }
    }

    public void buttonIsFortify(MouseEvent event){
        String countryName = ((Label) event.getSource()).getText();
        Player p = getDriver().getGameConfig().getCurrentPlayer();
        if (!isButtonClicked()){
            if (p.checkValidFortifyFrom(countryName)){
                chooseFortifyFrom.setText(countryName);
                setCountryFrom(countryName);
            }
            else{
                chooseFortifyFrom.setText(countryName+ " is not valid. \nPick a country to fortify from.");
                setButtonClicked(false);
            }
        }
        else{
            if (countryFrom == null) {
                setButtonClicked(false);
            }
            if (p.checkValidFortifyTo(countryFrom, countryName)){
                chooseFortify.setText(countryName);
                setCountryTo(countryName);
                fortifyTroopsVBox.setVisible(true);
                fillFortifyNumBox(countryFrom);
            }
            else{
                chooseFortify.setText(countryName+ " is not valid");
                fortifyTroopsVBox.setVisible(false);
            }
        }
    }

    public void continueButtonFortifyClicked(MouseEvent event) {
        if (countryFrom == null) {
            chooseFortifyFrom.setText("Move is not valid. \nPick a country to fortify from.");
        }
        else {
            setButtonClicked(true);
            chooseFortify.setText("Please choose a country to fortify");
        }
    }

    public void continueButtonAttackClicked(MouseEvent mouseEvent) {
        if (countryFrom == null) {
            chooseAttackFrom.setText("Move is not valid.");
        }
        else {
            setButtonClicked(true);
            chooseAttack.setText("Please choose a country to attack");
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
                chooseAttack.setText(null);

            }

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
     * This method will be connected to the button that indicates yes for t
     */
    public void playAgainYesClicked(MouseEvent event) throws Exception{
        Stage primaryStage = new Stage();
        getDriver().restart(primaryStage);
    }

    /**
     * This method will be connected to the yes button for asking if the player would want to play play again
     * and changes the playing instance variable to true.
     */
    public void playAgainNoClicked(MouseEvent event) {
        gameWonContainer.setVisible(false);
        endGameScreen.setVisible(true);
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

    /**
     * After the user selects a country that is valid to draft to,
     * this method fills the draftNumBox ChoiceBox to the appropriate number of troops
     * the user still have left.
     */
    public void fillDraftNumBox(){
        //getDriver().getGameConfig().getCurrentPlayer().setDraftNumLeft();
        int n =  getDriver().getGameConfig().getCurrentPlayer().getDraftNumLeft();
        ObservableList<Integer> list = FXCollections.observableArrayList();
        for (int i=1; i<=n; i++){
            list.add(i);
        }
        draftNumBox.setItems(list);
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
     * After the user selects a country that is valid to draft to,
     * this method fills the fortifyNumBox ChoiceBox to the appropriate number of troops
     * the user has in that country available to fortify.
     */
    public void fillFortifyNumBox(String countryName){
        //getDriver().getGameConfig().getCurrentPlayer().setDraftNumLeft();
        int n =  (getDriver().getGameConfig().getBoard().countryNameToCountry(countryName).getNumOfTroops())-1;
        ObservableList<Integer> list = FXCollections.observableArrayList();
        for (int i=1; i<=n; i++){
            list.add(i);
        }
        fortifyNumBox.setItems(list);
    }


    public void continueAttackClicked(MouseEvent event) {
        setCountryFrom(null);
        setCountryTo(null);
        setButtonClicked(false);
        secondAttackBox.setVisible(false);
        firstAttackBox.setVisible(true);
        chooseAttackFrom.setText("Choose a country you would like to attack from.");
        chooseAttackFrom.setText("Choose a country to attack from");
        chooseAttack.setText(null);
    }

    public void notContinueAttackClicked(MouseEvent event) {
        setCountryFrom(null);
        setCountryTo(null);
        setButtonClicked(false);
        chooseAttackFrom.setText("Choose a country you would like to attack from.");
        chooseAttackFrom.setText("Choose a country to attack from");
        chooseAttack.setText(null);
        secondAttackBox.setVisible(false);
        firstAttackBox.setVisible(true);
        attackPhaseContainer.setVisible(false);
        fortifyConfirmationContainer.setVisible(true);
        phase.setText("Would you like to continue to the fortify phase?");
    }

    public void updatePlayerName(Player currentPlayer){
        int num = getDriver().getGameConfig().getListOfPlayers().indexOf(currentPlayer); // Gets current player number
        setupHues();
        Double hue = hues.get(num); //Gets color of player
        //playerName.setTextFill();
        playerName.setText(currentPlayer.getPlayerName().toUpperCase() + "'S TURN");

    }

    /**
     * Displays and loads the proper scenes when the user declines to attack.
     * This method loads the proper fxml file and sets the scene of the window stage.
     */
    public void attackNoBtnClicked(MouseEvent event) {
        attackConfirmationContainer.setVisible(false);
        fortifyConfirmationContainer.setVisible(true);
        phase.setText("Would you like to continue to the fortify phase?");
    }

    /**
     * Displays and loads the proper scenes when the user declines to fortify.
     * This method loads the proper fxml file, changes to the next player, and sets the scene of the window stage.
     */
    public void fortifyNoBtnClicked(MouseEvent mouseEvent) {
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


    /**
     * Displays the proper window if the user decides to continue to attack or fortify.
     * This method loads the proper fxml files and sets the scene of the window stage.
     */
    public void attackYesBtnClicked(MouseEvent event) {
        //sets the console to the attack phase
        attackConfirmationContainer.setVisible(false);
        attackPhaseContainer.setVisible(true);
        playerName.setText(getDriver().getGameConfig().getCurrentPlayer().getPlayerName().toUpperCase()+"'S TURN");
        phase.setText("ATTACK PHASE");
        firstAttackBox.setVisible(true);
        secondAttackBox.setVisible(false);
    }

    public void fortifyYesBtnClicked(MouseEvent event) {
        fortifyConfirmationContainer.setVisible(false);
        fortifyPhaseContainer.setVisible(true);
        phase.setText("FORTIFY PHASE");
        chooseFortifyFrom.setText("Choose country to fortify from");


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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
