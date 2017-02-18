package com.globmart.service;

import com.globmart.domain.GlobMartPrice;
import com.globmart.repository.PriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Created by subramanian_p on 30-06-2016.
 */
@Service
@Validated
public class PricingServiceImpl implements PricingService{
    private static final Logger LOGGER = LoggerFactory.getLogger(PricingServiceImpl.class);
    @Autowired
    PriceRepository priceRepository;

    @Override
    @Transactional(readOnly = true)
    public List<GlobMartPrice> getProductPriceByName(String productName) {
        LOGGER.debug("Retrieving price of product with queried name");
        return priceRepository.findByProductName(productName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GlobMartPrice> getProductPrices() {
        LOGGER.debug("Retrieving all product prices");
        return priceRepository.findAll();
    }
}
