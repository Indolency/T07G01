package test;


import static org.junit.Assert.*;

import java.util.ArrayList;

import logic.AIPlayer;
import logic.Board;
import logic.Country;
import logic.HumanPlayer;
import org.junit.Test;

public class BoardTest{
    String filename = "Board.java";

    @Test
    public void test_creation(){
        Board b = new Board();
        assertEquals("Expected 41 countries to be made", 41, b.getCountriesList().size());
    }

    @Test
    public void test_setCountriesList(){
        Board b = new Board();
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(new Country("Far Far Away"));
        b.setCountriesList(countries);
        assertEquals("Expected country list to be set", countries, b.getCountriesList());
    }

    @Test
    public void test_checkWinner_true(){
        Board b = new Board();
        ArrayList<Country> countries = new ArrayList<Country>();
        Country c = new Country("Far Far Away");
        AIPlayer p = new AIPlayer("Shrek",b);
        c.setPlayerPossession(p);
        countries.add(c);
        b.setCountriesList(countries);
        assertEquals("Expected win", true, b.checkWinner());
    }

    @Test
    public void test_checkWinner_false(){
        Board b = new Board();
        ArrayList<Country> countries = new ArrayList<Country>();
        Country c = new Country("Far Far Away");
        Country c1 = new Country("Swamp");
        Country c2 = new Country("Olympus Coliseum");
        AIPlayer p = new AIPlayer("Shrek",b);
        HumanPlayer p1 = new HumanPlayer("Danny Devito",b);
        c.setPlayerPossession(p);
        c1.setPlayerPossession(p);
        c2.setPlayerPossession(p1);
        countries.add(c);
        countries.add(c1);
        countries.add(c2);
        b.setCountriesList(countries);
        assertEquals("Expected loss", false, b.checkWinner());
    }

    @Test
    public void test_adjacentCountries_CCIT(){
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("CCIT");
        assertEquals("2 Countries adjacent to CCIT", 2, b.adjacentCountries("CCIT").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "END");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "ENF");
    }

    @Test
    public void test_adjacentCountries_ENA(){
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("ENA");
        assertEquals("4 Countries adjacent to ENA", 4, b.adjacentCountries("ENA").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "ENB");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "ENC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "SSE");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "ICT");
    }

    @Test
    public void test_adjacentCountries_ENB() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("ENB");
        assertEquals("3 Countries adjacent to ENA", 3, b.adjacentCountries("ENB").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "ENA");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "ENC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "EEEL");
    }

    @Test
    public void test_adjacentCountries_ENC() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("ENC");
        assertEquals("5 Countries adjacent to ENC", 5, b.adjacentCountries("ENC").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "ENA");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "ENB");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "END");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "ENF");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(4).getCountryName() == "SSE");
    }

    @Test
    public void test_adjacentCountries_END() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("END");
        assertEquals("4 Countries adjacent to END", 4, b.adjacentCountries("END").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "CCIT");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "ENC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "ENF");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "SSE");
    }

    @Test
    public void test_adjacentCountries_ENF() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("ENF");
        assertEquals("3 Countries adjacent to ENF", 3, b.adjacentCountries("ENF").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "ENC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "END");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "SSE");
    }

    @Test
    public void test_adjacentCountries_SSE() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("SSE");
        assertEquals("5 Countries adjacent to SSE", 5, b.adjacentCountries("SSE").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "ENA");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "ENC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "END");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "ENF");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(4).getCountryName() == "TI");
    }

    @Test
    public void test_adjacentCountries_TI() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("TI");
        assertEquals("5 Countries adjacent to TI", 5, b.adjacentCountries("TI").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "ENF");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "SSE");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "SB");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "MSC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(4).getCountryName() == "MACHALL");
    }

    @Test
    public void test_adjacentCountries_EEEL() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("EEEL");
        assertEquals("3 Countries adjacent to EEEL", 3, b.adjacentCountries("EEEL").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "ENB");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "ICT");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "ES");
    }

    @Test
    public void test_adjacentCountries_ICT() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("ICT");
        assertEquals("3 Countries adjacent to ICT", 3, b.adjacentCountries("ICT").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "ENA");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "EEEL");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "ES");
    }

    @Test
    public void test_adjacentCountries_ES() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("ES");
        assertEquals("5 Countries adjacent to ES", 5, b.adjacentCountries("ES").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "EEEL");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "ICT");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "SB");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "TR");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(4).getCountryName() == "MS");
    }

    @Test
    public void test_adjacentCountries_SA() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("SA");
        assertEquals("4 Countries adjacent to SA", 4, b.adjacentCountries("SA").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "SB");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "ST");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "SS");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "AD");
    }

    @Test
    public void test_adjacentCountries_SB() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("SB");
        assertEquals("4 Countries adjacent to SB", 4, b.adjacentCountries("SB").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "TI");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "ES");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "SA");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "MACHALL");
    }

    @Test
    public void test_adjacentCountries_TR() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("TR");
        assertEquals("2 Countries adjacent to TR", 2, b.adjacentCountries("TR").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "ES");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "MS");
    }

    @Test
    public void test_adjacentCountries_MS() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("MS");
        assertEquals("3 Countries adjacent to MS", 3, b.adjacentCountries("MS").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "ES");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "TR");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "ST");
    }

    @Test
    public void test_adjacentCountries_ST() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("ST");
        assertEquals("4 Countries adjacent to ST", 4, b.adjacentCountries("ST").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "SA");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "MS");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "SS");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "BS");
    }

    @Test
    public void test_adjacentCountries_SS() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("SS");
        assertEquals("3 Countries adjacent to SS", 3, b.adjacentCountries("SS").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "SA");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "ST");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "AD");
    }

    @Test
    public void test_adjacentCountries_BS() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("BS");
        assertEquals("1 Country adjacent to BS", 1, b.adjacentCountries("BS").size());
        assertTrue("Array List doesn't contain the correct adjacent country", c.get(0).getCountryName() == "ST");
    }

    @Test
    public void test_adjacentCountries_OO() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("OO");
        assertEquals("2 Countries adjacent to OO", 2, b.adjacentCountries("OO").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "KNA");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "KNB");
    }
    @Test
    public void test_adjacentCountries_KNA() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("KNA");
        assertEquals("3 Countries adjacent to KNA", 3, b.adjacentCountries("KNA").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "OO");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "KNB");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "IH");
    }
    @Test
    public void test_adjacentCountries_KNB() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("KNB");
        assertEquals("3 Countries adjacent to KNB", 3, b.adjacentCountries("KNB").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "OO");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "KNA");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "MSC");
    }

    @Test
    public void test_adjacentCountries_MSC() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("MSC");
        assertEquals("3 Countries adjacent to MSC", 3, b.adjacentCountries("MSC").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "TI");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "KNB");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "MACHALL");
    }

    @Test
    public void test_adjacentCountries_MACHALL() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("MACHALL");
        assertEquals("5 Countries adjacent to MACHALL", 5, b.adjacentCountries("MACHALL").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "TI");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "SB");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "MSC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "MB");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(4).getCountryName() == "TFDL");
    }

    @Test
    public void test_adjacentCountries_MB() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("MB");
        assertEquals("3 Countries adjacent to MB", 3, b.adjacentCountries("MB").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "MACHALL");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "MT");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "TFDL");
    }

    @Test
    public void test_adjacentCountries_MT() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("MT");
        assertEquals("3 Countries adjacent to MT", 3, b.adjacentCountries("MT").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "MB");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "MFH");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "TFDL");
    }

    @Test
    public void test_adjacentCountries_MFH() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("MFH");
        assertEquals("3 Countries adjacent to MFH", 3, b.adjacentCountries("MFH").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "MT");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "CHC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "PF");
    }

    @Test
    public void test_adjacentCountries_TFDL() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("TFDL");
        assertEquals("3 Countries adjacent to TFDL", 3, b.adjacentCountries("TFDL").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "MACHALL");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "MT");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "CHG");
    }

    @Test
    public void test_adjacentCountries_CHG() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("CHG");
        assertEquals("4 Countries adjacent to MT", 4, b.adjacentCountries("CHG").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "TFDL");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "CHC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "RT");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "ARTSPARK");
    }

    @Test
    public void test_adjacentCountries_CHC() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("CHC");
        assertEquals("4 Countries adjacent to CHC", 4, b.adjacentCountries("CHC").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "MFH");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "CHG");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "RT");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "ARTSPARK");
    }

    @Test
    public void test_adjacentCountries_RT() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("RT");
        assertEquals("4 Countries adjacent to RT", 4, b.adjacentCountries("RT").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "CHG");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "CHC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "RC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(3).getCountryName() == "ARTSPARK");
    }

    @Test
    public void test_adjacentCountries_RC() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("RC");
        assertEquals("1 Country adjacent to RC", 1, b.adjacentCountries("RC").size());
        assertTrue("Array List doesn't contain the correct adjacent country", c.get(0).getCountryName() == "RT");
    }

    @Test
    public void test_adjacentCountries_ARTSPARK() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("ARTSPARK");
        assertEquals("3 Countries adjacent to ARTSPARK", 3, b.adjacentCountries("ARTSPARK").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "CHG");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "CHC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "RT");
    }

    @Test
    public void test_adjacentCountries_AD() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("AD");
        assertEquals("3 Countries adjacent to AD", 3, b.adjacentCountries("AD").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "SA");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "SS");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "PF");
    }

    @Test
    public void test_adjacentCountries_PF() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("PF");
        assertEquals("3 Countries adjacent to PF", 3, b.adjacentCountries("PF").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "MFH");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "AD");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(2).getCountryName() == "EDUC");
    }

    @Test
    public void test_adjacentCountries_EDUC() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("EDUC");
        assertEquals("2 Countries adjacent to MT", 2, b.adjacentCountries("EDUC").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "AD");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "SCRF");
    }

    @Test
    public void test_adjacentCountries_SCRF() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("SCRF");
        assertEquals("1 Country adjacent to SCRF", 1, b.adjacentCountries("SCRF").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "EDUC");
    }

    @Test
    public void test_adjacentCountries_IH() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("IH");
        assertEquals("2 Countries adjacent to MT", 2, b.adjacentCountries("IH").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "KNA");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "DC");
    }

    @Test
    public void test_adjacentCountries_DC() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("DC");
        assertEquals("2 Countries adjacent to DC", 2, b.adjacentCountries("DC").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "IH");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "TRAD");
    }

    @Test
    public void test_adjacentCountries_TRAD() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("TRAD");
        assertEquals("2 Countries adjacent to TRAD", 2, b.adjacentCountries("TRAD").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "DC");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "APTS");
    }

    @Test
    public void test_adjacentCountries_APTS() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("APTS");
        assertEquals("2 Countries adjacent to APTS", 2, b.adjacentCountries("APTS").size());
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(0).getCountryName() == "TRAD");
        assertTrue("Array List doesn't contain the correct adjacent countries", c.get(1).getCountryName() == "HYBRID");
    }

    @Test
    public void test_adjacentCountries_HYBRID() {
        Board b = new Board();
        ArrayList<Country> c = b.adjacentCountries("HYBRID");
        assertEquals("1 Country adjacent to HYBRID", 1, b.adjacentCountries("HYBRID").size());
        assertTrue("Array List doesn't contain the correct adjacent country", c.get(0).getCountryName() == "APTS");
    }
}
