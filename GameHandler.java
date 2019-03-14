import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import javafx.application.Application;

/**
 * This GameConfig class is part of the Risk game that is responsible
 * for creating the players, setting up the board, and running the
 * mechanism of the Game.
 * @version 2.0
 * @author T07G01
 * @since 2019-03-12
 */

public class GameConfig{

  /**
   * This game is a reference to the Game made in main.
   */
  private Game game;

  /**
   * Contains all the Players that the user has specifically made.
   */
  private ArrayList<Player> listOfPlayers;
  private Player currentPlayer;

  /**
   * Constructs a GameConfig object without any specific instance variables.
   * The instance variables are referenced after the Game has been made in Main
   * and after the Players have been created by the user.
   */
  public GameConfig(){
  }

  /**
    * Getter and Setter methods
    */
  public Game getGame(){
    return game;
  }

  public ArrayList<Player> getListOfPlayers(){
    return listOfPlayers;
  }

  public void setGame(Game game){
    this.game = game;
  }

  public void setListOfPlayers(ArrayList<Player> list){
    listOfPlayers = list;
  }

  public Player getCurrentPlayer(){
    return currentPlayer;
  }

  public void setCurrentPlayer(Player player){
    currentPlayer = player;
  }

  /**
   * Asks the user for how many players they would like to play a game with.
   * After the number of players has been determined, the user gets to specify
   * if they would like each specific Player to be a human player(0) or an AI player (1).
   * Depending on the user's input, a HumanPlayer or an AIPlayer object is created
   * and added to the listOfPlayers.
   */
  public void createPlayers(ArrayList<String> playerNames, ArrayList<String> playerTypes){
    ArrayList<Player> list = new ArrayList<Player>();
    //System.out.print("How many players would you like? Type a number between 2 and 6 (inclusive): ");
    int numOfPlayers = playerNames.size();
    for(int i=0; i<numOfPlayers; i++){
      String name = playerNames.get(i);
      if (playerTypes.get(i).equals("HUMAN")){
        Player player = new HumanPlayer(name, getGame().getGameBoard());
        list.add(player);
        }
      else if (playerTypes.get(i).equals("AI")){
        Player player = new AIPlayer(name, getGame().getGameBoard());
        list.add(player);
        }
      }
    setListOfPlayers(list);
    System.out.println(listOfPlayers.size());
  }

/*
  public int determineCountriesPP(int numOfPlayers){
    int numOfCountriesPP;
    switch(numOfPlayers){
      case 2:
        numOfCountriesPP = 20;
        break;
      case 3:
        numOfCountriesPP = 20;
        break;
      case 4:
        numOfCountriesPP = 20;
        break;
      case 5:
        numOfCountriesPP = 20;
        break;
      case 6:
        numOfCountriesPP = 20;
        break;
      }
      return numOfCountriesPP;
    }
  }
  */

  /**
   * Sets up the board according to the number of players specified by the User.
   * It divides the countries between the players and randomly distributes a standard
   * number of troops to each player's country possession.
   */
   public void boardSetup(){
      Board board = getGame().getGameBoard();
      Random rand = new Random();
      int numOfPlayers = listOfPlayers.size();
      // will change when more countries are added
      int numOfTroopsPP = 40; // will change when more countries are added

      //countries are randomly assigned to each player
  	int countriesToDistribute = 41;
  	while(countriesToDistribute!=0){
  		for (Player player: listOfPlayers){
  			if (countriesToDistribute!=0){
  				int index = rand.nextInt(getGame().getGameBoard().getCountriesList().size());
  				Country country = getGame().getGameBoard().getCountriesList().get(index);
  				if(country.getPlayerPossession() == null){
  					country.setPlayerPossession(player);
  					player.addCountry(country);
  				}
  				else{
  					while(country.getPlayerPossession()!= null){
  						index = rand.nextInt(getGame().getGameBoard().getCountriesList().size());
  						country = getGame().getGameBoard().getCountriesList().get(index);
  					}
  					country.setPlayerPossession(player);
  					player.addCountry(country);
  				}
  			countriesToDistribute --;
  		  }
  		}
  	}

      // after determining each player's countries, a standard number of troops are randomly distributed into each
      for (Player player: listOfPlayers){
        int n = numOfTroopsPP;
        for(Country country: player.getCountriesOwned()){
          country.setNumOfTroops(1);
          n--;
        }
        while(n > 0){
          int index = rand.nextInt(player.getCountriesOwned().size());
          player.getCountriesOwned().get(index).addTroops(1);
          n--;
        }
      }
      getGame().getGameBoard().showBoard();
    }



  /**
   * Contains specific player moves that run through the entire game.
   * Depending on the player (AI or Human), the moves are invoked from the
   * specified children classes of Player.
   * This method runs through each player in the listOfPlayers and always checks
   * for a winner after each attack is made.
   */
  public void play(){
    Dice dice = new Dice();
    boolean notWon = true;
/*
    while (notWon) {
        for(Player player: listOfPlayers){
          setCurrentPlayer(player);
          player.draft(String str);
          player.attack();
          boolean check = player.getWinner();
          if (check == true){
            System.out.println("----------------------------------------------");
            System.out.println("Congratulations " + player.getPlayerName() + " you have conquered U of C!");
            System.out.println("----------------------------------------------");
            notWon = false;
            break;
          }
          player.fortify();
      }
    }
    */
  }

}
