package org.example.Dao;

import org.example.Entity.Accompany;

import java.sql.*;
import java.util.ArrayList;

public class AccompanyDao {
    Connection cnn;
    public AccompanyDao() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accompanimentSystem?useUnicode=true&characterEncoding=utf8", "root", "");
    }

    // 新增陪诊员
    public void addAccompany(Accompany accompany) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 插入除ID外其他值
        String sql = "insert into accompany (accompany_name, accompany_password, accompany_phone, accompany_sex, accompany_age, accompany_idCardNum, accompany_workAge, accompany_price, accompany_description) values ('" + accompany.getAccompanyName() + "', '" + accompany.getAccompanyPassword() + "', '" + accompany.getAccompanyPhone() + "', '" + accompany.getAccompanySex() + "', '" + accompany.getAccompanyAge() + "', '" + accompany.getAccompanyIdCardNum() + "', '" + accompany.getAccompanyWorkAge() + "', '" + accompany.getAccompanyPrice() + "', '" + accompany.getAccompanyDescription() + "')";
        System.out.println(sql);
        statement.execute(sql);
    }

    // 删除陪诊员
    public void deleteAccompany(int id) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 删除ID为id的陪诊员
        String sql = "delete from accompany where accompany_id = " + id;
        System.out.println(sql);
        statement.execute(sql);
    }

    // 修改陪诊员
    public void updateAccompany(Accompany accompany) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 更新ID为accompany.getAccompanyId()的陪诊员的信息
        String sql = "update accompany set accompany_name = '" + accompany.getAccompanyName() + "', accompany_password = '" + accompany.getAccompanyPassword() + "', accompany_phone = '" + accompany.getAccompanyPhone() + "', accompany_sex = '" + accompany.getAccompanySex() + "', accompany_age = '" + accompany.getAccompanyAge() + "', accompany_idCardNum = '" + accompany.getAccompanyIdCardNum() + "', accompany_workAge = '" + accompany.getAccompanyWorkAge() + "', accompany_price = '" + accompany.getAccompanyPrice() + "', accompany_description = '" + accompany.getAccompanyDescription() + "' where accompany_id = " + accompany.getAccompanyId();
        System.out.println(sql);
        statement.execute(sql);
    }

    // 获取所有陪诊员
    public ArrayList<Accompany> getAllAccompany() throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 获取所有陪诊员
        String sql = "select * from accompany";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        ArrayList<Accompany> accompanies = new ArrayList<>();
        while (resultSet.next()) {
            Accompany accompany = new Accompany();
            accompany.setAccompanyId(resultSet.getInt("accompany_id"));
            accompany.setAccompanyName(resultSet.getString("accompany_name"));
            accompany.setAccompanyPassword(resultSet.getString("accompany_password"));
            accompany.setAccompanyPhone(resultSet.getString("accompany_phone"));
            accompany.setAccompanySex(resultSet.getString("accompany_sex"));
            accompany.setAccompanyAge(resultSet.getInt("accompany_age"));
            accompany.setAccompanyIdCardNum(resultSet.getString("accompany_idCardNum"));
            accompany.setAccompanyWorkAge(resultSet.getInt("accompany_workAge"));
            accompany.setAccompanyPrice(resultSet.getInt("accompany_price"));
            accompany.setAccompanyDescription(resultSet.getString("accompany_description"));
            accompanies.add(accompany);
        }
        return accompanies;
    }

    // 获取某陪诊员信息
    public Accompany getAccompanyById(int id) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 获取ID为id的陪诊员信息
        String sql = "select * from accompany where accompany_id = " + id;
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        Accompany accompany = new Accompany();
        if (resultSet.next()) {
            accompany.setAccompanyId(resultSet.getInt("accompany_id"));
            accompany.setAccompanyName(resultSet.getString("accompany_name"));
            accompany.setAccompanyPassword(resultSet.getString("accompany_password"));
            accompany.setAccompanyPhone(resultSet.getString("accompany_phone"));
            accompany.setAccompanySex(resultSet.getString("accompany_sex"));
            accompany.setAccompanyAge(resultSet.getInt("accompany_age"));
            accompany.setAccompanyIdCardNum(resultSet.getString("accompany_idCardNum"));
            accompany.setAccompanyWorkAge(resultSet.getInt("accompany_workAge"));
            accompany.setAccompanyPrice(resultSet.getInt("accompany_price"));
            accompany.setAccompanyDescription(resultSet.getString("accompany_description"));
        }
        return accompany;
    }
    // 根据用户名获取陪诊员信息
    public Accompany getAccompanyByName(String name) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 获取用户名为name的陪诊员信息
        String sql = "select * from accompany where accompany_name = '" + name + "'";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        Accompany accompany = new Accompany();
        if (resultSet.next()) {
            accompany.setAccompanyId(resultSet.getInt("accompany_id"));
            accompany.setAccompanyName(resultSet.getString("accompany_name"));
            accompany.setAccompanyPassword(resultSet.getString("accompany_password"));
            accompany.setAccompanyPhone(resultSet.getString("accompany_phone"));
            accompany.setAccompanySex(resultSet.getString("accompany_sex"));
            accompany.setAccompanyAge(resultSet.getInt("accompany_age"));
            accompany.setAccompanyIdCardNum(resultSet.getString("accompany_idCardNum"));
            accompany.setAccompanyWorkAge(resultSet.getInt("accompany_workAge"));
            accompany.setAccompanyPrice(resultSet.getInt("accompany_price"));
            accompany.setAccompanyDescription(resultSet.getString("accompany_description"));
        }
        return accompany;
    }
    // 修改陪诊员密码
    public void updatePassword(int id, String password) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 修改ID为id的陪诊员密码
        String sql = "update accompany set accompany_password = '" + password + "' where accompany_id = " + id;
        System.out.println(sql);
        statement.execute(sql);
    }
}
