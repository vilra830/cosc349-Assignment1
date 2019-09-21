package domain;


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
public class SaleItem {
    private BigDecimal purchaseQuantity;
    private BigDecimal salePrice;
    private Product product;
    private Sale sale;

    public SaleItem() {
    }

    
    public SaleItem(Product product, BigDecimal purchaseQuantity){
        this.product = product;
        this.purchaseQuantity = purchaseQuantity;
    }
    
    public SaleItem(BigDecimal purchaseQuantity, BigDecimal salePrice, Product product , Sale sale) {
        this.purchaseQuantity = purchaseQuantity;
        this.salePrice = salePrice;
        this.product = product;
        this.sale = sale;
	sale.addItem(this);
        
    }

    

    public SaleItem(BigDecimal purchaseQuantity, BigDecimal salePrice) {
        this.purchaseQuantity = purchaseQuantity;
        this.salePrice = salePrice;
    }

    public BigDecimal getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setPurchaseQuantity(BigDecimal purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public Sale getSale() {
        return sale;
    }
    
    
    
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
    
    
    public BigDecimal getItemTotal(){
        return this.salePrice.multiply(this.purchaseQuantity);
    }
    
    
    
    @Override
    public String toString() {
        return "SaleItem{" + "purchaseQuantity=" + purchaseQuantity + ", salePrice=" + salePrice + '}';
    }
    
    
}
