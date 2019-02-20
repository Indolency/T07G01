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
    
    //creation of all the continents 
    private Continent NA = new Continent("North America");
    private Continent SA = new Continent("South America");
    private Continent EU = new Continent("Europe");
    private Continent AS = new Continent("Asia");
    private Continent AF = new Continent("Africa");
    private Continent AU = new Continent("Australia");
	


    public int getNumOfTroopsPP(int num){//num is num of players
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

    public int getNumOfPlayers(){
        return numOfPlayers;
    }

    public void setNumOfPlayers(int num){
        numOfPlayers = 2;
    }

    public void setContinents(){
        continents.add(NA);
        continents.add(SA);
        continents.add(EU);
        continents.add(AS);
        continents.add(AF);
        continents.add(AU);

    }

    public void makeListOfCountries(){
		 listOfCountries.addAll(NA.getContinentByRef());
		 listOfCountries.addAll(SA.getContinentByRef());
		 listOfCountries.addAll(EU.getContinentByRef());
		 listOfCountries.addAll(AS.getContinentByRef());
		 listOfCountries.addAll(AF.getContinentByRef());
		 listOfCountries.addAll(AU.getContinentByRef());
    }

	public void setupTroops(){
			int num = getNumOfPlayers();
			int troops = getNumOfTroopsPP(num);
			int perPlayer = getNumOfCountries()/getNumOfPlayers();
			for (int i=0; i < numOfPlayers; i++){// for each player
				for (int j=0; j < listOfCountries.size(); j++){//for each country
					if (listOfCountries.get(j).getPossession() == i){
						Random rand1 = new Random();
						int num1 = rand1.nextInt(troops - (perPlayer - 1));
						listOfCountries.get(j).setNumOfTroops(num1);
						perPlayer--;
					}
				}
			}
	}


	public int getNumOfCountries(){
		//Need to get remainder for nondivisible countries with more than 2 players
		int numOfCountries = 0;
		numOfCountries += NA.getContinent().size();
		numOfCountries += SA.getContinent().size();
		numOfCountries += EU.getContinent().size();
		numOfCountries += AS.getContinent().size();
		numOfCountries += AF.getContinent().size();
		numOfCountries += AU.getContinent().size();

		return numOfCountries;
    }

    public void setupPossession(){


        for (int i=0; i < numOfPlayers; i++){
			Random rand = new Random();
            int countryPlayerCounter = 0;
			int numOfCountriesPerPlayer = getNumOfCountries()/getNumOfPlayers();
            while(countryPlayerCounter!= numOfCountriesPerPlayer){
				int num = rand.nextInt(getNumOfCountries());
                Country country = listOfCountries.get(num);
                if (country.getPossession() == -1){
                    country.setPossession(i);
                    countryPlayerCounter++;
                }
            }
        }
    }


}
