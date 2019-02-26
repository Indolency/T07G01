import java.util.Random;

/**
 * This Dice class outputs a random number out of six for each
 * die and will eventually keep track of all five die.
 *
 * @author Nicole Langevin
 * @version 1.0
 * @since 2019-02-21
 */

public class Dice{
	
	public static int diceRoll(){
		Random rand = new Random();
		int num = rand.nextInt(6) + 1;
		return num;
	}
	
}
