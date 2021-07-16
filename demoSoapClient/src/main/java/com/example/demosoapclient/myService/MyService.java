package com.example.demosoapclient.myService;

import com.example.demosoapclient.service.ProductService;
import com.example.demosoapclient.service.ProductServiceService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Bean
    public ProductService studentService() {
        ProductServiceService service = new ProductServiceService();
        return service.getProductServicePort();
    }
}
