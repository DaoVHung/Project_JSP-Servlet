package ra.Model.Service;

import ra.Model.Entity.User;

import java.util.List;

public interface UserServiceImp<T,V> extends ManageService<T,V> {
    boolean delete(Integer id);

    User getById(Integer id);

    List<T> searchProByName(String name);

    List<T> searchBetween(Float num1, Float num2);

    List<T> getAllBySort();
}
