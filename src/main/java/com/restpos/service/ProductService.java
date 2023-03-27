package com.restpos.service;

import java.util.List;
import java.util.Optional;

import com.restpos.model.Product;

public interface ProductService {

    public List<Product> products();

    public Optional<Product> getProduct(String id);

    public Product randomProduct();
}
