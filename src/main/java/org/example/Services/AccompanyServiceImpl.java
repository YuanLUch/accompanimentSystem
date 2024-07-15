package org.example.Services;

import org.example.Dao.AccompanyDao;
import org.example.Entity.Accompany;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccompanyServiceImpl implements AccompanyService{
    AccompanyDao accompanyDao = new AccompanyDao();

    public AccompanyServiceImpl() throws Exception {
    }

    @Override
    public void addAccompany(Accompany accompany) throws SQLException {
        accompanyDao.addAccompany(accompany);
    }

    @Override
    public void deleteAccompany(int id) throws SQLException {
        accompanyDao.deleteAccompany(id);
    }

    @Override
    public boolean checkAccompanyLogin(String name, String password) throws SQLException {
        Accompany accompany = accompanyDao.getAccompanyByName(name);
        if (accompany != null) {
            return accompany.getAccompanyPassword().equals(password);
        }
        return false;
    }

    @Override
    public Accompany getAccompanyById(int id) throws SQLException {
        return accompanyDao.getAccompanyById(id);
    }

    @Override
    public Accompany getAccompanyByName(String name) throws SQLException {
        return accompanyDao.getAccompanyByName(name);
    }

    @Override
    public ArrayList<Accompany> getAllAccompanys() throws SQLException {
        return accompanyDao.getAllAccompany();
    }

    @Override
    public void updateAccompany(Accompany accompany) throws SQLException {
        accompanyDao.updateAccompany(accompany);
    }

    @Override
    public void updatePassword(int id, String password) throws SQLException {
        accompanyDao.updatePassword(id, password);
    }
}
