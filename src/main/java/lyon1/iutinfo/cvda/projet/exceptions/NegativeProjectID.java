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
	  class NegativeProjectID extends Exception
	{

	public
		  NegativeProjectID()
		{
		super("L'ID du projet ne doit pas être négatif ou nul.");
		}
	}
