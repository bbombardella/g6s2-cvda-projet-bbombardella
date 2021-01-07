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
	  class ProjectTest
	{

	public
		  ProjectTest ()
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
	 * Test of toString method, of class Project.
	 */
	@Test
	public
		  void testToString ()
		{
		System.out.println("toString");
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		String expResult = "Projet id #4\nNom : \"Projet Test\"\nsshURL : \"test@test.com\"\nwebURL : \"https://www.test.com\"\nCommits : 5\nMembres (0)\n";
		String result = proj.toString();
		assertEquals(expResult, result);
		}

	/**
	 * Test of toXML method, of class Project.
	 */
	@Test
	public
		  void testToXML ()
		{
		System.out.println("toXML");

		Member bastien = new Member(2870, "BOMBARDELLA BASTIEN p1935610", "bastien.bombardella@etu.univ-lyon1.fr", "bastienbc.fr");
		Project proj = new Project(16646, "g6s2-cvda-projet-bbombardella", "https://forge.univ-lyon1.fr/p1935610/g6s2-cvda-projet-bbombardella.git", "git@forge.univ-lyon1.fr:p1935610/g6s2-cvda-projet-bbombardella.git", 23);
		ArrayList<Member> lstMaintainers = new ArrayList();
		lstMaintainers.add(bastien);
		proj.getLstMembers().put("Maintainer", lstMaintainers);
		ArrayList<Project> lstProjects = new ArrayList();
		lstProjects.add(proj);
		bastien.getLstProjects().put("Maintainer", lstProjects);

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
	 * Test of getId method, of class Project.
	 */
	@Test
	public
		  void testGetId ()
		{
		System.out.println("getId");
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		int expResult = 4;
		int result = proj.getId();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setId method, of class Project.
	 */
	@Test
	public
		  void testSetId () throws NegativeProjectID
		{
		System.out.println("setId");
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		int id = 5;
		proj.setId(id);
		assertEquals(id, proj.getId());
		}

	/**
	 * Test of getName method, of class Project.
	 */
	@Test
	public
		  void testGetName ()
		{
		System.out.println("getName");
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		String expResult = "Projet Test";
		String result = proj.getName();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setName method, of class Project.
	 */
	@Test
	public
		  void testSetName ()
		{
		System.out.println("setName");
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		String name = "Testons la méthode";
		proj.setName(name);
		assertEquals(name, proj.getName());
		}

	/**
	 * Test of getWebURL method, of class Project.
	 */
	@Test
	public
		  void testGetWebURL ()
		{
		System.out.println("getWebURL");
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		String expResult = "https://www.test.com";
		String result = proj.getWebURL();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setWebURL method, of class Project.
	 */
	@Test
	public
		  void testSetWebURL () throws WrongWebURL
		{
		System.out.println("setWebURL");
		String webURL = "https://new.test.com/projet.git";
		Project proj = new Project(4, "Projet Test", "https://www.test.com/projet.git", "test@test.com", 5);
		proj.setWebURL(webURL);
		assertEquals(webURL, proj.getWebURL());
		}

	/**
	 * Test of getSshURL method, of class Project.
	 */
	@Test
	public
		  void testGetSshURL ()
		{
		System.out.println("getSshURL");
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		String expResult = "test@test.com";
		String result = proj.getSshURL();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setSshURL method, of class Project.
	 */
	@Test
	public
		  void testSetSshURL () throws WrongSshURL
		{
		System.out.println("setSshURL");
		String sshURL = "git@forge.univ-lyon1.fr:pgfdgdg/gfdguyt.git";
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "git@forge.univ-lyon1.fr:podsfc/qornd.git", 5);
		proj.setSshURL(sshURL);
		assertEquals(sshURL, proj.getSshURL());
		}

	/**
	 * Test of getNbCommits method, of class Project.
	 */
	@Test
	public
		  void testGetNbCommits ()
		{
		System.out.println("getNbCommits");
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		int expResult = 5;
		int result = proj.getNbCommits();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setNbCommits method, of class Project.
	 */
	@Test
	public
		  void testSetNbCommits () throws NegativeNumberOfCommits
		{
		System.out.println("setNbCommits");
		int nbCommits = 8;
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		proj.setNbCommits(nbCommits);
		assertEquals(nbCommits, proj.getNbCommits());
		}

	/**
	 * Test of getLstMembers method, of class Project.
	 */
	@Test
	public
		  void testGetLstMembers ()
		{
		System.out.println("getLstMembers");
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		HashMap<String, ArrayList<Member>> expResult = new HashMap<>();
		HashMap<String, ArrayList<Member>> result = proj.getLstMembers();
		assertEquals(expResult, result);
		}

	/**
	 * Test of setLstMembers method, of class Project.
	 */
	@Test
	public
		  void testSetLstMembers () throws AnyMaintainerAvailable
		{
		System.out.println("setLstMembers");
		HashMap<String, ArrayList<Member>> lstMembres = new HashMap<>();
		Member bastien = new Member();
		ArrayList<Member> maintainer = new ArrayList();
		maintainer.add(bastien);
		lstMembres.put("Maintainer", maintainer);
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		proj.setLstMembers(lstMembres);
		assertEquals(lstMembres, proj.getLstMembers());
		}

	/**
	 * Test of getNbMembres method, of class Project.
	 */
	@Test
	public
		  void testGetNbMembres ()
		{
		System.out.println("getNbMembres");
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		int expResult = 0;
		int result = proj.getNbMembres();
		assertEquals(expResult, result);
		}

	public
		  void testSetIdNegatif ()
		{
		System.out.println("testSetIdNegatif");
		Project proj = new Project(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(NegativeProjectID.class, () ->
			{
			proj.setId(-2);
			});
		}

	public
		  void testSetIdZero ()
		{
		System.out.println("testSetIdNegatif");
		Project proj = new Project(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(NegativeProjectID.class, () ->
			{
			proj.setId(0);
			});
		}

	public
		  void testSetWebURLWrong ()
		{
		System.out.println("testSetWebURLWrong");
		Project proj = new Project(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(WrongWebURL.class, () ->
			{
			proj.setWebURL("");
			});
		}

	public
		  void testSetSshURLWrong ()
		{
		System.out.println("testSetSshURLWrong");
		Project proj = new Project(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(WrongWebURL.class, () ->
			{
			proj.setWebURL("");
			});
		}

	public
		  void testSetNbCommitsNegative ()
		{
		System.out.println("testSetNbCommitsNegative");
		Project proj = new Project(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(NegativeNumberOfCommits.class, () ->
			{
			proj.setNbCommits(-5);
			});
		}

	public
		  void testSetLstMembersAnyMaintainer ()
		{
		System.out.println("testSetNbCommitsNegative");
		Project proj = new Project(4, "Projet Test", "https://www.test.com/project.git", "test@test.com:blabla", 5);
		assertThrows(AnyMaintainerAvailable.class, () ->
			{
			proj.setLstMembers(new HashMap<String, ArrayList<Member>>());
			});
		}

	}
