package ra.Model.Dao;

import ra.Model.Entity.Bill;

import java.sql.SQLException;
import java.util.List;

public interface BillDao<T,V> extends ManagementDao<T,V> {
    List<T> searchBillByName(String name) throws SQLException;

    boolean delete(Integer id);

    Bill getById(Integer id);
}
