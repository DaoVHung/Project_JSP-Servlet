package ra.Model.Service;

import ra.Model.Entity.Catalog;

import java.util.List;

public interface CatalogService<T,V> extends ManageService<T,V> {
    boolean delete(Integer id);

    Catalog getById(Integer id);

    List<T> searchProByName(String name);

    List<T> searchBetween(Float num1, Float num2);

    List<T> getAllBySort();
}
