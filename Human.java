import java.util.Scanner;
import java.util.ArrayList;


import java.util.Scanner;

public class Human{

  public static int getNumOfPlayers(){
    System.out.println("How many players would you like?");
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    return num;
  }


}

/**
 * This is the original version of Human

public class Human{  
  
  private Scanner input = new Scanner();
  private ArrayList<Country> listOfCountries = new ArrayList<Country> ();
  private ArrayList<Country> listOfPlayerCountries = new ArrayList<Country> ();
  
  public void showCountries(Board board){
    System.out.println("These are the countries you own with the number of troops");
    listOfCountries = board.getListOfCountries();
    for (int i=0; i<listOfCountries.size(); i++){
      if (listOfCountries.get(i).getPossession() == 0){
        listOfPlayerCountries.add(listOfCountries.get(i));
      }
    for (int i=0; i<listOfPlayerCountries; i++){
      String countryName = listOfPlayerCountries.get(i).getCountryName();
      int numOfTroops =  listOfPlayerCountries.get(i).getNumOfTroops();
      System.out.println("In " + countryName+ " you have " +numOfTroops + " troops.");
    }
  }
  
  
}

*/
