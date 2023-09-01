package com.mockCommerce.mockCommerce.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name = "t_checkout")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CheckOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkout_id")
    private int checkoutId;

    @ManyToMany
    @JoinTable(name = "t_checkout_products", joinColumns =@JoinColumn (name = "checkout_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "checkout_date")
    private Date checkoutDate;

    @Column(name = "checkout_quantity")
    private int checkoutQuantity;

    @Column(name = "checkout_price")
    private float checkoutPrice;


}
