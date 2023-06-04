package com.comteco.ecommerce.repository;

import com.comteco.ecommerce.entity.Category;
import com.comteco.ecommerce.entity.Product;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

  Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
  Page<Product> findByCategoryId(UUID categoryId, Pageable pageable);
}
