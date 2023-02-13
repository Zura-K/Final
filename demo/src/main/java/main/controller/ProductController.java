package main.controller;

import main.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import main.services.ProductServiceImplementation;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImplementation productService;

    @PreAuthorize("hasRole('ROLE_Manager') or hasRole('ROLE_Salesman')")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PreAuthorize("hasRole('ROLE_Manager')")
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product products) {
        return productService.createProduct(products).getBody();
    }

    @PreAuthorize("hasRole('ROLE_Manager') or hasRole('ROLE_Salesman')")
    @GetMapping("/{EANcode}")
    public Product getProduct(@PathVariable String EANcode) {
        return productService.getProduct(EANcode);
    }

    @PreAuthorize("hasRole('ROLE_Manager') or hasRole('ROLE_Salesman')")
    @PutMapping
    public ResponseEntity<Void> sellProduct(String ENACode, Double price, Long bundle) {
        productService.sellProduct(ENACode, price, bundle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_Manager')")
    @PutMapping("/{id}")
    public ResponseEntity<Void> purchaseProduct(@PathVariable Integer id) {
        productService.purchaseProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}