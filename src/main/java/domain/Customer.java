package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vilra830
 */
public class Customer {
    
    private Integer customerID;
    private String firstname;
    private String surname;
    private String password;
    private String username;
    private String emailAddress;
    private String shippingAddress;

    public Customer(Integer customerID, String firstname, String surname, String password, String username, String emailAddress, String shippingAddress) {
        this.customerID = customerID;
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
        this.username = username;
        this.emailAddress = emailAddress;
        this.shippingAddress = shippingAddress;
    }

    public Customer() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", firstname=" + firstname + ", surname=" + surname + ", password=" + password + ", username=" + username + ", emailAddress=" + emailAddress + ", shippingAddress=" + shippingAddress + '}';
    }
    









}
