package com.taltech.demo;

import com.taltech.demo.model.Product;
import com.taltech.demo.repository.ProductRepository;
import com.taltech.demo.service.ProductService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


	@DisplayName("Should return product when ID is found")
	@Test
	void shouldReturnProductWhenIdIsFound() {
		Long productId = 1L;
		Product mockProduct = new Product("Product 1", "Test product", 10, 5);

		Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(mockProduct));
		Mockito.when(productService.getProductById(productId)).thenAnswer(invocation -> {
			Long id = invocation.getArgument(0);
			return productRepository.findById(id).orElse(null);
		});

		Product result = productService.getProductById(productId);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(mockProduct, result);
		Assertions.assertEquals("Product 1", result.getName());
	}

	@DisplayName("Should return null when product is not found")
	@Test
	void shouldReturnNullWhenProductNotFound() {
		Long productId = 10L;

		Mockito.when(productRepository.findById(productId)).thenReturn(Optional.empty());

		Product result = productService.getProductById(productId);

		Assertions.assertNull(result);
	}



}
