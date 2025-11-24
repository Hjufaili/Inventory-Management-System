package com.Inventory.Management.System.demo.controllers;

import com.Inventory.Management.System.demo.entities.Product;
import com.Inventory.Management.System.demo.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
        Product newProduct = productService.addNewProduct(product);
        return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProduct(){
            List<Product> allProduct = productService.getAllActiveProducts();
            return new ResponseEntity<>(allProduct,HttpStatus.OK);

    }

    @GetMapping("/getById")
    public ResponseEntity<?> getProductById(@Valid @RequestParam Integer id){
        try {
            Product product = productService.getProductByID(id);
            return new ResponseEntity<>(product,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct (@Valid @RequestBody Product product){
        try {
            Product updateProduct = productService.updateProduct(product);
            return new ResponseEntity<>(updateProduct,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct (@Valid @RequestParam Integer id){
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
        }
    }
}
