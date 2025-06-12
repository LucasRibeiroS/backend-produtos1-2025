package lucas.ifmg.produtos.repositories;

import lucas.ifmg.produtos.entities.Product;
import lucas.ifmg.produtos.projections.ProductProjection;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query(nativeQuery = true,
        value = """
            select * from
            (
                SELECT DISTINCT p.id, p.name, p.image_url, p.price
                FROM products p
                INNER JOIN categories_to_products cp ON cp.product_id = p.id
                WHERE (:categoriesID IS NULL OR cp.category_id in :categoriesID) 
                    and LOWER( p.name) like LOWER( CONCAT('%',:name,'%' ))
            ) as tb_result
            """,
        countQuery = """
            select count(*) from
            (
                SELECT DISTINCT p.id, p.name, p.image_url, p.price
                FROM products p
                INNER JOIN categories_to_products cp ON cp.product_id = p.id
                    WHERE (:categoriesID IS NULL OR cp.category_id in :categoriesID) 
                        and LOWER( p.name) like LOWER( CONCAT('%',:name,'%' ))
                    ) as tb_result
            """
    )
    public Page<ProductProjection> searchProducts(List<Long> categoriesID, String name, Pageable pageable);
    
}
