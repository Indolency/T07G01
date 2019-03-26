package logic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Player class stores the playerName, board, and player's countriesOwned
 * @version 4.0
 * @author
 * @since 2019-03-2
 */
public abstract class Player{

  protected String playerName;
  protected Board board;
  protected ArrayList<Country> countriesOwned = new ArrayList<Country>();
  protected boolean winner = false;
  protected String countryClicked;
  protected String nextCountryClicked;

  protected int draftNum;
  protected int draftNumLeft = draftNum();

  protected ArrayList<Integer> attackerRoll;
  protected ArrayList<Integer> defenderRoll;
  protected ArrayList<Integer> comparisonRoll;

  public ArrayList<Integer> getComparisonRoll() {
    return comparisonRoll;
  }

  public void setComparisonRoll(ArrayList<Integer> comparisonRoll) {
    this.comparisonRoll = comparisonRoll;
  }

  public ArrayList<Integer> getAttackerRoll() {
    return attackerRoll;
  }

  public void setAttackerRoll(ArrayList<Integer> attackerRoll) {
    this.attackerRoll = attackerRoll;
  }

  public ArrayList<Integer> getDefenderRoll() {
    return defenderRoll;
  }

  public void setDefenderRoll(ArrayList<Integer> defenderRoll) {
    this.defenderRoll = defenderRoll;
  }

  /**
   * Constructs the Player instance using the specified name and points it to
   * main board in Game
   * @param name String that represents the player's name
   * @param board Board that represents the Board found in main in Game
   */
  public Player(String name, Board board){
    setPlayerName(name);
    setBoard(board);
  }

  /**
   * Getter and Setter methods
   */
  public String getPlayerName(){
    return playerName;
  }

  public Board getBoard(){
    return board;
  }

  public ArrayList<Country> getCountriesOwned(){
    return countriesOwned;
  }

  public boolean getWinner() {
    return winner;
  }

  protected void setPlayerName(String name){
    playerName = name;
  }

  protected void setBoard(Board board){
    this.board = board;
  }

  public void setCountriesOwned(ArrayList<Country> list){
    countriesOwned = list;
  }

  protected void setWinner(boolean winLose) {
    winner = winLose;
  }

  public int getDraftNumLeft() {
    return draftNumLeft;
  }

  public void setDraftNumLeft(int draftNumLeft) {
    this.draftNumLeft = draftNumLeft;
  }

  public int getDraftNum() {
    return draftNum;
  }

  public void setDraftNum(int draftNum) {
    this.draftNum = draftNum;
  }

  public String getCountryClicked() {
    return countryClicked;
  }

  public void setCountryClicked(String countryClicked) {
    this.countryClicked = countryClicked;
  }
  public String getNextCountryClicked() {
    return nextCountryClicked;
  }

  public void setNextCountryClicked(String nextCountryClicked) {
    this.nextCountryClicked = nextCountryClicked;
  }

  /**
   * Adds an individual country to the countriesOwned ArrayList
   * @param country Country on the main board in Game that is assigned to this player
   */
  protected void addCountry(Country country){
    countriesOwned.add(country);
  }


  /**
   * Removes an individual country to the countriesOwned ArrayList
   * @param country
   */
  protected void removeCountry(Country country){
    countriesOwned.remove(country);
  }


  /**
   * Abstract methods that are overridden in the corresponding concrete children classes (HumanPlayer or AIPlayer)
   */
  public abstract void draft();

  public abstract void attack();

  public abstract void fortify(int num);

  public abstract boolean checkDraftValid(String labelText);

  public abstract boolean checkValidAttackFrom(String text);

  public abstract boolean checkValidAttackTo(String countryFrom, String countryTo);

  /**
   * Determines the number of troops a player will be able to draft with in the beginning of each turn
   * @return n is an integer that represents the number of troops each player can draft with
   */
  public int draftNum(){
    int enggCounter = 0;
    int knesCounter = 0;
    int scienceCounter = 0;
    int artsCounter = 0;
    int pfCounter = 0;
    int resCounter = 0;
    int n = getCountriesOwned().size() / 3;
    if (n<3)
      n = 3;
    int continentnum = 0;
    for(int i=0; i<getCountriesOwned().size(); i++) {
      continentnum = getCountriesOwned().get(i).getContinent();
      switch (continentnum) {
        case 0:
          enggCounter += 1;
          break;

        case 1:
          knesCounter += 1;
          break;

        case 2:
          scienceCounter += 1;
          break;

        case 3:
          artsCounter += 1;
          break;

        case 4:
          pfCounter += 1;
          break;

        case 5:
          resCounter += 1;
          break;
      }

    }

    if (enggCounter == 8)
      n += 5;

    if (knesCounter == 5)
      n += 3;

    if (scienceCounter == 10)
      n += 7;

    if (artsCounter == 9)
      n += 5;

    if (pfCounter == 4)
      n += 2;

    if (resCounter == 5)
      n += 2;

    setDraftNumLeft(n);

    return n;
  }

  public abstract boolean checkValidFortifyTo(String countryFrom, String countryName);

  public abstract boolean checkValidFortifyFrom(String countryName);

}
