package lucas.ifmg.produtos.services;

import lucas.ifmg.produtos.dto.CategoryDTO;
import lucas.ifmg.produtos.entities.Category;
import lucas.ifmg.produtos.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Category category = dbCategory.get();
        return new CategoryDTO(category);
    }
}
