package ra.Model.DaoImp;

import ra.Model.Dao.BillDao;
import ra.Model.Entity.Bill;
import ra.Model.Util.ConnectionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImp implements BillDao<Bill, String> {

    @Override
    public List<Bill> searchBillByName(String name) throws SQLException {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Bill> billList = null;
        conn = ConnectionDataBase.openConnection();
        callSt = conn.prepareCall("");
        ResultSet rs = callSt.executeQuery();
        billList = new ArrayList<>();
        while (rs.next()) {
            Bill bill = new Bill();
            bill.setBillID(rs.getInt("BillID"));
            bill.setFoodID(rs.getInt("FoodID"));
            bill.setDrinksID(rs.getInt("DinksID"));
            bill.setTableID(rs.getInt("TableID"));
            bill.setBillStatus(rs.getBoolean("BillStatus"));
            bill.setPrice(rs.getInt("BillPrice"));
            bill.setCreated(rs.getDate("CreateDate"));
            billList.add(bill);
        }
        return billList;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_DeleteBILL(?)}");
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
    public Bill getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Bill billInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_GetByIdBILL(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            billInfo = new Bill();
            if (rs.next()) {
                billInfo.setBillID(rs.getInt("BillID"));
                billInfo.setFoodID(rs.getInt("FoodID"));
                billInfo.setDrinksID(rs.getInt("DinksID"));
                billInfo.setTableID(rs.getInt("TableID"));
                billInfo.setBillStatus(rs.getBoolean("BillStatus"));
                billInfo.setPrice(rs.getInt("BillPrice"));
                billInfo.setCreated(rs.getDate("CreateDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return billInfo;
    }

    @Override
    public List<Bill> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Bill> billList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_GetAllBILL()}");
            ResultSet rs = callSt.executeQuery();
            billList = new ArrayList<>();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBillID(rs.getInt("BillID"));
                bill.setFoodID(rs.getInt("FoodID"));
                bill.setDrinksID(rs.getInt("DinksID"));
                bill.setTableID(rs.getInt("TableID"));
                bill.setBillStatus(rs.getBoolean("BillStatus"));
                bill.setPrice(rs.getInt("BillPrice"));
                bill.setCreated(rs.getDate("CreateDate"));
                billList.add(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return billList;
    }

    @Override
    public boolean create(Bill bill) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_InsertBILL(?,?,?,?,?,?,?)}");
            callSt.setInt(1, bill.getBillID());
            callSt.setInt(2, bill.getFoodID());
            callSt.setInt(3, bill.getDrinksID());
            callSt.setInt(4, bill.getTableID());
            callSt.setBoolean(5, bill.isBillStatus());
            callSt.setInt(6, bill.getPrice());
            callSt.setDate(7, new Date(bill.getCreated().getTime()));
            callSt.execute();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean update(Bill bill) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_UpdateBILL(?,?,?,?,?,?,?)}");
            callSt.setInt(1, bill.getBillID());
            callSt.setInt(2, bill.getFoodID());
            callSt.setInt(3, bill.getDrinksID());
            callSt.setInt(4, bill.getTableID());
            callSt.setBoolean(5, bill.isBillStatus());
            callSt.setInt(6, bill.getPrice());
            callSt.setDate(7, new Date(bill.getCreated().getTime()));
            callSt.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {

        return false;
    }

    @Override
    public Bill getById(String id) {
        return null;
    }
}


