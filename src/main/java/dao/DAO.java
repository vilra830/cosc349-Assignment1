/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import domain.Product;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author villa
 */
public class DAO {
    
private static Collection<Product> productList = new HashSet<>();
private static Collection<String> categoryList = new HashSet<>();
private static Map<String, Product> productIDList = new HashMap<>();
private static Multimap<String,Product> categories = HashMultimap.create();


public void saveProduct(Product product) {
    productList.add(product);
   categoryList.add(product.getProductCategory());
   productIDList.put(product.getProductID(), product);
   categories.put(product.getProductCategory(), product);
    
    
            
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

public Product searchProduct(String productID){
    if(!productIDList.containsKey(productID)){
        return null;
    } else {
        return productIDList.get(productID);
        
    }
    
}



public Collection<Product> filterCategory(String category){
    if(!categories.containsKey(category)){
        return null;
    } else {
        return categories.get(category);
        
    }
    
}

}





















