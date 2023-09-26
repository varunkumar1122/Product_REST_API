package com.ProductAPI.ProductAPI.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="productList")
public class Product {
    @Id
    @SequenceGenerator(name="prodList_seq",sequenceName ="prodList_seq",allocationSize =1)
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "prod_seq")
    private long productId;
    private String productName;

    private String productMfd;
    private String productExpd;

}
