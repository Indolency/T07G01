import java.util.Scanner;
import java.util.ArrayList;

/**
 * This Human class is part of the Risk game that take in an input from the
 * user, convert it to the proper data types and pass it to the Turn class.
 * This class also gives out all the proper print statements onto the console.
 * @author Jana Osea
 * @version 2.0
 * @since 2019-02-21
 */
public class Human{

  private static int playerNum = 0;

  public static int getPlayerNum(){
    return playerNum;
  }

  public static void setPlayerNum(int num){
    playerNum = num;
  }

  public static int getNumOfPlayers(){
    System.out.println("How many players would you like?");
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    return num;
  }


  public static void possessionStatus(){
    System.out.println();
    System.out.println("-----DRAFT-----");
    ArrayList<Country> countries = Board.getPlayerCountries(playerNum);
    for (int i=0; i<countries.size(); i++){
      System.out.println(countries.get(i).getCountryName() +" has "+ countries.get(i).getNumOfTroops()+" troops");
    }
  }


  public static String inputForDraft(){
    System.out.println();
    System.out.println("You have "+Turn.getNumOfTroopsToDraft()+" troops left.");
    System.out.println("Type the country name to draft one troop to that country ");
    Scanner input = new Scanner(System.in);
    String countryName = input.nextLine();
    return countryName;
  }

  public static void draftTurn(){
    Turn.draft();
  }

  public static boolean inputForAttackConfirmation(){
    Scanner input = new Scanner(System.in);
    boolean invalid = true;
    boolean response = false;
    Board.boardStatus();
    while(invalid){
      System.out.println("Would you like to continue attacking? Type 'yes' or 'no'.");
      String conf = input.next();
      if(conf.equalsIgnoreCase("yes")){
        invalid = false;
        response = true;
      }
      else if(conf.equalsIgnoreCase("no")){
        invalid = false;
        response = false;
      }
      else{
        System.out.println("Your input was incorrect. Please try again.");
        invalid = true;
      }
    }
    return response;
  }

  public static Country inputCountryAttackFrom(){
    ArrayList<Country> countriesList = Board.getPlayerCountries(playerNum);
    Scanner input = new Scanner(System.in);
    boolean invalid = true;
    Country response = new Country();

    while (invalid){
      System.out.println("Type a country you own that you want to attack from.");
      String countryName = input.nextLine();
      String countryNameEdited = countryName.replaceAll(" ", "");
      for (int i=0; i<countriesList.size(); i++){
            if(countryNameEdited.equalsIgnoreCase(countriesList.get(i).getCountryName())){
              response = countriesList.get(i);
              invalid = false;
            }
          }
        }
        return response;
      }

/*
  public static Country inputCountryToAttack(){
    ArrayList<C
  }
*/


  public static void attackTurn(){
    System.out.println();
    System.out.println("-----ATTACK-----");
    Turn.attack();
  }


}
