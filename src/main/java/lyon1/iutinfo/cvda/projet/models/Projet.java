/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet.models;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Bastien BOMBARDELLA
 */
public class Projet {
    
    protected int id;
    protected String nom;
    protected String webURL;
    protected String sshURL;
    protected int nbCommits;
    protected HashMap<String, ArrayList<Membre>> lstMembres;
    
}
