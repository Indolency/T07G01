import java.util.Random;
import java.util.ArrayList;

/**
 * This GameConfig class is part of the Risk game that is responsible
 * for the mechanics/rules of the game
 * @author Israa Farouk
 * @version 1.0
 * @since 2019-02-25
 */

public class GameConfig{
	
    /**
     * This method analyses the board and checks if the game has been won.
     * @return won is true if the game has been won and is false otherwise.
     */
	
	public static boolean ifWon(){
		boolean won = false; 
		for (int i=0; i < Board.getNumOfPlayers(); i++){// for each player
			int ccounter = 0; //country counter
			for (int j=0; j < Board.getListOfCountries().size(); j++) {//for each country
				if (Board.getListOfCountries().get(j).getPossession() == i)//if all the countries are owned by the same player then the game is won
					ccounter += 1;
			}
			if (ccounter == Board.getListOfCountries().size()) {
				won = true;
				break;
			}
		}
		return won;
	}	
	
    /**
     * This method determines how many troops each player receives to draft
     * based on how many countries they own.
     * @return pcountries.size() is the number of troops gained by that player 
     */
	
	public static int getNumOfTroopsGained(){ //later will implent continent rewards
		int pnum = Turn.getPlayerNum(); //gets the current player
		ArrayList<Country> pcountries = Board.getPlayerCountries(pnum);//gets the list of countries that player owns
		return pcountries.size(); //returns the number of countries that the player owns which is the size of the list.
	}
	
}
