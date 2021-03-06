import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @version
 * @author
 * @since
 */

public class AIPlayer extends Player{

  public AIPlayer(String name, Board board){
    super(name, board);
  }

  /**
	 * @return countriesToChooseFrom returns an arraylist of type country.
	 * The arraylist contains countries owned by the AI.
	 * Countries are added to this list based on the number of adjacent countries
	 * the AI does not own surrounding each country.
	 */

	protected ArrayList<Country> getCountriesToChooseFrom(String phase){
		ArrayList<Country> countriesToChooseFrom = new ArrayList<Country>();

    if (phase.equalsIgnoreCase("attack") || phase.equalsIgnoreCase("draft")){
  		//Checks each country AI owns
  		for (int i=0; i<countriesOwned.size(); i++){
  			Country AIOwnedCountry = countriesOwned.get(i);
  			ArrayList<Country> adjacentCountries = AIOwnedCountry.getAdjacentCountries();
  			//For every adjacent country to AI owned countries,
  			//if the adjacent country is not owned by AI, the AI country is added to the list of countriesToChooseFrom
  			for (Country checkCountry: AIOwnedCountry.getAdjacentCountries()){
  				if (checkCountry.getPlayerPossession() != AIOwnedCountry.getPlayerPossession())
  					countriesToChooseFrom.add(AIOwnedCountry);
  			}
  		}
    }
    if (phase.equalsIgnoreCase("fortify")){
      for (int i=0; i<countriesOwned.size(); i++){
        //Checks each country AI owns
        Country AIOwnedCountry = countriesOwned.get(i);
  			ArrayList<Country> adjacentCountries = AIOwnedCountry.getAdjacentCountries();
  			//For every adjacent country to AI owned countries,
  			//if the adjacent country is owned by AI, the AI country is added to the list of countriesToFortifyFrom
  			for (int j=0; j<adjacentCountries.size(); j++){
          Country checkCountry = adjacentCountries.get(j);
          if (checkCountry.getPlayerPossession() == AIOwnedCountry.getPlayerPossession())
            countriesToChooseFrom.add(AIOwnedCountry);
          }
      }
    }
  	return countriesToChooseFrom;
	}


  protected boolean getAttackConfirmation(){
		ArrayList<Boolean> listOfResponses = new ArrayList<Boolean>();
    ArrayList<Country> choices = getCountriesToChooseFrom("ATTACK");
		boolean response = false;

		//This for loop checks each country the AI owns and adds true to listOfResponses for each country owned
		//It then adds the countries AI doesn't own as false so the probability AI chooses to attack is ((countries owned)/(total countries))
		for (int i=0; i<41; i++){
			for (int j=0; j<countriesOwned.size(); j++){
				listOfResponses.add(true);
			}
			listOfResponses.add(false);
		}
    //AI chooses true or false from listOfResponses
		Random rand = new Random();
		int num = rand.nextInt(listOfResponses.size());
		response = listOfResponses.get(num);

		//Final check that there are countries on the map AI hasn't conquered and can attack
		if (choices.size()<1)
			response = false;

		//Final check that all countries AI can choose from have more than 1 troops
		int counter = 0;
		ArrayList<Country> checkNumOfTroops = new ArrayList<Country>();
		for (int i=0; i<choices.size(); i++){
			counter += 1;
			if (choices.get(i).getNumOfTroops()<2){
				checkNumOfTroops.add(choices.get(i));
			}
		}
		if (checkNumOfTroops.size() == counter)
			response = false;


		if (response == false){
			System.out.println();
			System.out.println("The computer is choosing not to attack.");
		}
		else{
			System.out.println();
			System.out.println("The computer is choosing to attack.");
		}
		return response;

	}

    /**
     * Depending on how many troops the AI has, they will roll the max number of dice.
     * @return the number of dice the user will roll
     */
      protected int getNumOfDice(Country userCountry) {
    	  if (userCountry.getNumOfTroops() > 3)
    		  return 3;
    	  // User has 3 troops, can roll 2, 1 dice
    	  else if (userCountry.getNumOfTroops() == 3)
    		  return 2;
    	  // User has 2 troops, can roll single die
    	  else
    		  return 1;
      }

  @Override
  public void draft(){
    getBoard().showBoard();
    System.out.println("\n--------------- "+getPlayerName().toUpperCase()+"'S TURN ---------------");
    System.out.println("-----DRAFT-----");
    int n = draftNum();
    while(n>0){
      Random rand = new Random();
      int num = rand.nextInt(getCountriesToChooseFrom("DRAFT").size());
      Country countryToDraft = getCountriesToChooseFrom("DRAFT").get(num);
      for(Country country: countriesOwned){
        if(countryToDraft.getCountryName().equalsIgnoreCase(country.getCountryName())){
          country.addTroops(1);
          n--;
          System.out.println("AI is drafting a troop to " + countryToDraft.getCountryName());
        }
      }
      getBoard().showBoard();
    }
  }

  @Override
  public void attack(){
    System.out.println("-----ATTACK-----");
    boolean attacking = getAttackConfirmation();
    Dice dice = new Dice();

    while(attacking){
      Country userCountry = new Country();
      Country opponentCountry = new Country();
      ArrayList<Country> countriesAttackFrom = new ArrayList<Country>();
      ArrayList<Country> countriesToAttack = new ArrayList<Country>();
      boolean proceed = true;

      /*Program asks AI which country to attack from
      * For every countri AI Owns, it checks how many countries it does not own that are adjacent to its own country
      * This is checked by AIOwnedCountry equal to a country from getCountriesToChooseFrom()
      */
      for (int i=0; i<countriesOwned.size(); i++){
        Country AIOwnedCountry = countriesOwned.get(i);
        for (int j=0; j<getCountriesToChooseFrom("attack").size(); j++){
          Country checkCountry = getCountriesToChooseFrom("attack").get(j);
          if (AIOwnedCountry == checkCountry && AIOwnedCountry.getNumOfTroops()>1){
            countriesAttackFrom.add(AIOwnedCountry);
          }
        }
      }

      //AI chooses a random country from countriesAttackFrom
      if (countriesAttackFrom.size()>0){
        Random randFrom = new Random();
        int numFrom = randFrom.nextInt(countriesAttackFrom.size());
        userCountry = countriesAttackFrom.get(numFrom);
        System.out.println("AI attacking from " + userCountry.getCountryName());
      }
      else{
        //userCountry = null;
        proceed = false;
      }

      /*Program asks AI which country to attack
      * For every country adjacent to the country AI is attacking from, if the country is not owned by AI,
      * AI will add that country to a list of possible countries to attack called countriesToAttack
      */
      ArrayList<Country> adjacentCountries = userCountry.getAdjacentCountries();
      for (int i=0; i<adjacentCountries.size(); i++){
        Country checkAdjacentOpponent = adjacentCountries.get(i);
        for (int j=0; j<41; j++){
          if (checkAdjacentOpponent.getPlayerPossession() != userCountry.getPlayerPossession()){
            countriesToAttack.add(checkAdjacentOpponent);
          }
        }
      }

      //AI randomly chooses a country to attack from the list countriesToAttack
      if (countriesToAttack.size()<1){
        //opponentCountry = null;
        proceed = false;
      }
      else{
        Random randTo = new Random();
        int numTo = randTo.nextInt(countriesToAttack.size());
        opponentCountry = countriesToAttack.get(numTo);
        System.out.println("Your opponent is attacking " + opponentCountry.getCountryName() + " from " + userCountry.getCountryName() + ".");
      }

      Player opponent = opponentCountry.getPlayerPossession();

      int numDice = 0;
      int oppNumDice = 0;
      do {
          /* Checks if there should be a prompt to pci ka number of dice or if
          the number of dice from the last round should be used */
        if (numDice == 0)
            numDice = getNumOfDice(userCountry);

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
        System.out.println("--AI rolled: ");
        for (int roll : userDice)
            System.out.println(roll);

        System.out.println("--Opponent rolled: ");
        for (int roll : opponentDice)
            System.out.println(roll);

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
                  System.out.println("--AI has conquered " + opponentCountry.getCountryName() + "!");

            //After each roll, the game checks to see if the game has been won
              boolean check = getBoard().checkWinner();
              if (check == true){
                  setWinner(true);
                  attacking = false;
              }
              conquered = true;
              break;
            }

        /*If the opponent's country has more than one troop, and the current player wins the dice roll,
            one troop is removed from the attacked country of the opponent.*/
            else if (userDice.get(index) > opponentDice.get(index)){
              opponentCountry.removeTroops(1);
              removeOpponentDice++;
            }

        /*If the current player loses the dice roll, one troop is removed from the attacking country of the current player.*/
            else if (userDice.get(index) <= opponentDice.get(index)){
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

        System.out.println("--AI has " + userDice.size() + " dice left.");
        System.out.println("You have " + opponentDice.size() + " dice left.");
        System.out.println("--AI has " + userCountry.getNumOfTroops() + " troops.");
        System.out.println("You have " + opponentCountry.getNumOfTroops() + " troops.");

        proceed = getAttackConfirmation();

      } while (proceed && userCountry==null && opponentCountry==null);

      attacking = getAttackConfirmation();

    }//End of while(attacking) loop

  }

  @Override
  public void fortify(int num){
    boolean fortifyConfirmation = true;
    ArrayList<Country> countriesToFortify = new ArrayList<Country>();
    ArrayList<Integer> listOfTroops = new ArrayList<Integer>();
    Country countryToFortify = new Country();
    Country countryFortifyFrom = new Country();


    //Program gets a country to fortify choice from AI
    //Checks number of troops in each country owned and fortifiable
    for (int i=0; i<getCountriesToChooseFrom("fortify").size(); i++){
      listOfTroops.add(getCountriesToChooseFrom("fortify").get(i).getNumOfTroops());
    }

    for (int j=0; j<listOfTroops.size(); j++){
      for (int k=0; k<listOfTroops.size(); k++){
        if (listOfTroops.get(k) <= listOfTroops.get(j))
					countriesToFortify.add(getCountriesToChooseFrom("fortify").get(k));
      }
    }

    //Picks a random country to fortify from countriesToFortify arraylist
    if (countriesToFortify.size()>0){
      Random randTo = new Random();
      int numTo = randTo.nextInt(countriesToFortify.size());
      countryToFortify = countriesToFortify.get(numTo);
    }

    //Program gets a country to fortify from choice from AI
    ArrayList<Country> possibleCountriesFortifyFrom = countryToFortify.getAdjacentCountries();
    ArrayList<Country> countriesFortifyFrom = new ArrayList<Country>();
    ArrayList<Integer> listOfTroopsAdjacent = new ArrayList<Integer>();

    //Checks number of troops in each country owned and fortifiable
    if(countryToFortify.getAdjacentCountries()  != null){
      for (int i=0; i<possibleCountriesFortifyFrom.size(); i++){
        listOfTroopsAdjacent.add(possibleCountriesFortifyFrom.get(i).getNumOfTroops());
      }
      for (int j=0; j<listOfTroopsAdjacent.size(); j++){
        for (int k=0; k<listOfTroopsAdjacent.size(); k++){
          if (listOfTroopsAdjacent.get(k)>=listOfTroopsAdjacent.get(j) && possibleCountriesFortifyFrom.get(k).getPlayerPossession()!=this){
            countriesFortifyFrom.add(possibleCountriesFortifyFrom.get(k));
          }
        }
      }

      //Picks a random country to fortify from from countriesFortifyFrom ArrayList
      if (countriesFortifyFrom.size()>0){
        Random randFrom = new Random();
        int numFrom = randFrom.nextInt(countriesFortifyFrom.size());
        countryFortifyFrom = countriesFortifyFrom.get(numFrom);
      }

      int numOfTroopsToFortify = (countryFortifyFrom.getNumOfTroops()-1)/2;

      if (countryFortifyFrom.getNumOfTroops()>2){
        countryFortifyFrom.removeTroops(numOfTroopsToFortify);
        countryToFortify.addTroops(numOfTroopsToFortify);
      }
    }
  }

    @Override
    public boolean checkDraftValid(String labelText) {
        return false;
    }

    @Override
    public boolean checkValidAttackFrom(String text) {
        return false;
    }

    @Override
    public boolean checkValidAttackTo(String countryFrom, String countryTo){
          return true;
      }

    @Override
    public boolean checkValidFortifyTo(String countryFrom, String countryName) {
        return false;
    }

    @Override
    public boolean checkValidFortifyFrom(String countryName) {
        return false;
    }


}
