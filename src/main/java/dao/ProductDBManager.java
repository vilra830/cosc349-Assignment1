/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author vilra830
 */


public class ProductDBManager implements DAOInterface {
    
     
    private String databaseURI = DbConnection.getDefaultConnectionUri();

    public ProductDBManager() {
    }
       
    public ProductDBManager(String databaseURI) {
        this.databaseURI = databaseURI;
    }
    
     @Override
    public void saveProduct(Product product) {
    
     
    String sql = "insert into Product (productID , productName, productDescription ,productCategory, stockQuantity,priceList) values (?,?,?,?,?,?)"; 
        
    try (
        // get connection to database
        Connection dbCon = DbConnection.getConnection(databaseURI);

        // create the statement
        PreparedStatement stmt = dbCon.prepareStatement(sql);
    ) { 
        
        stmt.setString(1, product.getProductID());
        stmt.setString(2, product.getProductName());
        stmt.setString(3, product.getProductDescription());
        stmt.setString(4, product.getProductCategory());      
        stmt.setBigDecimal(5, product.getStockQuantity());
        stmt.setBigDecimal(6, product.getPriceList());

        stmt.executeUpdate();  // execute the statement
    }catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
        
      
}

    @Override
    public Collection<Product> getProducts(){
       

    String sql = "select * from Product order by productID";

    try (
        // get a connection to the database
        Connection dbCon = DbConnection.getConnection(databaseURI);

        // create the statement
        PreparedStatement stmt = dbCon.prepareStatement(sql);
    ) {
        // execute the query
        ResultSet rs = stmt.executeQuery();

        // Using a List to preserve the order in which the data was returned from the query.
        ArrayList<Product> products = new ArrayList<>();

        // iterate through the query results
        while (rs.next()) {

            // get the data out of the query

             String productID = rs.getString("productID");
             String productName = rs.getString("productName"); 
             String productDescription = rs.getString("productDescription");
             String productCategory = rs.getString("productCategory");
             BigDecimal priceList = rs.getBigDecimal("priceList");
             BigDecimal stockQuantity = rs.getBigDecimal("stockQuantity");
            
            // use the data to create a student object
            Product p = new Product (productID , productName , productDescription , productCategory , priceList , stockQuantity); 
            // and put it in the collection
            products.add(p);
        }

        return products;

    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
}

    @Override
    public void deleteProduct(Product product) {
        String sql = "delete from Product where productID = ?"; 
        
    try (
        // get connection to database
        Connection dbCon = DbConnection.getConnection(databaseURI);

        // create the statement
        PreparedStatement stmt = dbCon.prepareStatement(sql);
    ) { 
        
        stmt.setString(1, product.getProductID());


        stmt.executeUpdate();  // execute the statement
    }catch (SQLException ex) {
        //throw new RuntimeException(ex);
    }
        
    }

    @Override
    public Collection<Product> filterCategory(String category) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String sql = "select * from Product where productCategory = ?"; 
        
    try (
        // get connection to database
        Connection dbCon = DbConnection.getConnection(databaseURI);

        // create the statement
        PreparedStatement stmt = dbCon.prepareStatement(sql);
    ) { 
        
        stmt.setString(1, category);
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Product> productList = new ArrayList<>();
        
        while(rs.next()) {
            
             String productID = rs.getString("productID");
             String productName = rs.getString("productName"); 
             String productDescription = rs.getString("productDescription");
             String productCategory = rs.getString("productCategory");
             BigDecimal priceList = rs.getBigDecimal("priceList");
             BigDecimal stockQuantity = rs.getBigDecimal("stockQuantity");
            
           
            Product product = new Product (productID , productName , productDescription , productCategory , priceList , stockQuantity); 
            
            productList.add(product);
        } 
            return productList;
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    
    
    
    }

    
    
    
    
    @Override
    public Collection<String> getCategories() {
        String sql = "select distinct productCategory from Product order by productCategory";

    try (
        // get a connection to the database
        Connection dbCon = DbConnection.getConnection(databaseURI);

        // create the statement
        PreparedStatement stmt = dbCon.prepareStatement(sql);
    ) {
        // execute the query
        ResultSet rs = stmt.executeQuery();

        // Using a List to preserve the order in which the data was returned from the query.
        ArrayList<String> categories = new ArrayList<>();

        // iterate through the query results
        while (rs.next()) {

            // get the data out of the query
        
             String productCategory = rs.getString("productCategory");
             categories.add(productCategory);
        }

        return categories;   
        
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }

        
    }

    @Override
    public Product searchProduct(String id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     String sql = "select * from Product where productID = ?"; 
        
    try (
        // get connection to database
        Connection dbCon = DbConnection.getConnection(databaseURI);

        // create the statement
        PreparedStatement stmt = dbCon.prepareStatement(sql);
    ) { 
        
        stmt.setString(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()) {
            
             String productID = rs.getString("productID");
             String productName = rs.getString("productName"); 
             String productDescription = rs.getString("productDescription");
             String productCategory = rs.getString("productCategory");
             BigDecimal priceList = rs.getBigDecimal("priceList");
             BigDecimal stockQuantity = rs.getBigDecimal("stockQuantity");
            
           
            return new Product (productID , productName , productDescription , productCategory , priceList , stockQuantity); 
           
        } else {
            return null;
        }
            
        } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
 
    }


}


















