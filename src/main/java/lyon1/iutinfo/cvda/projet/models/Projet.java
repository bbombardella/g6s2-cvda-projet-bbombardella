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
    
    public Projet(int i, String n, String wURL, String sURL, int nCommits) {
        id=i;
        nom=n;
        webURL=wURL;
        sshURL=sURL;
        nbCommits=nCommits;
        lstMembres=new HashMap<>();
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

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public String getSshURL() {
        return sshURL;
    }

    public void setSshURL(String sshURL) {
        this.sshURL = sshURL;
    }

    public int getNbCommits() {
        return nbCommits;
    }

    public void setNbCommits(int nbCommits) {
        this.nbCommits = nbCommits;
    }

    public HashMap<String, ArrayList<Membre>> getLstMembres() {
        return lstMembres;
    }

    public void setLstMembres(HashMap<String, ArrayList<Membre>> lstMembres) {
        this.lstMembres = lstMembres;
    }
    
}
