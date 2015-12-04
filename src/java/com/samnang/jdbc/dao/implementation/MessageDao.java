package com.samnang.jdbc.dao.implementation;

import com.samnang.entites.Message;
import com.samnang.jdbc.dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class MessageDao extends Dao<Message> {
    
    public MessageDao(Connection c) {
        super(c);
    }
// C R E A T E
    @Override
    public boolean create(Message x) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("INSERT INTO message (messagesend) VALUES (?) ");
            //stm.setInt(1, x.getId() );
            stm.setString(1, x.getMessage() );
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
    public boolean create(String m) {
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("INSERT INTO message(messagesend) VALUES('" + m + "')");
            if ( n > 0 ) {
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
    public Message read(String nom) {        
        /*
        PreparedStatement stm = null;
        try {            
            stm = cnx.prepareStatement("SELECT * FROM message WHERE id = ?");
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
        */
        return null;
    }       
// U P D A T E    
    @Override
    public boolean update(Message x) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("UPDATE message SET messagesend = ? WHERE id = ?");
            stm.setString(1, x.getMessage() );
            stm.setInt(2, x.getId() );
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
    public boolean delete(Message x) {        
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("DELETE FROM message WHERE id = ?");
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
    public List<Message> findAll() {
        List<Message> liste = new LinkedList<Message>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM message");
            while (r.next()) {
                Message c = new Message(r.getInt("id"), r.getString("messagesend"));
                liste.add(c);
            }
            r.close();
            stm.close();
            return liste;
        } catch (SQLException exp) {
            
        }
        return null;
    }  
}