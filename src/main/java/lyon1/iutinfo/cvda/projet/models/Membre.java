/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet.models;

import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Bastien BOMBARDELLA
 */
public class Membre {
    
    protected int id;
    protected String nom;
    protected String email;
    protected String website;
    protected HashMap<String, ArrayList<Projet>> lstProjets;
    
}
