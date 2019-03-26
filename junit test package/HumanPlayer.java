import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This HumanPlayer class is a subclass that extends Player.
 * It contains the state of each player. Specifically, the player's
 * name, reference to the Main's Board, and an ArrayList<Country> of all the
 * countries the player possesses.
 * @version 4.0
 * @author TO7GO7
 * @since 2019-03-02
 */

public class HumanPlayer extends Player{

    /**
     * Constructs an object of class HumanPlayer given the specified name with reference
     * to the Main's board.
     */
    public HumanPlayer(String name, Board board){
        super(name, board);
    }

    /**
     * This is the human's specific drafting mechanism. It overrides the parent class's
     * method because it is different from the AI's specific drafting method.
     * It asks input from the user for a country it would like to draft each troop into
     * and update the Main's board.
     */
    @Override
    public void draft() {
        String countryName = getCountryClicked();
        for (Country country : countriesOwned) {
            if (countryName.equalsIgnoreCase(country.getCountryName())) {
                country.addTroops(getDraftNum());
                 setDraftNumLeft(getDraftNumLeft()-getDraftNum());
            }
        }
    }

    /**
     * This is the human's specific attacking mechanism. It overrides the parent class's
     * method because it is different from the AI's specific drafting method.
     * It asks input from the user for a country it would like to attack and from Which
     * country it would like to attack.
     */
    @Override
    public void attack(){
        Country countryFrom = new Country();
        Country countryTo = new Country();
        // converts the string input from the user to the corresponding countries
        for (Country c: getBoard().getCountriesList()){
            if (getCountryClicked().equalsIgnoreCase(c.getCountryName())){
                countryFrom = c;
            }
            else if (getNextCountryClicked().equalsIgnoreCase(c.getCountryName())){
                countryTo = c;
            }
        }

        // gives the appropriate number of dice to be rolled by the attacker and defender
        ArrayList<Integer> diceList = numOfDice(countryFrom.getNumOfTroops()-1, countryTo.getNumOfTroops());

        Dice diceAttacker = new Dice();      // creates the dice that will be used by the attacker
        Dice diceDefender = new Dice();      // creates the dice that will be used by the defender

        ArrayList<Integer> attack = diceAttacker.rollDice(diceList.get(0));     // stores the dice rolls by the attacker
        ArrayList<Integer> defend = diceDefender.rollDice(diceList.get(1));     // stores the dice rolls by the defender

        setAttackerRoll(attack);
        setDefenderRoll(defend);

        ArrayList<Integer> results = compareRolls(attack, defend);      // stores the number of troops lost by attacker and defender
        setComparisonRoll(results);

        if (results.get(1) == -1 && countryTo.getNumOfTroops() == 1) {     // this checks if the defending country has been conquered
            countryTo.getPlayerPossession().removeCountry(countryTo);
            countryTo.setNumOfTroops(countryFrom.getNumOfTroops() - 1);
            countryTo.setPlayerPossession(this);
            countryFrom.setNumOfTroops(1);
            this.addCountry(countryTo);
        }
        if (results.get(1) == -2 && countryTo.getNumOfTroops() == 2){     // this checks if the defending country has been conquered
            countryTo.getPlayerPossession().removeCountry(countryTo);
            countryTo.setNumOfTroops(countryFrom.getNumOfTroops()-1);
            countryTo.setPlayerPossession(this);
            countryFrom.setNumOfTroops(1);
            this.addCountry(countryTo);
        }
        else {
            countryFrom.addTroops(results.get(0));
            countryTo.addTroops(results.get(1));
        }
    }

    /**
     * Returns an ArrayList of integers that represent the number of troops lost by each
     * player. The ArrayList has 2 digits where the first represents the attacking country's
     * troops lost and the second represents the defending country's troops lost.
     * @param attack ArrayList of integers that represent the attacker's rolls sorted by decreasing order
     * @param defend ArrayList of integers that represent the defender's rolls sorted by decreasing order
     * @return result is an ArrayList of integers that represent the number of troops lost by each player
     */
    protected ArrayList<Integer> compareRolls(ArrayList<Integer> attack, ArrayList<Integer> defend){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int a = attack.size();
        int d = defend.size();

        // this is when there are 2 dice each being compared
        if ((d == 2)){
            int from = 0;
            int to = 0;
            for (int i=0; i<2; i++) {
                if (attack.get(i) <= defend.get(i)) {
                    from--;
                } else {
                    to--;
                }
            }
            result.add(from);
            result.add(to);

        }

        // this is when there is only 1 die each being compared
        else if (a > d && d == 1){ //1,1
            if (attack.get(0) <= defend.get(0)){
                result.add(-1);
                result.add(0);
            }
            else{
                result.add(0);
                result.add(-1);
            }
        }
        return result;
    }

    /**
     * This methods returns an ArrayList of integers, where the first integer is the number of dice for the attacking
     * player and the second integer is the number of dice for the defending player. The number of dice is determined
     * by the number of troops of each country.
     * @param a is an integer that represents the number of troops of the attacking country that are able to attack.
     * @param d is an integer that represents the number of troops of the defending country.
     * @return list is an ArrayList of integers
     */
    protected ArrayList<Integer> numOfDice(int a, int d){
        ArrayList<Integer> list = new ArrayList<Integer>();

        // these conditions are all the number of troops attacker (a) and defender (d) has
        if ((a >= 3 && d >= 2) && (d <= a)) {
            list.add(3);
            list.add(2);
        }
        else if (d < a && a == 2) {
            list.add(2);
            list.add(1);
        }
        else if (a<d && a ==2){
            list.add(2);
            list.add(2);
        }
        else if (a==d && a==2){
            list.add(2);
            list.add(2);
        } else if (a >= 3 && d < 2) {
            list.add(3);
            list.add(1);
        }
        return list;
    }

    /**
     * Returns true if the chosen country is an allowable country to draft to
     * @param countryName is the label the user has chosen from the board
     * @return valid which is a boolean that is true if valid
     */
    public boolean checkDraftValid(String countryName){
        boolean valid = true;
        for (Country c: getCountriesOwned()){
            if (countryName.equalsIgnoreCase(c.getCountryName())){
                valid = true;
                break;
            }
            else{
                valid = false;
            }
        }
        return valid;
    }

    /**
     * Returns true if the chosen country is an allowable country to attack from
     * @param countryName is the label the user has chosen from the board
     * @return valid which is a boolean that is true if valid
     */
    public boolean checkValidAttackFrom(String countryName){
        boolean valid;
        // converts countryName from a string to the corresponding Country
        Country country = getBoard().countryNameToCountry(countryName);
        /*
        for (Country c: getCountriesOwned()) {
            if (countryName.equalsIgnoreCase(c.getCountryName())) {
                country = c;
            }
        }*/
        // obtains the list of valid countries to attack from
        ArrayList<Country> list = validCountries("attack");
        // determines if the chosen country is valid or not by seeing if the the valid countries list contains country
        if (list.contains(country)){
            valid = true;
        }
        else{
            valid = false;
        }
        return valid;
    }

    /**
     * This methods checks if the country that the user wants to attack is a valid
     * country (ie. it is adjacent). This is done by taking two String parameters, where the first one is
     * the valid country to attack from and the second country String the country the user
     * has chose to attack.
     * @param countryFrom String of country to attack from
     * @param countryTo String of coutnry to attack
     * @return valid is true if the countryTo is adjacent and is owned by the opponent and false otherwise.
     */
    public boolean checkValidAttackTo(String countryFrom, String countryTo) {
        boolean valid;
        Country fromCountry = new Country();
        Country toCountry = new Country();
        // converts the given countryFrom and countryTo String to a country in the board
        for (Country c: getBoard().getCountriesList()){
            if (countryFrom.equalsIgnoreCase(c.getCountryName())){
                fromCountry = c;
            }
            else if (countryTo.equalsIgnoreCase(c.getCountryName())){
                toCountry = c;
            }
        }
        // loads the valid adjacent countries surrounding the user's chose country
        ArrayList<Country> list = validAdjacentCountries(fromCountry, "attack");
        if (list.contains(toCountry)) {
            valid = true;
        }
        else {
            valid = false;
        }
        return valid;
    }

    @Override
    public boolean checkValidFortifyTo(String countryFrom, String countryTo) {
        boolean valid;
        Country fromCountry = new Country();
        Country toCountry = new Country();
        // converts the given countryFrom and countryTo String to a country in the board
        for (Country c: getBoard().getCountriesList()){
            if (countryFrom.equalsIgnoreCase(c.getCountryName())){
                fromCountry = c;
            }
            else if (countryTo.equalsIgnoreCase(c.getCountryName())){
                toCountry = c;
            }
        }
        // loads the valid adjacent countries surrounding the user's chose country
        ArrayList<Country> list = validAdjacentCountries(fromCountry, "fortify");
        if (list.contains(toCountry)) {
            valid = true;
        }
        else {
            valid = false;
        }
        return valid;
    }

    @Override
    public boolean checkValidFortifyFrom(String countryName) {
        boolean valid;
        // converts countryName from a string to the corresponding Country
        Country country = getBoard().countryNameToCountry(countryName);
        /*
        for (Country c: getCountriesOwned()) {
            if (countryName.equalsIgnoreCase(c.getCountryName())) {
                country = c;
            }
        }*/
        // obtains the list of valid countries to attack from
        ArrayList<Country> list = validCountries("fortify");
        // determines if the chosen country is valid or not by seeing if the the valid countries list contains country
        if (list.contains(country)){
            valid = true;
        }
        else{
            valid = false;
        }
        return valid;
    }


    /**
     * Returns the countries that are valid choices corresponding to the current phase the user is in
     * @param phase String that determines the phase which the user is currently in
     * @return valid which is an ArrayList of Country
     */
    protected ArrayList<Country> validCountries(String phase) {
        ArrayList<Country> validTroops = new ArrayList<Country>();
        ArrayList<Country> valid = new ArrayList<Country>();
        for (Country country : countriesOwned) {
            if (country.getNumOfTroops() >= 2){
                validTroops.add(country);
            }
        }
        // Creates attack valid countries ArrayList
        if (phase.equalsIgnoreCase("attack")){
            for (Country country: validTroops){
                for (Country adjacent: country.getAdjacentCountries()){
                    if (country.getPlayerPossession() != adjacent.getPlayerPossession() && (valid.contains(country) == false)){
                        valid.add(country);
                    }
                }
            }
        }
        // Create fortify valid countries ArrayList
        if (phase.equalsIgnoreCase("fortify")){
            for (Country country: validTroops){
                for (Country adjacent: country.getAdjacentCountries()){
                    if (country.getPlayerPossession() == adjacent.getPlayerPossession() && (valid.contains(country) == false)){
                        valid.add(country);
                    }
                }
            }
        }
        return valid;
    }

    /*@Override
    public boolean checkValidFortifyTo(String countryName){
        Country country = getBoard().countryNameToCountry(countryName);
        return true;
    }*/

    /**
     * Returns an ArrayList of countries that represents the valid countries that are valid
     * according to the phase (attack or fortify)
     * @param country Country that represent which country the user selects
     * @param phase String that represents the current user's game phase
     * @return ArrayList<Country> that are the valid countries
     */
    protected ArrayList<Country> validAdjacentCountries(Country country, String phase){
        ArrayList<Country> valid = new ArrayList<Country>();
        // if the phase is attack, then the valid list will be constructed using these requirements
        if (phase.equalsIgnoreCase("attack")){
            for (Country adjacent: country.getAdjacentCountries()){
                if(adjacent.getPlayerPossession() != country.getPlayerPossession() && (valid.contains(adjacent)) == false){
                    valid.add(adjacent);
                }
            }
        }
        // if the phase is fortify, then the valid list will be constructed using this instead
        if (phase.equalsIgnoreCase("fortify")){
            for (Country adjacent: country.getAdjacentCountries()){
                if(adjacent.getPlayerPossession() == country.getPlayerPossession() && (valid.contains(adjacent)) == false){
                    valid.add(adjacent);
                }
            }
        }
        return valid;
    }

    /**
     * This will take the player's input and loops through to check if their answer is valid.
     * @return numDice the amount of dice the player wants to roll.
     */
    protected int validDiceRoll(Country userCountry) {
        boolean invalid = true;
        int numDice = 0;
        while (invalid) {
            System.out.println("--Enter a valid number of dice to roll: ");
            Scanner diceInput = new Scanner(System.in);
            numDice = diceInput.nextInt();
            if (userCountry.getNumOfTroops() > 3 && (numDice == 3 || numDice == 2 || numDice == 1))
                invalid = false;
                // User has 3 troops, can roll 2, 1 dice
            else if (userCountry.getNumOfTroops() == 3 && (numDice == 2 || numDice == 1))
                invalid = false;
                // User has 2 troops, can roll single die
            else if (userCountry.getNumOfTroops() == 2 && numDice == 1)
                invalid = false;
        }
        return numDice;
    }

    /**
     * This is the human's specific fortifying mechanism. It overrides the parent class's
     * method because it is different from the AI's specific fortifying method.
     * It asks input from the user for a country it would like to fortify and from Which
     * country it would like to fortify from..
     */
    @Override
    public void fortify(int num){
        Country countryFrom = new Country();
        Country countryTo = new Country();
        // converts the string input from the user to the corresponding countries
        for (Country c: getBoard().getCountriesList()){
            if (getCountryClicked().equalsIgnoreCase(c.getCountryName())){
                countryFrom = c;
            }
            else if (getNextCountryClicked().equalsIgnoreCase(c.getCountryName())){
                countryTo = c;
            }
        }

        countryFrom.removeTroops(num);
        countryTo.addTroops(num);

        /*******************************DELETE******************************************************
        System.out.println("-----FORTIFY-----");
        System.out.println("--Would you like to fortify? Type 'yes' or 'no'--");
        boolean invalidFrom = true;
        boolean invalidTo = true;
        boolean invalidTroops = true;
        Scanner input = new Scanner(System.in);
        String response = input.next();

        if (response.equalsIgnoreCase("Yes")) {
            ArrayList<Country> valid = validCountries("Fortify");
            Country countryFrom = new Country();
            if (valid.size() == 0){
                System.out.println("You are unable fortify because there are no valid moves available!");
                invalidFrom = false;
                invalidTo = false;
                invalidTroops = false;
            }

            while (invalidFrom) {
                System.out.println("--Please enter a valid country to fortify from: ");
                Scanner validCountryFrom = new Scanner(System.in);
                String answer = validCountryFrom.nextLine();

                for (Country country: getBoard().getCountriesList()){
                    if(answer.equalsIgnoreCase(country.getCountryName())){
                        countryFrom = country;
                        if (valid.contains(countryFrom) == true){
                            invalidFrom = false;
                        }
                    }
                }
            }

            valid = validAdjacentCountries(countryFrom, "Fortify");
            Country countryTo = new Country();
            while (invalidTo) {
                System.out.println("--Please enter a valid country to fortify: ");
                Scanner ans = new Scanner(System.in);
                String answer = ans.nextLine();

                for (Country country: getBoard().getCountriesList()){
                    if(answer.equalsIgnoreCase(country.getCountryName())){
                        countryTo = country;
                        if (valid.contains(countryTo) == true){
                            invalidTo = false;
                        }
                    }
                }
            }

            while (invalidTroops) {
                System.out.println("--Please enter a valid enter of troops to move: ");
                Scanner ans = new Scanner(System.in);
                int answer = ans.nextInt();
                int max = countryFrom.getNumOfTroops() - 1;
                int min = 1;
                if (answer >= min && answer <= max){
                    countryFrom.removeTroops(answer);
                    countryTo.addTroops(answer);
                    invalidTroops = false;
                }
            }
        }****************************************************************************/
    }
}
