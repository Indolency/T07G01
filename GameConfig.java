import java.util.Random;
import java.util.List;

public class GameConfig{
    
    }
    

    public void gameSetUp(Board emptyBoard){ //emptyBoard is board before we have continents and troops assigned
	//Call methods to name continents
	    emptyBoard.setContinents();
	    emptyBoard.makeListOfCountries();
	    
	    int numOfPlayers = emptyBoard.getNumOfPlayers();
	    emptyPBoard.setNumOfPlayers(numOfPlayers);
	    int numOfTroopsPerPlayer = emptyBoard.getNumOfTroops(numOfPlayers);
	    emptyBoard.setupPossession();
	    emptyBoard.setupTroops();
        
    }
   
   /** Might need for graphical part
    public void updateBoard(Board board){
    }*/
    
    public boolean ifWon(){
        //check if any player has all territories
	    //if 
        //check if numOfAdjacent == 0
    }
    
    public boolean validMove(){
        //continent attacking from is owned by attacker
        
    }
    
}


}
