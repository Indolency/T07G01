import java.util.ArrayList;
import java.util.Random;

/**
 * This AI class is a program the user will play against.
 * All of the decisions made by AI in the Risk game
 * are made by probability and printed out to the user.
 *
 * @author Nicole Langevin
 * @version 2.0
 * @since 2019-02-25
 */

public class AI{
	
	private static int playerNum = 1;
	private static Country attackingCountry;
	private static Country attackedCountry;
	private static ArrayList<Country> countriesToChooseFrom;
	private static ArrayList<Country> countriesToFortifyFrom;

	//Setters
	
	/**
	 * This method sets the number of the player that currently is playing their turn
	 * @param num is the number of the current player 
	 */	
	
	public static void setPlayerNum(int num){
		playerNum = num;
	}
	
	/**
	 * @param country is the country the AI is attacking from 
	 */	
	
	public static void setAttackingCountry(Country country){
		attackingCountry = country;
	}
	
	/**
	 * @param country is the country the AI is attacking 
	 */	
	
	public static void setAttackedCountry(Country country){
		attackedCountry = country;
	}
	
	//Getters
	
	/**
	 * This method gets the number of the player that currently is playing their turn
	 * @return playerNum is the number of the current player 
	 */	
	
	public static int getPlayerNum(){
		return playerNum;
	}
	
	/**
	 * @return attackingCountry is the country the AI is attacking from 
	 */	
		
	public static Country getAttackingCountry(){
		return attackingCountry;
	}
	
	/**
	 * @return attackedCountry is the country the AI is attacking  
	 */	
		
	public static Country getAttackedCountry(){
		return attackedCountry;
	}
	
	
	/**
	 * The method possessionStatus() prints out all the countries on the board,
	 * the troops in the countries and which player they are owned by.
	 */	
	
	public static void possessionStatus(){
		System.out.println();
		System.out.println("----------DRAFT----------");
		ArrayList<Country> countries = Board.getPlayerCountries(playerNum);
		for (int i=0; i<countries.size(); i++){
			System.out.println(countries.get(i).getCountryName() +" has "+ countries.get(i).getNumOfTroops()+" troops");
		}	
	}
	
	/** 
	 * @return countriesToChooseFrom returns an arraylist of type country.
	 * The arraylist contains countries owned by the AI.
	 * Countries are added to this list based on the number of adjacent countries
	 * the AI does not own surrounding each country.
	 */
	
	public static ArrayList<Country> getCountriesToChooseFrom(){
		ArrayList<Country> AICountries = Board.getPlayerCountries(playerNum);
		ArrayList<Country> countriesToChooseFrom = new ArrayList<Country>();
		
		//Checks each country AI owns
		for (int i=0; i<AICountries.size(); i++){
			Country AIOwnedCountry = AICountries.get(i);
			ArrayList<Country> adjacentCountries = Board.getAdjacentCountries(AIOwnedCountry);
			//For every adjacent country to AI owned countries, 
			//if the adjacent country is not owned by AI, the AI country is added to the list of countriesToChooseFrom
			for (int j=0; j<adjacentCountries.size(); j++){
				Country checkCountry = adjacentCountries.get(j);
				if (checkCountry.getPossession() != playerNum)
					countriesToChooseFrom.add(AIOwnedCountry);
			}
		}
		return countriesToChooseFrom;
	}
	
	
	//DRAFT PHASE
	
	
	/**
	 * @return returns a randomly selected country from the list getCountriesToChooseFrom()
	 */	
	
	public static Country inputForDraft(){
		Random rand = new Random();
		int num = rand.nextInt(getCountriesToChooseFrom().size());
		Country countryToDraft = getCountriesToChooseFrom().get(num);
		return countryToDraft;
	}
	
	/**
	 * The method draftTurn() is called in Game and it initiates
	 * the AI draft methods in Turn
	 */	
	
	public static void draftTurn(){
		System.out.println();
		Turn.AIDraft();
	}


	//ATTACK PHASE
	
	
	/**
	 * @return response of type boolean returns to Turn class if it wants to attack or not
	 * at the beginning of the attack phase
	 */	
	
	public static boolean inputForAttackConfirmation(){
		ArrayList<Country> countries = Board.getPlayerCountries(playerNum);
		ArrayList<Boolean> listOfResponses = new ArrayList<Boolean>();
		boolean response = false;
		
		//This for loop checks each country the AI owns and adds true to listOfResponses for each country owned
		//It then adds the countries AI doesn't own as false so the probability AI chooses to attack is ((countries owned)/(total countries))
		for (int i=0; i<Board.getNumOfCountries(); i++){ //By reference
			for (int j=0; j<countries.size(); j++){ 
				listOfResponses.add(true); 
			}
			listOfResponses.add(false);
		}
		
		
		//AI chooses true or false from listOfResponses
		Random rand = new Random();
		int num = rand.nextInt(listOfResponses.size());
		response = listOfResponses.get(num);
		
		//Final check that there are countries on the map AI hasn't conquered and can attack
		if (getCountriesToChooseFrom().size()<1)
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
	 * @return response of type Country returns the country the AI is choosing to attack from
	 */	
	
	public static Country inputCountryAttackFrom(){
		System.out.println();
		System.out.println("----------ATTACK----------");
		
		Country response = new Country();
		Country countryNotAttackFrom = new Country();
		ArrayList<Country> AICountries = Board.getPlayerCountries(playerNum);//By reference
		ArrayList<Country> countriesAttackFrom = new ArrayList<Country>();
		
		
		//For every country AI Owns, it checks how many countries it does not own that are adjacent to its own country
		//This is checked by AIOwnedCountry equal to a country from getCountriesToChooseFrom()
		for (int i=0; i<AICountries.size(); i++){
			Country AIOwnedCountry = AICountries.get(i);
			for (int j=0; j<getCountriesToChooseFrom().size(); j++){
					Country checkCountry = getCountriesToChooseFrom().get(j);
					if (AIOwnedCountry == checkCountry && AIOwnedCountry.getNumOfTroops()>1){
						countriesAttackFrom.add(AIOwnedCountry);
					}				
				}
		}
				
		//Final check to make sure the countryAttackFrom will have more than 1 troops
		for (int i=0; i<countriesAttackFrom.size(); i++){
			if (countriesAttackFrom.get(i).getNumOfTroops()<2)
				countryNotAttackFrom = countriesAttackFrom.get(i);
			for (int j=0; j<Board.getListOfCountries().size(); j++){ //By reference (you can probably get rid of this, not sure)
				if (countryNotAttackFrom.getCountryName().equalsIgnoreCase(Board.getListOfCountries().get(j).getCountryName())){
					countriesAttackFrom.remove(countryNotAttackFrom);
				}
			}
		}
		
		
		//AI chooses a random country from countriesAttackFrom
		if (countriesAttackFrom.size()>0){
			Random rand = new Random();
			int num = rand.nextInt(countriesAttackFrom.size());
			Country attackingCountry = countriesAttackFrom.get(num);
			setAttackingCountry(attackingCountry);
			response = attackingCountry;
			System.out.println("Attacking from " + response.getCountryName());
		}
		else 
			response = null; //AI can't win because of this line 
		
		return response;
	}
	
	/**
	 * @return response of type Country returns a country the AI is choosing to attack
	 */	
	
	public static Country inputCountryToAttack(){
		Country response = new Country();
		//adjacentCountries is an arraylist of countries adjacent to the country AI is attacking from
		ArrayList<Country> adjacentCountries = Board.getAdjacentCountries(attackingCountry); 
		ArrayList<Country> countriesToAttack = new ArrayList<Country>();
		ArrayList<Country> checkCountryList = Board.getPlayerCountries(playerNum); //list of countries AI owns
		
		
		//For every country adjacent to the country AI is attacking from, if the country is not owned by AI,
		//AI will add that country to a list of possible countries to attack called countriesToAttack
		for (int i=0; i<adjacentCountries.size(); i++){
			Country checkAdjacentOpponent = adjacentCountries.get(i);
			for (int j=0; j<Board.getListOfCountries().size(); j++){ //By reference
				if (checkAdjacentOpponent.getCountryName().equalsIgnoreCase(Board.getListOfCountries().get(j).getCountryName())){
					if (checkAdjacentOpponent.getPossession() != playerNum)
						countriesToAttack.add(Board.getListOfCountries().get(j));
				}
			}
		}
		
		//AI randomly chooses a country to attack from the list countriesToAttack
		if (countriesToAttack.size()<1)
			response = null;
		else{
			Random rand = new Random();
			int num = rand.nextInt(countriesToAttack.size());
			attackedCountry = countriesToAttack.get(num);
			setAttackedCountry(attackedCountry);
			response = attackedCountry;
			String attackedCountryName = attackedCountry.getCountryName();
			System.out.println("Your opponent is attacking " + attackedCountryName + " from " + attackingCountry.getCountryName() + ".");
		}
		return response;
	}
	
	/**
	 * The method outputGainedCountry() prints out which country has been conquered by AI
	 * after AI conquers a country.
	 */
	 
	public static void outputGainedCountry(){
		System.out.println("The computer has conquered your country "+attackedCountry.getCountryName()+"!");
	}
	
	/**
	 * The method outputAttackWon() prints out the countries and their respective troops and owners
	 * after the dice have been rolled and the AI wins the roll
	 */
	 
	public static void outputAttackWon(){
		System.out.println("The computer's country "+attackingCountry.getCountryName()+" has won the attack against your country "+attackedCountry.getCountryName());
		System.out.println("Your country "+attackedCountry.getCountryName() + " now has "+ attackedCountry.getNumOfTroops()+ " troops.");
		System.out.println("The computer's country "+ attackingCountry.getCountryName()+" now has "+ attackingCountry.getNumOfTroops()+ " tropps.");
		System.out.println();
	}
	
	/**
	 * The method outputAttackLost() prints out the countries and their respective troops and owners
	 * after the dice have been rolled and the AI loses the roll
	 */
	 
	public static void outputAttackLost(){
		System.out.println("The computer's country "+attackingCountry.getCountryName()+" has lost the attack against your country "+attackedCountry.getCountryName());
		System.out.println("Your country "+attackedCountry.getCountryName() + " now has "+ attackedCountry.getNumOfTroops()+ " troops.");
		System.out.println("The computer's country "+ attackingCountry.getCountryName()+" now has "+ attackingCountry.getNumOfTroops()+ " tropps.");
		System.out.println();
	}
		
	/**
	 * The method attackTurn() is called in Game and it initiates
	 * the AI attack methods in Turn
	 */	
	
	public static void attackTurn(){
		System.out.println();
		Turn.AIAttack();
	}
	
	/**
	 * The method outputDiceRolls() prints out the dice rolls of the attacker and the attacked
	 */
	 
	public static void outputDiceRolls(){
		System.out.println();
		System.out.println("You rolled a " + Turn.getDiceRollTo() +" and the computer a "+ Turn.getDiceRollFrom());
	}
	
	
	//FORTIFY PHASE
	
	
	/**
	 * @return countriesFortifyFrom returns an arraylist of countries that AI owns and are adjacent to each other
	 */
	 
	public static ArrayList<Country> getCountriesToFortifyFrom(){
		ArrayList<Country> AICountries = Board.getPlayerCountries(playerNum);
		ArrayList<Country> countriesToFortifyFrom = new ArrayList<Country>();
		
		//Checks each country AI owns
		for (int i=0; i<AICountries.size(); i++){
			Country AIOwnedCountry = AICountries.get(i);
			ArrayList<Country> adjacentCountries = Board.getAdjacentCountries(AIOwnedCountry);
			//For every adjacent country to AI owned countries, 
			//if the adjacent country is owned by AI, the AI country is added to the list of countriesToFortifyFrom
			for (int j=0; j<adjacentCountries.size(); j++){
				Country checkCountry = adjacentCountries.get(j);
				if (checkCountry.getPossession() == playerNum)
					countriesToFortifyFrom.add(checkCountry);
			}
		}
		return countriesToFortifyFrom;
	}
	
	/**
	 * @return response returns a country picked from a list of possible countries AI can fortify
	 * Countries are first checked to be fortifiable in getCountriesToFortifyFrom()
	 * Probability of a country being picked is first added based off less troops being in that country
	 * Probability is also added to a country if it has more adjacent countries not owned by AI
	 */
	 
	public static Country inputCountryToFortify(){		
		ArrayList<Country> countriesToFortifyFrom = getCountriesToFortifyFrom();
		ArrayList<Country> countriesToFortify = new ArrayList<Country>(); 
		ArrayList<Integer> listOfTroops = new ArrayList<Integer>();
		Country response = new Country();
		
		
		//Checks number of troops in each country owned and fortifiable
		for (int i=0; i<countriesToFortifyFrom.size(); i++){
			listOfTroops.add(countriesToFortifyFrom.get(i).getNumOfTroops());
		}
		
		for (int j=0; j<listOfTroops.size(); j++){
			for (int k=0; k<listOfTroops.size(); k++){
				if (listOfTroops.get(k) <= listOfTroops.get(j))
					countriesToFortify.add(countriesToFortifyFrom.get(k));
			}
		}
		
		
		
		//Picks a random country to fortify from countriesToFortify arraylist
		if (countriesToFortify.size()>0){
			Random rand = new Random();
			int num = rand.nextInt(countriesToFortify.size());
			Country countryToFortify = countriesToFortify.get(num);
			response = countryToFortify;
			String countryToFortifyName = countryToFortify.getCountryName();
			System.out.println("The computer is fortifying to " + countryToFortifyName + ".");
			for (int j=0; j<Board.getListOfCountries().size(); j++){
				if (response.getCountryName().equalsIgnoreCase(Board.getListOfCountries().get(j).getCountryName()))
					response = Board.getListOfCountries().get(j);
			}
		}
		
		return response;
		
		
	}
	
	/**
	 * @return response of type Country returns a country adjacent to countryToFortify that AI chooses to fortify from
	 */
	 
	public static Country inputCountryFortifyFrom(){
		Country countryToFortify = Turn.getCountryToFortify();
		ArrayList<Country> possibleCountriesFortifyFrom = Board.getAdjacentCountries(countryToFortify);
		ArrayList<Country> countriesFortifyFrom = new ArrayList<Country>();;
		ArrayList<Integer> listOfTroops = new ArrayList<Integer>();
		Country response = new Country();
		
		
		//Checks number of troops in each country owned and fortifiable
		for (int i=0; i<possibleCountriesFortifyFrom.size(); i++){
			listOfTroops.add(possibleCountriesFortifyFrom.get(i).getNumOfTroops());
		}
		for (int j=0; j<listOfTroops.size(); j++){
			for (int k=0; k<listOfTroops.size(); k++){
				if (listOfTroops.get(k) >= listOfTroops.get(j))
					countriesFortifyFrom.add(possibleCountriesFortifyFrom.get(k));
			}
		}
		
		//Final check that the country AI is fortifiying from is owned by AI
		for (int i=0; i<countriesFortifyFrom.size(); i++){
			if (countriesFortifyFrom.get(i).getPossession() != playerNum)
				countriesFortifyFrom.remove(countriesFortifyFrom.get(i));
		}
		
		//Picks a random country to fortify from from countriesFortifyFrom arraylist
		if (countriesFortifyFrom.size()>0){
			Random rand = new Random();
			int num = rand.nextInt(countriesFortifyFrom.size());
			Country countryFortifyFrom = countriesFortifyFrom.get(num);
			//setCountryFortifyFrom(countryFortifyFrom);
			response = countryFortifyFrom;
			String countryFortifyFromName = countryFortifyFrom.getCountryName();
			System.out.println("The computer is fortifying from " + countryFortifyFromName + ".");
			for (int j=0; j<Board.getListOfCountries().size(); j++){
				if (response.getCountryName().equalsIgnoreCase(Board.getListOfCountries().get(j).getCountryName()))
					response = Board.getListOfCountries().get(j);
			}
		}
		
		return response;
		
	}
	
	/**
	 * @return response of type boolean returns true if countryFortifyFrom has more than 2 troops
	 */
	 
	public static boolean inputForFortifyConfirmation(){
		boolean response = true;
		
		if (Turn.getCountryFortifyFrom().getNumOfTroops()<3)
			response = false;
		
		System.out.println();
		System.out.println("----------BOARD STATUS----------");
		Board.boardStatus();
		System.out.println();

		if(response == true){
			System.out.println("The computer is choosing to fortify.");
			System.out.println();
			System.out.println("----------FORTIFY----------");
		}
		else if(response == false){
			System.out.println("The computer is choosing to skip the fortify phase.");
			System.out.println();
			System.out.println("It is now your turn!");
			System.out.println();
		}
		
		return response;
	}
	
	/**
	 * @return numOfTroopsToFortify of type int returns the number of troops the AI wants to fortify
	 */
	 
	public static int inputNumOfTroopsToFortify(){
		int numOfTroopsToFortify = ((Turn.getCountryFortifyFrom().getNumOfTroops()-1)/2);
		
		return numOfTroopsToFortify;
	}
	
	/**
	 * The method outputFortifyStatus() prints out what the AI has fortified and its updated troops
	 * for countries fortified to and from
]	 */
	 
	public static void outputFortifyStatus(){
		Country countryFortifyFrom = Turn.getCountryFortifyFrom();
		Country countryToFortify = Turn.getCountryToFortify();
		System.out.println();
		System.out.println(countryToFortify.getCountryName()+" has been fortified!");
		System.out.println(countryFortifyFrom.getCountryName()+" now has "+countryFortifyFrom.getNumOfTroops()+" troops.");
		System.out.println(countryToFortify.getCountryName()+" now has "+countryToFortify.getNumOfTroops()+" troops.");
	}
	
	/**
	 * The method fortifyTurn() is called in Game and it initiates
	 * the AI fortify methods in Turn
	 */	
	
	public static void fortifyTurn(){
		System.out.println();
		Turn.AIFortify();
		System.out.println();
		Board.boardStatus();
	}
	

	
}
