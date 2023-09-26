package com.ProductAPI.ProductAPI.Controller;

import com.ProductAPI.ProductAPI.Payload.ProductDto;
import com.ProductAPI.ProductAPI.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductDto> createProductApi(@RequestBody ProductDto productDto) {

        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDto>> printAllProducts(@RequestBody ProductDto productDto){

        return new ResponseEntity<>(productService.getAllProducts(productDto),HttpStatus.OK);
    }

}
