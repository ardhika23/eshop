package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrlGet;
    private String baseUrlList;

    @BeforeEach
    public void setUp() {
        baseUrlGet = String.format("%s:%d/product/create", testBaseUrl, serverPort);
        baseUrlList = String.format("%s:%d/product/list", testBaseUrl, serverPort);
    }

    @Test
    void testCreateProduct(ChromeDriver driver) {
        // Navigate to the product creation page
        driver.get(baseUrlGet);

        // Input fields for the product details
        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        productNameInput.sendKeys("Test Product");
        productQuantityInput.sendKeys("25");

        // Submit the form to create a new product
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        // Wait and verify the product is added by checking the list
        driver.get(baseUrlList);
        WebElement productList = driver.findElement(By.tagName("body"));
        String productListText = productList.getText();
        assertTrue(productListText.contains("Test Product"));
        assertTrue(productListText.contains("25"));
    }

    @AfterEach
    public void tearDown(ChromeDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
