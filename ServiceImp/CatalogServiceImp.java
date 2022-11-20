package ra.Model.ServiceImp;

import ra.Model.Dao.CatalogDao;
import ra.Model.DaoImp.CatalogImp;
import ra.Model.Entity.Catalog;
import ra.Model.Service.CatalogService;

import java.util.List;

public class CatalogServiceImp implements CatalogService<Catalog, String> {

private CatalogDao<Catalog,String> stringCatalogDao = new CatalogImp();
    @Override
    public boolean delete(Integer id) {
        return stringCatalogDao.delete(id);
    }

    @Override
    public Catalog getById(Integer id) {
        return stringCatalogDao.getById(id);
    }

    @Override
    public List<Catalog> searchProByName(String name) {
        return stringCatalogDao.searchBillByName(name);
    }

    @Override
    public List<Catalog> searchBetween(Float num1, Float num2) {
        return null;
    }

    @Override
    public List<Catalog> getAllBySort() {
        return null;
    }

    @Override
    public List<Catalog> getAll() {
        return stringCatalogDao.getAll();
    }

    @Override
    public boolean save(Catalog catalog) {
        return stringCatalogDao.create(catalog);
    }

    @Override
    public boolean update(Catalog catalog) {
        return stringCatalogDao.update(catalog);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Catalog getById(String id) {
        return null;
    }
}
