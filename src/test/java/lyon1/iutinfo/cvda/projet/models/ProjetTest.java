/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet.models;

import java.util.ArrayList;
import java.util.HashMap;
import lyon1.iutinfo.cvda.projet.exceptions.AnyMaintainerAvailable;
import lyon1.iutinfo.cvda.projet.exceptions.NegativeNumberOfCommits;
import lyon1.iutinfo.cvda.projet.exceptions.NegativeProjectID;
import lyon1.iutinfo.cvda.projet.exceptions.WrongSshURL;
import lyon1.iutinfo.cvda.projet.exceptions.WrongWebURL;
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
public
	  class ProjetTest
	{

	public
		  ProjetTest ()
		{
		}

	@BeforeAll
	public static
		  void setUpClass ()
		{
		}

	@AfterAll
	public static
		  void tearDownClass ()
		{
		}

	@BeforeEach
	public
		  void setUp ()
		{
		}

	@AfterEach
	public
		  void tearDown ()
		{
		}

	/**
	 * Test of toString method, of class Projet.
	 */
	@Test
	public
		  void testToString ()
		{
		System.out.println("toString");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		String expResult = "Projet id #4\nNom : \"Projet Test\"\nsshURL : \"test@test.com\"\nwebURL : \"https://www.test.com\"\nCommits : 5\nMembres (0)\n";
		String result = proj.toString();
		assertEquals(expResult, result);
		}

	/**
	 * Test of toXML method, of class Projet.
	 */
	@Test
	public
		  void testToXML ()
		{
		System.out.println("toXML");

		Membre bastien = new Membre(2870, "BOMBARDELLA BASTIEN p1935610", "bastien.bombardella@etu.univ-lyon1.fr", "bastienbc.fr");
		Projet proj = new Projet(16646, "g6s2-cvda-projet-bbombardella", "https://forge.univ-lyon1.fr/p1935610/g6s2-cvda-projet-bbombardella.git", "git@forge.univ-lyon1.fr:p1935610/g6s2-cvda-projet-bbombardella.git", 23);
		ArrayList<Membre> lstMaintainers = new ArrayList();
		lstMaintainers.add(bastien);
		proj.getLstMembres().put("Maintainer", lstMaintainers);
		ArrayList<Projet> lstProjets = new ArrayList();
		lstProjets.add(proj);
		bastien.getLstProjets().put("Maintainer", lstProjets);

		String expXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
			  + "<projet id=\"16646\" nbcommits=\"23\">"
			  + "<nom>g6s2-cvda-projet-bbombardella</nom>"
			  + "<webURL>https://forge.univ-lyon1.fr/p1935610/g6s2-cvda-projet-bbombardella.git</webURL>"
			  + "<sshURL>git@forge.univ-lyon1.fr:p1935610/g6s2-cvda-projet-bbombardella.git</sshURL>"
			  + "<membres>"
			  + "<membre id=\"2870\" role=\"Maintainer\">"
			  + "<nom>BOMBARDELLA BASTIEN p1935610</nom>"
			  + "<nb-projets>1</nb-projets>"
			  + "</membre>"
			  + "</membres>"
			  + "</projet>";
		String resultXML = proj.toXML();

		String expHash = new DigestUtils(SHA_224).digestAsHex(expXML);
		String resultHash = new DigestUtils(SHA_224).digestAsHex(resultXML);

		assertEquals(expHash, resultHash);
		}

	/**
	 * Test of getId method, of class Projet.
	 */
	@Test
	public
		  void testGetId ()
		{
		System.out.println("getId");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		int expResult = 4;
		int result = proj.getId();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setId method, of class Projet.
	 */
	@Test
	public
		  void testSetId () throws NegativeProjectID
		{
		System.out.println("setId");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		int id = 5;
		proj.setId(id);
		assertEquals(id, proj.getId());
		}

	/**
	 * Test of getNom method, of class Projet.
	 */
	@Test
	public
		  void testGetNom ()
		{
		System.out.println("getNom");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		String expResult = "Projet Test";
		String result = proj.getNom();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setNom method, of class Projet.
	 */
	@Test
	public
		  void testSetNom ()
		{
		System.out.println("setNom");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		String nom = "Testons la méthode";
		proj.setNom(nom);
		assertEquals(nom, proj.getNom());
		}

	/**
	 * Test of getWebURL method, of class Projet.
	 */
	@Test
	public
		  void testGetWebURL ()
		{
		System.out.println("getWebURL");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		String expResult = "https://www.test.com";
		String result = proj.getWebURL();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setWebURL method, of class Projet.
	 */
	@Test
	public
		  void testSetWebURL () throws WrongWebURL
		{
		System.out.println("setWebURL");
		String webURL = "https://new.test.com/projet.git";
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com/projet.git", "test@test.com", 5);
		proj.setWebURL(webURL);
		assertEquals(webURL, proj.getWebURL());
		}

	/**
	 * Test of getSshURL method, of class Projet.
	 */
	@Test
	public
		  void testGetSshURL ()
		{
		System.out.println("getSshURL");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		String expResult = "test@test.com";
		String result = proj.getSshURL();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setSshURL method, of class Projet.
	 */
	@Test
	public
		  void testSetSshURL () throws WrongSshURL
		{
		System.out.println("setSshURL");
		String sshURL = "git@forge.univ-lyon1.fr:pgfdgdg/gfdguyt.git";
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "git@forge.univ-lyon1.fr:podsfc/qornd.git", 5);
		proj.setSshURL(sshURL);
		assertEquals(sshURL, proj.getSshURL());
		}

	/**
	 * Test of getNbCommits method, of class Projet.
	 */
	@Test
	public
		  void testGetNbCommits ()
		{
		System.out.println("getNbCommits");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		int expResult = 5;
		int result = proj.getNbCommits();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setNbCommits method, of class Projet.
	 */
	@Test
	public
		  void testSetNbCommits () throws NegativeNumberOfCommits
		{
		System.out.println("setNbCommits");
		int nbCommits = 8;
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		proj.setNbCommits(nbCommits);
		assertEquals(nbCommits, proj.getNbCommits());
		}

	/**
	 * Test of getLstMembres method, of class Projet.
	 */
	@Test
	public
		  void testGetLstMembres ()
		{
		System.out.println("getLstMembres");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		HashMap<String, ArrayList<Membre>> expResult = new HashMap<>();
		HashMap<String, ArrayList<Membre>> result = proj.getLstMembres();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setLstMembres method, of class Projet.
	 */
	@Test
	public
		  void testSetLstMembres () throws AnyMaintainerAvailable
		{
		System.out.println("setLstMembres");
		HashMap<String, ArrayList<Membre>> lstMembres = new HashMap<>();
		Membre bastien = new Membre();
		ArrayList<Membre> maintainer = new ArrayList();
		maintainer.add(bastien);
		lstMembres.put("Maintainer", maintainer);
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		proj.setLstMembres(lstMembres);
		assertEquals(lstMembres, proj.getLstMembres());
		}

	/**
	 * Test of getNbMembres method, of class Projet.
	 */
	@Test
	public
		  void testGetNbMembres ()
		{
		System.out.println("getNbMembres");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		int expResult = 0;
		int result = proj.getNbMembres();
		assertEquals(expResult, result);
		}

	public
		  void testSetIdNegatif ()
		{
		System.out.println("testSetIdNegatif");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(NegativeProjectID.class, () ->
			{
			proj.setId(-2);
			});
		}

	public
		  void testSetIdZero ()
		{
		System.out.println("testSetIdNegatif");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(NegativeProjectID.class, () ->
			{
			proj.setId(0);
			});
		}

	public
		  void testSetWebURLWrong ()
		{
		System.out.println("testSetWebURLWrong");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(WrongWebURL.class, () ->
			{
			proj.setWebURL("");
			});
		}

	public
		  void testSetSshURLWrong ()
		{
		System.out.println("testSetSshURLWrong");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(WrongWebURL.class, () ->
			{
			proj.setWebURL("");
			});
		}

	public
		  void testSetNbCommitsNegative ()
		{
		System.out.println("testSetNbCommitsNegative");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(NegativeNumberOfCommits.class, () ->
			{
			proj.setNbCommits(-5);
			});
		}

	public
		  void testSetLstMembresAnyMaintainer ()
		{
		System.out.println("testSetNbCommitsNegative");
		Projet proj = new Projet(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(AnyMaintainerAvailable.class, () ->
			{
			proj.setLstMembres(new HashMap<String, ArrayList<Membre>>());
			});
		}

	}
