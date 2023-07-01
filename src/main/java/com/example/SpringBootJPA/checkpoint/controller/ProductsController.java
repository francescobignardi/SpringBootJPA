package com.example.SpringBootJPA.checkpoint.controller;

import com.example.SpringBootJPA.checkpoint.entity.Products;
import com.example.SpringBootJPA.checkpoint.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductsController {
    @Autowired
    public ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/insertProduct")
    public ResponseEntity<?> insertProduct(@RequestBody Products product){
        productsService.insertProduct(product);
        return ResponseEntity.ok("Prodotto inserito");
    }

    @GetMapping("/findById/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable("productId") Integer id){
        productsService.getProductById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllProducts")
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") Integer id){
        productsService.deleteProducts(id);
        return ResponseEntity.ok("Prodotto eliminato");
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody Products product, @PathVariable("productId") Integer id){
        productsService.updateProduct(product, id);
        return ResponseEntity.ok("Prodotto modificato");
    }
}
