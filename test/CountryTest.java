package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import logic.AIPlayer;
import logic.Board;
import logic.Country;
import org.junit.Test;

public class CountryTest{
    String filename = "Country.java";

    @Test
    public void test_creation(){
        Country c = new Country("AD");
        assertEquals("Expected country Name to be AD", "AD", c.getCountryName());
    }

    @Test
    public void test_creation_with_continent(){
        Country c = new Country("AD",0);
        assertEquals("Expected country Name to be AD", "AD", c.getCountryName());
        assertEquals("Expected continent Number to be 0", 0, c.getContinent(), 0.00001);
    }

    @Test
    public void test_creation_default() {
        Country c = new Country();
        assertEquals("Expected country Name to be null", null, c.getCountryName());
    }

    @Test
    public void test_setNumOfTroops() {
        Country c = new Country();
        c.setNumOfTroops(5);
        assertEquals("Expected Number of Troops in the country to be 5.", 5, c.getNumOfTroops(), 0.000001);
    }

    @Test
    public void test_setNumOfTroops_negativeNumber() {
        Country c = new Country();
        c.setNumOfTroops(-2);
        assertEquals("Expected Number of Troops in the country to be 0", 0, c.getNumOfTroops(), 0.000001);
    }

    @Test
    public void test_setPlayerPossession(){
        Country c = new Country();
        Board b = new Board();
        AIPlayer p = new AIPlayer("Shrek",b);
        c.setPlayerPossession(p);
        assertEquals("Expected Player Shrek", p, c.getPlayerPossession());
    }

    @Test
    public void test_setAdjacentCountries(){
        Country c = new Country("Swamp");
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(c);
        c.setAdjacentCountries(countries);
        assertEquals("Expected Adjacent Country Swamp", countries, c.getAdjacentCountries());
    }

    @Test
    public void test_setContinent(){
        Country c = new Country("Swamp");
        c.setContinent(0);
        assertEquals("Expected Continent 0", 0, c.getContinent());
    }

    @Test
    public void test_setContinent_negativeNumber(){
        Country c = new Country("Swamp");
        c.setContinent(-1);
        assertEquals("Expected Continent 0", 0, c.getContinent());
    }

    @Test
    public void test_isEmpty_false(){
        Country c = new Country("Swamp");
        c.setNumOfTroops(2);
        assertEquals("Expected isEmpty to return false", false, c.isEmpty());
    }

    @Test
    public void test_isEmpty_true(){
        Country c = new Country("Swamp");
        assertEquals("Expected isEmpty to return true", true, c.isEmpty());
    }

    @Test
    public void addTroops(){
        Country c = new Country("Swamp");
        c.addTroops(9);
        assertEquals("Expected Number of troops 9", 9, c.getNumOfTroops());
    }

    @Test
    public void addTroops_negative(){
        Country c = new Country("Swamp");
        c.setNumOfTroops(8);
        c.addTroops(-6);
        assertEquals("Expected Number of troops 8", 8, c.getNumOfTroops());
    }

    @Test
    public void removeTroops_negative(){
        Country c = new Country("Swamp");
        c.setNumOfTroops(8);
        c.removeTroops(-6);
        assertEquals("Expected Number of troops 8", 8, c.getNumOfTroops());
    }

    @Test
    public void removeTroops_insufficient(){
        Country c = new Country("Swamp");
        c.setNumOfTroops(8);
        c.removeTroops(9);
        assertEquals("Expected Number of troops 8", 8, c.getNumOfTroops());
    }

    @Test
    public void removeTroops(){
        Country c = new Country("Swamp");
        c.setNumOfTroops(8);
        c.removeTroops(5);
        assertEquals("Expected Number of troops 3", 3, c.getNumOfTroops());
    }
}