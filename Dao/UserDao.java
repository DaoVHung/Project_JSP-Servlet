package ra.Model.Dao;

import ra.Model.Entity.User;

import java.util.List;

public interface UserDao<T,V> extends ManagementDao<T,V> {
    List<T> searchUserByName(String name);

    boolean delete(Integer id);

    User getById(Integer id);
}
