package lk.jiat.app.core.service;

import jakarta.ejb.Remote;
import lk.jiat.app.core.model.Product;

import java.util.List;
import java.util.Optional;

@Remote
public interface ProductService {

    Product getProductById(long id);
    Product getProductByName(String name);
    List<Product> getProductByCategory(String category);
    List<Product> getAllProduct();

    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(long id);



}
