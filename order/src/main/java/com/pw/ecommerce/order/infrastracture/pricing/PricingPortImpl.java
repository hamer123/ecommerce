package com.pw.ecommerce.order.infrastracture.pricing;

import com.pw.ecommerce.order.domain.Product;
import com.pw.ecommerce.order.domain.pricing.PricingPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingPortImpl implements PricingPort {

    @Override
    public List<Product> getPricing(List<String> productIds) {
        return null;
    }
}
