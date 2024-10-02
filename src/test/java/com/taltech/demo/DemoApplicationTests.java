package com.taltech.demo;

import com.taltech.demo.model.Product;
import com.taltech.demo.repository.ProductRepository;
import com.taltech.demo.service.ProductService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	private ProductService productService;
	private ProductRepository productRepository;

	@BeforeEach
	public void setUp() {
		productService = Mockito.mock(ProductService.class);
		productRepository = Mockito.mock(ProductRepository.class);
	}

	@DisplayName("Should return list of products")
	@Test
	void shouldReturnProductList() {
		List<Product> mockData = new ArrayList<>();
		mockData.add(new Product("Product 1", "Test product", 10, 5));
		mockData.add(new Product("Product 2", "Test product", 8, 3));
		mockData.add(new Product("Product 3", "Test product", 15, 1));
		mockData.add(new Product("Product 4", "Test product", 20, 9));

		Mockito.when(productRepository.findAll()).thenReturn(mockData);
		Mockito.when(productService.getProductList()).thenAnswer(invocation -> productRepository.findAll());

		List<Product> result = productService.getProductList();

		Assertions.assertEquals(4, result.size());
		Assertions.assertEquals(mockData, result);
	}




}
