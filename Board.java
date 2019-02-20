import java.util.ArrayList;
import java.util.Random;

public class Board{
		
    private ArrayList<Continent> continents = new ArrayList<Continent>();
    private int numOfPlayers;
    private ArrayList<Country> listOfCountries = new ArrayList<Country>();
    private int numOfTroops;
	
	
	private Continent NA = new Continent("North America");
	private Continent SA = new Continent("South America");
	private Continent EU = new Continent("Europe");
	private Continent AS = new Continent("Asia");
	private Continent AF = new Continent("Africa");
	private Continent AU = new Continent("Australia");
    
    public int getNumOfTroops(int num){//num is num of players
        switch(num){
            case 2:
                numOfTroops = 9;
            case 3:
                numOfTroops = 9;
            case 4:
                numOfTroops = 9;
            case 5:
                numOfTroops = 9;
            case 6:
                numOfTroops = 9;
            case 7:
                numOfTroops = 9;
            case 8:
                numOfTroops = 9;
        }
        return numOfTroops;
    }
	
    public int getNumOfPlayers(){
        return numOfPlayers;
    }
	
    public void setNumOfPlayers(int num){
        numOfPlayers = num;
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
			int troops = getNumOfTroops(num);
			int numCountriesPerPlayer = getNumOfCountries()/getNumOfPlayers();
			int perPlayer = numCountriesPerPlayer;
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
	
	public void setNumOfTroopsPerPlayer(){
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
			int numCountriesPerPlayer = getNumOfCountries()/getNumOfPlayers();
            while(countryPlayerCounter!= numCountriesPerPlayer){
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
