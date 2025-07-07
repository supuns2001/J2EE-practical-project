package lk.jiat.app.ejb.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lk.jiat.app.core.model.Product;
import lk.jiat.app.core.service.ProductService;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductSessionBean implements ProductService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Product getProductById(long id) {
        Product product = em.find(Product.class, id);
        return product;
    }

    @Override
    public Product getProductByName(String name) {
        Product product = em.createNamedQuery("Product.findByName", Product.class)
                .setParameter("name", name)
                .getSingleResult();
        return product;

    }

    @Override
    public List<Product> getProductByCategory(String category) {
        List<Product> product = em.createNamedQuery("Product.findByCategory", Product.class)
                .setParameter("category", category)
                .getResultList();
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> product = em.createNamedQuery("Product.findAll", Product.class)
                .getResultList();
        return product;

    }

    @Override
    public void addProduct(Product product) {
        em.persist(product);

    }

    @Override
    public void updateProduct(Product product) {

        em.merge(product);

    }

    @Override
    public void deleteProduct(long id) {
        Product product = getProductById(id);
        em.remove(product);

    }
}
