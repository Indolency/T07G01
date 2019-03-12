import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;

/**
 * This Game class is the main class of the Risk game
 * it contains the game loop that runs the game.
 * @version 2.0
 * @author T07G01
 * @since 2019-03-02
 */

public class Game {

  private Board gameBoard;
  private GameConfig gameConfig;
    /**
   * Constructs a Game object given the already initialized
   * Board and GameConfig objects.
   */
  public Game(Board board, GameConfig config){
    gameBoard = board;
    gameConfig = config;
  }

  /**
   * Getter and Setter methods.
   */
  public Board getGameBoard(){
    return gameBoard;
  }

  public GameConfig getGameConfig(){
    return gameConfig;
  }

  public void setGameBoard(Board board){
    gameBoard = board;
  }

  public void setGameConfig(GameConfig config){
    gameConfig = config;
  }

  /**
   * Main that creates the specific Class objects and ensures that each Class
   * has appropriate references to each other.
   * Specifically,
   * Game has reference to GameConfig and Board
   * GameConfig has reference to Game (which has reference to Board.
   * Also, Main invokes the play() method.
   */

  /*public static void main(String [] args){
    do{
      //GameHandler.start(GameHandler.class, args);
      //Application.launch(GameHandler.class, args);//Numofplayersbtn
      //StartMenu theStartMenu = new StartMenu();
      //System.out.println("This is from the main: "+StartMenu.getNumOfPlayers());
      //Application.launch(PlayerSelection.class, args);//Numofplayersbtn
      //System.out.println("This is also from main: "+StartMenu.getPlayerNames().size());
      Board theBoard = new Board();
      GameConfig theGameConfig = new GameConfig();
      Graphics theGraphics = new Graphics();
      Game game = new Game(theBoard, theGameConfig, theGraphics);
      theGameConfig.setGame(game);
      game.play();
    } while (Game.playAgain());
  }*/

  /**
    * Gathers all the appropriate methods to play a game from the referenced
    * GameConfig object.
    * createPlayers() creates the players according to the user.
    * boardSetup() distributes the countries amongst the players the user has created.
    * play() contains all the methods to play the game.
    */
/*  public void play(){
    getGameConfig().createPlayers();
    getGameConfig().boardSetup();
    getGameConfig().play();
  }*/

  public static boolean playAgain() {
    System.out.println("Would you like to play again? Type 'yes' or 'no': ");
    boolean response = true;
    boolean invalid = true;
    Scanner input = new Scanner(System.in);
    String answer = input.nextLine();
    while (invalid){
      if (answer.equalsIgnoreCase("yes")){
        response = true;
        invalid = false;
      }
      if (answer.equalsIgnoreCase("no")){
        response = false;
        invalid = false;
      }
    }
    return response;
  }


  }
