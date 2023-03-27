package com.restpos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restpos.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public Optional<Product> getProduct(String id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<Product> products() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product randomProduct() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
