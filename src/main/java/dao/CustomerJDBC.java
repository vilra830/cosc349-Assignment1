/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author villa
 */
public class CustomerJDBC implements CustomerDAO {
    
    private String databaseURI = DbConnection.getDefaultConnectionUri();

    public CustomerJDBC() {
    }
       
    public CustomerJDBC(String databaseURI) {
        this.databaseURI = databaseURI;
    }

    @Override
    public void save(Customer customer) {
        
        String sql = "insert into Customer (customerID , firstname, surname , password, username , emailAddress , shippingAddress) values (?,?,?,?,?,?,?)"; 
        
    try (
        // get connection to database
        Connection dbCon = DbConnection.getConnection(databaseURI);

        // create the statement
        PreparedStatement stmt = dbCon.prepareStatement(sql);
    ) { 
        
        stmt.setInt(1, customer.getCustomerID());
        stmt.setString(2, customer.getFirstname());
        stmt.setString(3, customer.getSurname());
        stmt.setString(4, customer.getPassword());      
        stmt.setString(5, customer.getUsername());
        stmt.setString(6, customer.getEmailAddress());
        stmt.setString(7, customer.getShippingAddress());


        stmt.executeUpdate();  // execute the statement
    }catch (SQLException ex) {
        throw new DAOException(ex.getMessage(), ex);
    }
        
    }

    @Override
    public Customer getCustomer(String user) {
         String sql = "select * from Customer where username = ?"; 
        
    try (
        // get connection to database
        Connection dbCon = DbConnection.getConnection(databaseURI);

        // create the statement
        PreparedStatement stmt = dbCon.prepareStatement(sql);
    ) { 
        
        stmt.setString(1, user);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()) {
            
             Integer customerID = rs.getInt("customerID");
             String firstname = rs.getString("firstname"); 
             String surname = rs.getString("surname");
             String password = rs.getString("password");
             String username = rs.getString("username");
             String emailAddress = rs.getString("emailAddress");
             String shippingAddress = rs.getString("shippingAddress");
           
            return new Customer (customerID , firstname , surname , password , username , emailAddress, shippingAddress); 
           
        } else {
            return null;
        }
            
        } catch (SQLException ex) {
        throw new DAOException(ex.getMessage(), ex);
    }
 
    }
        
        
      
        
    

    @Override
    public Boolean validateCredentials(String username, String password) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       String sql = "select * from Customer where username = ? and password = ? "; 
        
    try (
        // get connection to database
        Connection dbCon = DbConnection.getConnection(databaseURI);

        // create the statement
        PreparedStatement stmt = dbCon.prepareStatement(sql);
    ) { 
        
        stmt.setString(1, username);
        stmt.setString(1, password);

        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()) {
            return true;
        } else {
            return false;
        }
            
        } catch (SQLException ex) {
        throw new DAOException(ex.getMessage(), ex);
    }
    }
    
    
    
}




