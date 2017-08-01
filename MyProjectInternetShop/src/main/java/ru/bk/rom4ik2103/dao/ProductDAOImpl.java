package ru.bk.rom4ik2103.dao;

import org.springframework.stereotype.Repository;
import ru.bk.rom4ik2103.productPuck.Product;
import ru.bk.rom4ik2103.productPuck.ProductType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addProduct(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void deleteProductById(long [] ids) {
        Product c;
        for (long id : ids) {
            c = entityManager.getReference(Product.class, id);
            entityManager.remove(c);
        }
    }

    @Override
    public Product findProducyByName(String name) {
        Query query;
        query= entityManager.createQuery("SELECT c FROM Product c WHERE c.name = :name", Product.class);
        query.setParameter("name", name);
        return (Product) query.getSingleResult();
    }

    @Override
    public Product findProductById(long ids) {
        Query query;
        query= entityManager.createQuery("SELECT c FROM Product c WHERE c.id = :id", Product.class);
        query.setParameter("id", ids);
        return (Product) query.getSingleResult();
    }

    @Override
    public List<Product> showListByProductType(ProductType productType) {
        Query query;
        if (productType!=null){
            query = entityManager.createQuery("SELECT c FROM Product c WHERE c.productType = :productType ORDER BY c.id ASC ", Product.class);

            query.setParameter("productType", productType);
        }else{
            query = entityManager.createQuery("SELECT c FROM Product c ORDER BY c.id", Product.class);
        }
        return (List <Product>) query.getResultList();
    }

    @Override
    public List<Product> showListBySearchLine(String pattern) {
        Query query = entityManager.createQuery("SELECT c FROM Product c WHERE c.name LIKE :pattern");
        query.setParameter("pattern", "%" + pattern + "%");

        return (List<Product>) query.getResultList();
    }

    @Override
    public void updateProduct(Product product) {
        entityManager.refresh(product);
    }
}
