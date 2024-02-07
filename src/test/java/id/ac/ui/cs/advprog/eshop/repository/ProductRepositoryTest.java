package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de47-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Bambang");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteProduct() {
        Product productToDelete = new Product();
        productToDelete.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        productToDelete.setProductName("Sampo Cap Bambang");
        productToDelete.setProductQuantity(23);
        productRepository.create(productToDelete);

        productRepository.delete(productToDelete.getProductId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteIfProductMoreThanOne() {
        Product firstProduct = new Product();
        firstProduct.setProductName("Shampoo X");
        firstProduct.setProductQuantity(100);
        productRepository.create(firstProduct);

        Product secondProduct = new Product();
        secondProduct.setProductName("Shampoo Y");
        secondProduct.setProductQuantity(60);
        productRepository.create(secondProduct);

        boolean isDeleted = productRepository.delete(firstProduct.getProductId());

        assertTrue(isDeleted);
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product remainingProduct = productIterator.next();
        assertEquals(secondProduct.getProductId(), remainingProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testAttemptToDeleteNonExistentProduct() {
        String nonExistentProductId = "non-existent-id";
        boolean isDeleted = productRepository.delete(nonExistentProductId);
        assertFalse(isDeleted);
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setProductName("Body Wash Aqua Fresh");
        product.setProductQuantity(35);
        productRepository.create(product);

        product.setProductName("Body Wash Ocean Breeze");
        product.setProductQuantity(55);
        productRepository.update(product);

        Product updatedProduct = productRepository.findById(product.getProductId());
        assertNotNull(updatedProduct);
        assertEquals("Body Wash Ocean Breeze", updatedProduct.getProductName());
        assertEquals(55, updatedProduct.getProductQuantity());
    }

    @Test
    void testUpdate() {
        Product product1 = new Product();
        product1.setProductId("022c3fb6-9e0e-441a-a4e3-eb0824f6abf4");
        product1.setProductName("Product Name 69");
        product1.setProductQuantity(40);
        productRepository.create(product1);

        String updatedName = "Updated Product Name 69";
        int updatedQuantity = 75;
        product1.setProductName(updatedName);
        product1.setProductQuantity(updatedQuantity);
        productRepository.update(product1);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext(), "Expected at least one product after update");
        Product updatedProduct = productIterator.next();
        assertEquals(updatedName, updatedProduct.getProductName(), "Product name did not update correctly");
        assertEquals(updatedQuantity, updatedProduct.getProductQuantity(), "Product quantity did not update correctly");
    }

    @Test
    void testUpdateNonExistingProduct() {
        // Create a product
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(70);
        productRepository.create(product);

        // Attempt to update a non-existing product
        String nonExistingId = "3a7c0d8e-9b21-4f4e-7d8a-2c9e8b1d0f4e";
        String updatedName = "Sampo Cap Ria";
        int updatedQuantity = 40;
        Product updatedProduct = new Product();
        updatedProduct.setProductId(nonExistingId);
        updatedProduct.setProductName(updatedName);
        updatedProduct.setProductQuantity(updatedQuantity);
        productRepository.update(updatedProduct);

        // Check if the product is not updated
        Iterator<Product> productIterator = productRepository.findAll();
        boolean updated = false;
        while (productIterator.hasNext()) {
            Product curProduct = productIterator.next();
            if (curProduct.getProductId().equals("eb558e9f-1c39-460e-8860-71af6af63bd6")) {
                assertEquals("Sampo Cap Bambang", curProduct.getProductName());
                assertEquals(70, curProduct.getProductQuantity());
            } else if (curProduct.getProductId().equals(nonExistingId)) {
                updated = true;
            }
        }
        assertFalse(updated, "Non-existing product should not be updated.");
    }

}