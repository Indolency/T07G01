import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This Dice class outputs a random number out of six for each
 * die and will eventually keep track of all five die.
 *
 * @author T07G01
 * @version 1.0
 * @since 2019-02-21
 */

public class Dice{

	public Dice() {
	}

	/**
	 * @return num of type int returns a random number between 1 and 6
	 */

	public ArrayList<Integer> rollDice(int numOfDice){
		Random rand = new Random();
		ArrayList<Integer> diceRoll = new ArrayList<Integer>();
		for (int n = 0; n < numOfDice; n++) {
			int num = rand.nextInt(6) + 1;
			diceRoll.add(num);
		}
		Collections.sort(diceRoll, Collections.reverseOrder());
		return diceRoll;
	}
}
