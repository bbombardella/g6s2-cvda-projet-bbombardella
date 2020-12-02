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
        Projet instance = new Projet();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        Projet instance = new Projet();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Projet.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Projet instance = new Projet();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Projet.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Projet instance = new Projet();
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNom method, of class Projet.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String nom = "";
        Projet instance = new Projet();
        instance.setNom(nom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWebURL method, of class Projet.
     */
    @Test
    public void testGetWebURL() {
        System.out.println("getWebURL");
        Projet instance = new Projet();
        String expResult = "";
        String result = instance.getWebURL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWebURL method, of class Projet.
     */
    @Test
    public void testSetWebURL() {
        System.out.println("setWebURL");
        String webURL = "";
        Projet instance = new Projet();
        instance.setWebURL(webURL);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSshURL method, of class Projet.
     */
    @Test
    public void testGetSshURL() {
        System.out.println("getSshURL");
        Projet instance = new Projet();
        String expResult = "";
        String result = instance.getSshURL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSshURL method, of class Projet.
     */
    @Test
    public void testSetSshURL() {
        System.out.println("setSshURL");
        String sshURL = "";
        Projet instance = new Projet();
        instance.setSshURL(sshURL);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbCommits method, of class Projet.
     */
    @Test
    public void testGetNbCommits() {
        System.out.println("getNbCommits");
        Projet instance = new Projet();
        int expResult = 0;
        int result = instance.getNbCommits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNbCommits method, of class Projet.
     */
    @Test
    public void testSetNbCommits() {
        System.out.println("setNbCommits");
        int nbCommits = 0;
        Projet instance = new Projet();
        instance.setNbCommits(nbCommits);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLstMembres method, of class Projet.
     */
    @Test
    public void testGetLstMembres() {
        System.out.println("getLstMembres");
        Projet instance = new Projet();
        HashMap<String, ArrayList<Membre>> expResult = null;
        HashMap<String, ArrayList<Membre>> result = instance.getLstMembres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLstMembres method, of class Projet.
     */
    @Test
    public void testSetLstMembres() {
        System.out.println("setLstMembres");
        HashMap<String, ArrayList<Membre>> lstMembres = null;
        Projet instance = new Projet();
        instance.setLstMembres(lstMembres);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbMembres method, of class Projet.
     */
    @Test
    public void testGetNbMembres() {
        System.out.println("getNbMembres");
        Projet instance = new Projet();
        int expResult = 0;
        int result = instance.getNbMembres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
