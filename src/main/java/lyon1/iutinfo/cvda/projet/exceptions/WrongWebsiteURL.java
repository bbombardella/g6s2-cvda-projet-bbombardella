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
	  class WrongWebsiteURL extends Exception {

	public
		  WrongWebsiteURL() {
		super("L'adresse du site web n'a pas de format correct");
	}
}
