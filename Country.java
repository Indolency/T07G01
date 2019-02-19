public class Country{
	
	private String countryName;
	private int numOfTroops = 0;
	private char possesion = -1; 
		
	/** 
	constructor that takes in one argument 
	@param countryName the name of the country 
	*/
	public Country(String countryName){
		this.countryName = countryName;
	}
	
	// getter methods 
	
	public String getCountryName(){
		return countryName;
	}
	
	public int getNumOfTroops(){
		return numOfTroops;
	}
	
	public int getPossesion(){
		return possesion;
	}
	
	// setter methods
	
	public void setCountryName(String cname){
		countryName = cname;
	}
		
	public void setnumOfTroops(int num){
		numOfTroops = num;
	}
		
	public void setPossesion(int poss){
		possesion = poss;
	}
}
