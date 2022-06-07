package com.pw.ecommerce.order.infrastracture.order.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "client")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ClientEntity {
    @Id
    private String customerId;

    @Enumerated(EnumType.STRING)
    private CustomerLoyaltyEntity customerLoyalty;
}
