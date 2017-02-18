package com.globmart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by subramanian_p on 30-06-2016.
 */
@Entity
public class GlobMartPrice {
    @Id
	@GeneratedValue private long id;
	@NotNull @Size(min = 1, max = 50) private String productPrice;
	@NotNull @Size(min = 1, max = 50) private String productName;

	public GlobMartPrice() {
	}

	public GlobMartPrice(String productPrice, String productName) {
		this.productPrice = productPrice;
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GlobMartPrice that = (GlobMartPrice) o;

		if (!productPrice.equals(that.productPrice)) return false;
		return productName.equals(that.productName);

	}

	@Override
	public int hashCode() {
		int result = productPrice.hashCode();
		result = 41 * result + productName.hashCode();
		return result;
	}
}
