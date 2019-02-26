import java.util.ArrayList;
import java.util.Random;

/**
 * This Turn class is part of the Risk game that will look at the input from the
 * player and allow them to draft, attack, or fortify during their turn.
 *
 * @author Sophia Ngo, Jana Osea, Nicole Langevin
 * @version 3.0
 * @since 2019-02-24
 */

public class Turn{

	private static int playerNum = -1; //needs to be able to change in value to reflect player number
	private static int numOfTroopsToDraft;
	private static int diceRollFrom = 0;
	private static int diceRollTo = 0;
	private static Country countryAttackFrom;
	private static Country countryToAttack;
	private static Country countryFortifyFrom;
	private static Country countryToFortify;


	//Setters
	
	
	/**
	 * @param country is the country the player is fortifying from 
	 */
	 
	public static void setCountryFortifyFrom(Country country){
		countryFortifyFrom = country;
	}

	/**
	 * @param country is the country the player is fortifying  
	 */
	 
	public static void setCountryToFortify(Country country){
		countryToFortify = country;
	}

	/**
	 * @param country is the country the player is attacking from 
	 */
	 
	public static void setCountryAttackFrom(Country country){
		countryAttackFrom = country;
	}
	
	/**
	 * @param country is the country the player is attacking  
	 */
	 
	public static void setCountryToAttack(Country country){
		countryToAttack = country;
	}
	
	/**
	 * This method sets the number of the player that currently is playing their turn
	 * @param num is the number of the current player 
	 */	
	 
	public static void setPlayerNum(int num){
		playerNum = num;
	}


	//Getters
	
	
	/**
	 * @return playerNum is the number of the current player 
	 */	
	
	public static int getPlayerNum(){
		return playerNum;
	}

	/**
	 * @return countryAttackFrom is the country the player is attacking from  
	 */	
		
	public static Country getCountryAttackFrom(){
		return countryAttackFrom;
	}

	/**
	 * @return countryToAttack is the country the player is attacking  
	 */	
		
	public static Country getCountryToAttack(){
		return countryToAttack;
	}

	/**
	 * @return countryFortifyFrom is the country the player is fortifying from  
	 */	
		
	public static Country getCountryFortifyFrom(){
		return countryFortifyFrom;
	}

	/**
	 * @return countryToFortify is the country the player is fortifying   
	 */	
		
	public static Country getCountryToFortify(){
		return countryToFortify;
	}

	/**
	 * @return numOfTroopsToDraft is the number of troops the player chooses to fortify  
	 */	
		
	public static int getNumOfTroopsToDraft(){
		return numOfTroopsToDraft;
	}

	/**
	 * @return diceRollFrom is the dice roll of the current player  
	 */	
		
	public static int getDiceRollFrom(){
		return diceRollFrom;
	}

	/**
	 * @return diceRollTo is the dice roll of the player being attacked
	 */	
		
	public static int getDiceRollTo(){
		return diceRollTo;
	}

	
	//Human Methods

	/**
	 * The method draft() takes an input from the user in Human class of type country
	 * and drafts troops into the countries owned and chosen by the user
	 */
	 
	public static void draft(){
		setPlayerNum(0);
		numOfTroopsToDraft = GameConfig.getNumOfTroopsGained();
		while (numOfTroopsToDraft > 0){
			Human.possessionStatus();
			String countryName = Human.inputForDraft();
			ArrayList<Country> countries = Board.getPlayerCountries(playerNum);
			for (int i=0; i<countries.size(); i++){
				String countryNameEdited = countryName.replaceAll(" ", "");
				if(countryNameEdited.equalsIgnoreCase(countries.get(i).getCountryName().replaceAll(" ", ""))){
				countries.get(i).addNumOfTroops(1);
				numOfTroopsToDraft--;
				}
			}
		}
	}

	/**
	 * The method attack() takes input from the user in Human class of type country
	 * and attacks countries of another player from countries of the user.
	 */
	 
	public static void attack(){
		while (Human.inputForAttackConfirmation() && GameConfig.ifWon() == false){
			Country from = Human.inputCountryAttackFrom();
			setCountryAttackFrom(from);
			if (Human.checkAdjacentOpponent(countryAttackFrom) && (from.getNumOfTroops() > 1)){
					Country to = Human.inputCountryToAttack();
					setCountryToAttack(to);
					int playerTroops = from.getNumOfTroops();
					int opponentTroops = to.getNumOfTroops();
					while (((playerTroops>1) && (opponentTroops>0)) && Human.inputForAttackContinuation()){
						diceRollFrom= Dice.diceRoll();
						diceRollTo = Dice.diceRoll();
						Human.outputDiceRolls();
						if (diceRollFrom > diceRollTo){
							if (opponentTroops == 1){
								from.setNumOfTroops(1);
								to.setNumOfTroops(playerTroops - 1);
								to.setPossession(0);
								opponentTroops = 0;
								Human.outputGainedCountry();
								System.out.println();
								System.out.println("-----------------------------------");
								System.out.println("A COUNTRY HAS BEEN CONQUERED!!!!!!!");
								System.out.println("-----------------------------------");
								System.out.println();
							}
							else{
								opponentTroops--;
								to.setNumOfTroops(opponentTroops);
								Human.outputAttackWon();
							}
						}
						else if (diceRollFrom <= diceRollTo){
							playerTroops--;
							from.setNumOfTroops(playerTroops);
							Human.outputAttackLost();
						}
					}
				}
			}
		}


	/**
	 * The method fortify() takes input from the user in Human class of type country
	 * and moves the user owned troops from one country to another, said countries being adjacent and owned by the user.
	 */
	 
    public static void fortify(){
			setPlayerNum(0);
			ArrayList<Country> countries = Board.getPlayerCountries(playerNum);
			boolean valid = true;
			for (int i=0; i<countries.size(); i++){
				if(countries.get(i).getNumOfTroops() >=2){
					break;
				}
				else{
					valid = false;
				}
			}

			while(valid && Human.inputForFortifyConfirmation()){
				int currentPlayer = playerNum;
				Country countryFortifyFrom = Human.inputCountryFortifyFrom();
				setCountryFortifyFrom(countryFortifyFrom);
				if(Human.countryHasAdjacent(countryFortifyFrom)){
		  		Country countryToFortify = Human.inputCountryToFortify();
					setCountryToFortify(countryToFortify);
					int numOfTroopsToFortify = Human.inputNumOfTroopsToFortify();
					if ((countryFortifyFrom.getPossession() == currentPlayer) && (countryToFortify.getPossession() == currentPlayer)){
							int numOfTroopsLeftBehind = countryFortifyFrom.getNumOfTroops() - numOfTroopsToFortify;
							countryFortifyFrom.setNumOfTroops(numOfTroopsLeftBehind);
							countryToFortify.addNumOfTroops(numOfTroopsToFortify);
							Human.outputFortifyStatus();
							break;
						}
					}
				}
			}


	//AI Methods


	/**
	 * The method AIDraft() takes a probability based choice of type Country from AI class
	 * and drafts troops into the countries owned by AI.
	 */
	 
	public static void AIDraft(){
		setPlayerNum(1);
		numOfTroopsToDraft = GameConfig.getNumOfTroopsGained();
		while (numOfTroopsToDraft > 0){
			AI.possessionStatus();
			Country countryToDraft = AI.inputForDraft();
			countryToDraft.addNumOfTroops(1);
			numOfTroopsToDraft--;
		}
	}

	/**
	 * The method AIAttack() takes probability based choices of type Country from AI class
	 * and attacks countries of another player from countries of AI.
	 */
	 
	public static void AIAttack(){
		setPlayerNum(1);
		while (AI.inputForAttackConfirmation() && GameConfig.ifWon() == false){
			Country countryAttackFrom = AI.inputCountryAttackFrom();
			setCountryAttackFrom(countryAttackFrom);
			Country countryToAttack = AI.inputCountryToAttack();
			setCountryToAttack(countryToAttack);
			int playerTroops = countryAttackFrom.getNumOfTroops(); 
			int opponentTroops = countryToAttack.getNumOfTroops();
			int currentPlayer = playerNum;
			System.out.println("The player " + currentPlayer + " is attacking from " + countryAttackFrom.getCountryName() + " which has " + playerTroops);
			System.out.println("The player " + currentPlayer + " is attacking " + countryToAttack.getCountryName() + " which has " + opponentTroops);
			while (((playerTroops>1) && (opponentTroops>0)) && AI.inputForAttackConfirmation() && GameConfig.ifWon()==false){
				diceRollFrom = Dice.diceRoll();
				diceRollTo = Dice.diceRoll();
				AI.outputDiceRolls();
				if (diceRollFrom > diceRollTo){
					if (opponentTroops == 1){
						countryAttackFrom.setNumOfTroops(1);
						countryToAttack.setPossession(currentPlayer);
						countryToAttack.setNumOfTroops(playerTroops-1);
						opponentTroops = 0;
						AI.outputGainedCountry();
						System.out.println();
						System.out.println("-----------------------------------");
						System.out.println("A COUNTRY HAS BEEN CONQUERED!!!!!!!");
						System.out.println("-----------------------------------");
						System.out.println();
					}
					else{
						opponentTroops--;
						countryToAttack.setNumOfTroops(opponentTroops);
						AI.outputAttackWon();
					}
				}
				else if (diceRollFrom <= diceRollTo){
					playerTroops--;
					countryAttackFrom.setNumOfTroops(playerTroops);
					AI.outputAttackLost();
				}
			}
		}
	}




	/**
	 * The method AIFortify() takes probability based choices of type Country from AI class
	 * and moves AI owned troops from one country to another, said countries being adjacent and owned by AI.
	 */
	 
	public static void AIFortify(){
		setPlayerNum(1);
		Country countryToFortify = AI.inputCountryToFortify();
		setCountryToFortify(countryToFortify);
		Country countryFortifyFrom = AI.inputCountryFortifyFrom();
		setCountryFortifyFrom(countryFortifyFrom);
		AI.inputForFortifyConfirmation();
		if (AI.inputForFortifyConfirmation()){
			int numOfTroopsToFortify = AI.inputNumOfTroopsToFortify();
			int numOfTroopsLeftBehind = countryFortifyFrom.getNumOfTroops() - numOfTroopsToFortify;
			countryFortifyFrom.setNumOfTroops(numOfTroopsLeftBehind);
			countryToFortify.addNumOfTroops(numOfTroopsToFortify);
			
			System.out.println(countryFortifyFrom.getCountryName()+" has "+ numOfTroopsToFortify +" less troops. It now has "+countryFortifyFrom.getNumOfTroops()+" troops.");
			System.out.println(countryToFortify.getCountryName()+" has been fortified and now has "+countryToFortify.getNumOfTroops()+" troops.");

			AI.outputFortifyStatus();
		}
	}




































/**
	public static void AIFortify(){
		ArrayList<Country> countries = Board.getPlayerCountries(playerNum);
		boolean valid = true;
		for (int i=0; i<countries.size(); i++){
			if(countries.get(i).getNumOfTroops() >=2){
				break;
			}
			else{
				valid = false;
			}
		}
			while(valid && AI.inputForFortifyConfirmation()){
			int currentPlayer = playerNum;
			Country countryFortifyFrom = AI.inputCountryFortifyFrom();
			setCountryFortifyFrom(countryFortifyFrom);
			if(AI.countryHasAdjacent(countryFortifyFrom)){
	  		Country countryToFortify = AI.inputCountryToFortify();
				setCountryToFortify(countryToFortify);
				int numOfTroopsToFortify = AI.inputNumOfTroopsToFortify();
				if ((countryFortifyFrom.getPossession() == currentPlayer) && (countryToFortify.getPossession() == currentPlayer)){
						int numOfTroopsLeftBehind = countryFortifyFrom.getNumOfTroops() - numOfTroopsToFortify;
						countryFortifyFrom.setNumOfTroops(numOfTroopsLeftBehind);
						countryToFortify.addNumOfTroops(numOfTroopsToFortify);
						AI.outputFortifyStatus();
						break;
				}
			}
			}
	}
	*/

}
