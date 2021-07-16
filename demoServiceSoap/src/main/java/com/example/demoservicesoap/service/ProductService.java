package com.example.demoservicesoap.service;

import com.example.demoservicesoap.entity.Product;
import com.example.demoservicesoap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Component(value = "ProductService")
@WebService
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @WebMethod
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @WebMethod
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @WebMethod
    public Product sellProduct(int id, int quantity) {
        Product existProduct = productRepository.findById(id).orElse(null);
        if (existProduct != null && existProduct.getQuantity() > quantity){
            existProduct.setQuantity(existProduct.getQuantity() - quantity);
            productRepository.save(existProduct);
            return existProduct;
        }
        return null;
    }
}
