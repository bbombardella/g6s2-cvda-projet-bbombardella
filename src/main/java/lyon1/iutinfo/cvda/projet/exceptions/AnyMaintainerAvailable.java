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
	  class AnyMaintainerAvailable extends Exception
	{

	public
		  AnyMaintainerAvailable ()
		{
		super("Le projet ne contient pas de maintainer dans la liste des membres.");
		}
	}
