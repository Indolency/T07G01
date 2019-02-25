import java.util.Scanner;
import java.util.ArrayList;

/**
 * This Human class is part of the Risk game that takes in an input from the
 * user, converts it to the proper data types and passes it to the Turn class.
 * This class also gives out all the proper print statements onto the console.

 * @author Jana Osea, Israa Farouk, Nicole Langevin
 * @version 3.0
 * @since 2019-02-24
 */

public class Human{

  private static int playerNum = 0;
 /** Represents the country the player chooses to attack from
 */
  private static Country attackingCountry;
 /** Represents the country the player chooses to attack
 */
  private static Country attackedCountry;
 /** Represents the country the player chooses to fortify from
 */
  private static Country countryFortifyFrom;

 // Getter
  public static int getPlayerNum(){
    return playerNum;
  }

 // Setter
  public static void setPlayerNum(int num){
    playerNum = num;
  }

 /** This method is not a getter. It is a prompt in the console to the user asking
  * how many players they would like to have for the game.
  * @return response is an int that represents the number of players user wants
 */
  public static int getNumOfPlayers(){
    boolean invalid = true;
    Scanner input = new Scanner(System.in);
    int response = 0;
    while (invalid){
      System.out.println("How many players would you like?");
      int num = input.nextInt();
      if(num>0 && num<=8){
        response = num;
        invalid = false;
      }
      else{
        System.out.println("Your input was incorrect. Please input a number between 1 and 8 (inclusive).");
      }
    }
    return response;
  }

 /** This method outputs to the console the countries the player owns and the
  * number of troops each country owns.
 */
  public static void possessionStatus(){
    System.out.println();
    System.out.println("----------DRAFT----------");
    ArrayList<Country> countries = Board.getPlayerCountries(playerNum);
    for (int i=0; i<countries.size(); i++){
      System.out.println(countries.get(i).getCountryName() +" has "+ countries.get(i).getNumOfTroops()+" troops");
    }
  }

 /** This method is a prompt in the console to the user asking for a country
  * into which they would like to draft a troop.
  * @return countryName is a String that Represents
  *   country the user wants to draft to
 */
  public static String inputForDraft(){
    System.out.println();
    System.out.println("You have "+Turn.getNumOfTroopsToDraft()+" troops left.");
    System.out.println("Type the country name to draft one troop to that country ");
    Scanner input = new Scanner(System.in);
    String countryName = input.nextLine();
    return countryName;
  }

  /** This method is called in Game (main) and it initiates all the human draft
   * methods in Turn.
  */
  public static void draftTurn(){
    System.out.println();
    Turn.draft();
  }

 /** This method is prompt in the console to the user asking if they would like
  * to attack
  * @return response is a boolean that is true if the user indicates yes
  *   and false if the user indicates a no
 */
  public static boolean inputForAttackConfirmation(){
    Scanner input = new Scanner(System.in);
    boolean invalid = true;
    boolean response = false;
    System.out.println();
    System.out.println("----------BOARD STATUS----------");
    Board.boardStatus();
    while(invalid){
      System.out.println();
      System.out.println("Would you like to attack? Type 'yes' or 'no'.");
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

  /** This method is a prompt in the console to the user asking them for a
   * they would like to attack from
   * @return attackingCountry is an object of type Country that refers back to
   *    the orginial board that represents the user's attacking country
  */
  public static Country inputCountryAttackFrom(){
    System.out.println();
    System.out.println("----------ATTACK----------");
    ArrayList<Country> countriesList = Board.getPlayerCountries(playerNum);
    Scanner input = new Scanner(System.in);
    boolean invalid = true;

    while (invalid){
      System.out.println("Type a country you own that you want to attack from.");
      String countryName = input.nextLine();
      for (int i=0; i<countriesList.size(); i++){
            if(countryName.equalsIgnoreCase(countriesList.get(i).getCountryName())){
              attackingCountry = countriesList.get(i);
              invalid = false;
            }
          }
        }
        return attackingCountry;
      }

  /** This method checks if there are adjacent opponent countries from the
   * country the user has chosen to attack from.
   * @return response is a boolean that is true is there are adjacent opponent
   *    countries and false is there are none
  */
  public static boolean checkAdjacentOpponent(Country countryFrom){
        System.out.println("You cannot attack from this country.");
        boolean response = true;
        Country attackingCountry = Turn.getCountryAttackFrom();
        ArrayList<Country> adjacent = Board.getAdjacentCountries(attackingCountry);
        ArrayList<Country> opponent = Board.getPlayerCountries(AI.getPlayerNum());
        ArrayList<Country> correct = new ArrayList<Country>();

        for (int i=0; i<adjacent.size(); i++){
          for(int j=0; j<opponent.size(); j++){
            if((adjacent.get(i).getCountryName().replaceAll(" ", "")).equalsIgnoreCase(opponent.get(j).getCountryName().replaceAll(" ", ""))){
              correct.add(adjacent.get(i));
            }
          }
        }

        if(correct.size() == 0){
          System.out.println("There are no opponent countries that are adjacent.");
          response = false;
        }
        return response;
      }

  /** This is a method that is a prompt in the console to the user asking them
   * for a country they would like to attack
   * @return attackedCountry is an object of type Country that refers back to the
   *    orginal board that represents the country the user wants to attack
  */
  public static Country inputCountryToAttack(){
    ArrayList<Country> adjacent = Board.getAdjacentCountries(attackingCountry);
    ArrayList<Country> opponent = Board.getPlayerCountries(playerNum+1);
    ArrayList<Country> correct = new ArrayList<Country>();

    for (int i=0; i<adjacent.size(); i++){
      for(int j=0; j<opponent.size(); j++){
        if((adjacent.get(i).getCountryName().replaceAll(" ", "")).equalsIgnoreCase(opponent.get(j).getCountryName().replaceAll(" ", ""))){
          correct.add(opponent.get(j));
          System.out.println(opponent.get(j).getCountryName()+" is adjacent with "+ opponent.get(j).getNumOfTroops()+" troops.");
        }
      }
    }
    Scanner input = new Scanner(System.in);
    boolean invalid = true;
    while (invalid){
      System.out.println("Type a country you want to attack");
      String challenge = input.nextLine();
      for(int i=0; i<correct.size(); i++){
        if (challenge.equalsIgnoreCase(correct.get(i).getCountryName())){
          attackedCountry = correct.get(i);
          invalid = false;
        }
      }
    }
    return attackedCountry;
  }

  /** This is a method that outputs when the user has conquered an opponent's
   * territory country.
  */
  public static void outputGainedCountry(){
    Country gained = Turn.getCountryToAttack();
    System.out.println("Owned by"+gained.getPossession());
    System.out.println("Great job! Opponent's country "+gained.getCountryName()+" has been conquered!");
    System.out.println(gained.getCountryName()+" now has "+ gained.getNumOfTroops()+ " of your troops.");
  }

  /** This is a method that outputs when the user has won an attempted attack but
   * has not conquered the territory country.
  */
  public static void outputAttackWon(){
    System.out.println("Awesome! Your country "+attackingCountry.getCountryName()+" has won the attack against "+attackedCountry.getCountryName());
    System.out.println("Your country "+attackingCountry.getCountryName() + " now has "+ attackingCountry.getNumOfTroops()+ " troops.");
    System.out.println("Opponent's country "+ attackedCountry.getCountryName()+" now has "+ attackedCountry.getNumOfTroops()+ " troops.");
    System.out.println();
  }

  /** This is a method that outputs when the user has lost an attempted attack.
  */
  public static void outputAttackLost(){
    System.out.println("Too bad! Your country "+attackingCountry.getCountryName()+" has lost the attack against "+attackedCountry.getCountryName());
    System.out.println("Your country "+attackingCountry.getCountryName() + " now only has "+ attackingCountry.getNumOfTroops()+ " troops.");
    System.out.println("Opponent's country "+ attackedCountry.getCountryName()+" now has "+ attackedCountry.getNumOfTroops()+ " troops.");
    System.out.println();
  }

  /** This is a method that prompts the user in the console asking them if they
   * would like to continue attacking with the same country configurations
   * @return response is a boolean that is true if the user indicates yes
   *    and false if the user indicates no
  */
  public static boolean inputForAttackContinuation(){
    boolean invalid = true;
    boolean response = true;
    Scanner input = new Scanner(System.in);
    while (invalid){
      System.out.println("Would you like to continue with this attack where "+ attackedCountry.getCountryName()+ " is attacked from your country "+ attackingCountry.getCountryName()+ "? Type 'yes' or 'no'");
      String ans = input.nextLine();
      if (ans.equalsIgnoreCase("yes")){
        response = true;
        invalid = false;
      }
      else if (ans.equalsIgnoreCase("no")){
        response = false;
        invalid = false;
      }
      else{
        System.out.println("Your input was incorrect. Please try again.");
        invalid = true;
      }
    }
    return response;
  }

  /** This method outputs the dice roll numbers between the user and the opponent.
  */
  public static void outputDiceRolls(){
    System.out.println();
    System.out.println("You rolled a " +Turn.getDiceRollFrom()+" and your opponent rolled a "+ Turn.getDiceRollTo());
  }

  /** This method is called in Game (main) and it initiates all the human attack
   * methods in Turn.
  */
  public static void attackTurn(){
    System.out.println();
    Turn.attack();
  }

  /** This method is a prompt in the console to the user asking them if they would
   * like to fortify a country.
   * @return response is a boolean that is true if the user indicates yes
   *    and false if the user indicates no
  */
  public static boolean inputForFortifyConfirmation(){
    Scanner input = new Scanner(System.in);
    boolean invalid = true;
    boolean response = false;
    System.out.println();
    System.out.println("----------BOARD STATUS----------");
    Board.boardStatus();
    System.out.println();
    while(invalid){
      System.out.println("Would you like to fortify? Type 'yes' or 'no'.");
      String conf = input.next();
      if(conf.equalsIgnoreCase("yes")){
        System.out.println();
        System.out.println("----------FORTIFY----------");
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

  /** This method is a prompt in the console to the user asking them for a country
   * they would like to fortify from
   * @return response is an object of type Country that refers back to the orignal
   *    board that represents the country to foritify from
  */
  public static Country inputCountryFortifyFrom(){
    ArrayList<Country> countriesList = Board.getPlayerCountries(playerNum);
    Scanner input = new Scanner(System.in);
    boolean invalid = true;
    Country response = new Country();
    while (invalid){
      System.out.println("Type a country you own that you want to fortify from.");
      String countryName = input.nextLine();
      for (int i=0; i<countriesList.size(); i++){
        if(countryName.equalsIgnoreCase(countriesList.get(i).getCountryName())){
          response = countriesList.get(i);
          System.out.println(response.getCountryName());
          int adjacentArraySize = Board.getAdjacentCountries(response).size();
          if (response.getNumOfTroops()>1 && adjacentArraySize>0){
            countryFortifyFrom = response;
            invalid = false;
          }
        }
      }
    }
    return response;
  }

  /** This method checks if there are adjacent countries from the country the
   * user wants to fortify from
   * @return response is a boolean that is true is there are adjacent countries
   *     and false is there are none
  */
  public static boolean countryHasAdjacent(Country countryFrom){
    boolean response = true;
    ArrayList<Country> adjacent = Board.getAdjacentCountries(countryFrom);
    ArrayList<Country> correct = new ArrayList<Country>();
    for(int i=0; i<adjacent.size(); i++){
      String adjName = adjacent.get(i).getCountryName();
      int adjPossession = adjacent.get(i).getPossession();
      if(adjPossession == playerNum){
          correct.add(adjacent.get(i));
      }
    }
    if (correct.size()>0){
      response = true;
    }
    else{
      response = false;
    }
    return response;
  }

  /** This method is a prompt in the console to the user asking them for a country
   * they would like to fortify
   * @return response is an object of type Country that refers back to the orignal
   *    board that represents the country to foritify
  */
  public static Country inputCountryToFortify(){
    ArrayList<Country> countriesList = Board.getPlayerCountries(playerNum);
    Scanner input = new Scanner(System.in);
    boolean invalid = true;
    Country response = new Country();
    while (invalid){
      System.out.println("Type a country you own that you want to fortify to.");
      String countryName = input.nextLine();
      for (int i=0; i<countriesList.size(); i++){
        if(countryName.equalsIgnoreCase(countriesList.get(i).getCountryName())){
          response = countriesList.get(i);
          ArrayList<Country> adjacentCountries = Board.getAdjacentCountries(countryFortifyFrom);
          for (int j=0; j<adjacentCountries.size(); j++){
            Country country = new Country();
            country = adjacentCountries.get(j);
            if (response.getCountryName().equalsIgnoreCase(country.getCountryName()))
              invalid = false;
          }
        }
      }
    }

        return response;
    }

  /** This method is a prompt in the console to the user asking them for the number
   * of troops they would like to transfer over to the other country they have chosen
   * @return numOfTroopsToFortify is an int that represents the number of troops
   *    the user would like to forify
  */
  public static int inputNumOfTroopsToFortify(){
    Scanner input = new Scanner(System.in);
    boolean invalid = true;
    int numOfTroopsToFortify = 0;
    while (invalid){
      System.out.println("How many troops would you like to fortify?");
      numOfTroopsToFortify = input.nextInt();
      if (countryFortifyFrom.getNumOfTroops() - numOfTroopsToFortify >= 1)
        invalid = false;
    }
    return numOfTroopsToFortify;
  }

  /** This is a method that outputs the status of the fortify move onto the console
  */
  public static void outputFortifyStatus(){
    Country from = Turn.getCountryFortifyFrom();
    Country to = Turn.getCountryToFortify();
    System.out.println();
    System.out.println(to.getCountryName()+" has been fortified!");
    System.out.println(from.getCountryName()+" now has "+from.getNumOfTroops()+" troops.");
    System.out.println(to.getCountryName()+" now has "+to.getNumOfTroops()+" troops.");
  }

  /** This method is called in Game (main) and it initiates all the human fortify
   * methods in Turn.
  */
  public static void fortifyTurn(){
		System.out.println();
		Turn.fortify();
	}

}
