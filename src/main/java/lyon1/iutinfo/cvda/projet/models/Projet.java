/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

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
    
    public Projet() {
        id=0;
        nom="";
        webURL="";
        sshURL="";
        nbCommits=0;
        lstMembres=null;        
    }
    
    public Projet(int i, String n, String wURL, String sURL, int nCommits) {
        id=i;
        nom=n;
        webURL=wURL;
        sshURL=sURL;
        nbCommits=nCommits;
        lstMembres=new HashMap<>();
    }
    
    public String toString() {
        int nbMembre=0;
        String membreInfo = "";
        for(ArrayList<Membre> list : lstMembres.values()) {
            nbMembre+=list.size();
            for(Membre m : list) {
                membreInfo+="-\t#"+m.getId()+": "+m.getNom()+" ("+m.getNbProjets()+" projets)\n";
            }
        }
        String info = "Projet id #"+id
                + "\nNom : \""+nom+"\""
                + "\nsshURL : \""+sshURL+"\""
                + "\nwebURL : \""+webURL+"\""
                + "\nCommits : "+nbCommits
                + "\nMembres ("+nbMembre+")"
                + "\n"+membreInfo;
        return(info);
    }
    
    public String toXML() {
        String xml = "<projet id=\""+this.id+"\" nbcommits=\""+this.nbCommits+"\">"
                + "\n\t<nom>"+this.nom+"</nom>"
                + "\n\t<webURL>"+this.webURL+"</webURL>"
                + "\n\t<sshURL>"+this.sshURL+"</sshURL>"
                + "\n\t<membres>";
        for(Entry<String, ArrayList<Membre>> entry : lstMembres.entrySet())  {
            for(Membre m : entry.getValue()) {
                xml += "\n\t\t<membre id=\""+m.getId()+"\" role=\""+entry.getKey()+"\">"
                        + "\n\t\t\t<nom>"+m.getNom()+"</nom>"
                        + "\n\t\t\t<nb-projets>"+m.getNbProjets()+"</nb-projets>"
                        + "\n\t\t</membre>";
            }
        }
        xml+= "\n\t</membres>"
                +"\n</projet>";
        return xml;
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
    
    public int getNbMembres() {
        int nbMembres=0;
        for(ArrayList<Membre> listMembre : lstMembres.values()) {
            nbMembres+=listMembre.size();
        }
        return nbMembres;
    }
    
}
