package org.example.Services;

import org.example.Dao.AccompanyOrderDao;
import org.example.Entity.AccompanyOrder;
import org.example.Entity.OrderAndAccompany;
import org.example.Entity.OrderAndComment;
import org.example.Entity.OrderAndPatient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class AccompanyOrderServiceImpl implements AccompanyOrderService{
    AccompanyOrderDao accompanyOrderDao = new AccompanyOrderDao();

    public AccompanyOrderServiceImpl() throws Exception {
    }

    @Override
    public void addAccompanyOrder(AccompanyOrder accompanyOrder) throws SQLException {
        accompanyOrderDao.addAccompanyOrder(accompanyOrder);
    }

    @Override
    public void deleteAccompanyOrder(int id) throws SQLException {
        accompanyOrderDao.deleteAccompanyOrder(id);
    }

    @Override
    public void updateOrderStatus(int orderId, int status) throws SQLException {
        accompanyOrderDao.updateOrderStatus(orderId, status);
    }

    @Override
    public ArrayList<OrderAndComment> getOrderAndCommentByAccompanyId(int accompanyId) throws SQLException {
        return accompanyOrderDao.getOrderAndCommentByAccompanyId(accompanyId);
    }

    // 患者订单历史
    @Override
    public ArrayList<OrderAndComment> getOrderAndCommentByPatientId(int patientId) throws SQLException {
        return accompanyOrderDao.getOrderAndCommentByPatientId(patientId);
    }

    @Override
    public ArrayList<OrderAndAccompany> getOrderAndAccompanyById(int patientId) throws SQLException {
        return accompanyOrderDao.getOrderAndAccompanyByPatientId(patientId);
    }

    @Override
    public ArrayList<OrderAndPatient> getOrderAndPatientById(int accompanyId) throws SQLException {
        return accompanyOrderDao.getOrderAndPatientById(accompanyId);
    }

    @Override
    public ArrayList<OrderAndComment> getOrderAndCommentByAccompanyIdAndStatus(int accompanyId) throws SQLException {
        return accompanyOrderDao.getOrderAndCommentByAccompanyIdAndStatus(accompanyId);
    }

    @Override
    public Map<String, Integer> getOrderStatusCountByPatientId(int patientId) throws SQLException {
        return accompanyOrderDao.getOrderStatusCountByPatientId(patientId);
    }

    @Override
    public Map<String, Integer> getOrderStatusCountByAccompanyId(int accompanyId) throws SQLException {
        return accompanyOrderDao.getOrderStatusCountByAccompanyId(accompanyId);
    }

}
