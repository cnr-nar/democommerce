package com.mockCommerce.mockCommerce.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name="product_name")
    private String productName;

    @Column(name = "product_price")
    private float productPrice;

    @Column(name = "product_desc")
    private String productDesc;

    @ManyToMany
    @JoinTable(name = "t_checkout_products", joinColumns =@JoinColumn (name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "checkout_id"))
    private List<CheckOut> checkOuts;
}
