package com.samnang.entites;

public class Pays {	
            // attribut(s)
    private int id;
    private String nom;
    private String ville;
            // methode(s)
    // constructeur(s)
    public Pays() {
        this(1, "no name", "no city");
    }	
    public Pays(int id, String nom, String ville) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
    }    
    // accesseur(s)
    public int getId()  {
        return this.id;
    }
    public String getNom() {
        return this.nom;
    }
    public String getVille() {
        return this.ville;
    }
    // mutateur(s)  
    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }    
}