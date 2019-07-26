/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author villa
 */
public class Administration {
        /**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
            
                Customer cust = new Customer(0123, "Summer" , "Johns" , "adfhj" , "summersj", "summer09@gmail.com" , "81 Saturn Street Dunedin City");

		Product product = new Product("D1231","DVD",new BigDecimal("12.25"));
                Product product1 = new Product("PC12","Personal Computer",new BigDecimal("624.75"));

		LocalDate date = LocalDate.parse("03/06/2014", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Sale sale = new Sale(12, date,"pending" );
		
                
		SaleItem saleItem = new SaleItem(new BigDecimal("4") , new BigDecimal("10.50") , product , sale );
                SaleItem saleItem1 = new SaleItem(new BigDecimal("3") , new BigDecimal("4.50"), product, sale);
                
		ArrayList<SaleItem> saleList = new ArrayList<>();
		SaleItem instance = new SaleItem(new BigDecimal("3"), new BigDecimal("6.50") , product ,  sale );
		SaleItem instance1 = new SaleItem(new BigDecimal("4") , new BigDecimal("5.50") , product1, sale);
		SaleItem instance2 = new SaleItem(new BigDecimal("5"), new BigDecimal("4.50") , product , sale);
		saleList.add(instance);
		saleList.add(instance1);
		saleList.add(instance2);
                
                BigDecimal total = BigDecimal.ZERO;
		for(SaleItem s : saleList){
                    total.add(s.getItemTotal());
		}
		
		System.out.println(saleItem.getItemTotal());
		System.out.println(total);
                System.out.println(cust);
                System.out.println(product);
                System.out.println(sale);
                System.out.println(instance);

	}
}

    




