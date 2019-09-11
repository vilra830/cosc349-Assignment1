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
import static org.junit.Assert.assertEquals;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vilra830
 */
public class ProductEditorTest {
    
    private DAOInterface dao;
    private DialogFixture fixture;
    private Robot robot;
    
    private Product prodOne;
    private Product prodTwo;
    private Product prodThree;
    
    @Before
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();      
    
	// Slow down the robot a little bit - default is 30 (milliseconds).
	// Do NOT make it less than 10 or you will have thread-race problems.
	robot.settings().delayBetweenEvents(75);
        
  

        // add some majors for testing with
       this.prodOne = new Product("1", "name1", "cat1", "desc1",new BigDecimal("11.00"), new BigDecimal("22.00"));
       this.prodTwo = new Product("2", "name2", "cat2", "desc2",new BigDecimal("33.00"), new BigDecimal("44.00"));
       this.prodThree = new Product("3", "name3", "cat3", "desc3",new BigDecimal("55.00"), new BigDecimal("66.00"));
       
	Collection<Product> products = new ArrayList<>();
        products.add(prodOne);
        products.add(prodTwo);
        products.add(prodThree);

	
	// create a mock for the DAO
	dao = mock(DAOInterface.class);

	// stub the getMajors method to return the test majors
	when(dao.getProducts()).thenReturn(products);
	
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
		fixture.comboBox("cmbMajor").selectItem("Knitting");

		// click the save button
		fixture.button("btnSave").click();

		// create a Mockito argument captor to use to retrieve the passed student from the mocked DAO
		ArgumentCaptor<Student> argument = ArgumentCaptor.forClass(Student.class);

		// verify that the DAO.save method was called, and capture the passed student
		verify(dao).save(argument.capture());

		// retrieve the passed student from the captor
		Student savedStudent = argument.getValue();

		// test that the student's details were properly saved
		assertEquals("Ensure the ID was saved", Integer.valueOf(1234), savedStudent.getId());
		assertEquals("Ensure the name was saved", "Jack", savedStudent.getName());
		assertEquals("Ensure the major was saved", "Knitting", savedStudent.getMajor());
	}
            
            
    
}
        
}
