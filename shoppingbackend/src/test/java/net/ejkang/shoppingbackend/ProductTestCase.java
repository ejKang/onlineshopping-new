package net.ejkang.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ejkang.shoppingbackend.dao.ProductDAO;
import net.ejkang.shoppingbackend.dto.Product;

public class ProductTestCase {
    
    public static AnnotationConfigApplicationContext context;
    private static ProductDAO productDAO;

    private Product product;

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("net.ejkang.shoppingbackend");
        context.refresh();
        productDAO = (ProductDAO) context.getBean("ProductDAO");
    }

    @Test 
    public void testProductCRUD() {
        product = new Product();
        product.setName("abc");
        product.setBrand("ooop");
        product.setDescription("wow description ~ ");
        product.setUnitPrice(25000);
        product.setActive(true);
        product.setCategoryId(3);
        product.setSupplierId(3);

        assertEquals("something went wrong ! ", true,  productDAO.add(product));

        product = productDAO.get(6);
        product.setName("newnamechanged");
        assertEquals("something went wrong ! ", true, productDAO.update(product));

        assertEquals("something went wrong ! ", true, productDAO.delete(product));

        assertEquals("something went wrong ! ", 6, productDAO.list().size());
    }

    @Test
    public void testGetList() {
        assertEquals("something went wrong ! ", 5, productDAO.listActiveProducts().size());

        assertEquals("something went wrong ! ", 3, productDAO.listActiveProductsByCategoryId(3).size());

        assertEquals("something went wrong ! ", 3, productDAO.getLatestActiveProducts(3).size());

    }
}