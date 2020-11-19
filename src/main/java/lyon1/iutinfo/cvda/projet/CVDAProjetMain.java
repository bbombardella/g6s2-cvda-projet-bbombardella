/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet;

import lyon1.iutinfo.cvda.projet.models.*;

/**
 *
 * @author Bastien BOMBARDELLA
 */
public class CVDAProjetMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
        
        
    }
    
}
