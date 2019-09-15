/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


"use strict";

// create a new module, and load the other pluggable modules
var module = angular.module('ShoppingApp', ['ngResource', 'ngStorage']);

module.factory('productDAO', function ($resource) {
return $resource('/api/products/:id');
});

module.factory('categoryDAO', function ($resource) {
return $resource('/api/categories/:cat');
});

module.factory('registerDAO', function ($resource) {
return $resource('/api/register');
});

module.controller('ProductController', function (productDAO , categoryDAO) {
//alert("in controller");
// load the products
this.products = productDAO.query();
this.categories = categoryDAO.query();

this.selectCategory = function (selectedCat) {
    this.products = categoryDAO.query({"cat": selectedCat});
};

this.registerCustomer = function (customer) {
alert("register customer");
console.log(customer);
};


});


