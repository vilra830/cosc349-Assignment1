/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author villa
 */
public class SaleItemTest {
    private SaleItem testItem;
    
    public SaleItemTest() {
    }
    
    @Before
    public void setUp() {
        testItem = new SaleItem();
        testItem.setSalePrice(new BigDecimal("12.5"));
        testItem.setPurchaseQuantity(new BigDecimal("6"));
                
        
    }
    
    
    @After
    public void tearDown() {
    }



    @Test
    public void testGetItemTotal() {
        BigDecimal actual = new BigDecimal("75.0");
        //assertTrue(actual.compareTo(new BigDecimal("75.0")) == 0);
        assertEquals(actual, testItem.getItemTotal());

        
    }

  
    
}










