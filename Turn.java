import java.util.ArrayList;
import java.util.Random;

/**
 * This Turn class is part of the Risk game that will look at the input from the
 * player and allow them to draft, attack, or fortify during their turn.
 *
 * @author Sophia Ngo
 * @version 1.0
 * @since 2019-02-20
 */
public class Turn {

    // Checks whose turn it is currently
    private int currentPlayer = getCurrentPlayer();
    // The number of troops a player has gained from countries they own
    private int numOfTroopsGained = getNumOfTroopsGained();
    // Player input of any number
    private int playerNum;
    // Player country selection
    private Country playerCountry = getPlayerCountry();
    // Total number of troops used to set
    private int totalTroops;
    // Decides if player wants to end attack turn or not
    private boolean playerEnd;
    // List of countries that the current player possesses
    private ArrayList<Country> listOfPossessions = new ArrayList<Country>();
    private ArrayList<Country> listOfAdjacent = new ArrayList<Country>();
    private Board board;

    /**
     * This method allows the players to choose countries to place their troops
     * at the beginning of their turn.
     * @param numOfTroopsGained
     */
    public void draft(int numOfTroopsGained) {
        System.out.println("--DRAFTING PHASE--");

        playerNum = getPlayerNum();
        // number of inside a country in total
        while (numOfTroopsGained != 0) {
            totalTroops = 0;
            // show player the number of troops
            System.out.println("You currently have" + numOfTroopsGained + "remaining.");
            // show player the countries and troops currently inside (using a key)
            System.out.println("counties that player owns");
            // ask player how many troops they want to place in that country
            // place the number of troops into that country
            totalTroops = Country(playerCountry).getNumOfTroops() + playerNum;
            playerCountry.setNumOfTroops(totalTroops);
            // take off the number of troops they placed
            numOfTroopsGained -= playerNum;
        }
    }

    /**
     * The player will choose a country to attack from, then choose an adjacent
     * country to attack. The player will choose how many dice they want to roll
     * depending on the number of troops they want to use in the attack. (Up to 3)
     *
     *     If the dice roll is won, the player will get to choose how many troops
     *     to move into the country that was just attacked, the minimum being
     *     the amount of dice they chose to roll.
     *
     *     If the dice roll is lost, the player will lose the amount of troops
     *     from the number of dice.
     *
     * This will be repeated until the player is done, or there are no more
     * countries they can attack from.
     */
    public void attack() {
        System.out.println("--ATTACKING PHASE--");

        playerEnd = true;
        // while player does not want to end or until no more to attack from
        do {
            // gets a list of the current countries available to attack
            listOfAdjacent.clear();
            ArrayList<Country> currentAdjacent = new ArrayList<Country>();
            listOfPossessions.add(getPlayerCountries(currentPlayer));
            // for each country possessed, get adjacent countries, add into list
            for (Country country : listOfPossessions) {
                currentAdjacent.add(getAdjacentCountries(country));
                for (Country adjacent : currentAdjacent) {
                    // make sure no duplicates
                    if (!listOfAdjacent.contains(adjacent))
                    listOfAdjacent.add(adjacent);
                }
            }

            int numCountriesAvailable = listOfAdjacent.size();
            totalTroops = 0;
            // show countries to attack and number of troops in each
            for (Country country : listOfAdjacent) {
                System.out.println(country.getCountryName() + ": " + country.getNumOfTroops());
            }
            // or end attack phase

            // player will be prompted to roll a die
            // opponent will also roll a die
            // current player's dice
            int dice1;
            // opponent's dice
            int dice2;
            // the highest dice rolls will be compared
            // if the highest dice rolls are from player
            if (dice1 > dice2) {
                // player will choose the amount of armies -1
                totalTroops += playerCountry.getNumOfTroops();
                if (totalTroops == 1) {
                    playerNum = getPlayerNum();
                    totalTroops += playerNum;
                    playerCountry.setNumOfTroops(totalTroops);
                    playerCountry.setPossession(currentPlayer);
                } else {
                    totalTroops--;
                    playerCountry.setNumOfTroops(totalTroops);
                }
            //the highest dice rolls are from opponent
            } else if (dice1 < dice2){
                // player will lose 1 troop
                // find which country that the attack was from
            playerEnd = getPlayerEnd();
            }

        } while (playerEnd && numCountriesAvailable != 0);
    }

    /**
     * The player will choose a country to move troops from, into an adjacent
     * country of their choice. Then the turn will end.
     */
    public void fortify() {
        System.out.println("--FORTIFY PHASE--");

        totalTroops = 0;
        playerNum = getPlayerNum();
        // show countries the player has owned
        System.out.println("countries that player owns");
        // player will choose a country
        // show countries adjacent to one picked
        board.getAdjacentCountries(playerCountry);
        // choose amount of troops to move into new country
        totalTroops = Country(playerCountry).getNumOfTroops + playerNum;
        // end

    }

}
