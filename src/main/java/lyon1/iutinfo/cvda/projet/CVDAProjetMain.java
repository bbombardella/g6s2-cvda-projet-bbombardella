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
		  void main (String[] args)
		{

		try
			{
			//Création de 2 membres et de 2 projets vides
			Member member_1 = new Member();
			Member member_2 = new Member();
			Project project_1 = new Project();
			Project project_2 = new Project();

			//Remplissage des propriétés simples du 1er membre
			member_1.setId(1);
			member_1.setName("QUIROULE Pierre");
			member_1.setEmail("pierre.quiroule@test.com");
			member_1.setWebsite("https://www.pierrequiroule.com/");

			//Remplissage des propriétés simples du 2ème membre
			member_2.setId(2);
			member_2.setName("DUPONT Jean");
			member_2.setEmail("jean.dupont@test.com");
			member_2.setWebsite("https://www.dupontjean.com/");

			//Remplissage des propriétés simples du 1er projet
			project_1.setId(1);
			project_1.setName("projet-test-1");
			project_1.setNbCommits(6);
			project_1.setWebURL("https://forge.univ-lyon1.fr/pierrequiroule/projet-test-1");
			project_1.setSshURL("git@forge.univ-lyon1.fr:pierrequiroule/projet-test-1.git");

			//Remplissage des propriétés simples du 2ème projet
			project_2.setId(2);
			project_2.setName("projet-test-2");
			project_2.setNbCommits(14);
			project_2.setWebURL("https://forge.univ-lyon1.fr/jeandupont/projet-test-2");
			project_2.setSshURL("git@forge.univ-lyon1.fr:jeandupont/projet-test-2.git");

			//Création des ArrayList et ajout des membres
			ArrayList<Member> maintainer_projet_1 = new ArrayList();
			maintainer_projet_1.add(member_1);
			maintainer_projet_1.add(member_2);

			ArrayList<Member> maintainer_projet_2 = new ArrayList();
			maintainer_projet_2.add(member_1);

			ArrayList<Member> reporter_projet_2 = new ArrayList();
			reporter_projet_2.add(member_2);

			//Création de la Hashmap du premier projet
			project_1.setLstMembers(new HashMap<String, ArrayList<Member>>());

			//Ajout de l'ArrayList à la HashMap
			project_1.getLstMembers().put("Maintainer", maintainer_projet_1);

			//Création de la HashMap du second projet
			project_2.setLstMembers(new HashMap<String, ArrayList<Member>>());

			//Ajout des deux ArrayList à la HashMap
			project_2.getLstMembers().put("Maintainer", maintainer_projet_2);
			project_2.getLstMembers().put("Reporter", reporter_projet_2);

			//Création de la liste des projets de chacun des membres
			ArrayList<Project> projetMb1 = new ArrayList<Project>();
			ArrayList<Project> projetMb2 = new ArrayList<Project>();

			//Ajout des projets
			projetMb1.add(project_1);
			projetMb1.add(project_2);
			projetMb2.add(project_1);
			projetMb2.add(project_2);

			member_1.setLstProjects(new HashMap<String, ArrayList<Project>>());
			member_1.getLstProjects().put("Projet 1", projetMb1);

			member_2.setLstProjects(new HashMap<String, ArrayList<Project>>());
			member_2.getLstProjects().put("Projet 2", projetMb2);

			}
		catch (Exception e)
			{
			System.out.println(e.getMessage());
			}
		}

	}
