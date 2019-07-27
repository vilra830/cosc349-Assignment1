/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author villa
 */
public class DAO {
    
private static Collection<Product> productList = new ArrayList<>();


public void saveProduct(Product product) {
    productList.add(product);
}

public Collection<Product> getProducts(){
    return productList;
}

public void deleteProduct(Product product){
    productList.remove(product);
    
}
}


