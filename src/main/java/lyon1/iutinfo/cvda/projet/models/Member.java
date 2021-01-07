/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet.models;

import java.util.HashMap;
import java.util.ArrayList;
import lyon1.iutinfo.cvda.projet.exceptions.NegativeMemberID;
import lyon1.iutinfo.cvda.projet.exceptions.WrongEmailAddress;
import lyon1.iutinfo.cvda.projet.exceptions.WrongWebsiteURL;

/**
 *
 * @author Bastien BOMBARDELLA
 */
public
	  class Member
	{

	protected
		  int id;
	protected
		  String name;
	protected
		  String email;
	protected
		  String website;
	protected
		  HashMap<String, ArrayList<Project>> lstProjects;

	public
		  Member ()
		{
		this.id = 0;
		this.name = "";
		this.email = "";
		this.website = "";
		this.lstProjects = null;
		}

	public
		  Member (int i, String n, String e, String w)
		{
		this.id = i;
		this.name = n;
		this.email = e;
		this.website = w;
		this.lstProjects = new HashMap<>();
		}

	public
		  String toString ()
		{
		String projects = "";
		for (ArrayList<Project> listProject : lstProjects.values())
			{
			for (Project p : listProject)
				{
				projects += "-\t#" + p.getId() + ": " + p.getName() + " (" + p.getNbMembers() + ")\n";
				}
			}
		String info = "#" + this.id + ": " + this.name
			  + "\nEmail: \"" + this.email + "\""
			  + "\nWebsite : \"" + this.website + "\""
			  + "\nProjets (" + this.getNbProjects() + ")"
			  + "\n" + projects;
		return info;
		}

	public
		  int getId ()
		{
		return this.id;
		}

	public
		  void setId (int id) throws NegativeMemberID
		{
		if (id <= 0)
			{
			throw new NegativeMemberID();
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
		  String getEmail ()
		{
		return this.email;
		}

	public
		  void setEmail (String email) throws WrongEmailAddress
		{
		if (email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
			{
			this.email = email;
			}
		else
			{
			throw new WrongEmailAddress();
			}
		return;
		}

	public
		  String getWebsite ()
		{
		return this.website;
		}

	public
		  void setWebsite (String website) throws WrongWebsiteURL
		{
		if (website.matches("^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"))
			{
			this.website = website;
			}
		else
			{
			throw new WrongWebsiteURL();
			}
		return;
		}

	public
		  HashMap<String, ArrayList<Project>> getLstProjects ()
		{
		return this.lstProjects;
		}

	public
		  void setLstProjects (HashMap<String, ArrayList<Project>> lstProjects)
		{
		this.lstProjects = lstProjects;
		return;
		}

	public
		  int getNbProjects ()
		{
		int nb_projects = 0;
		for (ArrayList<Project> list_project : this.lstProjects.values())
			{
			nb_projects += list_project.size();
			}
		return nb_projects;
		}

	public
		  String toXML ()
		{
		String xml = "<membre id='" + this.getId() + "'>";
		xml += "\n   <nom>" + this.getName() + "</nom>";
		xml += "\n   <email>" + this.getEmail() + "</email>";
		xml += "\n   <website>" + this.getWebsite() + "</website>";
		xml += "\n   <nbprojets>" + this.getNbProjects() + "</nbprojets>";
		xml += "\n</membre>";
		return xml;
		}

	}
