import java.util.ArrayList;
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

  protected String getPlayerName(){
    return playerName;
  }

  protected Board getBoard(){
    return board;
  }

  protected ArrayList<Country> getCountriesOwned(){
    return countriesOwned;
  }

  protected boolean getWinner() {
    return winner;
  }

  protected void setPlayerName(String name){
    playerName = name;
  }

  protected void setBoard(Board board){
    this.board = board;
  }

  protected void setCountriesOwned(ArrayList<Country> list){
    countriesOwned = list;
  }

  protected void setWinner(boolean winLose) {
    winner = winLose;
  }

  /**
   * Adds an individual country to the countriesOwned ArrayList
   * @param country Country on the main board in Game that is assigned to this player
   */
  protected void addCountry(Country country){
    countriesOwned.add(country);
  }

  protected void removeCountry(Country country){
    countriesOwned.remove(country);
  }

  /**
   * This method is overridden in the children classes: HumanPlayer and AIPlayer
   */
  protected void draft(String str){
  }

  /**
   * This method is overridden in the children classes: HumanPlayer and AIPlayer
   */
  protected void attack(){
  }

  /**
   * This method is overridden in the children classes: HumanPlayer and AIPlayer
   */
  protected void fortify(){
  }


/*
  protected boolean countriesUpdated(){
    updated = true;
  }/

  /**
   * Determines the number of troops a player will be able to draft with in the beginning of each turn
   * @return n is an integer that represents the number of troops each player can draft with
   */
  protected int draftNum(){
    int n = getCountriesOwned().size() / 3;
    return n;
  }
}
