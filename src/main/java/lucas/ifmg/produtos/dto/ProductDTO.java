package lucas.ifmg.produtos.dto;

import lucas.ifmg.produtos.entities.Product;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.hateoas.RepresentationModel;

public class ProductDTO extends RepresentationModel<ProductDTO> {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, String imageUrl, Set<CategoryDTO> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.categories = categories;
    }

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.imageUrl = entity.getImageUrl();
        this.categories = entity.getCategories().stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", categories=" + categories +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
}
