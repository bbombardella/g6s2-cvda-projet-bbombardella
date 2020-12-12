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
 * @author Marin
 */
public class MembreTest {
    
    public MembreTest() {
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
     * Test of toString method, of class Membre.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Membre instance = new Membre();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Membre.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Membre instance = new Membre();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Membre.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Membre instance = new Membre();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Membre.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Membre instance = new Membre();
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNom method, of class Membre.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String nom = "";
        Membre instance = new Membre();
        instance.setNom(nom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Membre.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Membre instance = new Membre();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Membre.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Membre instance = new Membre();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWebsite method, of class Membre.
     */
    @Test
    public void testGetWebsite() {
        System.out.println("getWebsite");
        Membre instance = new Membre();
        String expResult = "";
        String result = instance.getWebsite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWebsite method, of class Membre.
     */
    @Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        String website = "";
        Membre instance = new Membre();
        instance.setWebsite(website);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLstProjets method, of class Membre.
     */
    @Test
    public void testGetLstProjets() {
        System.out.println("getLstProjets");
        Membre instance = new Membre();
        HashMap<String, ArrayList<Projet>> expResult = null;
        HashMap<String, ArrayList<Projet>> result = instance.getLstProjets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLstProjets method, of class Membre.
     */
    @Test
    public void testSetLstProjets() {
        System.out.println("setLstProjets");
        HashMap<String, ArrayList<Projet>> lstProjets = null;
        Membre instance = new Membre();
        instance.setLstProjets(lstProjets);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbProjets method, of class Membre.
     */
    @Test
    public void testGetNbProjets() {
        System.out.println("getNbProjets");
        Membre instance = new Membre();
        int expResult = 0;
        int result = instance.getNbProjets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
