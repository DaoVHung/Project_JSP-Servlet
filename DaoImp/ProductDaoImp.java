package ra.Model.DaoImp;

import ra.Model.Dao.ProductDao;
import ra.Model.Entity.Product;
import ra.Model.Util.ConnectionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao<Product,String> {

    @Override
    public List<Product> searchProductByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productsInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_SearchByProductName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            productsInfo = new ArrayList<>();
            while (rs.next()) {
                Product products = new Product();
                products.setProductID(rs.getInt("productID"));
                products.setCatalogID(rs.getString("CatalogName"));
                products.setProductName(rs.getString("productName"));
                products.setPrice(rs.getInt("productPrice"));
                products.setTitle(rs.getString("productTitle"));
                products.setProductStatus(rs.getBoolean("productStatus"));
                productsInfo.add(products);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productsInfo;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt2 = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt2 = conn.prepareCall(" {call 3pr_DeleteProductImg(?) }");
            callSt2.setInt(1,id);
            callSt2.executeUpdate();
            callSt = conn.prepareCall("{call 3pr_DeleteProduct(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public Product getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Product productInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetByIdProduct(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            productInfo = new Product();
            if (rs.next()) {
                productInfo.setProductID(rs.getInt("ProductID"));
                productInfo.setProductName(rs.getString("ProductName"));
                productInfo.setPrice(rs.getInt("ProductPrice"));
                productInfo.setTitle(rs.getString("ProductTitle"));
                productInfo.setDescription(rs.getString("descriptions"));
                productInfo.setProductImg(rs.getString("ProductImg"));
                CallableStatement callSt2 = conn.prepareCall("{call 7pr_get_Img_ID(?) }");
                callSt2.setInt(1,id);
                ResultSet rs2 = callSt2.executeQuery();
                while (rs2.next()){
                    productInfo.getListImgLinks().add(rs2.getString("imgLink"));

                }
                callSt2.close();
             }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productInfo;
    }
    @Override
    public List<Product> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetAllProduct()}");
            ResultSet rs = callSt.executeQuery();
            productInfo = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCatalogID(rs.getString("CatalogName"));
                product.setProductName(rs.getString("ProductName"));
                product.setPrice(rs.getInt("ProductPrice"));
                product.setTitle(rs.getString("ProductTitle"));
                product.setProductStatus(rs.getBoolean("ProductStatus"));
                product.setProductImg(rs.getString("ProductImg"));
                product.setDescription(rs.getString("descriptions"));
                productInfo.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productInfo;
    }
    public List<Product> getAllShort() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetAllProduct()}");
            ResultSet rs = callSt.executeQuery();
            productInfo = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCatalogID(rs.getString("CatalogName"));
                product.setProductName(rs.getString("ProductName"));
                product.setPrice(rs.getInt("ProductPrice"));
                product.setTitle(rs.getString("ProductTitle"));
                product.setProductStatus(rs.getBoolean("ProductStatus"));
                productInfo.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productInfo;
    }

    @Override
    public boolean create(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;

        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_InsertProduct(?,?,?,?,?,?,?,?)}");
            callSt.setInt(1, Integer.parseInt(product.getCatalogID()));
            callSt.setString(2, product.getProductName());
            callSt.setInt(3, product.getPrice());
            callSt.setString(4, product.getTitle());
            callSt.setString(5, product.getDescription());
            callSt.setBoolean(6, product.isProductStatus());
            callSt.setString(7,product.getProductImg());
            callSt.registerOutParameter(8, Types.INTEGER);
            callSt.execute();
            int productID = callSt.getInt(8);

            for (String imgLinks : product.getListImgLinks()){
                CallableStatement callSt2 = conn.prepareCall("{call 7pr_insert_Image(?,?) }");

                callSt2.setString(1,imgLinks);
                callSt2.setInt(2,productID);
                callSt2.executeUpdate();
                callSt2.close();
            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        CallableStatement callSt3 = null;
        ;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_UpdateProduct(?,?,?,?,?,?,?,?)}");
            callSt.setInt(1,product.getProductID());
            callSt.setInt(2, Integer.parseInt(product.getCatalogID()));
            callSt.setString(3, product.getProductName());
            callSt.setInt(4, product.getPrice());
            callSt.setString(5, product.getTitle());
            callSt.setString(6, product.getDescription());
            callSt.setBoolean(7, product.isProductStatus());
            callSt.setString(8,product.getProductImg());

            callSt.executeUpdate();
            int productID = product.getProductID();
            callSt3 = conn.prepareCall(" {call 3pr_DeleteProductImg(?) }");
            callSt3.setInt(1,productID);
            callSt3.executeUpdate();
            for (String imgLinks : product.getListImgLinks()){
                CallableStatement callSt2 = conn.prepareCall("{call 7pr_insert_Image(?,?) }");
                callSt2.setString(1,imgLinks);
                callSt2.setInt(2,productID);
                callSt2.executeUpdate();
                callSt2.close();
            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return result;
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
