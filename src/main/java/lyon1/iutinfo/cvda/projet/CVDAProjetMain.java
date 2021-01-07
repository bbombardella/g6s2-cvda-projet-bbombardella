/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet;

import java.util.ArrayList;
import java.util.HashMap;
import lyon1.iutinfo.cvda.projet.models.*;

/**
 *
 * @author Bastien BOMBARDELLA
 */
public
	  class CVDAProjetMain
	{

	/**
	 * @param args the command line arguments
	 */
	public static
		  void main(String[] args)
		{

		try
			{
			//Création de 2 membres et de 2 projets vides
			Membre mb1 = new Membre();
			Membre mb2 = new Membre();
			Projet prj1 = new Projet();
			Projet prj2 = new Projet();

			//Remplissage des propriétés simples du 1er membre
			mb1.setId(1);
			mb1.setNom("QUIROULE Pierre");
			mb1.setEmail("pierre.quiroule@test.com");
			mb1.setWebsite("https://www.pierrequiroule.com/");

			//Remplissage des propriétés simples du 2ème membre
			mb2.setId(2);
			mb2.setNom("DUPONT Jean");
			mb2.setEmail("jean.dupont@test.com");
			mb2.setWebsite("https://www.dupontjean.com/");

			//Remplissage des propriétés simples du 1er projet
			prj1.setId(1);
			prj1.setNom("projet-test-1");
			prj1.setNbCommits(6);
			prj1.setWebURL("https://forge.univ-lyon1.fr/pierrequiroule/projet-test-1");
			prj1.setSshURL("git@forge.univ-lyon1.fr:pierrequiroule/projet-test-1.git");

			//Remplissage des propriétés simples du 2ème projet
			prj2.setId(2);
			prj2.setNom("projet-test-2");
			prj2.setNbCommits(14);
			prj2.setWebURL("https://forge.univ-lyon1.fr/jeandupont/projet-test-2");
			prj2.setSshURL("git@forge.univ-lyon1.fr:jeandupont/projet-test-2.git");

			//Création des ArrayList et ajout des membres
			ArrayList<Membre> maintainer_projet1 = new ArrayList();
			maintainer_projet1.add(mb1);
			maintainer_projet1.add(mb2);

			ArrayList<Membre> maintainer_projet2 = new ArrayList();
			maintainer_projet2.add(mb1);

			ArrayList<Membre> reporter_projet2 = new ArrayList();
			reporter_projet2.add(mb2);

			//Création de la Hashmap du premier projet
			prj1.setLstMembres(new HashMap<String, ArrayList<Membre>>());

			//Ajout de l'ArrayList à la HashMap
			prj1.getLstMembres().put("Maintainer", maintainer_projet1);

			//Création de la HashMap du second projet
			prj2.setLstMembres(new HashMap<String, ArrayList<Membre>>());

			//Ajout des deux ArrayList à la HashMap
			prj2.getLstMembres().put("Maintainer", maintainer_projet2);
			prj2.getLstMembres().put("Reporter", reporter_projet2);

			//Création de la liste des projets de chacun des membres
			ArrayList<Projet> projetMb1 = new ArrayList<Projet>();
			ArrayList<Projet> projetMb2 = new ArrayList<Projet>();

			//Ajout des projets
			projetMb1.add(prj1);
			projetMb1.add(prj2);
			projetMb2.add(prj1);
			projetMb2.add(prj2);

			mb1.setLstProjets(new HashMap<String, ArrayList<Projet>>());
			mb1.getLstProjets().put("Projet 1", projetMb1);

			mb2.setLstProjets(new HashMap<String, ArrayList<Projet>>());
			mb2.getLstProjets().put("Projet 2", projetMb2);

			}
		catch (Exception e)
			{
			System.out.println(e.getMessage());
			}
		}

	}
