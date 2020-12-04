/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet.models;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bastien BOMBARDELLA
 */
public class ProjetTest {
    
    public ProjetTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() { 
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Projet.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        String expResult = "Projet id #4\nNom : \"Projet Test\"\nsshURL : \"test@test.com\"\nwebURL : \"https://www.test.com\"\nCommits : 5\nMembres (0)\n";
        String result = proj.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toXML method, of class Projet.
     */
    @Test
    public void testToXML() {
        System.out.println("toXML");
        Projet instance = new Projet();
        String expResult = "";
        String result = instance.toXML();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Projet.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        int expResult = 4;
        int result = proj.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Projet.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        int id = 5;
        proj.setId(id);
        assertEquals(id, proj.getId());
    }

    /**
     * Test of getNom method, of class Projet.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        String expResult = "Projet Test";
        String result = proj.getNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNom method, of class Projet.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        String nom = "Testons la méthode";
        proj.setNom(nom);
        assertEquals(nom, proj.getNom());
    }

    /**
     * Test of getWebURL method, of class Projet.
     */
    @Test
    public void testGetWebURL() {
        System.out.println("getWebURL");
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        String expResult = "https://www.test.com";
        String result = proj.getWebURL();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWebURL method, of class Projet.
     */
    @Test
    public void testSetWebURL() {
        System.out.println("setWebURL");
        String webURL = "https://new.test.com/";
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        proj.setWebURL(webURL);
        assertEquals(webURL, proj.getWebURL());
    }

    /**
     * Test of getSshURL method, of class Projet.
     */
    @Test
    public void testGetSshURL() {
        System.out.println("getSshURL");
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        String expResult = "test@test.com";
        String result = proj.getSshURL();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSshURL method, of class Projet.
     */
    @Test
    public void testSetSshURL() {
        System.out.println("setSshURL");
        String sshURL = "test2@test.com";
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        proj.setSshURL(sshURL);
        assertEquals(sshURL, proj.getSshURL());
    }

    /**
     * Test of getNbCommits method, of class Projet.
     */
    @Test
    public void testGetNbCommits() {
        System.out.println("getNbCommits");
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        int expResult = 5;
        int result = proj.getNbCommits();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNbCommits method, of class Projet.
     */
    @Test
    public void testSetNbCommits() {
        System.out.println("setNbCommits");
        int nbCommits = 8;
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        proj.setNbCommits(nbCommits);
        assertEquals(nbCommits, proj.getNbCommits());
    }

    /**
     * Test of getLstMembres method, of class Projet.
     */
    @Test
    public void testGetLstMembres() {
        System.out.println("getLstMembres");
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        HashMap<String, ArrayList<Membre>> expResult = new HashMap<>();
        HashMap<String, ArrayList<Membre>> result = proj.getLstMembres();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLstMembres method, of class Projet.
     */
    @Test
    public void testSetLstMembres() {
        System.out.println("setLstMembres");
        HashMap<String, ArrayList<Membre>> lstMembres = new HashMap<>();
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        proj.setLstMembres(lstMembres);
        assertEquals(lstMembres, proj.getLstMembres());
    }

    /**
     * Test of getNbMembres method, of class Projet.
     */
    @Test
    public void testGetNbMembres() {
        System.out.println("getNbMembres");
        Projet proj=new Projet(4,"Projet Test", "https://www.test.com", "test@test.com", 5);
        int expResult = 0;
        int result = proj.getNbMembres();
        assertEquals(expResult, result);
    }
    
}
