package lucas.ifmg.produtos.repositories;

import lucas.ifmg.produtos.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
