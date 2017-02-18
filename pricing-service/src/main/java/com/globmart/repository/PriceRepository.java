package com.globmart.repository;

import com.globmart.domain.GlobMartPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by subramanian_p on 30-06-2016.
 */
public interface PriceRepository  extends JpaRepository<GlobMartPrice, UUID> {

    List<GlobMartPrice> findByProductName(String productName);
}
