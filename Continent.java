import java.util.ArrayList;

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
			
			case "North America":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("North America"));
				}
			
			case "South America":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("South America"));
				}
			
			case "Europe":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("Europe"));
				}
			
			case "Asia":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("Asia"));
				}
			
			case "Africa":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("Africa"));
				}
				
			case "Australia":
				for (int i =0; i < 1 ; i++){ //i<1 should be changed and will be different for each continent
					countries.add(new Country("Australia"));
				}
			}
	} 
	
	public ArrayList<Country> getContinent(){
		ArrayList<Country> countryList = new ArrayList<Country>();
		for (int i =0; i < this.countries.size(); i++){
			countryList.add(new Country(this.countries.get(i)));
		}
		return countryList;
	}
	
	public ArrayList<Country> getContinentByRef(){
		return countries;
	}
}


