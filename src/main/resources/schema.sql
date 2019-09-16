/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
/**
 * Author:  villa
 * Created: 13/08/2019
 * Reference issue#6
 */
   create table Product( 
    productID varchar(20) ,
    productName varchar(20) not null,
    productDescription varchar(300) not null,
    productCategory varchar(50) not null, 
    stockQuantity decimal(8,2) not null,
    priceList decimal(8,2) not null,
    

    constraint Product_PK primary key (productID)
);
   

   create table Customer(
    customerID int auto_increment,
    firstname varchar(50) not null ,
    surname varchar(20) not null,
    password varchar(20) not null,
    username varchar(50) not null unique,
    emailAddress varchar(300) not null ,
    shippingAddress varchar(300) not null, 

    constraint Customer_PK primary key(customerID)
);
