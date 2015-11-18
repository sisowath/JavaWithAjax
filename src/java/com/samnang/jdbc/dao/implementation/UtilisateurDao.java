package com.samnang.jdbc.dao.implementation;

import com.samnang.entites.Utilisateur;
import com.samnang.jdbc.dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UtilisateurDao extends Dao<Utilisateur> {

    public UtilisateurDao(Connection c) {
        super(c);
    }
// C R E A T E
    @Override
    public boolean create(Utilisateur x) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("INSERT INTO utilisateur VALUES (?, ?)");
            stm.setString(1, x.getNom() );
            stm.setString(2, x.getPrenom() );
            ResultSet r = stm.executeQuery();
            if ( r.next() ) {
                stm.close();
                cnx.close();
                return true;
            }
        } catch (SQLException exp) {
			
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {                
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
// R E A D
    @Override 
    public Utilisateur read(String nom) {        
        PreparedStatement stm = null;
        try {            
            stm = cnx.prepareStatement("SELECT * FROM utilisateur WHERE nom = ?");
            stm.setString(1,nom);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Utilisateur c = new Utilisateur();
                c.setId(r.getInt("id"));
                c.setNom(r.getString("nom"));
                c.setPrenom( r.getString("prenom") );
                c.setEtat( r.getString("etat") );
                r.close();
                stm.close();
                return c;
            }
        } catch (SQLException exp) {
			
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {            
                    e.printStackTrace();
                }
            }
        }
        return null;
    }       
// U P D A T E    
    @Override
    public boolean update(Utilisateur x) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("UPDATE utilisateur SET nom = ?, prenom = ?, etat = ? WHERE id = ?");
            stm.setString(1, x.getNom() );
            stm.setString(2, x.getPrenom() );
            stm.setString(3, x.getEtat() );
            stm.setInt(4, x.getId() );
            ResultSet r = stm.executeQuery();
            if ( r.next() ) {
                stm.close();
                cnx.close();
                r.close();
                return true;
            }
        } catch (SQLException exp) {
			
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {            
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
// D E L E T E
    @Override
    public boolean delete(Utilisateur x) {        
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("DELETE FROM utilisateur WHERE id = ?");
            stm.setInt(1, x.getId() );
            ResultSet r = stm.executeQuery();
            if ( r.next() ) {
                stm.close();
                cnx.close();
                return true;
            }
        } catch (SQLException exp) {
        
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }    
// F I N D A L L
    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> liste = new LinkedList<Utilisateur>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM utilisateur");
            while (r.next()) {
                Utilisateur c = new Utilisateur(r.getInt("id"), r.getString("nom"), r.getString("prenom"), r.getString("etat") );
                liste.add(c);
            }
            r.close();
            stm.close();
            return liste;
        } catch (SQLException exp) {
            
        }
        return null;
    }
    public List<Utilisateur> findAllActive() {
        List<Utilisateur> liste = new LinkedList<Utilisateur>();
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM utilisateur WHERE etat = ?");
            stm.setString(1, "active");
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Utilisateur c = new Utilisateur(r.getInt("id"), r.getString("nom"), r.getString("prenom"), r.getString("etat") );
                liste.add(c);
            }
            r.close();
            stm.close();
            //cnx.close();
            return liste;
        } catch (SQLException exp) {
            
        }
        return null;
    }
}