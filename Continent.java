import java.util.ArrayList;

/**
 * This Continent class is part of the Risk game that contains an array list of countries
 * for each of the 6 continents.
 *
 * @author Israa Farouk
 * @version 2.0
 * @since 2019-02-19
 */

public class Continent{
	
	private String continentName;
	private ArrayList<Country> countries = new ArrayList<Country>();
	
	/**
	Constructor
	@param continentName is the name of the continent 
	and will also determine how many countries are in each continent
	*/
	public Continent(String continentName){ 
		this.continentName = continentName;
		
		switch (continentName){
			
			case "NORTH AMERICA":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("NORTH AMERICA"));
				}
				break;
			
			case "SOUTH AMERICA":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("SOUTH AMERICA"));
				}
				break;
			
			case "EUROPE":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("EUROPE"));
				}
				break;
			
			case "ASIA":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("ASIA"));
				}
				break;
			
			case "AFRICA":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("AFRICA"));
				}
				break;
				
			case "AUSTRALIA":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("AUSTRALIA"));
				}
				break;
			}
	} 
	
	/**
	 * @return countryList returns an arraylist of type Country 
	 */
	
	public ArrayList<Country> getContinent(){
		ArrayList<Country> countryList = new ArrayList<Country>();
		for (int i =0; i < this.countries.size(); i++){
			countryList.add(new Country(this.countries.get(i)));
		}
		return countryList;
	}
	
	/**
	 * @return countries returns the countries it gets from each continent arraylist
	 */
	
	public ArrayList<Country> getContinentByRef(){
		return countries;
	}
}




