package ra.Model.DaoImp;

import ra.Model.Dao.UserDao;
import ra.Model.Entity.Bill;
import ra.Model.Entity.User;
import ra.Model.Util.ConnectionDataBase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao<User, String> {


    @Override
    public List<User> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<User> userList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_GetAllBILL()}");
            ResultSet rs = callSt.executeQuery();
            userList = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("UserPassword"));
                user.setConfirmPass(rs.getString("UserConfirm"));
                user.setFullName(rs.getString("UserFullName"));
                user.setUserStatus(rs.getBoolean("UserStatus"));
                user.setPermission(rs.getBoolean("UserPermission"));
                user.setEmail(rs.getString("UserEmail"));
                user.setPhoneNumber(rs.getString("UserPhoneNumber"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return userList;
    }

    @Override
    public boolean create(User user) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_InsertUser(?,?,?,?,?,?,?,?)}");
            callSt.setInt(1, user.getUserID());
            callSt.setString(2, user.getUserName());
            callSt.setString(3, user.getPassword());
            callSt.setString(4, user.getConfirmPass());
            callSt.setString(5, user.getFullName());
            callSt.setBoolean(6, user.isUserStatus());
            callSt.setBoolean(7, user.isPermission());
            callSt.setString(8, user.getEmail());
            callSt.setString(9, user.getPhoneNumber());
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
    public boolean update(User user) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_UpdateUser(?,?,?,?,?,?,?,?)}");
            callSt.setInt(1, user.getUserID());
            callSt.setString(2, user.getUserName());
            callSt.setString(3, user.getPassword());
            callSt.setString(4, user.getConfirmPass());
            callSt.setString(5, user.getFullName());
            callSt.setBoolean(6, user.isUserStatus());
            callSt.setBoolean(7, user.isPermission());
            callSt.setString(8, user.getEmail());
            callSt.setString(9, user.getPhoneNumber());
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
    public User getById(String id) {
        return null;
    }

    @Override
    public List<User> searchUserByName(String name) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_DeleteUser(?)}");
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
    public User getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        User user = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_GetByIdUser(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            user = new User();
            while (rs.next()) {
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("UserPassword"));
                user.setConfirmPass(rs.getString("UserConfirm"));
                user.setFullName(rs.getString("UserFullName"));
                user.setUserStatus(rs.getBoolean("UserStatus"));
                user.setPermission(rs.getBoolean("UserPermission"));
                user.setEmail(rs.getString("UserEmail"));
                user.setPhoneNumber(rs.getString("UserPhoneNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return user;
    }
}
