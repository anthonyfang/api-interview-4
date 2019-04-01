package com.code_challenge.model;
import org.apache.commons.lang3.builder.*;

import java.util.Objects;

/**
 * Created by 45011470 on 12/09/2018.
 */
public class Product implements Diffable<Product> {
    //The product description
    private String description;
    //The database generated product ID
    private int id;
    //The image URL of the product
    private String imageUrl;
    //The price of the product
    private double price;
    //The application-specific product ID
    private String productId;
    //The auto-generated version of the product
    private int version;

    public Product() {
        super();
    }

    public Product(String description, String imageUrl, double price) {
        this(description, 0, imageUrl, price, "", 0);
    }

    public Product(String description, int id, String imageUrl, double price, String productId, int version) {
        this.description = description;
        this.id = id;
        this.imageUrl = imageUrl;
        this.price = price;
        this.productId = productId;
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        Product otherProduct = (Product) other;
        return this.description.equals(otherProduct.description) &&
            this.id == otherProduct.id &&
            this.imageUrl.equals(otherProduct.imageUrl) &&
            this.price == otherProduct.price &&
            this.version == otherProduct.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, description, imageUrl, price);
    }

    @Override
    public DiffResult diff(Product product) {
        return new DiffBuilder(this, product, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id, product.id)
                .append("price", price, product.price)
                .append("imageUrl" ,imageUrl, product.imageUrl)
                .append("version", version, product.version)
                .append("description", description, product.description)
                .build();
    }
}
