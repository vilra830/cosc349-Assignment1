/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


"use strict";

class SaleItem {

    constructor(product, quantity) {
        // only set the fields if we have a valid product
        if (product) {
            this.product = product;
            this.purchaseQuantity = quantity;
            this.salePrice = product.priceList;
        }
    }

    getItemTotal() {
        return this.salePrice * this.purchaseQuantity;
    }

}


class ShoppingCart {

    constructor() {
        this.items = new Array();
    }

    reconstruct(sessionData) {
        for (let item of sessionData.items) {
            this.addItem(Object.assign(new SaleItem(), item));
        }
    }

    getItems() {
        return this.items;
    }

    addItem(item) {
        this.items.push(item);
    }

    setCustomer(customer) {
        this.customer = customer;
    }

    getTotal() {
        let total = 0;
        for (let item of this.items) {
            total += item.getItemTotal();
        }
        return total;
    }

}

// create a new module, and load the other pluggable modules
var module = angular.module('ShoppingApp', ['ngResource', 'ngStorage']);

module.factory('cart', function ($sessionStorage) {
    let cart = new ShoppingCart();

    // is the cart in the session storage?
    if ($sessionStorage.cart) {

        // reconstruct the cart from the session data
        cart.reconstruct($sessionStorage.cart);
    }

    return cart;
});


module.factory('productDAO', function ($resource) {
return $resource('/api/products/:id');
});

module.factory('categoryDAO', function ($resource) {
return $resource('/api/categories/:cat');
});

module.factory('saleDAO', function ($resource) {
return $resource('/api/sales');
});

module.factory('registerDAO', function ($resource) {
return $resource('/api/register');
});

module.factory('signInDAO', function ($resource) {
return $resource('/api/customers/:username');
});

module.controller('ShoppingController', function (cart, saleDAO, $sessionStorage, $window) {
    
    this.items = cart.getItems();
    this.total = cart.getTotal();
    this.theSelectedProduct = $sessionStorage.selectedProduct;
     //this.quantity = $sessionStorage.quantity;
    
    this.selectedProduct = function(prod) {
        $sessionStorage.selectedProduct = prod;
        //redirect to buy.html page
        $window.location.href = 'buy.html';
    }
    
    this.addToCart = function(quantity) {
        let theSelectedProduct = $sessionStorage.selectedProduct;
        
        let item = new SaleItem(theSelectedProduct, quantity);
        cart.addItem(item);
        $sessionStorage.cart = cart;
        console.log(cart);
        
        $window.location.href = "products.html";
    };
    
    this.checkOut = function () {
        
       if(cart > 0){
        
        
       cart.setCustomer($sessionStorage.customer);
       saleDAO.save(cart);
       delete $sessionStorage.cart;
       $window.location.href = "thankyou.html";
   } else {
       this.message = "Cart empty nothing to checkout!"
   }
       
       
        
    }
    

});



module.controller('ProductController', function (productDAO , categoryDAO) {
//alert("in controller");
// load the products
this.products = productDAO.query();
this.categories = categoryDAO.query();

this.selectCategory = function (selectedCat) {
    this.products = categoryDAO.query({"cat": selectedCat});
};


this.allProducts = function () {
    this.products = productDAO.query();  
};
});

module.controller('CustomerController', function (registerDAO, signInDAO, $sessionStorage, $window ) {
    this.registerCustomer = function (customer) {
        registerDAO.save(null, customer,
        // success callback
       function () {
          $window.location = 'signin.html';
      },
      // error callback
      function (error) {
          console.log(error);
      }
);
};
this.signInMessage = "Please sign in to continue.";

// alias 'this' so that we can access it inside callback functions
let ctrl = this;
this.signIn = function (username, password) {
    // get customer from web service
    signInDAO.get({'username': username},
    // success
    function (customer) {
    // also store the retrieved customer
        $sessionStorage.customer = customer;
    // redirect to home
        $window.location.href = '.';
    },
    // fail
        function () {
            ctrl.signInMessage = 'Sign in failed. Please try again.';
        }
                );
    };
    
    this.checkSignIn = function () {
    // has the customer been added to the session?
    if ($sessionStorage.customer) {
        this.signedIn = true;
        this.welcome = "Welcome " + $sessionStorage.customer.firstname;
    } else {
        this.signedIn = false;
    }
};


});


