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
public class DAO implements DAOInterface {
    
//private static Collection<String> categoryList = new HashSet<>();
private static Map<String, Product> productIDList = new HashMap<>();
private static Multimap<String,Product> categories = HashMultimap.create();


    @Override
    public void saveProduct(Product product) {
   //productList.add(product);
   //categoryList.add(product.getProductCategory());
   productIDList.put(product.getProductID(), product);
   categories.put(product.getProductCategory(), product);
    
    
            
}

    @Override
    public Collection<Product> getProducts(){
    return productIDList.values();

}

    @Override
    public Collection<String> getCategories(){
    
    return categories.keySet();

}

    @Override
    public void deleteProduct(Product product){
    //productList.remove(product);
    //categoryList.remove(product.getProductCategory());
    productIDList.remove(product.getProductID());
    categories.remove(product.getProductCategory(), product);
    

    
    
}

    @Override
    public Product searchProduct(String productID){
    if(!productIDList.containsKey(productID)){
        return null;
    } else {
        return productIDList.get(productID);
        
    }
    
}



    @Override
    public Collection<Product> filterCategory(String category){
        Collection<Product> productList = categories.get(category);

        return productList;
        
    
    
}

}


























