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
	  class WrongSshURL extends Exception
	{

	public
		  WrongSshURL()
		{
		super("L'adresse SSH n'a pas un format correct.");
		}
	}
