package pl.edu.vistula.firstrestspring.product.repository;

import org.springframework.stereotype.Repository;
import pl.edu.vistula.firstrestspring.product.domain.Product;

import java.util.*;

@Repository
public class ProductRepository {

    private final Map<Long, Product> map = new HashMap<>();
    private Long counter = 1L;

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(counter++);
        }
        map.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    public void deleteById(Long id) {
        map.remove(id);
    }
}
