package com.ex.ecom_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ex.ecom_project.model.cart;
import com.ex.ecom_project.service.cartserv;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private cartserv cartService;

    /**
     * Endpoint to add a product to the cart.
     * Example: POST /cart/add?cartId=1&productId=2&quantity=3
     */
    @PostMapping("/add")
    public String addToCart(@RequestParam Long cartId,
                            @RequestParam int productId,
                            @RequestParam int quantity) {
        cartService.addToCart(cartId, productId, quantity);
        return "Product added to cart successfully!";
    }

    /**
     * Endpoint to retrieve the cart.
     * Example: GET /cart/1
     */
    @GetMapping("/{cartId}")
    public cart viewCart(@PathVariable Long cartId) {
        return cartService.getCart(cartId);
    }
}
