package lucas.ifmg.produtos.repositories;

import lucas.ifmg.produtos.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
