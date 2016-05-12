package com.vsii.tsc.model;

import java.util.List;

public class PPackage {
private String packageName;
private List<Product> product;
private String packagePrice;

public String getPackageName() {
	return packageName;
}

public void setPackageName(String packageName) {
	this.packageName = packageName;
}


public String getPackagePrice() {
	return packagePrice;
}

public void setPackagePrice(String packagePrice) {
	this.packagePrice = packagePrice;
}

public List<Product> getProduct() {
	return product;
}

public void setProduct(List<Product> product) {
	this.product = product;
}

}
