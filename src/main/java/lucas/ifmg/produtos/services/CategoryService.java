package lucas.ifmg.produtos.services;

import lucas.ifmg.produtos.dto.CategoryDTO;
import lucas.ifmg.produtos.entities.Category;
import lucas.ifmg.produtos.repositories.CategoryRepository;
import lucas.ifmg.produtos.services.exceptions.ResourceNotFound;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = categoryRepository.findAll();
        return list.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> dbCategory = categoryRepository.findById(id);
        Category category = dbCategory.orElseThrow(() -> new ResourceNotFound("Category not found"));
        return new CategoryDTO(category);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category = categoryRepository.save(category);
        return new CategoryDTO(category);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        try {
            Category category = categoryRepository.getReferenceById(id);
            category.setName(categoryDTO.getName());
            return new CategoryDTO(category);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFound("Category not found");
        }
    }
    
    @Transactional
    public void delete(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFound("Category not found");
        }
    }
}
