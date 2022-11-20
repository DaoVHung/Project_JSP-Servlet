package ra.Model.Service;

import ra.Model.Entity.Product;

import java.util.List;

public interface ProductService<T,V> extends ManageService<T,V> {
    boolean delete(Integer id);

    Product getById(Integer id);

    List<T> searchProByName(String name);

    List<T> searchBetween(Float num1, Float num2);

    List<T> getAllBySort();
}
