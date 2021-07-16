package com.example.demoservicesoap.repository;

import com.example.demoservicesoap.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
