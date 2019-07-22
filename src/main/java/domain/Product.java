
import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vilra830
 */
public class Product {
    private String productID;
    private String productName;
    private String productDescription;
    private String productCategory;
    private BigDecimal priceList;
    private BigDecimal stockQuantity;
    
    public Product(){}

    public Product(String productID, String productName, String productDescription, String productCategory, BigDecimal priceList, BigDecimal stockQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.priceList = priceList;
        this.stockQuantity = stockQuantity;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public BigDecimal getPriceList() {
        return priceList;
    }

    public BigDecimal getStockQuantity() {
        return stockQuantity;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setPriceList(BigDecimal priceList) {
        this.priceList = priceList;
    }

    public void setStockQuantity(BigDecimal stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productDescription=" + productDescription + ", productCategory=" + productCategory + ", priceList=" + priceList + ", stockQuantity=" + stockQuantity + '}';
    }
    
    
    
    
}


