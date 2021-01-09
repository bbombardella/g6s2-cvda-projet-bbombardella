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

	protected
		  int id;
	protected
		  String name;
	protected
		  String webURL;
	protected
		  String sshURL;
	protected
		  int nbCommits;
	protected
		  HashMap<String, ArrayList<Member>> lstMembers;

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

	public
		  String toXML () throws TransformerException, ParserConfigurationException
		{
		Document xml_doc = this.XMLBuildNodes();
		String xml_string = this.nodeToString(xml_doc);
		return xml_string;
		}

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

	private
		  Element projectNodeXML (Document doc)
		{
		Element root_element = doc.createElement("projet");
		doc.appendChild(root_element);
		root_element.setAttribute("id", String.valueOf(this.id));
		root_element.setAttribute("nbcommits", String.valueOf(this.nbCommits));
		return root_element;
		}

	private
		  Element nameNodeXML (Document doc)
		{
		Element name_element = doc.createElement("nom");
		name_element.appendChild(doc.createTextNode(this.name));
		return name_element;

		}

	private
		  Element webURLNodeXML (Document doc)
		{
		Element web_url_element = doc.createElement("webURL");
		web_url_element.appendChild(doc.createTextNode(this.webURL));
		return web_url_element;
		}

	private
		  Element sshURLNodeXML (Document doc)
		{
		Element ssh_url_element = doc.createElement("sshURL");
		ssh_url_element.appendChild(doc.createTextNode(this.sshURL));
		return ssh_url_element;
		}

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

	public
		  int getId ()
		{
		return this.id;
		}

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

	public
		  String getName ()
		{
		return this.name;
		}

	public
		  void setName (String name)
		{
		this.name = name;
		return;
		}

	public
		  String getWebURL ()
		{
		return this.webURL;
		}

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

	public
		  String getSshURL ()
		{
		return this.sshURL;
		}

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

	public
		  int getNbCommits ()
		{
		return this.nbCommits;
		}

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

	public
		  HashMap<String, ArrayList<Member>> getLstMembers ()
		{
		return this.lstMembers;
		}

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
