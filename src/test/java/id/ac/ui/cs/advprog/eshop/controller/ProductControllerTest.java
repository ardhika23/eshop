package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProductPage() {
        String expectedView = "createProduct";
        String actualView = productController.createProductPage(model);

        verify(model).addAttribute(eq("product"), any(Product.class));
        assertEquals(expectedView, actualView);
    }

    @Test
    void testCreateProductPost() {
        Product dummyProduct = new Product();
        String expectedRedirect = "redirect:list";
        String actualRedirect = productController.createProductPost(dummyProduct, model);

        verify(productService).create(productCaptor.capture());
        assertEquals(dummyProduct, productCaptor.getValue());
        assertEquals(expectedRedirect, actualRedirect);
    }

    @Test
    void testProductListPage() {
        List<Product> expectedProducts = Arrays.asList(new Product(), new Product());
        when(productService.findAll()).thenReturn(expectedProducts);

        String expectedView = "ProductList";
        String actualView = productController.productListPage(model);

        verify(model).addAttribute("products", expectedProducts);
        assertEquals(expectedView, actualView);
    }

    @Test
    void testDeleteProduct() {
        String productId = "testId";
        String expectedRedirect = "redirect:/product/list";
        String actualRedirect = productController.deleteProduct(productId);

        verify(productService).delete(productId);
        assertEquals(expectedRedirect, actualRedirect);
    }

    @Test
    void testEditProductPage() {
        String productId = "testEditId";
        Product expectedProduct = new Product();
        when(productService.findById(productId)).thenReturn(expectedProduct);

        String expectedView = "EditProduct";
        String actualView = productController.editProductPage(productId, model);

        verify(model).addAttribute("product", expectedProduct);
        assertEquals(expectedView, actualView);
    }

    @Test
    void testUpdateProduct() {
        Product productToUpdate = new Product();
        String expectedRedirect = "redirect:/product/list";
        String actualRedirect = productController.updateProduct(productToUpdate);

        verify(productService).update(productCaptor.capture());
        assertEquals(productToUpdate, productCaptor.getValue());
        assertEquals(expectedRedirect, actualRedirect);
    }
}
