/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.DAOInterface;
import org.jooby.Jooby;

/**
 *
 * @author villa
 */
public class ProductModule extends Jooby{
    
    public ProductModule(DAOInterface dao){
    get("/api/products", () -> dao.getProducts());
    
    get("/api/categories", () -> dao.getCategories());
        
       
        get("/api/products/:id", (req) -> {
            String id = req.param("id").value();
            return dao.searchProduct(id);
});
    
         get("/api/categories/:category", (req) -> {
            String category = req.param("category").value();
            return dao.filterCategory(category);
});
    }
    
    
    
}



