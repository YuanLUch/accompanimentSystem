package org.example.Services;

import org.example.Entity.Accompany;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AccompanyService {
    void addAccompany(Accompany accompany) throws SQLException;
    void deleteAccompany(int id) throws SQLException;
    boolean checkAccompanyLogin(String accompanyId, String password) throws SQLException;
    Accompany getAccompanyById(int id) throws SQLException;
    Accompany getAccompanyByName(String name) throws SQLException;
    ArrayList<Accompany> getAllAccompanys() throws SQLException;
    void updateAccompany(Accompany accompany) throws SQLException;
    void updatePassword(int id, String password) throws SQLException;
}
