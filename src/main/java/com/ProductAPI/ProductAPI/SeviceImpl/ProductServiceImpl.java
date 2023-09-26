package com.ProductAPI.ProductAPI.SeviceImpl;

import com.ProductAPI.ProductAPI.Entity.Product;
import com.ProductAPI.ProductAPI.Payload.ProductDto;
import com.ProductAPI.ProductAPI.Repository.ProductRepository;
import com.ProductAPI.ProductAPI.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
   private ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


   /* private ProductDto mapToDtos(Product product){

        ProductDto newProductDto=new ProductDto();
        newProductDto.setProductId(product.getProductId());
        newProductDto.setProductName(product.getProductName());
        newProductDto.setProductMfd(product.getProductMfd());
        newProductDto.setProductExpd(product.getProductExpd());
        return newProductDto;
    }*/
  /*  private Product mapToEntity(ProductDto productDto){
        Product newProduct=new Product();
        newProduct.setProductId(productDto.getProductId());
        newProduct.setProductName(productDto.getProductName());
        newProduct.setProductMfd(productDto.getProductMfd());
        newProduct.setProductExpd(productDto.getProductExpd());
        return newProduct;
    }*/

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product newProduct=mapToEntity(productDto);
        Product savedProduct=productRepository.save(newProduct);
        return mapToDtos(savedProduct);
    }

    @Override
    public List<ProductDto> getAllProducts(ProductDto productDto) {
        List<Product> productList=productRepository.findAll();
        List<ProductDto> productDtoList=productList.stream().map(Product->mapToDtos(Product)).collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public ProductDto getProductById(ProductDto productDto, Long productId) {
        Product product=productRepository.findById(productId).orElse(()->productNotFoundException());
        return mapToDtos(product);
    }

    private ProductDto mapToDtos(Product product){
        ProductDto newProductDto=modelMapper.map(product,ProductDto.class);
        return newProductDto;
     }
     private Product mapToEntity(ProductDto productDto){
        Product newProduct=modelMapper.map(productDto,Product.class);
        return newProduct;
     }
}
