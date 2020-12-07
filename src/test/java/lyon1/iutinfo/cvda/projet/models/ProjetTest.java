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
import org.apache.commons.codec.digest.DigestUtils;
import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_224;

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
        
        Membre bastien = new Membre(2870,"BOMBARDELLA BASTIEN p1935610","bastien.bombardella@etu.univ-lyon1.fr","bastienbc.fr");
        Projet proj = new Projet(16646,"g6s2-cvda-projet-bbombardella","https://forge.univ-lyon1.fr/p1935610/g6s2-cvda-projet-bbombardella.git","git@forge.univ-lyon1.fr:p1935610/g6s2-cvda-projet-bbombardella.git",23);
        ArrayList<Membre> lstMaintainers = new ArrayList();
        lstMaintainers.add(bastien);
        proj.getLstMembres().put("Maintainer", lstMaintainers);
        ArrayList<Projet> lstProjets = new ArrayList();
        lstProjets.add(proj);
        bastien.getLstProjets().put("Maintainer", lstProjets);
        
        String expXML = "<projet id=\"16646\" nbcommits=\"23\">\n" +
            "\t<nom>g6s2-cvda-projet-bbombardella</nom>\n" +
            "\t<webURL>https://forge.univ-lyon1.fr/p1935610/g6s2-cvda-projet-bbombardella.git</webURL>\n" +
            "\t<sshURL>git@forge.univ-lyon1.fr:p1935610/g6s2-cvda-projet-bbombardella.git</sshURL>\n" +
            "\t<membres>\n" +
            "\t\t<membre id=\"2870\" role=\"Maintainer\">\n" +
            "\t\t\t<nom>BOMBARDELLA BASTIEN p1935610</nom>\n" +
            "\t\t\t<nb-projets>1</nb-projets>\n" +
            "\t\t</membre>\n" +
            "\t</membres>\n" +
            "</projet>";
        String resultXML = proj.toXML();
        
        System.out.println(expXML);
        System.out.println(resultXML);
        
        String expHash = new DigestUtils(SHA_224).digestAsHex(expXML);
        String resultHash = new DigestUtils(SHA_224).digestAsHex(resultXML);
        
        assertEquals(expHash, resultHash);
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
