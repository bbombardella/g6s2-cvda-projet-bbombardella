/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet.models;

import java.util.ArrayList;
import java.util.HashMap;
import lyon1.iutinfo.cvda.projet.exceptions.NegativeMemberID;
import lyon1.iutinfo.cvda.projet.exceptions.WrongEmailAddress;
import lyon1.iutinfo.cvda.projet.exceptions.WrongWebsiteURL;
import org.apache.commons.codec.digest.DigestUtils;
import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_224;
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
		Membre instance = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		String expResult = "#12: QUIROULE Pierre\nEmail: \"Pierre.Quiroule@test.fr\"";
		expResult += "\nWebsite : \"Pierrequiroule.com\"\nProjets (0)\n";

		String result = instance.toString();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getId method, of class Membre.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Membre instance = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		int expResult = 12;
		int result = instance.getId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setId method, of class Membre.
	 */
	@Test
	public void testSetId() throws NegativeMemberID {
		System.out.println("setId");
		int id = 1;
		Membre instance = new Membre();
		instance.setId(id);
	}

	/**
	 * Test of getNom method, of class Membre.
	 */
	@Test
	public void testGetNom() {
		System.out.println("getNom");
		Membre instance = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		String expResult = "QUIROULE Pierre";
		String result = instance.getNom();
		assertEquals(expResult, result);
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
	}

	/**
	 * Test of getEmail method, of class Membre.
	 */
	@Test
	public void testGetEmail() {
		System.out.println("getEmail");
		Membre instance = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		String expResult = "Pierre.Quiroule@test.fr";
		String result = instance.getEmail();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setEmail method, of class Membre.
	 */
	@Test
	public void testSetEmail() throws WrongEmailAddress {
		System.out.println("setEmail");
		String email = "test@test.co.uk";
		Membre instance = new Membre();
		instance.setEmail(email);
	}

	/**
	 * Test of getWebsite method, of class Membre.
	 */
	@Test
	public void testGetWebsite() {
		System.out.println("getWebsite");
		Membre instance = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		String expResult = "Pierrequiroule.com";
		String result = instance.getWebsite();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setWebsite method, of class Membre.
	 */
	@Test
	public void testSetWebsite() throws WrongWebsiteURL {
		System.out.println("setWebsite");
		String website = "http://test.com/";
		Membre instance = new Membre();
		instance.setWebsite(website);
	}

	/**
	 * Test of getLstProjets method, of class Membre.
	 */
	@Test
	public void testGetLstProjets() {
		System.out.println("getLstProjets");
		Membre instance = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		HashMap<String, ArrayList<Projet>> expResult = new HashMap<>();
		HashMap<String, ArrayList<Projet>> result = instance.getLstProjets();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setLstProjets method, of class Membre.
	 */
	@Test
	public void testSetLstProjets() {
		System.out.println("setLstProjets");
		HashMap<String, ArrayList<Projet>> lstProjets = new HashMap<>();
		Membre instance = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		instance.setLstProjets(lstProjets);
	}

	/**
	 * Test of getNbProjets method, of class Membre.
	 */
	@Test
	public void testGetNbProjets() {
		System.out.println("getNbProjets");
		Membre instance = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		int expResult = 0;
		int result = instance.getNbProjets();
		assertEquals(expResult, result);
	}

	/**
	 * Test of toXML method, of class Membre.
	 */
	@Test
	public void testToXML() {

		Membre m1 = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		Projet p1 = new Projet(128, "Test", "Test.com", "Test.com.ssh", 3);
		ArrayList<Membre> lstMaintainers = new ArrayList();
		lstMaintainers.add(m1);
		p1.getLstMembres().put("Maintainer", lstMaintainers);
		ArrayList<Projet> lstProjets = new ArrayList();
		lstProjets.add(p1);
		m1.getLstProjets().put("Maintainer", lstProjets);

		System.out.println("toXML");
		String expResult = "<membre id='12'>\n   <nom>QUIROULE Pierre</nom>\n   <email>Pierre.Quiroule@test.fr</email>";
		expResult += "\n   <website>Pierrequiroule.com</website>\n   <nbprojets>1</nbprojets>";
		expResult += "\n</membre>";
		String result = m1.toXML();

		String expHash = new DigestUtils(SHA_224).digestAsHex(expResult);
		String resultHash = new DigestUtils(SHA_224).digestAsHex(result);

		assertEquals(expHash, resultHash);
		System.out.println(resultHash);
	}

	@Test
	public void testSetIdNegative() {
		Membre m1 = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		assertThrows(NegativeMemberID.class, () -> {
			m1.setId(-1);
		});
	}

	@Test
	public void testSetIdNull() {
		Membre m1 = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		assertThrows(NegativeMemberID.class, () -> {
			m1.setId(0);
		});
	}

	@Test
	public void testSetEmailWrong() {
		Membre m1 = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		assertThrows(WrongEmailAddress.class, () -> {
			m1.setEmail("");
		});
	}

	@Test
	public void testSetWebsiteWrong() {
		Membre m1 = new Membre(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		assertThrows(WrongWebsiteURL.class, () -> {
			m1.setWebsite("");
		});
	}

}
