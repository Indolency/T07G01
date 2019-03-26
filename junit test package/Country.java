import java.util.ArrayList;

/**
  * This Country class is part of the Risk game that stores information about the status of each country
  * before and during the game.
 * @version 3.0
 * @author
 * @since 2019-03-02
 */

public class Country{

  private String countryName;
  private int numOfTroops;
  /**
   * References to the specific Player object this country belongs to.
   */
  private Player playerPossession;
  /**
   * ArrayList that contains objects of type Country and references the countries
   * that are adjacent.
   */
  private ArrayList<Country> adjacentCountries;
  /**
   * Represents the continent number of this specific countryName.
   */
  private int continent;

  /**
   * Constructs a Country specified by a name. This is instantiated in the
   * creation of a Board where the String is specified by the developers.
   * @param name is a String the represents the name of a Country.
   */
  public Country(String name){
    setCountryName(name);
  }

  /**
   * Constructs a Country specified by a name and continent number. This is instantiated in the
   * creation of a Board where the String is specified by the developers.
   * @param name is a String the represents the name of a Country.
   * @param continentNum is an Integer that represents the continent number of s Country.
   */
  public Country(String name, int continentNum){
    setCountryName(name);
    setContinent(continentNum);
  }

  public Country() {
  }

  /**
   * Getter and Setter methods
   */
  public String getCountryName(){
    return countryName;
  }

  public int getNumOfTroops(){
    return numOfTroops;
  }

  public Player getPlayerPossession(){
    return playerPossession;
  }

  public ArrayList<Country> getAdjacentCountries(){
    return adjacentCountries;
  }

  public int getContinent(){
    return continent;
  }

  public void setCountryName(String name){
    countryName = name;
  }

  public void setNumOfTroops(int num){
    if (num>=0)
      numOfTroops = num;
  }

  public void setPlayerPossession(Player player){
    playerPossession = player;
  }

  public void setAdjacentCountries(ArrayList<Country> list){
    adjacentCountries = list;
  }

  public void setContinent(int n){
    if (n>= 0)
      continent = n;
  }

  /**
   * Determines if the country no longer has any troops inside of it.
   * @return boolean that is true is it is empty of troops
   *  and false if it is not empty of troops.
   */
  public boolean isEmpty(){
    if (numOfTroops == 0)
      return true;
    else
      return false;
  }

  /**
   * Adds the specified amount of troops to the country's numOfTroops.
   * @param n is an integer that represents the number of troops being added.
   */
  public void addTroops(int n){
      numOfTroops += n;
  }

  /**
   * Removes the specified amount of troops to the country's numOfTroops.
   * @param n is an integer that represents the number of troops being removed.
   */
  public void removeTroops(int n){
    if (numOfTroops>n && n>0)
      numOfTroops -= n;
  }

  public boolean oneLeft(){
    boolean response = true;
    if (getNumOfTroops() == 1){
      response = true;
    }
    else{
      response = false;
    }
    return response;
  }
}
