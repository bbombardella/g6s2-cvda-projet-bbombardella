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
    
    public Membre() {
        id=0;
        nom="";
        email="";
        website="";
        lstProjets=null;
    }
    
    public Membre(int i, String n, String e, String w) {
        id=i;
        nom=n;
        email=e;
        website=w;
        lstProjets=new HashMap<>();
    }
    
    public String toString() {
        String projets="";
        for(ArrayList<Projet> listProjet : lstProjets.values()) {
            for(Projet p : listProjet) {
                projets+="-\t#"+p.getId()+": "+p.getNom()+" ("+p.getNbMembres()+")\n";
            }
        }
        String info="#"+id+": "+nom
                + "\nEmail: \""+email+"\""
                + "\nWebsite : \""+website+"\""
                + "\nProjets ("+this.getNbProjets()+")"
                + "\n"+projets;
        return info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public HashMap<String, ArrayList<Projet>> getLstProjets() {
        return lstProjets;
    }

    public void setLstProjets(HashMap<String, ArrayList<Projet>> lstProjets) {
        this.lstProjets = lstProjets;
    }
    
    public int getNbProjets() {
        int nbProjets=0;
        for(ArrayList<Projet> projetList : lstProjets.values()) {
            nbProjets+=projetList.size();
        }
        return nbProjets;
    }
    
}
