public class Game{
	
	public static void main(String[] args){
		int numOfPlayers = Human.getNumOfPlayers();
		Board gameBoard = new Board(numOfPlayers);
		gameBoard.boardSetup();
		
		
		/**
		while (GameConfig.ifWon() == false){
			Human.draftTurn();
			Human.attackTurn();
			if (GameConfig.ifWon() == true)
				break;
			Human.fortifyTurn();
			AI.draftTurn();
			AI.attackTurn();
			if (GameConfig.ifWon() == true)
				break;
			AI.fortifyTurn();
			
		}
		*/
	}
	
	
	
}











/**
 * This is the original class Game for reference
public class Game{
  
  private GameConfig config = new GameConfig();
  
  public static void main(String[] args){
    //Make the original gameBoard
    Board gameBoard = new Board();
    config.gameSetup(gameBoard);
    
    while (config.ifWon == false){
      humanPlayer1
        if (config.ifWon == true);
        break;
      humanPlayer2
      //'AIPlayer'
    }
    
  }
}
*/
