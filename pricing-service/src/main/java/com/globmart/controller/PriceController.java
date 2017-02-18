package com.globmart.controller;

import com.globmart.domain.GlobMartPrice;
import com.globmart.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by subramanian_p on 30-06-2016.
 */
@RestController
public class PriceController {
    @Autowired
    PricingService pricingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<GlobMartPrice> getPrices(@RequestParam(value="name", required=false) String name) {
        if (name!=null) {
            return pricingService.getProductPriceByName(name);
        } else {
            return pricingService.getProductPrices();
        }
    }
}
