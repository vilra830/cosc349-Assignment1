package domain;


import java.math.BigDecimal;
import java.util.Objects;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;

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
    @NotNull(message = "ID must be provided.")
    @NotBlank(message = "ID must be provided.")
    @Length(min=2, max = 20 , message="ID must contain at least two characters.")
    private String productID;
    @NotNull(message = "Name must be provided.")
    @NotBlank(message = "Name must be provided.")
    @Length(min=2, max=20, message="Name must contain at least two characters.")
    private String productName; 
    @NotNull(message = "Description must be provided.")
    @NotBlank(message = "Description must be provided.")
    @Length(min=2, max=300, message="Description must contain at least five characters.")
    private String productDescription;
    @NotNull(message = "Category must be provided.")
    @NotBlank(message = "Category must be provided.")
    @Length(min=2, max=50, message="Category must contain at least three characters.")
    private String productCategory;
    @NotNull(message = "Price must be provided.")
    @NotNegative(message = "Price must be zero or greater.")
    @Length(max=8)
    private BigDecimal priceList;
    @NotNull(message = "Quantity must be provided.")
    @NotNegative(message = "Quantity must be zero or greater.")
    @Length(max=8)
    private BigDecimal stockQuantity;
    
    
    
    
    
    
    public Product(){}

    
    public Product(String productID, String productName, String productDescription,String productCategory, BigDecimal priceList, BigDecimal stockQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.priceList = priceList;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.productID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productID, other.productID)) {
            return false;
        }
        return true;
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
        return "ProductID: " + productID + " " + "Name: " + productName + " " + "Description: " + productDescription + " "+ "Category: " + productCategory +" "+ "Price: " + priceList + " "+"Quantity: " + " " + stockQuantity ;
    }
    
    
    
    
}


