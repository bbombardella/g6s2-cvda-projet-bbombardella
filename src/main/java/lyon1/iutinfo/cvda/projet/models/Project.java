/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet.models;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import lyon1.iutinfo.cvda.projet.exceptions.AnyMaintainerAvailable;
import lyon1.iutinfo.cvda.projet.exceptions.NegativeNumberOfCommits;
import lyon1.iutinfo.cvda.projet.exceptions.NegativeProjectID;
import lyon1.iutinfo.cvda.projet.exceptions.WrongSshURL;
import lyon1.iutinfo.cvda.projet.exceptions.WrongWebURL;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Bastien BOMBARDELLA
 */
public
	  class Project
	{

	/**
	 * the id
	 */
	protected
		  int id;

	/**
	 * the name
	 */
	protected
		  String name;

	/**
	 * the git web URL
	 */
	protected
		  String webURL;

	/**
	 * the git ssh URL
	 */
	protected
		  String sshURL;

	/**
	 * the number of commits
	 */
	protected
		  int nbCommits;

	/**
	 * the map of roles & members
	 */
	protected
		  HashMap<String, ArrayList<Member>> lstMembers;

	/**
	 * constructor with no params
	 */
	public
		  Project ()
		{
		this.id = 0;
		this.name = "";
		this.webURL = "";
		this.sshURL = "";
		this.nbCommits = 0;
		this.lstMembers = null;
		}

	/**
	 * constructor using several params to define a project
	 *
	 * @param i        the id
	 * @param n        the name
	 * @param wURL     the git https URL
	 * @param sURL     the git ssh URL
	 * @param nCommits the number of commits
	 */
	public
		  Project (int i, String n, String wURL, String sURL, int nCommits)
		{
		this.id = i;
		this.name = n;
		this.webURL = wURL;
		this.sshURL = sURL;
		this.nbCommits = nCommits;
		this.lstMembers = new HashMap<>();
		}

	/**
	 * get the project's information
	 *
	 * @return a string of the project's information
	 */
	public
		  String toString ()
		{
		int nb_member = 0;

		String info = "Projet id #" + this.id
			  + "\nNom : \"" + this.name + "\""
			  + "\nsshURL : \"" + this.sshURL + "\""
			  + "\nwebURL : \"" + this.webURL + "\""
			  + "\nCommits : " + this.nbCommits
			  + "\nMembres (" + this.getNbMembers() + ")"
			  + "\n" + this.getProjectMembers();
		return (info);
		}

	/**
	 * get the project's members' informations
	 *
	 * @return a string of project's members' informations
	 */
	public
		  String getProjectMembers ()
		{
		String members_info = "";
		for (ArrayList<Member> list : this.lstMembers.values())
			{
			for (Member m : list)
				{
				members_info += "-\t#" + m.getId() + ": " + m.getName() + " (" + m.getNbProjects() + " projets)\n";
				}
			}
		return members_info;
		}

	/**
	 * get the project's informations in an XML format
	 *
	 * @return	a string of XML project's informations
	 *
	 * @throws TransformerException         throw TransformerException
	 * @throws ParserConfigurationException throw ParserConfigurationException
	 */
	public
		  String toXML () throws TransformerException, ParserConfigurationException
		{
		Document xml_doc = this.XMLBuildNodes();
		String xml_string = this.nodeToString(xml_doc);
		return xml_string;
		}

	/**
	 * build the root of the XML informations
	 *
	 * @return	the root of the XML informations
	 *
	 * @throws ParserConfigurationException throw ParserConfigurationException
	 */
	private
		  Document XMLBuildNodes () throws ParserConfigurationException
		{
		DocumentBuilderFactory doc_factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder doc_builder = doc_factory.newDocumentBuilder();
		Document doc = doc_builder.newDocument();
		Element root_element = this.projectNodeXML(doc);
		Element name_element = this.nameNodeXML(doc);
		root_element.appendChild(name_element);
		Element web_url_element = this.webURLNodeXML(doc);
		root_element.appendChild(web_url_element);
		Element ssh_url_element = this.sshURLNodeXML(doc);
		root_element.appendChild(ssh_url_element);
		Element members_element = doc.createElement("membres");
		root_element.appendChild(members_element);
		this.membersNodeXML(doc, members_element);
		return doc;
		}

	/**
	 * get the project XML node
	 *
	 * @param doc the XML informations
	 * @return the modificated XML informations with the project node
	 */
	private
		  Element projectNodeXML (Document doc)
		{
		Element root_element = doc.createElement("projet");
		doc.appendChild(root_element);
		root_element.setAttribute("id", String.valueOf(this.id));
		root_element.setAttribute("nbcommits", String.valueOf(this.nbCommits));
		return root_element;
		}

	/**
	 * get the name XML node
	 *
	 * @param doc the XML informations
	 * @return the modificated XML informations with the name node
	 */
	private
		  Element nameNodeXML (Document doc)
		{
		Element name_element = doc.createElement("nom");
		name_element.appendChild(doc.createTextNode(this.name));
		return name_element;

		}

	/**
	 * get the git web URL XML node
	 *
	 * @param doc the XML informations
	 * @return the modificated XML informations with the git web URL node
	 */
	private
		  Element webURLNodeXML (Document doc)
		{
		Element web_url_element = doc.createElement("webURL");
		web_url_element.appendChild(doc.createTextNode(this.webURL));
		return web_url_element;
		}

	/**
	 * get the git SSH URL XML node
	 *
	 * @param doc the XML informations
	 * @return the modificated XML informations with the git SSH URL node
	 */
	private
		  Element sshURLNodeXML (Document doc)
		{
		Element ssh_url_element = doc.createElement("sshURL");
		ssh_url_element.appendChild(doc.createTextNode(this.sshURL));
		return ssh_url_element;
		}

	/**
	 * get the project's members XML node
	 *
	 * @param doc             the XML informations
	 * @param members_element the node of members to add those ones
	 */
	private
		  void membersNodeXML (Document doc, Element members_element)
		{
		for (Entry<String, ArrayList<Member>> list : this.lstMembers.entrySet())
			{
			for (Member m : list.getValue())
				{
				Element member_element = doc.createElement("membre");
				member_element.setAttribute("id", String.valueOf(m.getId()));
				member_element.setAttribute("role", list.getKey());
				Element name_element_2 = doc.createElement("nom");
				name_element_2.appendChild(doc.createTextNode(m.getName()));
				member_element.appendChild(name_element_2);
				Element nb_projects_element = doc.createElement("nb-projets");
				nb_projects_element.appendChild(doc.createTextNode(String.valueOf(m.getNbProjects())));
				member_element.appendChild(nb_projects_element);
				members_element.appendChild(member_element);
				}
			}
		return;
		}

	/**
	 * convert the XML document to a String
	 *
	 * @param doc the XML document
	 * @return the string of XML document
	 *
	 * @throws TransformerException throw TransformerException
	 */
	private
		  String nodeToString (Document doc) throws TransformerException
		{
		TransformerFactory transformer_factory = TransformerFactory.newInstance();
		Transformer transformer = transformer_factory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StringWriter string_writer = new StringWriter();
		StreamResult result = new StreamResult(string_writer);
		transformer.transform(source, result);
		return string_writer.toString();
		}

	/**
	 * get the project's id
	 *
	 * @return an int of the project's id
	 */
	public
		  int getId ()
		{
		return this.id;
		}

	/**
	 * set the project's id
	 *
	 * @param id the id to set
	 * @throws NegativeProjectID if the id is less than or equals to 0
	 */
	public
		  void setId (int id) throws NegativeProjectID
		{
		if (id <= 0)
			{
			throw new NegativeProjectID();
			}
		else
			{
			this.id = id;
			}
		return;
		}

	/**
	 * get the project's name
	 *
	 * @return the string of the project's name
	 */
	public
		  String getName ()
		{
		return this.name;
		}

	/**
	 * set the project's name
	 *
	 * @param name the name to set
	 */
	public
		  void setName (String name)
		{
		this.name = name;
		return;
		}

	/**
	 * get the project's git web URL
	 *
	 * @return a string of the git web URL
	 */
	public
		  String getWebURL ()
		{
		return this.webURL;
		}

	/**
	 * set the project's git web URL
	 *
	 * @param webURL the URL to set
	 * @throws WrongWebURL if the URL to set doesn't look like an correct one
	 */
	public
		  void setWebURL (String webURL) throws WrongWebURL
		{
		if (webURL.matches("^https.*\\.git$"))
			{
			this.webURL = webURL;
			}
		else
			{
			throw new WrongWebURL();
			}
		return;
		}

	/**
	 * get the project's git SSH URL
	 *
	 * @return a string of the project's git SSH URL
	 */
	public
		  String getSshURL ()
		{
		return this.sshURL;
		}

	/**
	 * set the project's git SSH URL
	 *
	 * @param sshURL the URL to set
	 * @throws WrongSshURL if the URL to set doesn't look like an correct SSH format
	 */
	public
		  void setSshURL (String sshURL) throws WrongSshURL
		{
		if (sshURL.matches("^git\\@[A-Za-z0-9-\\.]*\\:[A-Za-z0-9]*\\/[A-Za-z0-9_\\.]*\\.git$"))
			{
			this.sshURL = sshURL;
			}
		else
			{
			throw new WrongSshURL();
			}
		return;
		}

	/**
	 * get the project's number of commits
	 *
	 * @return an int of the project's number of commits
	 */
	public
		  int getNbCommits ()
		{
		return this.nbCommits;
		}

	/**
	 * set the project's number of commits
	 *
	 * @param nbCommits the number to set
	 * @throws NegativeNumberOfCommits if the number to set is negative
	 */
	public
		  void setNbCommits (int nbCommits) throws NegativeNumberOfCommits
		{
		if (nbCommits < 0)
			{
			throw new NegativeNumberOfCommits();
			}
		else
			{
			this.nbCommits = nbCommits;
			}
		return;
		}

	/**
	 * get the project's map roles & members
	 *
	 * @return an map of project's roles & members
	 */
	public
		  HashMap<String, ArrayList<Member>> getLstMembers ()
		{
		return this.lstMembers;
		}

	/**
	 * set the project's map roles & members
	 *
	 * @param lstMembers the map to set
	 * @throws AnyMaintainerAvailable if there's no maintainers inside the list
	 */
	public
		  void setLstMembers (HashMap<String, ArrayList<Member>> lstMembers) throws AnyMaintainerAvailable
		{
		if (lstMembers.containsKey("Maintainer") && lstMembers.get("Maintainer").size() > 0)
			{
			this.lstMembers = lstMembers;
			}
		else
			{
			throw new AnyMaintainerAvailable();
			}
		return;
		}

	/**
	 * get the project's number of members
	 *
	 * @return an int of the project's number of members
	 */
	public
		  int getNbMembers ()
		{
		int nb_members = 0;
		for (ArrayList<Member> list_member : lstMembers.values())
			{
			nb_members += list_member.size();
			}
		return nb_members;
		}

	}
