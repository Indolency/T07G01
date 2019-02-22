import java.util.ArrayList;
import java.util.Random;

/**
 * This Board class is part of the Risk game that will initialize the board and update it 
 * throughout the game. ""NOTE: at this point Board only initializes the board""
 *
 * @author Israa Farouk, Jana Osea, Nicole Langevin
 * @version 2.0
 * @since 2019-02-21
 */

public class Board{
	
	/**
	 * Here, @numOfTroopsPP is number of troops per player
	 */

    private int numOfPlayers = 0;
    private int numOfTroopsPP = 0; //initial value
    private ArrayList<Continent> continents = new ArrayList<Continent>();
    private ArrayList<Country> listOfCountries = new ArrayList<Country>();

    //creation of all the continents using Continent class
	private Continent NA = new Continent("NORTH AMERICA");
    private Continent SA = new Continent("SOUTH AMERICA");
    private Continent EU = new Continent("EUROPE");
    private Continent AS = new Continent("ASIA");
    private Continent AF = new Continent("AFRICA");
    private Continent AU = new Continent("AUSTRALIA");

    public Board(int numOfPlayers){
      setNumOfPlayers(numOfPlayers);
    }
	
	//Setters
	
	/**
	 * This method sets the number of players playing the game
	 * @param num is the number of players 
	 */

    public void setNumOfPlayers(int numOfPlayers){
      this.numOfPlayers = numOfPlayers;
    }
	
	//The method setContinents adds all the continents to the arraylist continents
	
	public void setContinents(){
        continents.add(NA);
        continents.add(SA);
        continents.add(EU);
        continents.add(AS);
        continents.add(AF);
        continents.add(AU);
		System.out.println(continents.get(0).getContinent().get(0).getCountryName());
    }
	
	// The method setListOfCountries adds all the countries in each continent to the arraylist listOfCountries
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
	
	/**The method getNumOfCountries counts the number of countries in each arraylist of continents
	 * and adds them together to get a total number of countries on the game board
	 */
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
	* 
	* @param selectedCountry is the country the player selects to attack or fortify from 
	* @return adjacentCountries an arraylist that contains all the adjacent countries
	*/
	//""NOTE: It would be great if we found a better way to do this for the actual thing 
	//other than just hardcoding 42 countries""
	
	public ArrayList<Country> getAdjacentCountries(Country selectedCountry){
		//get the name of the selectedCountry and return the arraylist of countries adjacent to it
		String cname = selectedCountry.getCountryName();
		ArrayList<Country> adjacentCountries = new ArrayList<Country>();
		switch(cname){
			case "NORTH AMERICA":
				adjacentCountries.add(SA.getContinent().get(0));
				adjacentCountries.add(EU.getContinent().get(0));
				adjacentCountries.add(AS.getContinent().get(0));
			case "SOUTH AMERICA":
				adjacentCountries.add(NA.getContinent().get(0));
				adjacentCountries.add(AF.getContinent().get(0));
			case "EUROPE":
				adjacentCountries.add(NA.getContinent().get(0));
				adjacentCountries.add(AF.getContinent().get(0));
				adjacentCountries.add(AS.getContinent().get(0));
			case "AFRICA":
				adjacentCountries.add(SA.getContinent().get(0));
				adjacentCountries.add(EU.getContinent().get(0));
				adjacentCountries.add(AS.getContinent().get(0));
			case "ASIA":
				adjacentCountries.add(AF.getContinent().get(0));
				adjacentCountries.add(EU.getContinent().get(0));
				adjacentCountries.add(NA.getContinent().get(0));
				adjacentCountries.add(AU.getContinent().get(0));
			case "AUSTRALIA":
				adjacentCountries.add(AS.getContinent().get(0));
				
		}
		return adjacentCountries;
	}
	
	/**
	* @param playerNumber is player's number (starts from 0)
	* @return possessedCountries is an arraylist that contains all the countries owned by the player
	*/
	
	public ArrayList<Country> getPlayerCountries(int playerNumber){
		ArrayList<Country> possessedCountries = new ArrayList<Country>();
		for (int i=0; i <listOfCountries.size(); i++){
			if (listOfCountries.get(i).getPossession() == playerNumber){
				possessedCountries.add(listOfCountries.get(i));
			}
		}
		for (int i=0;i<possessedCountries.size(); i++){
			System.out.println(possessedCountries.get(i).getCountryName());
		}
		return possessedCountries;
	}
	
	//Methods that initialize the game
	
	/** 
	* @return numOfTroopsPP gives each player a number of troops to start with
	* based on the number of players 
	*/
	//""NOTE: This needs to be updated when numOfPlayers isn't just 2 - follow rules of game""
		
	public int setupNumOfTroopsPP(){
	    int num = numOfPlayers;
        switch(num){
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
	* The method setupPossession distributes the number of troops per player among their respective countries
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
	
	
	
	public void setupTroops(){
			int troops = setupNumOfTroopsPP();
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
	
	public void boardStatus(){
		for (int i=0; i<continents.size(); i++){ //for each continent
			System.out.println("Print please");
			ArrayList<Country> a = continents.get(i).getContinent();
			//System.out.println(a.get(0).getCountryName());
			for (int j=0; j<a.size(); j++){ //for each country
				String countryName = a.get(j).getCountryName();
				int numOfTroops = a.get(j).getNumOfTroops();
				int playerNumber = a.get(j).getPossession();
				System.out.println(countryName + " is owned by player " + playerNumber + " and has " + numOfTroops + " troops.");
			}
		}
	}
	
	/**The method boardSetup initializes the continents and countries on the board
	 * and initializes the troops and players belonging to said countries
	 */
	
	public void boardSetup(){
		setContinents();
		setListOfCountries();
		setupPossession();
		setupTroops();
	}
	
	
	
}
