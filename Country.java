public class Country{
	
	
/**
 * This Country class is part of the Risk game that stores information about the status of each country
 * before and during the game.
 * @author Israa Farouk
 * @version 2.0
 * @since 2019-02-19
 */
	/** The variables for number of troops and possession are each assigned to each country
	* instead of assigning a country to a player
	*/
	
	private String countryName;  
	private int numOfTroops = 0; //number of troops in each country
	private int possession = -1; //initial possession value of -1 indicates no ownership

	
	/** 
	constructor that takes in one parameter to create a country
	@param countryName the name of the country 
	*/
	public Country(String countryName){
		this.countryName = countryName;
	}
	
	public Country(Country c){
		countryName = c.getCountryName();
		numOfTroops = c.getNumOfTroops();
		possession = c.getPossession();
	}
	
	
	// getter methods 
	
	/** getter method for the country name
	* @return countryName returns the name of the country
	*/
	
	public String getCountryName(){
		return countryName;
	}
	
	/** getter method for number of troops per country
	* @return numOfTroops returns the number of troops in that country
	*/
	
	public int getNumOfTroops(){
		return numOfTroops;
	}
	
	/** getter method for the ownership of the country
	* @return posession which is a number that indicates the player's ownership
	*/
	
	public int getPossession(){
		return possession;
	}
	
	// setter methods
	
	
	/** setter method for the country name
	* @param cname the new country name if a change is required 
	*/
	
	public void setCountryName(String cname){
		countryName = cname;
	}
	
	/** setter method for number of troops in the country
	* @param tnum the new number of troops the country will contain  
	*/
		
	public void setNumOfTroops(int tnum){
		numOfTroops = tnum;
	}
		
	/** setter method for the ownership of the country
	* @param poss the new value that indicates the new ownership of the country  
	*/
	
	public void setPossession(int poss){
		possession = poss;
	}
}
