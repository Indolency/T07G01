import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import java.util.ArrayList;

public class DiceTest
{
    // Checks if number of dice is added properly
    @Test
    public void test_rollDice_correctNumOfDice() {
        Dice d = new Dice();
        assertEquals("There should be 3 dice in the array list.", 3, d.rollDice(3).size());
    }

    // Checks if the list is sorted in descending order
    @Test
    public void test_rollDice_descendingOrder() {
        Dice d = new Dice();
         ArrayList<Integer> dice = d.rollDice(3);
        assertTrue("List should be sorted in descending order.", dice.get(0) > dice.get(2));
    }
}
