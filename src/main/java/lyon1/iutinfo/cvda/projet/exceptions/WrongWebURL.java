/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet.exceptions;

/**
 *
 * @author Bastien BOMBARDELLA
 */
public
	  class WrongWebURL extends Exception
	{

	public
		  WrongWebURL()
		{
		super("L'URL de l'adresse web doit commencer par 'https' et doit se finir par '.git'.");
		}
	}
