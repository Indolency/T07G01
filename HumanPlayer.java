import java.util.ArrayList;
import java.util.Scanner;

/**
 * This HumanPlayer class is a subclass that extends Player.
 * It contains the state of each player. Specifically, the player's
 * name, reference to the Main's Board, and an ArrayList<Country> of all the
 * countries the player possesses.
 * @version 4.0
 * @author
 * @since 2019-03-02
 */

public class HumanPlayer extends Player{

  /**
  * Constructs an object of class HumanPlayer given the specified name with reference
  * to the Main's board.
  */
  public HumanPlayer(String name, Board board){
    super(name, board);
  }

  /**
   * This is the human's specific drafting mechanism. It overrides the parent class's
   * method because it is different from the AI's specific drafting method.
   * It asks input from the user for a country it would like to draft each troop into
   * and update the Main's board.
   */
  @Override
  protected void draft(String string){
    for (Country country: getCountriesOwned()){
      if (string.equalsIgnoreCase(country.getCountryName())){
        country.addTroops(1);
      }
    }
  }

  /**
   * This is the human's specific attacking mechanism. It overrides the parent class's
   * method because it is different from the AI's specific drafting method.
   * It asks input from the user for a country it would like to attack and from Which
   * country it would like to attack.
   */
  @Override
  protected void attack(){
    System.out.println("-----ATTACK-----");
    boolean attacking = true;
    boolean invalid = true;
    Dice dice = new Dice();

    while (attacking){
        ArrayList<Country> valid = validCountries("Attack");
        Country userCountry = new Country();
        System.out.println("--Would you like to attack? Type 'yes' or 'no'--");
        if (valid.size()==0){
          System.out.println("You are unable attack because there are no valid moves available!");
          break;
        }
        Scanner input = new Scanner(System.in);
        String response = input.nextLine();
        if (response.equalsIgnoreCase("Yes")){
        // Asks player for which country to attack from.
        // Checks if the input given is valid

        invalid = true;
        while (invalid){
          System.out.println("--Please enter a valid country to attack from: ");
          Scanner validCountryFrom = new Scanner(System.in);
          String answer = validCountryFrom.nextLine();
          // For each country in the board, we check if the user string input is the same as the country name String
          // If it is, then we point the userCountry variable to that country.
          for (Country country: getBoard().getCountriesList()){
            if(answer.equalsIgnoreCase(country.getCountryName())){
              userCountry = country;
              if (valid.contains(userCountry) == true){
                invalid = false;
              }
            }
          }
        }
        // Asks player for which country to attack.
        invalid = true;
        valid = validAdjacentCountries(userCountry, "Attack");
        Country opponentCountry = new Country();
        while (invalid) {
            System.out.println("--Please enter a valid country to attack: ");
            Scanner validCountryTo = new Scanner(System.in);
            String answer = validCountryTo.nextLine();
            // For each country in the board, we check if the user string input is the same as the country name String
            // If it is, then we point the userCountry variable to that country.
            for (Country country: getBoard().getCountriesList()){
              if(answer.equalsIgnoreCase(country.getCountryName())){
                opponentCountry = country;
                if (valid.contains(opponentCountry) == true){
                  invalid = false;
                }
              }
            }
          }
          Player opponent = opponentCountry.getPlayerPossession();
          boolean proceed = true;
          do {
            int userDice = dice.rollDice();
            int opponentDice = dice.rollDice();
            System.out.println("--" + "\nYou rolled a " + userDice + "\nOpponent rolled a " + opponentDice + "\n--");

            if (userDice > opponentDice && opponentCountry.oneLeft()){
                addCountry(opponentCountry);
                opponent.removeCountry(opponentCountry);
                opponentCountry.setPlayerPossession(this);
                System.out.println("--You have conquered " + opponentCountry.getCountryName() + "!");

                boolean check = getBoard().checkWinner();
                if (check == true){
                    setWinner(true);
                    attacking = false;
                }
                break;

            } else if (userDice > opponentDice){
              opponentCountry.removeTroops(1);
              System.out.println("--You won! \nThe opponent now has: " + opponentCountry.getNumOfTroops() + " troops.");
              System.out.println("You have: " + userCountry.getNumOfTroops() + " troops.");

            } else if (userDice <= opponentDice){
              userCountry.removeTroops(1);
              System.out.println("--You lost! \nYou now have: " + userCountry.getNumOfTroops() + " troops.");
              System.out.println("Your opponent has "+ opponentCountry.getNumOfTroops() + " troops");

            }


            getBoard().showBoard();

            invalid = true;
            if (userCountry.oneLeft()){
                System.out.println("--You have 1 troop left! You can no longer attack from this country!--");
                break;
            }
            else{
                while (invalid){
                  System.out.println("--Would you like to continue? Type 'yes' or 'no': ");
                  Scanner again = new Scanner(System.in);
                  String answer = again.nextLine();
                  if (answer.equalsIgnoreCase("yes")) {
                    invalid = false;
                  } else if(answer.equalsIgnoreCase("no")){
                    proceed = false;
                    invalid = false;
                  }
                }
            }
        } while (proceed);
        }
        if (response.equalsIgnoreCase("No"))
            attacking = false;
    }
  }



  protected ArrayList<Country> validCountries(String phase) {
    ArrayList<Country> validTroops = new ArrayList<Country>();
    ArrayList<Country> valid = new ArrayList<Country>();
    for (Country country : countriesOwned) {
          if (country.getNumOfTroops() >= 2){
            validTroops.add(country);
          }
      }
    // Attack output for valid countries to attack from
    if (phase.equalsIgnoreCase("attack")){
      for (Country country: validTroops){
        for (Country adjacent: country.getAdjacentCountries()){
          if (country.getPlayerPossession() != adjacent.getPlayerPossession() && (valid.contains(country) == false)){
            valid.add(country);
          }
        }
      }
      System.out.println("--These are the valid countries you can attack from--");
      for (Country country: valid){
        System.out.println(country.getCountryName() + " and it has "+ country.getNumOfTroops() + " troops.");
      }
    }

    // Fortify output for valid countries to fortify from
    if (phase.equalsIgnoreCase("fortify")){
      for (Country country: validTroops){
        for (Country adjacent: country.getAdjacentCountries()){
          if (country.getPlayerPossession() == adjacent.getPlayerPossession() && (valid.contains(country) == false)){
            valid.add(country);
          }
        }
      }
      System.out.println("--These are the valid countries you can forify from--");
      for (Country country: valid){
        System.out.println(country.getCountryName() + " and it has "+ country.getNumOfTroops() + " troops.");
      }
    }
    return valid;
  }

  protected ArrayList<Country> validAdjacentCountries(Country country, String phase){
    ArrayList<Country> valid = new ArrayList<Country>();
    if (phase.equalsIgnoreCase("attack")){
      for (Country adjacent: country.getAdjacentCountries()){
        if(adjacent.getPlayerPossession() != country.getPlayerPossession() && (valid.contains(adjacent)) == false){
          valid.add(adjacent);
        }
      }
      System.out.println("--These are the valid countries you can attack--");
      for (Country country1: valid){
        System.out.println(country1.getCountryName() + " and it has "+ country1.getNumOfTroops() + " troops.");
      }
    }
    if (phase.equalsIgnoreCase("fortify")){
      for (Country adjacent: country.getAdjacentCountries()){
        if(adjacent.getPlayerPossession() == country.getPlayerPossession() && (valid.contains(adjacent)) == false){
          valid.add(adjacent);
        }
      }
      System.out.println("--These are the valid countries you can fortify--");
      for (Country country1: valid){
        System.out.println(country1.getCountryName() + " and it has "+ country1.getNumOfTroops() + " troops.");
      }
    }
    return valid;
  }
  /**
   * This is the human's specific fortifying mechanism. It overrides the parent class's
   * method because it is different from the AI's specific fortifying method.
   * It asks input from the user for a country it would like to fortify and from Which
   * country it would like to fortify from..
   */
  @Override
  protected void fortify(){
    System.out.println("-----FORTIFY-----");
    System.out.println("--Would you like to fortify? Type 'yes' or 'no'--");
    boolean invalidFrom = true;
    boolean invalidTo = true;
    boolean invalidTroops = true;
    Scanner input = new Scanner(System.in);
    String response = input.next();

    if (response.equalsIgnoreCase("Yes")) {
      ArrayList<Country> valid = validCountries("Fortify");
      Country countryFrom = new Country();
      if (valid.size() == 0){
        System.out.println("You are unable fortify because there are no valid moves available!");
        invalidFrom = false;
        invalidTo = false;
        invalidTroops = false;
      }

      while (invalidFrom) {
          System.out.println("--Please enter a valid country to fortify from: ");
          Scanner validCountryFrom = new Scanner(System.in);
          String answer = validCountryFrom.nextLine();

          for (Country country: getBoard().getCountriesList()){
            if(answer.equalsIgnoreCase(country.getCountryName())){
              countryFrom = country;
              if (valid.contains(countryFrom) == true){
                invalidFrom = false;
              }
            }
          }
        }

    valid = validAdjacentCountries(countryFrom, "Fortify");
    Country countryTo = new Country();
    while (invalidTo) {
        System.out.println("--Please enter a valid country to fortify: ");
        Scanner ans = new Scanner(System.in);
        String answer = ans.nextLine();

        for (Country country: getBoard().getCountriesList()){
          if(answer.equalsIgnoreCase(country.getCountryName())){
            countryTo = country;
            if (valid.contains(countryTo) == true){
              invalidTo = false;
            }
          }
        }
      }

    while (invalidTroops) {
        System.out.println("--Please enter a valid enter of troops to move: ");
        Scanner ans = new Scanner(System.in);
        int answer = ans.nextInt();
        int max = countryFrom.getNumOfTroops() - 1;
        int min = 1;
        if (answer >= min && answer <= max){
          countryFrom.removeTroops(answer);
          countryTo.addTroops(answer);
          invalidTroops = false;
          }
        }
      }
    }
  }
