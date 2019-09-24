package domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vilra830
 */
public class Sale {
    
    
    private Integer saleID;
    private LocalDate date;
    private String status;
    private List<SaleItem> items = new ArrayList<>();
    private Customer customer;

    public Sale(Integer saleID, LocalDate date, String status, Customer customer) {
        this.saleID = saleID;
        this.date = date;
        this.status = status;
        this.customer = customer;
    }
    
    public Sale(){}

    public Integer getSaleID() {
        return saleID;
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
    
    public Customer getCustomer(){
        return customer;
    }

    public void setSaleID(Integer saleID) {
        this.saleID = saleID;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for(SaleItem item :items){
            
            total.add(item.getItemTotal());
        }
        return total;
    
    }
    
    public void addItem(SaleItem saleItem){
        
        this.items.add(saleItem);
            
            
            
        }
            
    
    
    
    
      
    
    
    @Override
    public String toString() {
        return "Sale{" + "saleID=" + saleID + ", date=" + date + ", status=" + status + '}';
    }
    
    
    
}

