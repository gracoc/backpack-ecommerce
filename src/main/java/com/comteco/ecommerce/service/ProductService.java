package com.comteco.ecommerce.service;

import com.comteco.ecommerce.dto.PageDto;
import com.comteco.ecommerce.dto.ProductDto;
import com.comteco.ecommerce.entity.Product;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

  Product create(ProductDto dto);

  Product getById(UUID id);

  Product update(UUID id, ProductDto dto);

  Page<Product> getProducts(Pageable pageable);

  PageDto<Product> getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable);
}
