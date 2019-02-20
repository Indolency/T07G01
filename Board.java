import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This Board class is part of the Risk game that will initialize the board and update it 
 * throughout the game. ""NOTE: at this point Board only initializes the board""
 *
 * @author Israa Farouk, Jana Osea, Nicole Langevin
 * @version 1.0
 * @since 2019-02-19
 */

public class Board{ 

	/**
	* Here, @numOfTroopsPP is number of troops per player
	*/
	
    private ArrayList<Continent> continents = new ArrayList<Continent>();
    private int numOfPlayers = 0;
    private ArrayList<Country> listOfCountries = new ArrayList<Country>();
    private int numOfTroopsPP = 0;
    
    //creation of all the continents using Continent class
    private Continent NA = new Continent("North America");
    private Continent SA = new Continent("South America");
    private Continent EU = new Continent("Europe");
    private Continent AS = new Continent("Asia");
    private Continent AF = new Continent("Africa");
    private Continent AU = new Continent("Australia");
	

	//Setters
	//This method adds all the continents to the arraylist continents

	public void setContinents(){
        continents.add(NA);
        continents.add(SA);
        continents.add(EU);
        continents.add(AS);
        continents.add(AF);
        continents.add(AU);

    }

	/**
	* This method sets the number of players playing the game
	* @param num is the number of players 
	*/
	//""NOTE: Later, this method will actually set the number 
	//based on a prompt from another method in another file""

    public void setNumOfPlayers(int num){
        numOfPlayers = 2;
    }
	
	// This method adds all the countries in each continent to the arraylist listOfCountries
	//""NOTE: At the moment, each continent has only one country with the same name as the continent
		
    public void setListOfCountries(){
		 listOfCountries.addAll(NA.getContinentByRef());
		 listOfCountries.addAll(SA.getContinentByRef());
		 listOfCountries.addAll(EU.getContinentByRef());
		 listOfCountries.addAll(AS.getContinentByRef());
		 listOfCountries.addAll(AF.getContinentByRef());
		 listOfCountries.addAll(AU.getContinentByRef());
    }

	//Getters
	//""NOTE: We should get rid of this method once we finalize the number of countries we will use
	// i.e. we can just set numOfCountries as a constant""

    public int getNumOfCountries(){
		int numOfCountries = 0;
		numOfCountries += NA.getContinent().size();
		numOfCountries += SA.getContinent().size();
		numOfCountries += EU.getContinent().size();
		numOfCountries += AS.getContinent().size();
		numOfCountries += AF.getContinent().size();
		numOfCountries += AU.getContinent().size();

		return numOfCountries;
    }
	
	/** 
	* @return numOfTroopsPP gives each player a number of troops to start with
	* based on the number of players 
	*/
	//""NOTE: This needs to be updated when numOfPlayers isn't just 2 - follow rules of game""
	
	public int getNumOfTroopsPP(){
        switch(numOfPlayers){
            case 2:
                numOfTroopsPP = 9;
            case 3:
                numOfTroopsPP = 9;
            case 4:
                numOfTroopsPP = 9;
            case 5:
                numOfTroopsPP = 9;
            case 6:
                numOfTroopsPP = 9;
            case 7:
                numOfTroopsPP = 9;
            case 8:
                numOfTroopsPP = 9;
        }
        return numOfTroopsPP;
    }
	
	/**
	* @return numOfPlayers returns the number of players
	*/

    public int getNumOfPlayers(){
        return numOfPlayers;
    }


	//Methods that initialize the game

	/**
	* This method assigns each player's possession (based off the numOfCountriesPerPlayer)
	* to each country 
	*/	

    public void setupPossession(){
		//""NOTE: Need to get remainder for nondivisible countries with more than 2 players""


        for (int i=0; i < numOfPlayers; i++){ //for each player
			Random rand = new Random();
            int countryPlayerCounter = 0;
			int numOfCountriesPerPlayer = getNumOfCountries()/numOfPlayers;
			//This while loop repeats until each player has the required number of countries
            while(countryPlayerCounter!= numOfCountriesPerPlayer){
				int num = rand.nextInt(getNumOfCountries()); //Generates a random number from the numOfCountries
                Country country = listOfCountries.get(num);
                if (country.getPossession() == -1){ //Checks if the country is owned
                    country.setPossession(i); //If country was unowned, the player now possesses it
                    countryPlayerCounter++;
                }
            }
        }
    }

	/**
	* This method distributes the number of troops per player among their respective countries
	*/

	public void setupTroops(){
			int troops = getNumOfTroopsPP();
			int numOfCountriesPerPlayer = getNumOfCountries()/numOfPlayers;
			for (int i=0; i < numOfPlayers; i++){// for each player
				for (int j=0; j < listOfCountries.size(); j++){//for each country
					if (listOfCountries.get(j).getPossession() == i){
						Random rand1 = new Random();
						int num1 = rand1.nextInt(troops - (numOfCountriesPerPlayer - 1)); 
							//The above line generates a random number so that there are enough troops for each country owned
						listOfCountries.get(j).setNumOfTroops(num1);
							//The changes in the arraylist listOfCountries affects the original country itself 
						numOfCountriesPerPlayer--;
					}
				}
			}
	}


}
