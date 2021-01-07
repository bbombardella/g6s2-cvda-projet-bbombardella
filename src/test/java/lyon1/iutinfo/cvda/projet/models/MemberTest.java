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
public
	  class MemberTest
	{

	public
		  MemberTest ()
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
	 * Test of toString method, of class Member.
	 */
	@Test
	public
		  void testToString ()
		{
		System.out.println("toString");
		Member instance = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		String exp_result = "#12: QUIROULE Pierre\nEmail: \"Pierre.Quiroule@test.fr\"";
		exp_result += "\nWebsite : \"Pierrequiroule.com\"\nProjets (0)\n";

		String result = instance.toString();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of getId method, of class Member.
	 */
	@Test
	public
		  void testGetId ()
		{
		System.out.println("getId");
		Member instance = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		int exp_result = 12;
		int result = instance.getId();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of setId method, of class Member.
	 */
	@Test
	public
		  void testSetId () throws NegativeMemberID
		{
		System.out.println("setId");
		int id = 1;
		Member instance = new Member();
		instance.setId(id);
		return;
		}

	/**
	 * Test of getName method, of class Member.
	 */
	@Test
	public
		  void testGetName ()
		{
		System.out.println("getName");
		Member instance = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		String exp_result = "QUIROULE Pierre";
		String result = instance.getName();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of setName method, of class Member.
	 */
	@Test
	public
		  void testSetName ()
		{
		System.out.println("setName");
		String name = "";
		Member instance = new Member();
		instance.setName(name);
		return;
		}

	/**
	 * Test of getEmail method, of class Member.
	 */
	@Test
	public
		  void testGetEmail ()
		{
		System.out.println("getEmail");
		Member instance = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		String exp_result = "Pierre.Quiroule@test.fr";
		String result = instance.getEmail();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of setEmail method, of class Member.
	 */
	@Test
	public
		  void testSetEmail () throws WrongEmailAddress
		{
		System.out.println("setEmail");
		String email = "test@test.co.uk";
		Member instance = new Member();
		instance.setEmail(email);
		return;
		}

	/**
	 * Test of getWebsite method, of class Member.
	 */
	@Test
	public
		  void testGetWebsite ()
		{
		System.out.println("getWebsite");
		Member instance = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		String exp_result = "Pierrequiroule.com";
		String result = instance.getWebsite();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of setWebsite method, of class Member.
	 */
	@Test
	public
		  void testSetWebsite () throws WrongWebsiteURL
		{
		System.out.println("setWebsite");
		String website = "http://test.com/";
		Member instance = new Member();
		instance.setWebsite(website);
		return;
		}

	/**
	 * Test of getLstProjects method, of class Member.
	 */
	@Test
	public
		  void testGetLstProjects ()
		{
		System.out.println("getLstProjects");
		Member instance = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		HashMap<String, ArrayList<Project>> exp_result = new HashMap<>();
		HashMap<String, ArrayList<Project>> result = instance.getLstProjects();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of setLstProjects method, of class Member.
	 */
	@Test
	public
		  void testSetLstProjects ()
		{
		System.out.println("setLstProjects");
		HashMap<String, ArrayList<Project>> lst_projects = new HashMap<>();
		Member instance = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		instance.setLstProjects(lst_projects);
		return;
		}

	/**
	 * Test of getNbProjects method, of class Member.
	 */
	@Test
	public
		  void testGetNbProjects ()
		{
		System.out.println("getNbProjects");
		Member instance = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		int exp_result = 0;
		int result = instance.getNbProjects();
		assertEquals(exp_result, result);
		return;
		}

	/**
	 * Test of toXML method, of class Member.
	 */
	@Test
	public
		  void testToXML ()
		{

		Member member_1 = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		Project project_1 = new Project(128, "Test", "Test.com", "Test.com.ssh", 3);
		ArrayList<Member> lst_maintainers = new ArrayList();
		lst_maintainers.add(member_1);
		project_1.getLstMembers().put("Maintainer", lst_maintainers);
		ArrayList<Project> lst_projects = new ArrayList();
		lst_projects.add(project_1);
		member_1.getLstProjects().put("Maintainer", lst_projects);

		System.out.println("toXML");
		String exp_result = "<membre id='12'>\n   <nom>QUIROULE Pierre</nom>\n   <email>Pierre.Quiroule@test.fr</email>";
		exp_result += "\n   <website>Pierrequiroule.com</website>\n   <nbprojets>1</nbprojets>";
		exp_result += "\n</membre>";
		String result = member_1.toXML();

		String exp_hash = new DigestUtils(SHA_224).digestAsHex(exp_result);
		String result_hash = new DigestUtils(SHA_224).digestAsHex(result);

		assertEquals(exp_hash, result_hash);
		System.out.println(result_hash);
		return;
		}

	@Test
	public
		  void testSetIdNegative ()
		{
		Member member_1 = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		assertThrows(NegativeMemberID.class, () ->
			{
			member_1.setId(-1);
			});
		return;
		}

	@Test
	public
		  void testSetIdNull ()
		{
		Member member_1 = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		assertThrows(NegativeMemberID.class, () ->
			{
			member_1.setId(0);
			});
		return;
		}

	@Test
	public
		  void testSetEmailWrong ()
		{
		Member member_1 = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		assertThrows(WrongEmailAddress.class, () ->
			{
			member_1.setEmail("");
			});
		return;
		}

	@Test
	public
		  void testSetWebsiteWrong ()
		{
		Member member_1 = new Member(12, "QUIROULE Pierre", "Pierre.Quiroule@test.fr", "Pierrequiroule.com");
		assertThrows(WrongWebsiteURL.class, () ->
			{
			member_1.setWebsite("");
			});
		return;
		}

	}
