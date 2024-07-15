package org.example.Dao;

import org.example.Entity.Patient;

import java.sql.*;
import java.util.ArrayList;

public class PatientDao {
    Connection cnn;
    public PatientDao() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accompanimentSystem?useUnicode=true&characterEncoding=utf8", "root", "");
    }

    public void addPatient(Patient patient) throws SQLException {
        Statement statement = this.cnn.createStatement();
        String sql = "INSERT INTO patient (patient_name, patient_password, patient_phone, patient_sex, patient_age, patient_idCardNum) VALUES ('" + patient.getPatientName() + "', '" + patient.getPatientPassword() + "', '" + patient.getPatientPhone() + "', '" + patient.getPatientSex() + "', '" + patient.getPatientAge() + "', '" + patient.getPatientIdCardNum() + "')";
        System.out.println(sql);
        statement.execute(sql);
    }

    public ArrayList<Patient> getAllPatient() throws SQLException {
        Statement statement = this.cnn.createStatement();
        String sql = "SELECT * FROM patient";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        ArrayList<Patient> patients = new ArrayList<>();
        while (resultSet.next()) {
            Patient patient = new Patient();
            patient.setPatientId(resultSet.getInt("patient_id"));
            patient.setPatientName(resultSet.getString("patient_name"));
            patient.setPatientPassword(resultSet.getString("patient_password"));
            patient.setPatientPhone(resultSet.getString("patient_phone"));
            patient.setPatientSex(resultSet.getString("patient_sex"));
            patient.setPatientAge(resultSet.getInt("patient_age"));
            patient.setPatientIdCardNum(resultSet.getString("patient_idCardNum"));
            patients.add(patient);
        }
        return patients;
    }

    public Patient getPatientById(int id) throws SQLException {
        Statement statement = this.cnn.createStatement();
        String sql = "SELECT * FROM patient WHERE patient_id = " + id;
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        Patient patient = new Patient();
        if (resultSet.next()) {
            patient.setPatientId(resultSet.getInt("patient_id"));
            patient.setPatientName(resultSet.getString("patient_name"));
            patient.setPatientPassword(resultSet.getString("patient_password"));
            patient.setPatientPhone(resultSet.getString("patient_phone"));
            patient.setPatientSex(resultSet.getString("patient_sex"));
            patient.setPatientAge(resultSet.getInt("patient_age"));
            patient.setPatientIdCardNum(resultSet.getString("patient_idCardNum"));
        }
        return patient;
    }
    // 根据用户名获取病人用户
    public Patient getPatientByName(String name) throws SQLException {
        Statement statement = this.cnn.createStatement();
        String sql = "SELECT * FROM patient WHERE patient_name = '" + name + "'";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        Patient patient = new Patient();
        if (resultSet.next()) {
            patient.setPatientId(resultSet.getInt("patient_id"));
            patient.setPatientName(resultSet.getString("patient_name"));
            patient.setPatientPassword(resultSet.getString("patient_password"));
            patient.setPatientPhone(resultSet.getString("patient_phone"));
            patient.setPatientSex(resultSet.getString("patient_sex"));
            patient.setPatientAge(resultSet.getInt("patient_age"));
            patient.setPatientIdCardNum(resultSet.getString("patient_idCardNum"));
        }
        return patient;
    }

    // 删除病人用户
    public void deletePatient(int id) throws SQLException {
        Statement statement = this.cnn.createStatement();
        String sql = "DELETE FROM patient WHERE patient_id = " + id;
        System.out.println(sql);
        statement.execute(sql);
    }

    // 更新病人用户信息
    public void updatePatient(Patient patient) throws SQLException {
        Statement statement = this.cnn.createStatement();
        String sql = "UPDATE patient SET patient_name = '" + patient.getPatientName() + "', patient_password = '" + patient.getPatientPassword() + "', patient_phone = '" + patient.getPatientPhone() + "', patient_sex = '" + patient.getPatientSex() + "', patient_age = " + patient.getPatientAge() + ", patient_idCardNum = '" + patient.getPatientIdCardNum() + "' WHERE patient_id = " + patient.getPatientId();
        System.out.println(sql);
        statement.execute(sql);
    }
    // 更新病人用户密码
    public void updatePassword(int id, String password) throws SQLException {
        Statement statement = this.cnn.createStatement();
        String sql = "UPDATE patient SET patient_password = '" + password + "' WHERE patient_id = " + id;
        System.out.println(sql);
        statement.execute(sql);
    }
}
