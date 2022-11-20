package ra.Model.Dao;

import ra.Model.Entity.Catalog;

import java.util.List;

public interface CatalogDao<T,V> extends ManagementDao<T,V> {
    List<T> searchBillByName(String name);

    boolean delete(Integer id);

    Catalog getById(Integer id);
}
