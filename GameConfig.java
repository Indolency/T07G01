import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * This GameConfig class is part of the Risk game that is responsible
 * for creating the players, setting up the board, and running the
 * mechanism of the Game.
 * @version 2.0
 * @author T07G01
 * @since 2019-03-02
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

  /**
   * Asks the user for how many players they would like to play a game with.
   * After the number of players has been determined, the user gets to specify
   * if they would like each specific Player to be a human player(0) or an AI player (1).
   * Depending on the user's input, a HumanPlayer or an AIPlayer object is created
   * and added to the listOfPlayers.
   */
  public void createPlayers(){
    ArrayList<Player> list = new ArrayList<Player>();
    boolean invalid = true;
    boolean invalidType = true;

    while (invalid) {
      Scanner input = new Scanner(System.in);
      System.out.print("How many players would you like? Type a number between 2 and 8 (inclusive): ");
      String num = input.nextLine();
      if (num.equals("2") || num.equals("3") || num.equals("4") || num.equals("5") || num.equals("6")|| num.equals("7") || num.equals("8")){
        int result = Integer.parseInt(num);
        for(int i=1; i<=result; i++){
          System.out.print("Enter the name of Player "+i+": ");
          String name = input.nextLine();

          invalidType = true;
          while (invalidType) {
              System.out.print("What kind of player would want "+name+" to be?\nEnter 0 for Human and 1 for AI: ");
              String type = input.nextLine();
              if (type.equals("0")){
                  int resultType = Integer.parseInt(type);
                  Player player = new HumanPlayer(name, getGame().getGameBoard());
                  list.add(player);
                  invalidType = false;
              }
              else if (type.equals("1")){
                  int resultType = Integer.parseInt(type);
                  Player player = new AIPlayer(name, getGame().getGameBoard());
                  list.add(player);
                  invalidType = false;
              }
            }
          }
         invalid = false;
        }
      }
      setListOfPlayers(list);
    }

  /**
   * Sets up the board according to the number of players specified by the User.
   * It divides the countries between the players and randomly distributes a standard
   * number of troops to each player's country possession.
   */
  public void boardSetup(){
    Board board = getGame().getGameBoard();
    Random rand = new Random();
    int numOfPlayers = listOfPlayers.size();
    int numOfCountriesPP = getGame().getGameBoard().getCountriesList().size() / numOfPlayers; // will change when more countries are added
    int numOfTroopsPP = 9; // will change when more countries are added

    //countries are randomly assigned to each player
    for (Player player: listOfPlayers){
      while(player.getCountriesOwned().size() != numOfCountriesPP){
        int index = rand.nextInt(getGame().getGameBoard().getCountriesList().size());
        Country country = getGame().getGameBoard().getCountriesList().get(index);
        if (country.getPlayerPossession() == null){
          country.setPlayerPossession(player);
          player.addCountry(country);
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

    while (notWon) {
        for(Player player: listOfPlayers){
          player.draft();
          player.attack();
          boolean check = player.getWinner();
          if (check == true){
            System.out.println("----------------------------------------------");
            System.out.println("Congradulations " + player.getPlayerName() + " you have conquered U of C!");
            System.out.println("----------------------------------------------");
            notWon = false;
            break;
          }
          player.fortify();
      }
    }
  }


}
