package ru.bk.rom4ik2103.dao;

import ru.bk.rom4ik2103.productPuck.Product;
import ru.bk.rom4ik2103.productPuck.ProductType;

import java.util.List;


public interface ProductDAO {
    void addProduct(Product product);
    void deleteProductById (long[] ids);
    Product findProductById(long ids);
    Product findProducyByName( String name);
    List<Product> showListByProductType (ProductType productType); // список по имени типа товаро либо полный список
    List<Product> showListBySearchLine (String pattern); //список по строке поиска
    void updateProduct(Product product);
}
