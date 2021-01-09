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
		return;
		}

	@AfterAll
	public static
		  void tearDownClass ()
		{
		return;
		}

	@BeforeEach
	public
		  void setUp ()
		{
		return;
		}

	@AfterEach
	public
		  void tearDown ()
		{
		return;
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
		String exp_result = "Projet id #4\nNom : \"Projet Test\"\nsshURL : \"test@test.com\"\nwebURL : \"https://www.test.com\"\nCommits : 5\nMembres (0)\n";
		String result = proj.toString();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of toXML method, of class Project.
	 */
	@Test
	public
		  void testToXML ()
		{
		try
			{
			System.out.println("toXML");

			Member bastien = new Member(2870, "BOMBARDELLA BASTIEN p1935610", "bastien.bombardella@etu.univ-lyon1.fr", "bastienbc.fr");
			Project proj = new Project(16646, "g6s2-cvda-projet-bbombardella", "https://forge.univ-lyon1.fr/p1935610/g6s2-cvda-projet-bbombardella.git", "git@forge.univ-lyon1.fr:p1935610/g6s2-cvda-projet-bbombardella.git", 23);
			ArrayList<Member> lst_maintainers = new ArrayList();
			lst_maintainers.add(bastien);
			proj.getLstMembers().put("Maintainer", lst_maintainers);
			ArrayList<Project> lst_projects = new ArrayList();
			lst_projects.add(proj);
			bastien.getLstProjects().put("Maintainer", lst_projects);

			String exp_xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
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
			String result_xml = proj.toXML();

			String exp_hash = new DigestUtils(SHA_224).digestAsHex(exp_xml);
			String result_hash = new DigestUtils(SHA_224).digestAsHex(result_xml);

			assertEquals(exp_hash, result_hash);
			}
		catch (Exception e)
			{
			fail(e.getMessage());
			}
		return;
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
		int exp_result = 4;
		int result = proj.getId();
		assertEquals(exp_result, result);
		return;
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
		return;
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
		String exp_result = "Projet Test";
		String result = proj.getName();
		assertEquals(exp_result, result);
		return;
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
		return;
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
		String exp_result = "https://www.test.com";
		String result = proj.getWebURL();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of setWebURL method, of class Project.
	 */
	@Test
	public
		  void testSetWebURL () throws WrongWebURL
		{
		System.out.println("setWebURL");
		String web_url = "https://new.test.com/projet.git";
		Project proj = new Project(4, "Projet Test", "https://www.test.com/projet.git", "test@test.com", 5);
		proj.setWebURL(web_url);
		assertEquals(web_url, proj.getWebURL());
		return;
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
		String exp_result = "test@test.com";
		String result = proj.getSshURL();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of setSshURL method, of class Project.
	 */
	@Test
	public
		  void testSetSshURL () throws WrongSshURL
		{
		System.out.println("setSshURL");
		String ssh_url = "git@forge.univ-lyon1.fr:pgfdgdg/gfdguyt.git";
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "git@forge.univ-lyon1.fr:podsfc/qornd.git", 5);
		proj.setSshURL(ssh_url);
		assertEquals(ssh_url, proj.getSshURL());
		return;
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
		int exp_result = 5;
		int result = proj.getNbCommits();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of setNbCommits method, of class Project.
	 */
	@Test
	public
		  void testSetNbCommits () throws NegativeNumberOfCommits
		{
		System.out.println("setNbCommits");
		int nb_commits = 8;
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		proj.setNbCommits(nb_commits);
		assertEquals(nb_commits, proj.getNbCommits());
		return;
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
		HashMap<String, ArrayList<Member>> exp_result = new HashMap<>();
		HashMap<String, ArrayList<Member>> result = proj.getLstMembers();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of setLstMembers method, of class Project.
	 */
	@Test
	public
		  void testSetLstMembers () throws AnyMaintainerAvailable
		{
		System.out.println("setLstMembers");
		HashMap<String, ArrayList<Member>> lst_members = new HashMap<>();
		Member bastien = new Member();
		ArrayList<Member> maintainer = new ArrayList();
		maintainer.add(bastien);
		lst_members.put("Maintainer", maintainer);
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		proj.setLstMembers(lst_members);
		assertEquals(lst_members, proj.getLstMembers());
		return;
		}

	/**
	 * Test of getNbMembers method, of class Project.
	 */
	@Test
	public
		  void testGetNbMembers ()
		{
		System.out.println("getNbMembers");
		Project proj = new Project(4, "Projet Test", "https://www.test.com", "test@test.com", 5);
		int exp_result = 0;
		int result = proj.getNbMembers();
		assertEquals(exp_result, result);
		return;
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
		return;
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
		return;
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
		return;
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
		return;
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
		return;
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
		return;
		}

	}
