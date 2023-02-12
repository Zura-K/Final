package controller;

import entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import services.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasRole('RoleManager') or hasRole('RoleSalesman')")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PreAuthorize("hasRole('RoleManager')")
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product products) {
        return productService.createProduct(products);
    }

    @PreAuthorize("hasRole('RoleManager') or hasRole('RoleSalesman')")
    @GetMapping
    public Product getProduct(@Valid @PathVariable String ENACode) {
        return productService.getProduct(ENACode);
    }

    @PreAuthorize("hasRole('RoleManager') or hasRole('RoleSalesman')")
    @PutMapping
    public ResponseEntity<Void> sellProduct(@PathVariable("id") String ENACode, Double price, Long bundle) {
        productService.sellProduct(ENACode, price, bundle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('RoleManager')")
    @PutMapping
    public ResponseEntity<Void> purchaseProduct(@PathVariable("id") Long id) {
        productService.purchaseProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}