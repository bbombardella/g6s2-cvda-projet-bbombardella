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
import javax.xml.transform.Transformer;
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
		String member_info = "";
		for (ArrayList<Member> list : this.lstMembers.values())
			{
			nb_member += list.size();
			for (Member m : list)
				{
				member_info += "-\t#" + m.getId() + ": " + m.getName() + " (" + m.getNbProjects() + " projets)\n";
				}
			}
		String info = "Projet id #" + this.id
			  + "\nNom : \"" + this.name + "\""
			  + "\nsshURL : \"" + this.sshURL + "\""
			  + "\nwebURL : \"" + this.webURL + "\""
			  + "\nCommits : " + this.nbCommits
			  + "\nMembres (" + nb_member + ")"
			  + "\n" + member_info;
		return (info);
		}

	public
		  String toXML ()
		{
		String test_xml = "";
		try
			{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("projet");
			doc.appendChild(rootElement);
			rootElement.setAttribute("id", String.valueOf(this.id));
			rootElement.setAttribute("nbcommits", String.valueOf(this.nbCommits));

			Element nomElement = doc.createElement("nom");
			nomElement.appendChild(doc.createTextNode(this.name));
			rootElement.appendChild(nomElement);

			Element webURLElement = doc.createElement("webURL");
			webURLElement.appendChild(doc.createTextNode(this.webURL));
			rootElement.appendChild(webURLElement);

			Element sshURLElement = doc.createElement("sshURL");
			sshURLElement.appendChild(doc.createTextNode(this.sshURL));
			rootElement.appendChild(sshURLElement);

			Element membresElement = doc.createElement("membres");
			rootElement.appendChild(membresElement);

			for (Entry<String, ArrayList<Member>> list : this.lstMembers.entrySet())
				{
				for (Member m : list.getValue())
					{
					Element membreElement = doc.createElement("membre");
					membreElement.setAttribute("id", String.valueOf(m.getId()));
					membreElement.setAttribute("role", list.getKey());

					Element nomElement2 = doc.createElement("nom");
					nomElement2.appendChild(doc.createTextNode(m.getName()));
					membreElement.appendChild(nomElement2);

					Element nbProjetsElement = doc.createElement("nb-projets");
					nbProjetsElement.appendChild(doc.createTextNode(String.valueOf(m.getNbProjects())));
					membreElement.appendChild(nbProjetsElement);

					membresElement.appendChild(membreElement);
					}
				}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StringWriter stringWriter = new StringWriter();
			StreamResult result = new StreamResult(stringWriter);
			transformer.transform(source, result);
			test_xml = stringWriter.toString();
			return test_xml;
			}
		catch (Exception e)
			{
			System.out.println(e.getMessage());
			}
		finally
			{
			return test_xml;
			}
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
		for (ArrayList<Member> listMembre : lstMembers.values())
			{
			nb_members += listMembre.size();
			}
		return nb_members;
		}

	}
