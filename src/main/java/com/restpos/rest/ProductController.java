package com.restpos.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restpos.model.Product;
import com.restpos.service.ProductService;

@RestController
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public ResponseEntity<CollectionModel<EntityModel<Product>>> allProducts() {
		List<EntityModel<Product>> products = productService.products().stream()
				.map(product -> EntityModel.of(product,
						linkTo(methodOn(ProductController.class).getProduct(product.getId())).withSelfRel(),
						linkTo(methodOn(ProductController.class).allProducts()).withRel("products")))
				.collect(Collectors.toList());

		return ResponseEntity.ok( //
				CollectionModel.of(products,
						linkTo(methodOn(ProductController.class).allProducts()).withSelfRel()));
	}

	@GetMapping("/products/{id}")
	ResponseEntity<EntityModel<Product>> getProduct(@PathVariable String id) {

		return productService.getProduct(id)
				.map(product -> EntityModel.of(product,
						linkTo(methodOn(ProductController.class).getProduct(product.getId())).withSelfRel(),
						linkTo(methodOn(ProductController.class).allProducts()).withRel("products")))
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
