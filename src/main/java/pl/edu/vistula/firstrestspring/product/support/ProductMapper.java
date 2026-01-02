package pl.edu.vistula.firstrestspring.product.support;

import org.springframework.stereotype.Component;
import pl.edu.vistula.firstrestspring.product.api.request.ProductRequest;
import pl.edu.vistula.firstrestspring.product.api.response.ProductResponse;
import pl.edu.vistula.firstrestspring.product.domain.Product;

@Component
public class ProductMapper {

    // ProductRequest -> Product
    public Product toProduct(ProductRequest request) {
        return new Product(request.getName());
    }

    // Product -> ProductResponse
    public ProductResponse toResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }
}
