package com.Inventory.Management.System.demo.services;

import com.Inventory.Management.System.demo.entities.Product;
import com.Inventory.Management.System.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product AddNewProduct(Product product) {
        product.setCreatedDate(new Date());
        product.setActiveStatus(true);
        return productRepository.save(product);
    }

    public List<Product> GetAllActiveProducts() {
        List<Product> activeProduct = new ArrayList<>();
        List<Product> allProduct= productRepository.findAll();
        for (Product p : allProduct) {
            if (p.getActiveStatus() != null && p.getActiveStatus()) {
                activeProduct.add(p);
            }

        }
        return activeProduct;
    }

    public Product GetProductByID(Integer id) throws Exception {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        if (existingProduct.getActiveStatus()) {
            return existingProduct;
        } else {
            throw new Exception("Is not Active");
        }
    }

    public Product UpdateProduct(Product product) throws Exception {
        Product existingProduct = productRepository.findById(product.getProductId())
                .orElseThrow(() -> new Exception("Product not found"));

        if (existingProduct.getActiveStatus()) {
            product.setUpdatedDate(new Date());
            product.setActiveStatus(existingProduct.getActiveStatus());
            product.setCreatedDate(existingProduct.getCreatedDate());
            product.setProductId(existingProduct.getProductId());
            return productRepository.save(product);
        } else {
            throw new Exception("Is not Active");
        }
    }

    public void DeleteProduct(Integer id) throws Exception {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));

        if (existingProduct.getActiveStatus()) {
            existingProduct.setUpdatedDate(new Date());
            existingProduct.setActiveStatus(false);
            productRepository.save(existingProduct);
        } else {
            throw new Exception("Is not Active");
        }
    }
}
