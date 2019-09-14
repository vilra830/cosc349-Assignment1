/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author villa
 */
public class CustomerCollectionsDAO implements CustomerDAO {
    // customers stored by username
	private static final Map<String, Customer> customers = new HashMap<>();
 
	public CustomerCollectionsDAO() {
		if (customers.isEmpty()) {
			// some dummy data for testing
			Customer boris = new Customer();
			boris.setUsername("boris");
			boris.setFirstname("Boris");
			boris.setSurname("McNorris");
			boris.setPassword("guest");
			boris.setShippingAddress("123 Some Street,\nNorth East Valley,\nDunedin");
			boris.setEmailAddress("boris@example.net");
 
			Customer doris = new Customer();
			doris.setUsername("doris");
			doris.setFirstname("Doris");
			doris.setSurname("Dolores");
			doris.setPassword("guest");
			doris.setShippingAddress("321 Anywere Ave,\nSt Clair,\nDunedin");
			doris.setEmailAddress("doris@example.net");
 
			this.save(boris);
			this.save(doris);
		}
	}
 
	@Override
	public void save(Customer customer) {
		System.out.println("Saving customer: " + customer);
		customers.put(customer.getUsername(), customer);
	}
 
	@Override
	public Customer getCustomer(String username) {
		return customers.get(username);
	}
 
	@Override
	public Boolean validateCredentials(String username, String password) {
		if (customers.containsKey(username)) {
			return customers.get(username).getPassword().equals(password);
		} else {
			return false;
		}
	}
 

    
}


