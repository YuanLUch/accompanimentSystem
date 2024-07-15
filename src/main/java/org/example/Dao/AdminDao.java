package org.example.Dao;

import org.example.Entity.Admin;

import java.sql.*;
import java.util.ArrayList;

public class AdminDao {
    Connection cnn;
    public AdminDao() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accompanimentSystem?useUnicode=true&characterEncoding=utf8", "root", "");
    }

    // 新增管理员
    public void addAdmin(Admin admin) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 插入除ID外其他值
        String sql = "insert into admin (admin_name, admin_password, admin_phone) values ('" + admin.getAdminName() + "', '" + admin.getAdminPassword() + "', '" + admin.getAdminPhone() + "')";
        System.out.println(sql);
        statement.execute(sql);
    }

    // 删除管理员
    public void deleteAdmin(int id) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 删除ID为id的管理员
        String sql = "delete from admin where admin_id = " + id;
        System.out.println(sql);
        statement.execute(sql);
    }

    // 修改管理员
    public void updateAdmin(Admin admin) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 更新ID为admin.getAdminId()的管理员的信息
        String sql = "update admin set admin_name = '" + admin.getAdminName() + "', admin_password = '" + admin.getAdminPassword() + "', admin_phone = '" + admin.getAdminPhone() + "' where admin_id = " + admin.getAdminId();
        System.out.println(sql);
        statement.execute(sql);
    }

    // 获取所有管理员
    public ArrayList<Admin> getAllAdmin() throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 获取所有管理员
        String sql = "select * from admin";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        ArrayList<Admin> admins = new ArrayList<>();
        while (resultSet.next()) {
            Admin admin = new Admin();
            admin.setAdminId(resultSet.getInt("admin_id"));
            admin.setAdminName(resultSet.getString("admin_name"));
            admin.setAdminPassword(resultSet.getString("admin_password"));
            admin.setAdminPhone(resultSet.getString("admin_phone"));
            admins.add(admin);
        }
        return admins;
    }

    // 获取某个管理员信息
    public Admin getAdminById(int id) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 获取ID为id的管理员信息
        String sql = "select * from admin where admin_id = " + id;
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        Admin admin = new Admin();
        if (resultSet.next()) {
            admin.setAdminId(resultSet.getInt("admin_id"));
            admin.setAdminName(resultSet.getString("admin_name"));
            admin.setAdminPassword(resultSet.getString("admin_password"));
            admin.setAdminPhone(resultSet.getString("admin_phone"));
        }
        return admin;
    }
    // 根据用户名获取管理员信息
    public Admin getAdminByName(String name) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 获取用户名为name的管理员信息
        String sql = "select * from admin where admin_name = '" + name + "'";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        Admin admin = new Admin();
        if (resultSet.next()) {
            admin.setAdminId(resultSet.getInt("admin_id"));
            admin.setAdminName(resultSet.getString("admin_name"));
            admin.setAdminPassword(resultSet.getString("admin_password"));
            admin.setAdminPhone(resultSet.getString("admin_phone"));
        }
        return admin;
    }

    // 更新密码
    public void updatePassword(int id, String password) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 更新ID为id的管理员的密码
        String sql = "update admin set admin_password = '" + password + "' where admin_id = " + id;
        System.out.println(sql);
        statement.execute(sql);
    }
}
