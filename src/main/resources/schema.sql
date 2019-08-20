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
    stockQuantity decimal(5,2) not null,
    priceList decimal(5,2) not null,
    

    constraint Product_PK primary key (productID)
);
    
