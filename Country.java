public class Country{
	
	private String countryName;
	private int numOfTroops = 0;
	private int possession = -1;
		
	/** 
	constructor that takes in one argument 
	@param countryName the name of the country 
	*/
	public Country(String countryName){
		this.countryName = countryName;
	}
	
	public Country(Country c){
		countryName = getCountryName();
		numOfTroops = getNumOfTroops();
		possession = getPossession();
	}
	
	
	// getter methods 
	
	public String getCountryName(){
		return countryName;
	}
	
	public int getNumOfTroops(){
		return numOfTroops;
	}
	
	public int getPossession(){
		return possession;
	}
	
	// setter methods
	
	public void setCountryName(String cname){
		countryName = cname;
	}
		
	public void setNumOfTroops(int num){
		numOfTroops = num;
	}
		
	public void setPossession(int poss){
		possession = poss;
	}
}
