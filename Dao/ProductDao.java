package ra.Model.Dao;

import ra.Model.Entity.Product;

import java.util.List;

public interface ProductDao<T,V> extends ManagementDao<T,V> {
    List<T> searchProductByName(String name);

    boolean delete(Integer id);

    Product getById(Integer id);

}
