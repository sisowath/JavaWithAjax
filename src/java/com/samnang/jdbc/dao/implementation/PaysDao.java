package com.samnang.jdbc.dao.implementation;

import com.samnang.entites.Pays;
import com.samnang.jdbc.dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PaysDao extends Dao<Pays> {

    public PaysDao(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Pays x) {
        String req = "INSERT INTO pays (`nom`, `ville`) VALUES ('" + x.getNom() + "','" +  x.getVille() + "'";
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
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

    @Override
    public boolean delete(Pays x) {        
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM pays WHERE id = " + x.getId());
            if (n > 0) {
                stm.close();
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

    @Override 
    public Pays read(String username) {        
        PreparedStatement stm = null;
        try {            
            stm = cnx.prepareStatement("SELECT * FROM pays WHERE nom = ?");
            stm.setString(1,username);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Pays c = new Pays();
                c.setId(r.getInt("id"));
                c.setNom(r.getString("nom"));
                c.setVille(r.getString("ville"));        
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
    public boolean update(Pays x) {
        Statement stm = null;
        try {
            String req =    "UPDATE pays SET nom = '" + x.getNom() + "', ville = '" + x.getVille() + " WHERE id = " + x.getId();
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
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

    @Override
    public List<Pays> findAll() {
        List<Pays> liste = new LinkedList<Pays>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM pays GROUP BY nom");
            while (r.next()) {
                Pays c = new Pays(r.getInt("id"), r.getString("nom"), r.getString("ville"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
            
        }
        return liste;
    }
    public List<Pays> findAllCity(String nom) {
        List<Pays> liste = new LinkedList<Pays>();
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM pays WHERE nom = ?");
            stm.setString(1, nom);
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Pays c = new Pays(r.getInt("id"), r.getString("nom"), r.getString("ville"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
            
        }
        return liste;
    }
}