/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author villa
 */
public class SaleTest {
    private SaleItem instance1;
    private SaleItem instance;
    private SaleItem instance2;
    

    
    public SaleTest() {
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testGetTotal() {
                ArrayList<SaleItem> saleList = new ArrayList<>();
		instance = new SaleItem(new BigDecimal("3"), new BigDecimal("6.50") );
		instance1 = new SaleItem(new BigDecimal("4") , new BigDecimal("5.50"));
		instance2 = new SaleItem(new BigDecimal("5"), new BigDecimal("4.50"));
		saleList.add(instance);
		saleList.add(instance1);
		saleList.add(instance2);
                
                BigDecimal total = BigDecimal.ZERO;
		for(SaleItem s : saleList){
                   total = total.add(s.getItemTotal());

		}
                
                BigDecimal actual = new BigDecimal("64.00");
                 assertEquals(actual, total);
                        
		
    }
    
    

    @Test
    public void testAddItem() {
                ArrayList<SaleItem> saleList = new ArrayList<>();
		instance = new SaleItem(new BigDecimal("3"), new BigDecimal("6.50") );
		instance1 = new SaleItem(new BigDecimal("4") , new BigDecimal("5.50"));
		instance2 = new SaleItem(new BigDecimal("5"), new BigDecimal("4.50"));
		saleList.add(instance);
		saleList.add(instance1);
		saleList.add(instance2);
        assertEquals(3, saleList.size());

        assertTrue(saleList.contains(instance1));
        assertTrue(saleList.contains(instance2));
        
    }

}





