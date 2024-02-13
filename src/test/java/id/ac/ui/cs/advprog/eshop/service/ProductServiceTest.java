package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product testProduct;

    @BeforeEach
    void setUp() {
        testProduct = new Product();
        testProduct.setProductName("Shampo Kuda");
        testProduct.setProductQuantity(100);
        // Note: Product ID is automatically set in the Product class
    }

    @Test
    void testCreateProduct() {
        when(productRepository.create(any(Product.class))).thenReturn(testProduct);

        Product createdProduct = productService.create(testProduct);

        assertNotNull(createdProduct);
        assertEquals("Shampo Kuda", createdProduct.getProductName());
        assertTrue(createdProduct.getProductQuantity() > 0);
        verify(productRepository).create(testProduct);
    }

    @Test
    void testFindAllProductsWhenNotEmpty() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(testProduct).iterator());

        List<Product> products = productService.findAll();

        assertFalse(products.isEmpty());
        assertEquals(1, products.size());
        assertEquals(testProduct.getProductName(), products.get(0).getProductName());
    }

    @Test
    void testFindAllProductsWhenEmpty() {
        when(productRepository.findAll()).thenReturn(new ArrayList<Product>().iterator());

        List<Product> products = productService.findAll();

        assertTrue(products.isEmpty());
    }

    @Test
    void testDeleteProduct() {
        String productId = testProduct.getProductId(); // Get ID from the test product
        when(productRepository.delete(productId)).thenReturn(true);

        boolean deleted = productService.delete(productId);

        assertTrue(deleted);
        verify(productRepository).delete(productId);
    }

    @Test
    void testFindProductByIdFound() {
        String productId = testProduct.getProductId();
        when(productRepository.findById(productId)).thenReturn(testProduct);

        Product foundProduct = productService.findById(productId);

        assertNotNull(foundProduct);
        assertEquals(testProduct.getProductName(), foundProduct.getProductName());
    }

    @Test
    void testUpdateProduct() {
        doNothing().when(productRepository).update(any(Product.class));

        productService.update(testProduct);

        verify(productRepository).update(testProduct);
    }
}
