package com.comteco.ecommerce.controller;

import com.comteco.ecommerce.dto.PageDto;
import com.comteco.ecommerce.dto.ProductDto;
import com.comteco.ecommerce.entity.Product;
import com.comteco.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Product")
@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

  private ProductService productService;

  @SecurityRequirement(name = "bearerAuth")
  @Operation(
      summary = "Save a new product"
  )
  @PostMapping
  public ResponseEntity<Product> create(@Valid @RequestBody ProductDto dto) {
    Product productSaved = productService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
  }

  @Operation(
      summary = "Get product by ID"
  )
  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(@PathVariable UUID id) {
    Product productFound = productService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(productFound);
  }

  @Operation(
      summary = "Update product by ID"
  )
  @PutMapping("/{id}")
  public ResponseEntity<Product> update(@PathVariable UUID id, @Valid @RequestBody ProductDto productDto){
    Product productUpdated = productService.update(id, productDto);
    return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
  }

  @Hidden
  @GetMapping("/pageable")
  public ResponseEntity<Page<Product>> getProducts(@RequestParam int page, @RequestParam int size) {
    Pageable pageable = PageRequest.of(page, size);
    Page<Product> productPage = productService.getProducts(pageable);
    return ResponseEntity.status(HttpStatus.OK).body(productPage);
  }

  @Operation(
      summary = "Get filtered products with pagination"
  )
  @GetMapping
  public ResponseEntity<PageDto<Product>> getFilteredProducts(
      @RequestParam(required = false) Double minPrice,
      @RequestParam(required = false) Double maxPrice,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size,
      @RequestParam(defaultValue = "id") String sortField,
      @RequestParam(defaultValue = "asc") String sortOrder
  ) {
    if (minPrice == null) {
      minPrice = Double.MIN_VALUE;
    }
    if (maxPrice == null) {
      maxPrice = Double.MAX_VALUE;
    }
    Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
    Pageable pageable = PageRequest.of(page, size, sort);
    PageDto<Product> productPage = productService.getFilteredProducts(minPrice, maxPrice, pageable);
    return ResponseEntity.status(HttpStatus.OK).body(productPage);
  }



}
