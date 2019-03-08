import java.util.ArrayList;
import java.util.Arrays;

/**
 * This Board class stores the state of the entire game.
 * Specifically, the state of each country in the game.
 * @version 4.0
 * @author
 * @since 2019-03-02
 */

public class Board{

  /**
   * countriesList stores each Country in an ArrayList
   */
  private ArrayList<Country> countriesList;

  /**
   * Constructs the game board. It initializes all countries and stores them
   * into an ArrayList that is assigned to the countriesList.
   */
  public Board(){
    ArrayList<Country> list = new ArrayList<Country>();
    ArrayList<String> listOfNames = new ArrayList<String>();
    String[] names = {"North America", "South America", "Europe", "Africa", "Asia", "Australia"};
    listOfNames.addAll(Arrays.asList(names));

    // creates each country as specified in the String[] names
    for(String name: listOfNames){
      Country country = new Country(name);
      list.add(country);
    }
    setCountriesList(list);

    // creates the adjacent list for each country and also assigns a continent
    for(Country country: countriesList){
      ArrayList<Country> adjList = adjacentCountries(country.getCountryName());
      country.setAdjacentCountries(adjList);
      int n = determineContinent(country.getCountryName());
      country.setContinent(n);
    }
  }

  /**
   * Determines the adjacent countries as specified by the String argument countryName
   * and adds the specific adjacent countries to each country's adjacentCountries ArrayList.
   * The result is that each country is now pointing to other countries that are adjacent.
   * @param countryName is a string the represents each country in the board
   * @return list is an ArrayList<Country> that points to countries that are adjacent to the countryName country.
   */
  public ArrayList<Country> adjacentCountries(String countryName){
    ArrayList<Country> list = new ArrayList<Country>();
    switch(countryName){
      case "North America" :
        list.add(countriesList.get(1));
        list.add(countriesList.get(2));
        list.add(countriesList.get(4));
        break;
      case "South America" :
        list.add(countriesList.get(0));
        list.add(countriesList.get(3));
        break;
      case "Europe" :
        list.add(countriesList.get(0));
        list.add(countriesList.get(3));
        list.add(countriesList.get(4));
        break;
      case "Africa" :
        list.add(countriesList.get(1));
        list.add(countriesList.get(2));
        list.add(countriesList.get(4));
        break;
      case "Asia" :
        list.add(countriesList.get(0));
        list.add(countriesList.get(2));
        list.add(countriesList.get(3));
        list.add(countriesList.get(5));
        break;
      case "Australia" :
        list.add(countriesList.get(4));
        break;
    }
    return list;
  }

  /**
   * Determines which continent each country in the board belongs to.
   * Depending on the country, the continent is determined by the specific rules
   * set by the developers.
   * @param countryName is a String that represents the country's name.
   * @return n is an int that represents the continent that the country belongs to.
   */
  public int determineContinent(String countryName){
    int n = 0;
    switch(countryName){
      case "North America":
        n = 0;
        break;
      case "South America":
        n = 0;
        break;
      case "Europe":
        n = 1;
        break;
      case "Africa":
        n = 1;
        break;
      case "Asia":
        n = 2;
        break;
      case "Australia":
        n = 2;
        break;
    }
    return n;
  }

  /**
   * Getter and Setter methods
   */
  public ArrayList<Country> getCountriesList(){
    return countriesList;
  }

  public void setCountriesList(ArrayList<Country> list){
    countriesList = list;
  }

  /**
   * Outputs onto the console the state of the board.
   * Specifically, the state of each country (ie. who owns it and how many troops).
   */
  public void showBoard(){
    System.out.println("\n---------------BOARD STATUS---------------");
    for (Country country: countriesList){
      String countryName = country.getCountryName();
      String playerName = country.getPlayerPossession().getPlayerName();
      int numOfTroops = country.getNumOfTroops();
      System.out.println(countryName+ " is owned by "+ playerName+" with "+numOfTroops+" troops.");
    }
  }

  /**
   * Determines if there is a winner of the game. This checks all the countries
   * in the referenced board and checks if there is only one player that owns
   * all of them.
   * @return boolean that is true when there is a whinner and false when there is not.
   */
  public boolean checkWinner() {
    boolean response = true;
    for (Country country: getCountriesList()){
        Player check = country.getPlayerPossession();
        for(Country otherCountries: getCountriesList()){
          if(check != otherCountries.getPlayerPossession()){
            response = false;
            break;
          }
        }
      }
      return response;
    }

 }
