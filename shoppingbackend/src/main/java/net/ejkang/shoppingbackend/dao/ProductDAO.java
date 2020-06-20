package net.ejkang.shoppingbackend.dao;

import java.util.List;

import net.ejkang.shoppingbackend.dto.Product;

public interface ProductDAO {
    Product get(int productId);
    List<Product> list();
    boolean add(Product product);
    boolean update(Product product);
    boolean delete(Product product);

    List<Product> listActiveProducts();
    List<Product> listActiveProductsByCategoryId(int categoryId);
    List<Product> getLatestActiveProducts(int cnt);
    
}