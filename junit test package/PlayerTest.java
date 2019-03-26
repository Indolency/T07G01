import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest{

    @Test
    public void test_creation_human(){
        Board b = new Board();
        Player p = new HumanPlayer("Danny Devito", b);
        assertEquals("Expected Player name Danny Devito", "Danny Devito", p.getPlayerName());
        assertEquals("Expected Board", b, p.getBoard());
    }

    @Test
    public void test_creation_AI(){
        Board b = new Board();
        Player p = new HumanPlayer("Shrek", b);
        assertEquals("Expected Player name Shrek", "Shrek", p.getPlayerName());
        assertEquals("Expected Board", b, p.getBoard());
    }

    @Test
    public void test_setCountriesOwned(){
        Country c = new Country("Swamp");
        Board b = new Board();
        ArrayList<Country> cs = new ArrayList<Country>();
        cs.add(c);
        b.setCountriesList(cs);
        Player p = new AIPlayer("Shrek", b);
        c.setPlayerPossession(p);
        p.setCountriesOwned(cs);
        assertEquals("Expected Country to be owned by Shrek", cs, p.getCountriesOwned());
    }

    @Test
    public void draftNum(){
        Country c = new Country("Swamp");
        Board b = new Board();
        ArrayList<Country> cs = new ArrayList<Country>();
        cs.add(c);
        b.setCountriesList(cs);
        Player p = new AIPlayer("Shrek", b);
        c.setPlayerPossession(p);
        p.setCountriesOwned(cs);
        assertEquals("Expected number of troops to draft to be 3", 3, p.draftNum());
    }





}
