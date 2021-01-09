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
	 * the email address
	 */
	protected
		  String email;

	/**
	 * the website URL
	 */
	protected
		  String website;

	/**
	 * the map of role and projects' member
	 */
	protected
		  HashMap<String, ArrayList<Project>> lstProjects;

	/**
	 * constructor having no params
	 */
	public
		  Member ()
		{
		this.id = 0;
		this.name = "";
		this.email = "";
		this.website = "";
		this.lstProjects = null;
		}

	/**
	 * constructor using several params to define a member
	 *
	 * @param i the id
	 * @param n the name
	 * @param e the email address
	 * @param w the website URL
	 */
	public
		  Member (int i, String n, String e, String w)
		{
		this.id = i;
		this.name = n;
		this.email = e;
		this.website = w;
		this.lstProjects = new HashMap<>();
		}

	/**
	 * member's information
	 *
	 * @return a string about member's information
	 */
	public
		  String toString ()
		{
		String info = "#" + this.id + ": " + this.name
			  + "\nEmail: \"" + this.email + "\""
			  + "\nWebsite : \"" + this.website + "\""
			  + "\nProjets (" + this.getNbProjects() + ")"
			  + "\n" + this.getMemberProjects();
		return info;
		}

	/**
	 * get the member's projects
	 *
	 * @return a string of member's projects
	 */
	public
		  String getMemberProjects ()
		{
		String projects = "";
		for (ArrayList<Project> listProject : lstProjects.values())
			{
			for (Project p : listProject)
				{
				projects += "-\t#" + p.getId() + ": " + p.getName() + " (" + p.getNbMembers() + ")\n";
				}
			}
		return projects;
		}

	/**
	 * get the id
	 *
	 * @return an int of the id
	 */
	public
		  int getId ()
		{
		return this.id;
		}

	/**
	 * set the member's id
	 *
	 * @param id the id to set
	 * @throws NegativeMemberID if the id is less than or equals to 0
	 */
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

	/**
	 * get the name
	 *
	 * @return a string of the name
	 */
	public
		  String getName ()
		{
		return this.name;
		}

	/**
	 * set the member's name
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
	 * get the member's email address
	 *
	 * @return a string of an email adress
	 */
	public
		  String getEmail ()
		{
		return this.email;
		}

	/**
	 * set the member's email address
	 *
	 * @param email the email address to set
	 * @throws WrongEmailAddress if the address doesn't look like an email one
	 */
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

	/**
	 * get the website URL
	 *
	 * @return a string of the website URL
	 */
	public
		  String getWebsite ()
		{
		return this.website;
		}

	/**
	 * set the website URL
	 *
	 * @param website the address to set
	 * @throws WrongWebsiteURL if the address doesn't look like an correct one
	 */
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

	/**
	 * get the member's roles and projects
	 *
	 * @return a map of roles and projects
	 */
	public
		  HashMap<String, ArrayList<Project>> getLstProjects ()
		{
		return this.lstProjects;
		}

	/**
	 * set the member's roles and projects
	 *
	 * @param lstProjects the map to set
	 */
	public
		  void setLstProjects (HashMap<String, ArrayList<Project>> lstProjects)
		{
		this.lstProjects = lstProjects;
		return;
		}

	/**
	 * get the member's number of projects
	 *
	 * @return an int of the projects' number
	 */
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

	/**
	 * get the member's information to an XML format
	 *
	 * @return a string of the XML member's information
	 */
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
