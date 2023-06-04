package com.comteco.ecommerce.service;

import com.comteco.ecommerce.entity.Category;
import com.comteco.ecommerce.exception.EntityNotFoundException;
import com.comteco.ecommerce.repository.CategoryRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

  private CategoryRepository categoryRepository;

  @Override
  public Category getById(UUID id) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Category", id));
    return category;
  }

  @Override
  public List<Category> getAll() {
    return categoryRepository.findAll();
  }
}
