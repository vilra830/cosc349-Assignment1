/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.HashMultimap;
import dao.DAOInterface;
import domain.Product;
import helpers.SimpleListModel;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Collection;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import static org.assertj.swing.core.matcher.DialogMatcher.withTitle;
import static org.assertj.swing.core.matcher.JButtonMatcher.withText;
import org.assertj.swing.fixture.DialogFixture;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


/**
 *
 * @author villa
 */
public class ProductReportTest {
    
    private DAOInterface dao;
    private DialogFixture fixture;
    private Robot robot;
    
    private Product p1;
    private Product p2;
    
    private static Multimap<String,Product> categories = HashMultimap.create();
    Collection<Product> products = new HashSet<>();
    
    public ProductReportTest() {
    }
    
    @Before
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();      
    
	// Slow down the robot a little bit - default is 30 (milliseconds).
	// Do NOT make it less than 10 or you will have thread-race problems.
	robot.settings().delayBetweenEvents(100);
        
	
	// create a mock for the DAO
	dao = mock(DAOInterface.class);
        
        
           // create a products collection for stubbing purposes
   
   this.p1 = new Product("ID1", "name1",  "desc12", "cat1", new BigDecimal("11.00"), new BigDecimal("22.00"));
   this.p2 = new Product("ID2", "name2",  "desc13", "cat2",  new BigDecimal("11.00"), new BigDecimal("22.00"));
   products.add(p1);
   products.add(p2);

  
   
   categories.put(p1.getProductCategory(), p1);
   categories.put(p2.getProductCategory(), p2);
   
   Collection<Product> categories1 = categories.get("cat1");

   // stub the getProducts method
   when(dao.getProducts()).thenReturn(products);
   
   when(dao.searchProduct("ID1")).thenReturn(p1);
   
   when(dao.getCategories()).thenReturn(categories.keySet());
   
   when(dao.filterCategory("cat1")).thenReturn(categories1);
   
   
   
   // stub the deleteProduct method
   Mockito.doAnswer(new Answer<Void>() {
      @Override
      public Void answer(InvocationOnMock invocation) throws Throwable {
         // remove the product from the collection that getProducts() uses
         products.remove(p1);
         return null;
      }
   }).when(dao).deleteProduct(p1);
   
   
    }
   
    
    
     @After
    public void tearDown() {
        fixture.cleanUp();
    }
    
        @Test
	public void testSearch() {
            
            // create the dialog passing in the mocked DAO
		ProductReport dialog = new ProductReport(null, true, dao);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);
		fixture.show().requireVisible();
                
                fixture.textBox("searchField").enterText("ID1");
                fixture.button("searchButton").click();
                
                verify(dao).searchProduct("ID1");
                
                SimpleListModel model = (SimpleListModel) fixture.list("productList").target().getModel();
             
                
                assertTrue("list contains p1", model.contains(p1));
                assertFalse("list contains p2", model.contains(p2));
                assertEquals("list contains the correct number of products", 1, model.getSize());
        }   
        
    /**
     *
     */
    @Test
	public void testView() {
            
            // create the dialog passing in the mocked DAO
		ProductReport dialog = new ProductReport(null, true, dao);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);
		fixture.show().requireVisible();
                              
                SimpleListModel model = (SimpleListModel) fixture.list("productList").target().getModel();
             
                
                assertTrue("list contains p1", model.contains(p1));
                assertTrue("list contains p2", model.contains(p2));
                assertEquals("list contains the correct number of products", 2, model.getSize());
        }   

    
    @Test
	public void testgetCategories() {
            
            // create the dialog passing in the mocked DAO
		ProductReport dialog = new ProductReport(null, true, dao);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);
		fixture.show().requireVisible();
                
                SimpleListModel model = (SimpleListModel) fixture.comboBox("filterCategoryBox").target().getModel();

                           
                
                assertTrue("list contains cat1", model.contains("cat1"));
                assertTrue("list contains cat2", model.contains("cat2"));
                assertEquals("list contains the correct number of categories", 2, model.getSize());
                
                //fixture.comboBox("filterCategoryBox").selectItem("cat1");
                
                
        
        }   
    
        @Test
	public void testFilterCategory() {
            
            // create the dialog passing in the mocked DAO
		ProductReport dialog = new ProductReport(null, true, dao);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);
		fixture.show().requireVisible();
                
                //SimpleListModel model = (SimpleListModel) fixture.comboBox("filterCategoryBox").target().getModel();

                
                fixture.comboBox("filterCategoryBox").selectItem("cat1");
                

                verify(dao).filterCategory("cat1");
                
                
                SimpleListModel model = (SimpleListModel) fixture.list("productList").target().getModel();

                
                
                assertTrue("list contains p1", model.contains(p1));
                assertEquals("list contains the correct number of products", 1, model.getSize());
        }   
        
        
        @Test
	public void testDelete() {
            
            // create the dialog passing in the mocked DAO
		ProductReport dialog = new ProductReport(null, true, dao);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);
		fixture.show().requireVisible();
                // select item to delete in the list
                

                fixture.list("productList").selectItem(p1.toString());
                
                // click the delete button
                fixture.button("deleteButton").click();
 
                // ensure a confirmation dialog is displayed
                DialogFixture confirmDialog = fixture.dialog(withTitle("confirm").andShowing()).requireVisible();

                // click the Yes button on the confirmation dialog
                confirmDialog.button(withText("Yes")).click();
                
                verify(dao).deleteProduct(p1);
                
                SimpleListModel model = (SimpleListModel) fixture.list("productList").target().getModel();

                
                
                assertFalse("list contains p1", model.contains(p1));
                assertEquals("list contains the correct number of products", 1, model.getSize());
        }   

    
}


























































