/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DAOInterface;
import domain.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author vilra830
 */
public class ProductEditorTest {
    
    private DAOInterface dao;
    private DialogFixture fixture;
    private Robot robot;
    
    @Before
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();      
    
	// Slow down the robot a little bit - default is 30 (milliseconds).
	// Do NOT make it less than 10 or you will have thread-race problems.
	robot.settings().delayBetweenEvents(75);
        
  

        // add some majors for testing with
        Collection<String> categories = new ArrayList<>();
        categories.add("cat1");
        categories.add("cat2");
        categories.add("cat3");

	
	// create a mock for the DAO
	dao = mock(DAOInterface.class);

	// stub the getMajors method to return the test majors
	when(dao.getCategories()).thenReturn(categories);
	
    }
        
        

    
    
    @After
    public void tearDown() {
        fixture.cleanUp();
    }

   @Test
	public void testSave() {
            
            // create the dialog passing in the mocked DAO
		ProductEditor dialog = new ProductEditor(null, true, dao);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);
		fixture.show().requireVisible();

		// enter some details into the UI components
		fixture.textBox("idField").enterText("1234");
		fixture.textBox("nameField").enterText("Jack");
		fixture.comboBox("categoryBox").selectItem("cat1");
                fixture.textBox("descriptionField").enterText("desc01");
                fixture.textBox("priceField").enterText("12.34");
                fixture.textBox("stockQuantityField").enterText("1231");

		// click the save button
		fixture.button("saveButton").click();

		// create a Mockito argument captor to use to retrieve the passed student from the mocked DAO
		ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);

		// verify that the DAO.save method was called, and capture the passed student
		verify(dao).saveProduct(argument.capture());

		// retrieve the passed student from the captor
		Product savedProduct = argument.getValue();

		// test that the student's details were properly saved
		assertEquals("Ensure the ID was saved", "1234", savedProduct.getProductID());
		assertEquals("Ensure the name was saved", "Jack", savedProduct.getProductName());
		assertEquals("Ensure the major was saved", "cat1", savedProduct.getProductCategory());
                assertEquals("Ensure the description was saved", "desc01", savedProduct.getProductDescription());
                assertEquals("Ensure the price was saved", new BigDecimal("12.34"), savedProduct.getPriceList());
		assertEquals("Ensure the quantity was saved", new BigDecimal("1231"), savedProduct.getStockQuantity());

	}
            
            
    
}
        

