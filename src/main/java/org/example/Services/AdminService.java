package org.example.Services;

import org.example.Entity.Admin;

import java.sql.SQLException;

public interface AdminService {
    void addAdmin(Admin admin) throws SQLException;
    boolean CheckLogin(String adminId, String password) throws SQLException;
    Admin getAdminByName(String name) throws SQLException;
    Admin getAdminById(int id) throws SQLException;
    void updateAdmin(Admin admin) throws SQLException;
    void updatePassword(int id, String password) throws SQLException;
}
