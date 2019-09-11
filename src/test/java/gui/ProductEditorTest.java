/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DAOInterface;
import domain.Product;
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
    
    public ProductEditorTest() {
    }
    
    @Before
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();      
    
	// Slow down the robot a little bit - default is 30 (milliseconds).
	// Do NOT make it less than 10 or you will have thread-race problems.
	robot.settings().delayBetweenEvents(75);

        // add some majors for testing with
	Collection<String> product = new ArrayList<>();
	majors.add("Knitting");
	majors.add("Ninjitsu");

	// create a mock for the DAO
	dao = mock(StudentDAO.class);

	// stub the getMajors method to return the test majors
	when(dao.getMajors()).thenReturn(majors);
	
    }
        
        

    }
    
    @After
    public void tearDown() {
        fixture.cleanUp();
    }

   @Test
	public void testSave() {
    
}
        
}
