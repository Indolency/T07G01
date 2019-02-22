import java.util.ArrayList;
import java.util.Random;

/**
 * This Turn class is part of the Risk game that will look at the input from the
 * player and allow them to draft, attack, or fortify during their turn.
 *
 * @author Sophia Ngo
 * @version 1.0
 * @since 2019-02-21
 */
public class Turn {

    //when country is given in parameter does it directly reference country on the board?

    // Total number of troops used to set
    private int totalTroops;
    // List of countries that the current player possesses
    private ArrayList<Country> listOfPossessions = new ArrayList<Country>();


    /**
     * This method allows the players to choose countries to place their troops
     * at the beginning of their turn.
     * @param countryToDraft is the player's choice of country to place troops in.
     * @param numOfTroops is the amount of troops the player wants to draft.
     * @param currentPlayer is whose turn it is.
     */
    public static void draft(Country countryToDraft, int numOfTroops, int currentPlayer) {
        System.out.println("--DRAFTING PHASE--");

        // number of troops a player has gained from countries they own
        int numOfTroopsGained = getNumOfTroopsGained();
        // list of the countries that the player currently owns
        ArrayList<Country> listOfPlayerCountries = new ArrayList<Country>();

        /*
        // number of inside a country in total
        while (numOfTroopsGained != 0) {
            totalTroops = 0;
            // show player the number of troops
            System.out.println("You currently have" + numOfTroopsGained + "remaining.");
            // show player the countries and troops currently inside
            System.out.println("Countries currently conquered: ")
            for (country : listOfPlayerCountries) {
                System.out.println(country);
            }
            // ask player how many troops they want to place in that country
        }
        NOTE: This might make sense in another class, this should happen before
        this method is called.
        */

        // check if the country given is one that is owned by the player
        if (countryToDraft.getPossession() == currentPlayer) {
            // place the number of troops into that country
            totalTroops = countryToDraft.getNumOfTroops() + numOfTroops;
            countryToDraft.setNumOfTroops(totalTroops);
            // take off the number of troops they placed
            numOfTroopsGained -= playerNum;
        } else {
            System.out.println("Country is not conquered!");
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
     * @param board is the main board that the game is played on.
     * @param countryToAttack is the country that the player wants to attack.
     * @param playerDice is what the player rolled.
     * @param opponentDice is what the opponent rolled.
     * @param numOfTroops is the number of troops the player wants to move if won.
     * @param currentPlayer is whose turn it is.
     */
    public static void attack(Board board, Country countryAttackFrom, Country countryToAttack,
    int playerDice, int opponentDice, int numOfTroops, int currentPlayer)
    {
        System.out.println("--ATTACKING PHASE--");

        ArrayList<Country> listOfAdjacent = new ArrayList<Country>();

        // NOTE: I think the while loop should be outside of the attack method
        // It should loop attack until player wants to end

        /*
        // check if they can still attack from country
        if (numCountriesAvailable != 0) {
            // gets a list of the current countries available to attack
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
            System.out.println("Countries that you can attack: ")
            // show countries to attack and number of troops in each
            for (Country country : listOfAdjacent) {
                System.out.println(country.getCountryName() + ": " + country.getNumOfTroops());
            }
            // or end attack phase
        }
            */

        totalTroops = 0;
        // check if amount of troops is valid
        // if the highest dice rolls are from player, -1 troops or take country
        if (playerDice > opponentDice) {
            // if the troops in attacked country is 1, the country is conquered
            totalTroops += countryToAttack.getNumOfTroops();
            if (totalTroops == 1) {
                totalTroops += numOfTroops;
                countryToAttack.setNumOfTroops(totalTroops);
                countryToAttack.setPossession(currentPlayer);
            } else {
                totalTroops--;
                countryToAttack.setNumOfTroops(totalTroops);
            }
        //the highest dice rolls are from opponent
        } else if (playerDice < opponentDice){
            totalTroops += countryAttackFrom.getNumOfTroops();
            // player will lose 1 troop
            totalTroops--;
            // find which country that the attack was from
            // add to a list of countries that attacked from already
        }
    }


    /**
     * The player will choose a country to move troops from, into an adjacent
     * country of their choice, making sure that both countries are owned by
     * the current player.
     * @param countryTroopsFrom is country chosen to take troops from.
     * @param countryToFortify is country chosen to fortify troops.
     * @param numOfTroops is amount of troops the player wants to move.
     * @param currentPlayer is whose turn it is.
     */
    public static void fortify(Country countryFortifyFrom Country countryToFortify,
    int numOfTroops, int currentPlayer)
    {
        System.out.println("--FORTIFY PHASE--");

        totalTroops = 0;
        /*
        // show countries the player has owned
        System.out.println("Countries currently conquered: ")
        for (country : listOfPlayerCountries) {
            System.out.println(country);
        // player will choose a country
        // show countries adjacent to one picked
        board.getAdjacentCountries(playerCountry);
        NOTE: I think this would also make sense elsewhere, should happen before
        this method is called.
        */
        // make sure country is one that they own
        if (countryFortifyFrom.getPossession() == currentPlayer
        && countryToFortify.getPossession() == currentPlayer)
        {
            // take off troops from country
            totalTroops = countryFortifyFrom.getNumOfTroops() - numOfTroops;
            countryFortifyFrom.setNumOfTroops(totalTroops);
            // add troops into new country
            totalTroops = 0
            totalTroops = countryToFortify.getNumOfTroops() + numOfTroops;
            countryToFortify.setNumOfTroops(totalTroops);
        } else {
            System.out.println("Choose a country you have conquered!")
        }

    }

}
