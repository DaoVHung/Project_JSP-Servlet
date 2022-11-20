package ra.Model.ServiceImp;

import ra.Model.Entity.Table;
import ra.Model.Service.TableService;

import java.util.List;

public class TableServiceImp implements TableService {
    @Override
    public List getAll() {
        return null;
    }

    @Override
    public boolean save(Object o) {
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }

    @Override
    public Object getById(Object id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Table getById(Integer id) {
        return null;
    }

    @Override
    public List searchProByName(String name) {
        return null;
    }

    @Override
    public List searchBetween(Float num1, Float num2) {
        return null;
    }

    @Override
    public List getAllBySort() {
        return null;
    }
}
