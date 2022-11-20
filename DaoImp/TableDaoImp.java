package ra.Model.DaoImp;

import javafx.scene.control.Tab;
import ra.Model.Dao.TableDao;
import ra.Model.Entity.Table;
import ra.Model.Util.ConnectionDataBase;

import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class TableDaoImp implements TableDao<Table, String> {


    @Override
    public List<Table> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Table> tableList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 4pr_GetAllTable(?)}");
            ResultSet rs = callSt.executeQuery();
            tableList = new ArrayList<>();
            if (rs.next()) {
                Table table = new Table();
                table.setTableID(rs.getInt("TableID"));
                table.setTableName(rs.getString("TableName"));
                table.setTableSeat(rs.getInt("TableSeat"));
                table.setTableStatus(rs.getBoolean("TableStatus"));
                table.setTableImg(rs.getString("TableImg"));
                table.setDescription(rs.getString("Descriptiong"));
                tableList.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return tableList;
    }

    @Override
    public boolean create(Table table) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 4pr_InsertTable(?,?,?,?,?,?)}");
            callSt.setString(1, table.getTableName());
            callSt.setInt(2, table.getTableSeat());
            callSt.setBoolean(3, table.isTableStatus());
            callSt.setString(4, table.getDescription());
            callSt.setString(5, table.getTableImg());
            callSt.registerOutParameter(6, Types.INTEGER);
            callSt.execute();
            int tableID = callSt.getInt(6);
            for (String imgLinks : table.getStringListImg()){
                CallableStatement callSt2 = conn.prepareCall("{call 4pr_insert_Image(?,?)}");
                callSt2.setString(1,imgLinks);
                callSt2.setInt(2,tableID);
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
    public boolean update(Table table) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_UpdateTable(?,?,?,?)}");
            callSt.setInt(1, table.getTableID());
            callSt.setString(2, table.getTableName());
            callSt.setInt(3, table.getTableSeat());
            callSt.setBoolean(4, table.isTableStatus());
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
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Table getById(String id) {
        return null;
    }

    @Override
    public List<Table> searchTableByName(String name) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_DeleteTable(?)}");
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
    public Table getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Table table = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_GetByIdTable(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            table = new Table();
            if (rs.next()) {
                table.setTableID(rs.getInt("TableID"));
                table.setTableName(rs.getString("TableName"));
                table.setTableSeat(rs.getInt("TableSeat"));
                table.setTableStatus(rs.getBoolean("TableStatus"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return table;
    }
}
