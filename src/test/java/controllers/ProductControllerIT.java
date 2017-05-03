package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsControllerConfig;
import config.TestsPersistenceConfig;
import wrappers.ProductWrapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class, TestsControllerConfig.class})
public class ProductControllerIT {

    @Autowired
    private ProductController productController;

    @Test
    public void testGetProductByCode() {
        String productCode = "article0";
        ProductWrapper product = productController.getProductByCode(productCode);
        assertNotNull(product);
        assertEquals(productCode, product.getCode());
    }

    @Test
    public void testGetNonexistentProductByCode() {
        String productCode = "justTesting-123";
        ProductWrapper product = productController.getProductByCode(productCode);
        assertNull(product);
    }
    
    @Test
    public void testExistentProductId() {
        long productId = 84000001111L;
        assertTrue(productController.productExists(productId));
    }
    
    @Test
    public void testNonexistentProductId() {
        long productId = 99999999999L;
        assertFalse(productController.productExists(productId));
    }
}