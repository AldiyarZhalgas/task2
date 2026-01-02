package pl.edu.vistula.firstrestspring.product.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.vistula.firstrestspring.product.api.request.ProductRequest;
import pl.edu.vistula.firstrestspring.product.api.response.ProductResponse;
import pl.edu.vistula.firstrestspring.product.service.ProductService;

import java.util.List;

@RestController   // ← ОБЯЗАТЕЛЬНО
@RequestMapping("/api/v1/products")  // ← ОБЯЗАТЕЛЬНО
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @GetMapping("/{id}")   // ← ОБЯЗАТЕЛЬНО
    public ResponseEntity<ProductResponse> find(@PathVariable Long id) {
        return ResponseEntity.ok(service.find(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
