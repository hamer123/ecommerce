package com.pw.ecommerce.order.infrastracture.order.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "product")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ProductEntity {

    @Id
    private String id;

    private String productId;

    private String currency;

    private BigDecimal amount;

    private int quantity;
}
