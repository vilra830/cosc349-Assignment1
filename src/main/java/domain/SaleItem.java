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

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
    
    
    public BigDecimal getItemTotal(){
        return getSalePrice().multiply(purchaseQuantity);
    }
    
    
    @Override
    public String toString() {
        return "SaleItem{" + "purchaseQuantity=" + purchaseQuantity + ", salePrice=" + salePrice + '}';
    }
    
    
}
