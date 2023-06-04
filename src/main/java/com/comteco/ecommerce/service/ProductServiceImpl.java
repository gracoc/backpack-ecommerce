package com.comteco.ecommerce.service;

import com.comteco.ecommerce.dto.PageDto;
import com.comteco.ecommerce.dto.ProductDto;
import com.comteco.ecommerce.entity.Category;
import com.comteco.ecommerce.entity.Product;
import com.comteco.ecommerce.exception.EntityNotFoundException;
import com.comteco.ecommerce.mapper.ProductMapper;
import com.comteco.ecommerce.repository.ProductRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;
  private CategoryService categoryService;

  private ProductMapper productMapper;

  @Override
  public Product create(ProductDto dto) {
    Category category = categoryService.getById(dto.getCategoryId());
    Product product = productMapper.fromDto(dto);
    product.setCategory(category);
    return productRepository.save(product);
  }

  @Override
  public Product getById(UUID id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product", id));
  }

  @Override
  public Product update(UUID id, ProductDto dto) {
    Product productFound = productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product", id));

      Category category = categoryService.getById(dto.getCategoryId());
      Product product = productMapper.fromDto(dto);
      product.setCategory(category);
      product.setId(productFound.getId());
      return productRepository.save(product);
  }

  @Override
  public PageDto<Product> getProductsByCategoryId(UUID categoryId, Pageable pageable) {

    Page<Product> page =  productRepository.findByCategoryId(categoryId, pageable);
    return productMapper.fromEntity(page);
  }

  @Override
  public Page<Product> getProducts(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  @Override
  public PageDto<Product> getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable) {
    Page<Product> page = productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
    return productMapper.fromEntity(page);
  }
}
