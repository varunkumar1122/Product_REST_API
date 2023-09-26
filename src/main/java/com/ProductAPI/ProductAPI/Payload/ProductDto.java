package com.ProductAPI.ProductAPI.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private long productId;
    private String productName;

    private String productMfd;
    private String productExpd;
}
