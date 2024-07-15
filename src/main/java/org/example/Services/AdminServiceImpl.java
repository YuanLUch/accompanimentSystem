package org.example.Services;

import org.example.Dao.AdminDao;
import org.example.Entity.Admin;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDao();

    public AdminServiceImpl() throws Exception {
    }

    @Override
    public void addAdmin(Admin admin) throws SQLException {
        adminDao.addAdmin(admin);
    }

    @Override
    public boolean CheckLogin(String name, String password) throws SQLException {
        Admin admin = adminDao.getAdminByName(name);
        if (admin != null) {
            return admin.getAdminPassword().equals(password);
        }
        return false;
    }

    @Override
    public Admin getAdminByName(String name) throws SQLException {
        return adminDao.getAdminByName(name);
    }

    @Override
    public Admin getAdminById(int id) throws SQLException {
        return adminDao.getAdminById(id);
    }

    @Override
    public void updateAdmin(Admin admin) throws SQLException {
        adminDao.updateAdmin(admin);
    }

    @Override
    public void updatePassword(int id, String password) throws SQLException {
        adminDao.updatePassword(id, password);
    }
}
