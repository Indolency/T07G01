import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This HumanPlayer class is a subclass that extends Player.
 * It contains the state of each player. Specifically, the player's
 * name, reference to the Main's Board, and an ArrayList<Country> of all the
 * countries the player possesses.
 * @version 5.0
 * @author T07G01
 * @since 2019-03-16
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
   @Override
   */
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

    // Main attacking loop, will begin by asking is they want to attack
    while (attacking){
        ArrayList<Country> valid = validCountries("Attack");
        Country userCountry = new Country();
        System.out.println("--Would you like to attack? Type 'yes' or 'no'--");
        // Checks if they user is still allowed to attack, loop if not
        if (valid.size()==0){
          System.out.println("You are unable attack because there are no valid moves available!");
          break;
        }
        Scanner input = new Scanner(System.in);
        String response = input.nextLine();
        // Begins the attack if user answers yes to the attack phase
        if (response.equalsIgnoreCase("Yes")){
        invalid = true;
        // Checks if the country is a valid country to attack from
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
        // Checks if the player country is valid, loops if invalid
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

          int numDice = 0;
          int oppNumDice = 0;
          do {
            /* Checks if there should be a prompt to pci ka number of dice or if
            the number of dice from the last round should be used */
            if (numDice == 0) {
                System.out.println("--You have " + userCountry.getNumOfTroops() + " troops.");
                System.out.println("The opponent has " + opponentCountry.getNumOfTroops() + " troops.");
                // Dice rolls for attacking troops
                numDice = validDiceRoll(userCountry);
            }
            /* Decides the number of dice the opponent will have depending on
            the number of troops they have and how many dice the player chose. */
            ArrayList<Integer> userDice = dice.rollDice(numDice);
            ArrayList<Integer> opponentDice = new ArrayList<Integer>();

            // Auto chooses the number of dice the opponent will roll
            if (oppNumDice != 0)
                opponentDice = dice.rollDice(oppNumDice);
            else {
                if (opponentCountry.getNumOfTroops() > 2)
                    opponentDice = dice.rollDice(2);
                else if (opponentCountry.getNumOfTroops() <= 2)
                    opponentDice = dice.rollDice(1);
            }

            // Print statements for the dice
            System.out.println("--You rolled: ");
            for (int roll : userDice)
                try {
                    Thread.sleep(500);
                    System.out.println(roll);
                } catch(InterruptedException ex){
                    System.exit(0);
                }

            System.out.println("--Opponent rolled: ");
            for (int roll : opponentDice)
                try {
                    Thread.sleep(500);
                    System.out.println(roll);
                } catch(InterruptedException ex){
                    System.exit(0);
                }

            boolean conquered = false;

            int lowestNumOfDice = 0;
            int removeUserDice = 0;
            int removeOpponentDice = 0;
            // Sets the lowest number of dice to loop
            if (userDice.size() < opponentDice.size())
                lowestNumOfDice = userDice.size() - 1;
            else
                lowestNumOfDice = opponentDice.size() - 1;
            /* This will compare the highest pairs dice then move onto the next highest
            pair keeping track of the number of dice to remove later.*/
            for (int index = 0; index <= lowestNumOfDice; index++) {
                /*If the opponent's country only has one troop and the current player wins the dice roll,
                the country being attacked changes its possession to that of the current player,
                and the troops of the current player minus one are all moved into the attacked country.*/
                if (userDice.get(index) > opponentDice.get(index) && opponentCountry.oneLeft()){
                    addCountry(opponentCountry);
                    opponent.removeCountry(opponentCountry);
                    opponentCountry.setPlayerPossession(this);
                    System.out.println("--You have conquered " + opponentCountry.getCountryName() + "!");
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException ex){
                        System.exit(0);
                    }

                  //After each roll, the game checks to see if the game has been won
                    boolean check = getBoard().checkWinner();
                    if (check == true){
                        setWinner(true);
                        attacking = false;
                    }
                    conquered = true;
                    break;

                  /*If the opponent's country has more than one troop, and the current player wins the dice roll,
                  one troop is removed from the attacked country of the opponent. An opponent dice will also
                  be removed.*/
                } else if (userDice.get(index) > opponentDice.get(index)){
                      opponentCountry.removeTroops(1);
                      removeOpponentDice++;

                /*If the current player loses the dice roll, one troop is removed from the attacking country of the current player.
                The user dice will also be removed.*/
                } else if (userDice.get(0) <= opponentDice.get(0)){
                      userCountry.removeTroops(1);
                      removeUserDice++;
                }
            }

            // Removes all the dice from earlier
            while (removeUserDice != 0){
                userDice.remove(0);
                removeUserDice--;
            }
            while (removeOpponentDice != 0){
                opponentDice.remove(0);
                removeOpponentDice--;
            }
            numDice = userDice.size();
            oppNumDice = opponentDice.size();

            // If a country has been conqured, breaks out of the continue loop
            if (conquered)
                break;

            System.out.println("--You have " + userDice.size() + " dice left.");
            System.out.println("The opponent has " + opponentDice.size() + " dice left.");
            System.out.println("--You have " + userCountry.getNumOfTroops() + " troops.");
            System.out.println("The opponent has " + opponentCountry.getNumOfTroops() + " troops.");

            // Checks if the user can still attack (If they have one troop remaining, cannot attack anymore)
            invalid = true;
            if (userCountry.oneLeft()) {
                System.out.println("--You have 1 troop left! You can no longer attack from this country!--");
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException ex){
                    System.exit(0);
                }
                break;
            // Asks user if they want to continue attacking
            } else{
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
        // If the user no longer wants to attack, attacking phase will end
        if (response.equalsIgnoreCase("No"))
            attacking = false;
    }
  }


//Creates an arraylist to check if the countries the user is picking from are owned by the player
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
 * This will take the player's input and loops through to check if their answer is valid.
 * @return numDice the amount of dice the player wants to roll.
 */
  protected int validDiceRoll(Country userCountry) {
      boolean invalid = true;
      int numDice = 0;
      while (invalid) {
          System.out.println("--Enter a valid number of dice to roll: ");
          Scanner diceInput = new Scanner(System.in);
          numDice = diceInput.nextInt();
          if (userCountry.getNumOfTroops() > 3 && (numDice == 3 || numDice == 2 || numDice == 1))
              invalid = false;
          // User has 3 troops, can roll 2, 1 dice
          else if (userCountry.getNumOfTroops() == 3 && (numDice == 2 || numDice == 1))
              invalid = false;
          // User has 2 troops, can roll single die
          else if (userCountry.getNumOfTroops() == 2 && numDice == 1)
              invalid = false;
      }
      return numDice;
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
