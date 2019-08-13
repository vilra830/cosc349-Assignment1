/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;

/**
 *
 * @author villa
 */
public interface DAOInterface {

    void deleteProduct(Product product);

    Collection<Product> filterCategory(String category);

    Collection<String> getCategories();

    Collection<Product> getProducts();

    void saveProduct(Product product);

    Product searchProduct(String productID);
    
}

