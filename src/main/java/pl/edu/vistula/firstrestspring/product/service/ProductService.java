package pl.edu.vistula.firstrestspring.product.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.firstrestspring.product.api.request.ProductRequest;
import pl.edu.vistula.firstrestspring.product.api.response.ProductResponse;
import pl.edu.vistula.firstrestspring.product.domain.Product;
import pl.edu.vistula.firstrestspring.product.repository.ProductRepository;
import pl.edu.vistula.firstrestspring.product.support.ProductExceptionSupplier;
import pl.edu.vistula.firstrestspring.product.support.ProductMapper;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // ✅ ЭТОТ МЕТОД ОБЯЗАТЕЛЕН
    public ProductResponse create(ProductRequest request) {
        Product product = mapper.toProduct(request);
        Product saved = repository.save(product);
        return mapper.toResponse(saved);
    }

    public ProductResponse find(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return mapper.toResponse(product);
    }

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        repository.deleteById(id);
    }
}
