/**
 * This Game class is the main class of the Risk game
 * it contains the game loop that runs the game.
 * @author Israa Farouk
 * @version 1.0
 * @since 2019-02-25
 */


public class Game{
	
	public static void main(String[] args){
		
		int numOfPlayers = Human.getNumOfPlayers(); //gets the number of players playing the game from the user
		Board gameBoard = new Board(numOfPlayers);
		gameBoard.boardSetup(); //board set up
		gameBoard.boardStatus();//board status displays the ownership and troops in each country
		
		
		while (GameConfig.ifWon() == false){ //while the game is not won
			Human.draftTurn(); //player gets to draft
			Human.attackTurn(); //player gets to attack
			if (GameConfig.ifWon() == true) //checks if the player's attack was the winning move
				break;
			Human.fortifyTurn(); //player gets to fortify
			AI.draftTurn(); //AI drafts 
			AI.attackTurn(); //AI gets to attack 
			if (GameConfig.ifWon() == true) //checks if the AI's attack was the winning move
				break;
			AI.fortifyTurn(); //AI gets to fortify
			
		}
		
		if (GameConfig.ifWon()){
			System.out.println("-----------------------------------");
			System.out.println("THE GAME HAS BEEN WON!!!!!!!!!!!!!!");
			System.out.println("-----------------------------------");
		}
	}
	
	
	
}
