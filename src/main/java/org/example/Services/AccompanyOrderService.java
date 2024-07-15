package org.example.Services;

import org.example.Entity.AccompanyOrder;
import org.example.Entity.OrderAndAccompany;
import org.example.Entity.OrderAndComment;
import org.example.Entity.OrderAndPatient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface AccompanyOrderService {
    void addAccompanyOrder(AccompanyOrder accompanyOrder) throws SQLException, SQLException;
    void deleteAccompanyOrder(int id) throws SQLException;
    void updateOrderStatus(int orderId, int status) throws SQLException;
    ArrayList<OrderAndComment> getOrderAndCommentByAccompanyId(int accompanyId) throws SQLException;
    ArrayList<OrderAndComment> getOrderAndCommentByPatientId(int patientId) throws SQLException;
    ArrayList<OrderAndAccompany> getOrderAndAccompanyById(int patientId) throws SQLException;
    ArrayList<OrderAndPatient> getOrderAndPatientById(int accompanyId) throws SQLException;
    ArrayList<OrderAndComment> getOrderAndCommentByAccompanyIdAndStatus(int accompanyId) throws SQLException;
    Map<String, Integer> getOrderStatusCountByPatientId(int patientId) throws SQLException;
    Map<String, Integer> getOrderStatusCountByAccompanyId(int accompanyId) throws SQLException;
}
