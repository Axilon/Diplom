package ru.bk.rom4ik2103.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bk.rom4ik2103.dao.ProductDAO;
import ru.bk.rom4ik2103.productPuck.Product;
import ru.bk.rom4ik2103.productPuck.ProductType;

import java.util.List;

/**
 * Created by user on 25.05.2017.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    @Transactional
    public void deleteProductById(long[] ids) {
        productDAO.deleteProductById(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductById(long ids) {
        return productDAO.findProductById(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProducyByName(String name) {
        return productDAO.findProducyByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> showListByProductType(ProductType productType) {
        return productDAO.showListByProductType(productType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> showListBySearchLine(String pattern) {
        return productDAO.showListBySearchLine(pattern);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }
}
