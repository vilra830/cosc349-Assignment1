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
private static Collection<String> categoryList = new ArrayList<>();


public void saveProduct(Product product) {
    productList.add(product);
    categoryList.add(product.getProductCategory());
}

public Collection<Product> getProducts(){
    return productList;

}

public Collection<String> getCategories(){
    return categoryList;

}

public void deleteProduct(Product product){
    productList.remove(product);
    
}


}









