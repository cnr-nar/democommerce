package com.mockCommerce.mockCommerce.repository;

import com.mockCommerce.mockCommerce.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
