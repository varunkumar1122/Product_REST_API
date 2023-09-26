package com.ProductAPI.ProductAPI.Service;

import com.ProductAPI.ProductAPI.Entity.Product;
import com.ProductAPI.ProductAPI.Payload.ProductDto;

import java.util.List;

public interface ProductService {
    public ProductDto createProduct(ProductDto productDto);
    public List<ProductDto> getAllProducts(ProductDto productDto);
    public ProductDto  getProductById(ProductDto productDto,Integer productId);
    public Product searchProduct(String productName);
}
