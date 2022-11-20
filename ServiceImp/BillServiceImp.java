package ra.Model.ServiceImp;

import ra.Model.Entity.Bill;
import ra.Model.Service.BillService;

import java.util.List;

public class BillServiceImp implements BillService {
    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Bill getById(Integer id) {
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
}
