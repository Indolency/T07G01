import java.util.Random;
import java.util.Scanner;

/**
 * This Turn class is part of the Risk game that will look at the input from the
 * player and allow them to draft, attack, or fortify during their turn.
 *
 * @author Sophia Ngo
 * @version 1.0
 * @since 2019-02-20
 */
public class Turn {

    /**
     * This method allows the players to choose continents to place their troops
     * at the beginning of their turn.
     * @param numOfTroops
     */
    public void draft(int numOfTroops) {
        // while num of troops is not 0
            // show player the number of troops
            // show player the continents and troops currently inside (using a key)
            // ask player how many troops they want to place in that continent
            // place the number of troops into that continent
            // take off the number of troops they placed
    }

    /**
     * The player will choose a continent to attack from, then choose an adjacent
     * continent to attack. The player will choose how many dice they want to roll
     * depending on the number of troops they want to use in the attack. (Up to 3)
     *
     *     If the dice roll is won, the player will get to choose how many troops
     *     to move into the continent that was just attacked, the minimum being
     *     the amount of dice they chose to roll.
     *
     *     If the dice roll is lost, the player will lose the amount of troops
     *     from the number of dice.
     *
     * This will be repeated until the player is done, or there are no more
     * continents they can attack from.
     */
    public void attack() {
        // while player does not want to end or until no more to attack from
        // show player which continents they can attack from
        // or end attack phase
        // show continents adjacent to the one chosen number of troops in each
        // the player will choose how many dice to roll (troops to attack)
            // the max is 3, must have enough troops matching dice
        // player will be prompted to roll their dice

        // opponent will also roll dice depending on their troops (up to 2)

        // the highest dice rolls will be compared

        // if the highest dice rolls are from player
            // player will choose the amount of armies -1 and min from dice

        // else the highest dice rolls are from opponent
            // player will lose the amount of armies from the dice lost

    }

    /**
     * The player will choose a continent to move troops from, into an adjacent
     * continent of their choice. Then the turn will end.
     */
    public void fortify() {
        // show continents the player has owned, player will choose
        // show continents adjacent to one picked
        // choose amount of troops to move into new continent
        // end

    }

}
