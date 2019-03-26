package logic;
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
    String[] names = {"HYBRID", "CCIT", "ENA", "ENB", "ENC", "END", "ENF", "SSE", "TI",
            "EEEL", "ICT", "ES", "SA",  "SB", "TR", "MS", "ST", "SS", "BS",
            "OO", "KNA", "KNB", "MSC", "MACHALL",
            "MB", "MT", "MFH", "TFDL", "CHG", "CHC", "RT", "RC", "ARTS PARK",
            "AD", "PF", "EDUC", "SCURF",
            "IH", "DC", "TRAD", "APTS"};
    Integer[] correspondingContinentNumbers = {5,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,3,3,3,3,3,3,3,3,3,4,4,4,4,5,5,5,5};
    listOfNames.addAll(Arrays.asList(names));

    // creates each country as specified in the String[] names
    for(int i=0; i<41; i++){
      Country country = new Country(names[i],correspondingContinentNumbers[i]);
      list.add(country);
    }
    setCountriesList(list);

    // creates the adjacent list for each country and also assigns a continent
    for(Country country: countriesList){
      ArrayList<Country> adjList = adjacentCountries(country.getCountryName());
      country.setAdjacentCountries(adjList);
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
      case "CCIT" :
        list.add(countriesList.get(5));
        list.add(countriesList.get(6));
        break;
      case "ENA" :
        list.add(countriesList.get(3));
        list.add(countriesList.get(4));
        list.add(countriesList.get(7));
        list.add(countriesList.get(10));
        break;
      case "ENB" :
        list.add(countriesList.get(2));
        list.add(countriesList.get(4));
        list.add(countriesList.get(9));
        break;
      case "ENC" :
        list.add(countriesList.get(2));
        list.add(countriesList.get(3));
        list.add(countriesList.get(5));
        list.add(countriesList.get(6));
        list.add(countriesList.get(7));
        break;
      case "END" :
        list.add(countriesList.get(1));
        list.add(countriesList.get(4));
        list.add(countriesList.get(6));
        list.add(countriesList.get(7));
        break;
      case "ENF" :
        list.add(countriesList.get(4));
        list.add(countriesList.get(5));
        list.add(countriesList.get(7));
        break;
      case "SSE" :
        list.add(countriesList.get(2));
        list.add(countriesList.get(4));
        list.add(countriesList.get(5));
        list.add(countriesList.get(6));
        list.add(countriesList.get(8));
        break;
      case "TI" :
        list.add(countriesList.get(6));
        list.add(countriesList.get(7));
        list.add(countriesList.get(13));
        list.add(countriesList.get(22));
        list.add(countriesList.get(23));
        break;
      case "EEEL" :
        list.add(countriesList.get(3));
        list.add(countriesList.get(10));
        list.add(countriesList.get(11));
        break;
      case "ICT" :
        list.add(countriesList.get(2));
        list.add(countriesList.get(9));
        list.add(countriesList.get(11));
        break;
      case "ES" :
        list.add(countriesList.get(9));
        list.add(countriesList.get(10));
        list.add(countriesList.get(13));
        list.add(countriesList.get(14));
        list.add(countriesList.get(15));
        break;
      case "SA" :
        list.add(countriesList.get(13));
        list.add(countriesList.get(16));
        list.add(countriesList.get(17));
        list.add(countriesList.get(33));
        break;
      case "SB" :
        list.add(countriesList.get(8));
        list.add(countriesList.get(11));
        list.add(countriesList.get(12));
        list.add(countriesList.get(23));
        break;
      case "TR" :
        list.add(countriesList.get(11));
        list.add(countriesList.get(15));
        break;
      case "MS" :
        list.add(countriesList.get(11));
        list.add(countriesList.get(14));
        list.add(countriesList.get(16));
        break;
      case "ST" :
        list.add(countriesList.get(12));
        list.add(countriesList.get(15));
        list.add(countriesList.get(17));
        list.add(countriesList.get(18));
        break;
      case "SS" :
        list.add(countriesList.get(12));
        list.add(countriesList.get(16));
        list.add(countriesList.get(33));
        break;
      case "BS" :
        list.add(countriesList.get(16));
        break;
      case "OO" :
        list.add(countriesList.get(20));
        list.add(countriesList.get(21));
        break;
      case "KNA" :
        list.add(countriesList.get(19));
        list.add(countriesList.get(21));
        list.add(countriesList.get(37));
        break;
      case "KNB" :
        list.add(countriesList.get(19));
        list.add(countriesList.get(20));
        list.add(countriesList.get(22));
        break;
      case "MSC" :
        list.add(countriesList.get(8));
        list.add(countriesList.get(21));
        list.add(countriesList.get(23));
        break;
      case "MACHALL" :
        list.add(countriesList.get(8));
        list.add(countriesList.get(13));
        list.add(countriesList.get(22));
        list.add(countriesList.get(24));
        list.add(countriesList.get(27));
        break;
      case "MB" :
        list.add(countriesList.get(23));
        list.add(countriesList.get(25));
        list.add(countriesList.get(27));
        break;
      case "MT" :
        list.add(countriesList.get(24));
        list.add(countriesList.get(26));
        list.add(countriesList.get(27));
        break;
      case "MFH" :
        list.add(countriesList.get(25));
        list.add(countriesList.get(29));
        list.add(countriesList.get(34));
        break;
      case "TFDL" :
        list.add(countriesList.get(23));
        list.add(countriesList.get(25));
        list.add(countriesList.get(28));
        break;
      case "CHG" :
        list.add(countriesList.get(27));
        list.add(countriesList.get(29));
        list.add(countriesList.get(30));
        list.add(countriesList.get(32));
        break;
      case "CHC" :
        list.add(countriesList.get(26));
        list.add(countriesList.get(28));
        list.add(countriesList.get(30));
        list.add(countriesList.get(32));
        break;
      case "RT" :
        list.add(countriesList.get(28));
        list.add(countriesList.get(29));
        list.add(countriesList.get(31));
        list.add(countriesList.get(32));
        break;
      case "RC" :
        list.add(countriesList.get(30));
        break;
      case "ARTS PARK" :
        list.add(countriesList.get(28));
        list.add(countriesList.get(29));
        list.add(countriesList.get(30));
        break;
      case "AD" :
        list.add(countriesList.get(12));
        list.add(countriesList.get(17));
        list.add(countriesList.get(34));
        break;
      case "PF" :
        list.add(countriesList.get(26));
        list.add(countriesList.get(33));
        list.add(countriesList.get(35));
        break;
      case "EDUC" :
        list.add(countriesList.get(33));
        list.add(countriesList.get(36));
        break;
      case "SCURF" :
        list.add(countriesList.get(35));
        break;
      case "IH" :
        list.add(countriesList.get(20));
        list.add(countriesList.get(38));
        break;
      case "DC" :
        list.add(countriesList.get(37));
        list.add(countriesList.get(39));
        break;
      case "TRAD" :
        list.add(countriesList.get(38));
        list.add(countriesList.get(40));
        break;
      case "APTS" :
        list.add(countriesList.get(39));
        list.add(countriesList.get(0));
        break;
      case "HYBRID" :
        list.add(countriesList.get(40));
        break;

    }
    return list;
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


  public Country countryNameToCountry(String countryName){
    Country country = new Country();
    for (int i=0; i<41; i++){
      Country checkCountry = countriesList.get(i);
      if (countryName.equalsIgnoreCase(checkCountry.getCountryName()))
        country = checkCountry;
    }
    return country;
  }

}
