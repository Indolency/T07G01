import java.util.Random;
import java.util.List;

/**
 * The GameConfig Class controls the main loop of the game, which brings
 * together all the classes to run Risk.
 * @author
 * @version 2.0
 * @since 2019-02-23
 */
public class GameConfig{



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

    public static void main(String[] args) {
        // set up board (troops, turns, any set up before game starts)

        // Main loop that controls the whole game
        // while the game is not won
        // player takes turn
            // draft
            // loop attack until player doest not want to attack anymore
                // or until there are no more places to attack from
            // fortify
        // check if won
        // switch the current player (keep switching back and forth)

    }

}
