package ra.Model.Dao;

import java.util.List;

public interface ManagementDao<T,V> {
    List<T> getAll();
    boolean create(T t);
    boolean update(T t);
    boolean delete(V id);
    T getById( V id);
}
