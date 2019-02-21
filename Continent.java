import java.util.ArrayList;

/**
 * This Continent class is part of the Risk game that contains an array list of countries
 * for each of the 6 continents.
 *
 * @author Israa Farouk
 * @version 1.0
 * @since 2019-02-19
 */

public class Continent{
	
	private String continentName;
	private ArrayList<Country> countries = new ArrayList<Country>(); 
	
	//there will be 6 different array lists for each continent.
	
	/**
	Constructor
	@param continentName is the name of the continent 
	and will also determine how many countries are in each continent and set up the array list accordingly.
	*/
	public Continent(String continentName){ 
		this.continentName = continentName;
		
		switch (continentName){
			
			case "NORTH AMERICA":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("NORTH AMERICA"));
				}
			
			case "SOUTH AMERICA":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("SOUTH AMERICA"));
				}
			
			case "EUROPE":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("EUROPE"));
				}
			
			case "ASIA":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("ASIA"));
				}
			
			case "AFRICA":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("AFRICA"));
				}
				
			case "AUSTRALIA":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("AUSTRALIA"));
				}
			}
	} 
	
	// getter methods
	
	/** This method returns an array list by value and NOT by reference
	* @return countryList is an array list of countries in the continent
	*/
	
	public ArrayList<Country> getContinent(){
		ArrayList<Country> countryList = new ArrayList<Country>();
		for (int i =0; i < this.countries.size(); i++){
			countryList.add(new Country(this.countries.get(i)));
		}
		return countryList;
	}
	
	
	/** This method returns an array list by reference therefore any changes made to the user's array list will change the original
	* @return countryList is an array list of countries in the continent
	*/
	
	public ArrayList<Country> getContinentByRef(){
		return countries;
	}
}


