package com.samnang.entites;

public class Utilisateur {
        // attribut(s)
    private int id;
    private String nom;
    private String prenom;
    private String etat;
        // methode(s)
    // constructeur(s)
    public Utilisateur(int id, String nom, String prenom, String etat) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.etat = etat;
    }
    public Utilisateur() {
        this(1, "no nom", "no prenom", "no etat");
    }
    // accesseur(s)
    public int getId() { return this.id; }
    public String getNom() { return this.nom; }
    public String getPrenom() { return this.prenom; }
    public String getEtat() { return this.etat; }
    // mutateur(s)
    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setEtat(String etat) { this.etat = etat; }
    // autre(s)
    public String toString() {
        return id + " :: " + nom + " :: " + prenom + " :: " + etat; 
    }
}
