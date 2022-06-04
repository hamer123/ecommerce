package com.pw.ecommerce.order.domain.pricing;

import com.pw.ecommerce.order.domain.Product;

import java.util.List;

public interface PricingPort {

    List<Product> getPricing(List<String> productIds);
}
