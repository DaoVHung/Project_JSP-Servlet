package ra.Model.ServiceImp;

import ra.Model.Dao.ProductDao;
import ra.Model.DaoImp.ProductDaoImp;
import ra.Model.Entity.Product;
import ra.Model.Service.ProductService;

import java.util.List;

public class ProductVerviceImp implements ProductService<Product, String> {
    private ProductDao<Product,String> productDao = new ProductDaoImp();
    @Override
    public boolean delete(Integer id) {
        return productDao.delete(id);
    }

    @Override
    public Product getById(Integer id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> searchProByName(String name) {
        return productDao.searchProductByName(name);
    }

    @Override
    public List<Product> searchBetween(Float num1, Float num2) {
        return null;
    }

    @Override
    public List<Product> getAllBySort() {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean save(Product drinks) {
        return productDao.create(drinks);
    }

    @Override
    public boolean update(Product drinks) {
        return productDao.update(drinks);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Product getById(String id) {
        return null;
    }
}
