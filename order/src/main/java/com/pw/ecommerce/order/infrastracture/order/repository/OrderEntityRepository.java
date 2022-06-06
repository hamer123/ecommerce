package com.pw.ecommerce.order.infrastracture.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderEntityRepository extends CrudRepository<String, OrderEntity> {
}
