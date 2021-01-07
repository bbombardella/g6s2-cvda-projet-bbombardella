/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet.models;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Bastien BOMBARDELLA
 */
public
	  class Projet
	{

	protected
		  int id;
	protected
		  String nom;
	protected
		  String webURL;
	protected
		  String sshURL;
	protected
		  int nbCommits;
	protected
		  HashMap<String, ArrayList<Membre>> lstMembres;

	public
		  Projet ()
		{
		id = 0;
		nom = "";
		webURL = "";
		sshURL = "";
		nbCommits = 0;
		lstMembres = null;
		}

	public
		  Projet (int i, String n, String wURL, String sURL, int nCommits)
		{
		id = i;
		nom = n;
		webURL = wURL;
		sshURL = sURL;
		nbCommits = nCommits;
		lstMembres = new HashMap<>();
		}

	public
		  String toString ()
		{
		int nbMembre = 0;
		String membreInfo = "";
		for (ArrayList<Membre> list : lstMembres.values())
			{
			nbMembre += list.size();
			for (Membre m : list)
				{
				membreInfo += "-\t#" + m.getId() + ": " + m.getNom() + " (" + m.getNbProjets() + " projets)\n";
				}
			}
		String info = "Projet id #" + id
			  + "\nNom : \"" + nom + "\""
			  + "\nsshURL : \"" + sshURL + "\""
			  + "\nwebURL : \"" + webURL + "\""
			  + "\nCommits : " + nbCommits
			  + "\nMembres (" + nbMembre + ")"
			  + "\n" + membreInfo;
		return (info);
		}

	public
		  String toXML ()
		{
		String testXML = "";
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
			nomElement.appendChild(doc.createTextNode(this.nom));
			rootElement.appendChild(nomElement);

			Element webURLElement = doc.createElement("webURL");
			webURLElement.appendChild(doc.createTextNode(this.webURL));
			rootElement.appendChild(webURLElement);

			Element sshURLElement = doc.createElement("sshURL");
			sshURLElement.appendChild(doc.createTextNode(this.sshURL));
			rootElement.appendChild(sshURLElement);

			Element membresElement = doc.createElement("membres");
			rootElement.appendChild(membresElement);

			for (Entry<String, ArrayList<Membre>> list : lstMembres.entrySet())
				{
				for (Membre m : list.getValue())
					{
					Element membreElement = doc.createElement("membre");
					membreElement.setAttribute("id", String.valueOf(m.getId()));
					membreElement.setAttribute("role", list.getKey());

					Element nomElement2 = doc.createElement("nom");
					nomElement2.appendChild(doc.createTextNode(m.getNom()));
					membreElement.appendChild(nomElement2);

					Element nbProjetsElement = doc.createElement("nb-projets");
					nbProjetsElement.appendChild(doc.createTextNode(String.valueOf(m.getNbProjets())));
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
			testXML = stringWriter.toString();
			return testXML;
			}
		catch (Exception e)
			{
			System.out.println(e.getMessage());
			}
		finally
			{
			return testXML;
			}
		}

	public
		  int getId ()
		{
		return id;
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
		}

	public
		  String getNom ()
		{
		return nom;
		}

	public
		  void setNom (String nom)
		{
		this.nom = nom;
		}

	public
		  String getWebURL ()
		{
		return webURL;
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
		}

	public
		  String getSshURL ()
		{
		return sshURL;
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
		}

	public
		  int getNbCommits ()
		{
		return nbCommits;
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
		}

	public
		  HashMap<String, ArrayList<Membre>> getLstMembres ()
		{
		return lstMembres;
		}

	public
		  void setLstMembres (HashMap<String, ArrayList<Membre>> lstMembres) throws AnyMaintainerAvailable
		{
		if (lstMembres.containsKey("Maintainer") && lstMembres.get("Maintainer").size() > 0)
			{
			this.lstMembres = lstMembres;
			}
		else
			{
			throw new AnyMaintainerAvailable();
			}
		}

	public
		  int getNbMembres ()
		{
		int nbMembres = 0;
		for (ArrayList<Membre> listMembre : lstMembres.values())
			{
			nbMembres += listMembre.size();
			}
		return nbMembres;
		}

	}
