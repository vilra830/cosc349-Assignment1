/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.Product;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author villa
 */
public class DAOTest {
    
  //private DAO dao = new DAO();
    
    private DAOInterface dao = new ProductDBManager("jdbc:h2:mem:tests;INIT=runscript from 'src/main/resources/schema.sql'");
    private Product prodOne;
    private Product prodTwo;
    private Product prodThree;
    private Product prodFour;


    
    
    
    public DAOTest() {
    }
    
    
    @Before
    public void setUp() {
       this.prodOne = new Product("1", "name1",  "desc1", "cat1", new BigDecimal("11.00"), new BigDecimal("22.00"));
       this.prodTwo = new Product("2", "name2",  "desc2", "cat2",new BigDecimal("33.00"), new BigDecimal("44.00"));
       this.prodThree = new Product("3", "name3",  "desc3", "cat3",new BigDecimal("55.00"), new BigDecimal("66.00"));
        // save the products

        dao.saveProduct(prodOne);
        dao.saveProduct(prodTwo);
//        System.out.println(prodOne.toString());


String[] stringArray = {"1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "20"};
System.out.println(stringArray.toString());
    }
    
    @After
    public void tearDown() {
        dao.deleteProduct(prodOne);
        dao.deleteProduct(prodTwo);
        dao.deleteProduct(prodThree);

        
    }

    @Test
    public void testSaveProduct() {

        

        
        // save the product using the DAO
        
        
    dao.saveProduct(prodThree);
// ensure that the data store includes the product
    assertTrue("Ensure that the product was saved",dao.getProducts().contains(prodThree));
//    assertTrue("Ensure that the product was saved",dao.getCategories().contains(prodThree.getProductCategory()));
    
    }
    
   // dao.saveProduct(prodThree.getProductCategory());
    @Test
    public void testGetProducts() {
    Collection<Product> products = dao.getProducts();
        System.out.println(products.toString());

    // ensure the result includes the two saved products
    assertTrue("prodOne should exist", products.contains(prodOne));
    assertTrue("prodTwo should exist", products.contains(prodTwo));
        assertFalse("prodThree should not exist", products.contains(prodThree));

    // ensure the result ONLY includes the two saved products
    assertEquals("Only 3 products in result", 2, products.size());
    

    }
    
    @Test
    public void testGetCategories(){
        
    Collection<String> categoryList = dao.getCategories();

        //ensure the result includes the two saved categories
        
        assertTrue("Prod1's cat is cat1", categoryList.contains("cat1"));

        assertTrue("cat1 should exist", categoryList.contains(prodOne.getProductCategory()));
        assertTrue("cat2 should exist", categoryList.contains(prodTwo.getProductCategory()));
        
       assertEquals("Only 2 categories in result", 2, categoryList.size());
        
       assertEquals("Prod2's cat is cat2", prodTwo.getProductCategory(), "cat2");
        
    }
    @Test
    public void testDeleteProduct() {
        
       // sanity check to make sure prodOne does exist before we delete it
        
    
        assertTrue("Ensure that the product does exist",dao.getProducts().contains(prodOne));
     

        // delete the product via the DAO
        dao.deleteProduct(prodOne);
        // ensure that the product no longer exists
       assertFalse("Ensure that the product does not exist",dao.getProducts().contains(prodOne));
    
       assertNull("prodOne should no longer exist", dao.searchProduct("1"));
   }
    
     @Test
    public void testSearchProduct() {
        
        Product searchedProduct1 =  dao.searchProduct("5");
        
        assertEquals(null, searchedProduct1);
        
        Product searchedProduct =  dao.searchProduct("2");
        
        assertEquals(prodTwo, searchedProduct);
        
      
        
        
        
        
        
    }
    
     @Test
    public void testFilterCategory() {
        
        Collection<Product> filteredProducts =  dao.filterCategory("cat2");
        
        assertTrue("prodTwo should be in the list", filteredProducts.contains(prodTwo));
        assertFalse("prodOne should not be in the list", filteredProducts.contains(prodOne));

   
        
    }
    

}




































