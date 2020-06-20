package net.ejkang.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ejkang.shoppingbackend.dao.CategoryDAO;
import net.ejkang.shoppingbackend.dto.Category;

public class CategoryTestCase {
    private static AnnotationConfigApplicationContext context;

    private static CategoryDAO categoryDAO;

    private Category category;

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("net.ejkang.shoppingbackend");
        context.refresh();

        categoryDAO = (CategoryDAO) context.getBean("CategoryDAO");
    }

    @Test
    public void testAddCategory() {
        category = new Category();
        category.setName("Mobile1");
        category.setDescription("This is some description for mobile1");
        category.setImageURL("CAT_2_1.png");

        assertEquals("Successfully added a category", true, categoryDAO.add(category));

    }
}