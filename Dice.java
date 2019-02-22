import java.util.Random;

public class Dice{
	
	public static int diceRoll(){
		Random rand = new Random();
		int num = rand.nextInt(6) + 1;
		return num;
	}
	
}