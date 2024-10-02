package com.taltech.demo;

import com.taltech.demo.model.Product;
import com.taltech.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	private ProductRepository productRepository;

	public DemoApplication(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		List<Product> products = new ArrayList();
			products.add(new Product("Product 1", "Test product", 10, 5));
			products.add(new Product("Product 2", "Test product", 8, 3));
			products.add(new Product("Product 3", "Test product", 15, 1));
			products.add(new Product("Product 4", "Test product", 20, 9));

		productRepository.saveAll(products);
	}
}
