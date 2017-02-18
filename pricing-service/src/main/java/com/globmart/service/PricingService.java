package com.globmart.service;

import com.globmart.domain.GlobMartPrice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by subramanian_p on 30-06-2016.
 */
public interface PricingService {
    @Transactional(readOnly = true)
    List<GlobMartPrice> getProductPriceByName(String productName);

    @Transactional(readOnly = true)
    List<GlobMartPrice> getProductPrices();
}
