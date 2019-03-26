package logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * This GameConfig class is part of the Risk game that is responsible
 * for creating the players, setting up the board, and running the
 * mechanism of the Game.
 * @version 2.0
 * @author T07G01
 * @since 2019-03-02
 */

public class GameConfig {

  private Driver driver;
  private ArrayList<Player> listOfPlayers;

  public ArrayList<String> getListOfPlayerTypes() {
    return listOfPlayerTypes;
  }

  public void setListOfPlayerTypes(ArrayList<String> listOfPlayerTypes) {
    this.listOfPlayerTypes = listOfPlayerTypes;
  }

  private ArrayList<String> listOfPlayerTypes;
  private Board board;

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  public void setCurrentPlayer(Player currentPlayer) {
    this.currentPlayer = currentPlayer;
  }

  private Player currentPlayer;

  public GameConfig(Driver driver) {
    this.driver = driver;
    setBoard(new Board());
  }

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  public ArrayList<Player> getListOfPlayers() {
    return listOfPlayers;
  }

  public void setListOfPlayers(ArrayList<Player> listOfPlayers) {
    this.listOfPlayers = listOfPlayers;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  /**
   * Asks the user for how many players they would like to play a game with.
   * After the number of players has been determined, the user gets to specify
   * if they would like each specific Player to be a human player(0) or an AI player (1).
   * Depending on the user's input, a HumanPlayer or an AIPlayer object is created
   * and added to the listOfPlayers.
   */
  public void createPlayers(ArrayList<String> names, ArrayList<String> types) {
    ArrayList<Player> list = new ArrayList<Player>();
    ArrayList<String> typesList = new ArrayList<String>();
    int numOfPlayers = names.size();
    for (int i = 0; i < numOfPlayers; i++) {
      String name = names.get(i);
      if (types.get(i).equals("HUMAN")) {
        Player player = new HumanPlayer(name, getBoard());
        list.add(player);
        typesList.add(types.get(i));
      } else if (types.get(i).equals("AI")) {
        Player player = new AIPlayer(name, getBoard());
        list.add(player);
        typesList.add(types.get(i));
      }
    }
    setListOfPlayers(list);
    setListOfPlayerTypes(typesList);
  }


  /**
   * Sets up the board according to the number of players specified by the User.
   * It divides the countries between the players and randomly distributes a standard
   * number of troops to each player's country possession.
   */
  public void boardSetup() {
    Random rand = new Random();

    //countries are randomly assigned to each player
    int countriesToDistribute = 41;
    while (countriesToDistribute != 0) {
      for (Player player : listOfPlayers) {
        if (countriesToDistribute != 0) {
          int index = rand.nextInt(getBoard().getCountriesList().size());
          Country country = getBoard().getCountriesList().get(index);
          if (country.getPlayerPossession() == null) {
            country.setPlayerPossession(player);
            player.addCountry(country);
          } else {
            while (country.getPlayerPossession() != null) {
              index = rand.nextInt(getBoard().getCountriesList().size());
              country = getBoard().getCountriesList().get(index);
            }
            country.setPlayerPossession(player);
            player.addCountry(country);
          }
          countriesToDistribute--;
        }
      }
    }

    int numOfTroopsPP = 40; // will change when more countries are added
    // after determining each player's countries, a standard number of troops are randomly distributed into each
    for (Player player : listOfPlayers) {
      int n = numOfTroopsPP;
      for (Country country : player.getCountriesOwned()) {
        country.setNumOfTroops(1);
        n--;
      }
      while (n > 0) {
        int index = rand.nextInt(player.getCountriesOwned().size());
        player.getCountriesOwned().get(index).addTroops(1);
        n--;
      }
    }

  }

  /**
   * Contains specific player moves that run through the entire game.
   * Depending on the player (AI or Human), the moves are invoked from the
   * specified children classes of Player.
   * This method runs through each player in the listOfPlayers and always checks
   * for a winner after each attack is made.
   */
  public void play() {
    Dice dice = new Dice();
    boolean notWon = true;

    while (notWon) {
      for (Player player : listOfPlayers) {
        setCurrentPlayer(player);
        player.draft();
        player.attack();
        boolean check = player.getWinner();
        if (check == true){
          notWon = false;
          break;
        }
        int num = 0;
        player.fortify(num);

      }
    }
  }

}
