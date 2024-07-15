package org.example.Dao;

import org.example.Entity.AccompanyOrder;
import org.example.Entity.OrderAndAccompany;
import org.example.Entity.OrderAndComment;
import org.example.Entity.OrderAndPatient;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccompanyOrderDao {
    Connection cnn;
    public AccompanyOrderDao() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accompanimentSystem?useUnicode=true&characterEncoding=utf8", "root", "");
    }
    // 新增陪诊订单
    public void addAccompanyOrder(AccompanyOrder accompanyOrder) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 插入除ID外其他值
        String sql = "insert into accompany_order (patient_id, accompany_id, order_time, order_status, order_price, order_description, hospital, department, body_detail) values ('" + accompanyOrder.getPatientId() + "', '" + accompanyOrder.getAccompanyId() + "', '" + accompanyOrder.getOrderTime() + "', '" + accompanyOrder.getOrderStatus() + "', '" + accompanyOrder.getOrderPrice() + "', '" + accompanyOrder.getOrderDescription() + "', '" + accompanyOrder.getHospital() + "', '" + accompanyOrder.getDepartment() + "', '" + accompanyOrder.getBodyDetail() + "')";
        System.out.println(sql);
        statement.execute(sql);
    }

    // 获取病人ID获取所有陪诊订单
    public ArrayList<AccompanyOrder> getAccompanyOrderByPatientId(int patientId) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 获取病人ID为patientId的所有陪诊订单
        String sql = "select * from accompany_order where patient_id = " + patientId;
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        ArrayList<AccompanyOrder> accompanyOrders = new ArrayList<>();
        while (resultSet.next()) {
            AccompanyOrder accompanyOrder = new AccompanyOrder();
            accompanyOrder.setOrderId(resultSet.getInt("order_id"));
            accompanyOrder.setPatientId(resultSet.getInt("patient_id"));
            accompanyOrder.setAccompanyId(resultSet.getInt("accompany_id"));
            accompanyOrder.setOrderTime(resultSet.getString("order_time"));
            accompanyOrder.setOrderStatus(resultSet.getInt("order_status"));
            accompanyOrder.setOrderPrice(resultSet.getInt("order_price"));
            accompanyOrder.setOrderDescription(resultSet.getString("order_description"));
            accompanyOrder.setHospital(resultSet.getString("hospital"));
            accompanyOrder.setDepartment(resultSet.getString("department"));
            accompanyOrder.setBodyDetail(resultSet.getString("body_detail"));
            accompanyOrders.add(accompanyOrder);
        }
        return accompanyOrders;
    }

    // 根据陪诊员ID并且状态为0获取所有陪诊订单和病人信息
    public ArrayList<OrderAndPatient> getOrderAndPatientById(int accompanyId) throws SQLException {
        Statement statement = this.cnn.createStatement();
        String sql = "select accompany_order.order_id, accompany_order.patient_id, accompany_order.accompany_id, accompany_order.order_time, accompany_order.order_status, accompany_order.order_price, accompany_order.order_description, accompany_order.hospital, accompany_order.department, accompany_order.body_detail, patient.patient_name, patient.patient_phone, patient.patient_sex, patient.patient_age, patient.patient_idCardNum from accompany_order left join patient on accompany_order.patient_id = patient.patient_id where accompany_order.accompany_id = " + accompanyId + " and accompany_order.order_status = 0";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        ArrayList<OrderAndPatient> orderAndPatients = new ArrayList<>();
        while (resultSet.next()) {
            OrderAndPatient orderAndPatient = new OrderAndPatient();
            orderAndPatient.setOrderId(resultSet.getInt("order_id"));
            orderAndPatient.setPatientId(resultSet.getInt("patient_id"));
            orderAndPatient.setAccompanyId(resultSet.getInt("accompany_id"));
            orderAndPatient.setOrderTime(resultSet.getString("order_time"));
            orderAndPatient.setOrderStatus(resultSet.getInt("order_status"));
            orderAndPatient.setOrderPrice(resultSet.getInt("order_price"));
            orderAndPatient.setOrderDescription(resultSet.getString("order_description"));
            orderAndPatient.setHospital(resultSet.getString("hospital"));
            orderAndPatient.setDepartment(resultSet.getString("department"));
            orderAndPatient.setBodyDetail(resultSet.getString("body_detail"));
            orderAndPatient.setPatientName(resultSet.getString("patient_name"));
            orderAndPatient.setPatientPhone(resultSet.getString("patient_phone"));
            orderAndPatient.setPatientSex(resultSet.getString("patient_sex"));
            orderAndPatient.setPatientAge(resultSet.getInt("patient_age"));
            orderAndPatient.setPatientIdCardNum(resultSet.getString("patient_idCardNum"));
            orderAndPatients.add(orderAndPatient);
        }
        return orderAndPatients;
    }

    public ArrayList<AccompanyOrder> getAccompanyOrderByAccompanyId(int accompanyId) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 获取陪诊员ID为accompanyId的所有陪诊订单
        String sql = "select * from accompany_order where accompany_id = " + accompanyId;
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        ArrayList<AccompanyOrder> accompanyOrders = new ArrayList<>();
        while (resultSet.next()) {
            AccompanyOrder accompanyOrder = new AccompanyOrder();
            accompanyOrder.setOrderId(resultSet.getInt("order_id"));
            accompanyOrder.setPatientId(resultSet.getInt("patient_id"));
            accompanyOrder.setAccompanyId(resultSet.getInt("accompany_id"));
            accompanyOrder.setOrderTime(resultSet.getString("order_time"));
            accompanyOrder.setOrderStatus(resultSet.getInt("order_status"));
            accompanyOrder.setOrderPrice(resultSet.getInt("order_price"));
            accompanyOrder.setOrderDescription(resultSet.getString("order_description"));
            accompanyOrder.setHospital(resultSet.getString("hospital"));
            accompanyOrder.setDepartment(resultSet.getString("department"));
            accompanyOrder.setBodyDetail(resultSet.getString("body_detail"));
            accompanyOrders.add(accompanyOrder);
        }
        return accompanyOrders;
    }

    // 根据患者ID获取获取订单和评论
    public ArrayList<OrderAndComment> getOrderAndCommentByPatientId(int patientId) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 根据患者ID从订单表和评论表获取所有信息
        String sql = "select accompany_order.order_id, accompany_order.patient_id, accompany_order.accompany_id, accompany_order.order_time, accompany_order.order_status, accompany_order.order_price, accompany_order.order_description, accompany_order.hospital, accompany_order.department, accompany_order.body_detail, accompany_comment.comment_time, accompany_comment.comment_content, accompany_comment.comment_score from accompany_order left join accompany_comment on accompany_order.order_id = accompany_comment.accompany_order_id where accompany_order.patient_id = " + patientId;
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        ArrayList<OrderAndComment> orderAndComments = new ArrayList<>();
        while (resultSet.next()) {
            OrderAndComment orderAndComment = new OrderAndComment();
            orderAndComment.setOrderId(resultSet.getInt("order_id"));
            orderAndComment.setPatientId(resultSet.getInt("patient_id"));
            orderAndComment.setAccompanyId(resultSet.getInt("accompany_id"));
            orderAndComment.setOrderTime(resultSet.getString("order_time"));
            orderAndComment.setOrderStatus(resultSet.getInt("order_status"));
            orderAndComment.setOrderPrice(resultSet.getInt("order_price"));
            orderAndComment.setOrderDescription(resultSet.getString("order_description"));
            orderAndComment.setHospital(resultSet.getString("hospital"));
            orderAndComment.setDepartment(resultSet.getString("department"));
            orderAndComment.setBodyDetail(resultSet.getString("body_detail"));
            orderAndComment.setCommentTime(resultSet.getString("comment_time"));
            orderAndComment.setCommentContent(resultSet.getString("comment_content"));
            orderAndComment.setCommentScore(resultSet.getInt("comment_score"));
            orderAndComments.add(orderAndComment);
        }
        return orderAndComments;
    }

    // 根据陪诊员ID获取订单和评论
    public ArrayList<OrderAndComment> getOrderAndCommentByAccompanyId(int accompanyId) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 根据患者ID从订单表和评论表获取所有信息
        String sql = "select accompany_order.order_id, accompany_order.patient_id, accompany_order.accompany_id, accompany_order.order_time, accompany_order.order_status, accompany_order.order_price, accompany_order.order_description, accompany_order.hospital, accompany_order.department, accompany_order.body_detail, accompany_comment.comment_time, accompany_comment.comment_content, accompany_comment.comment_score from accompany_order left join accompany_comment on accompany_order.order_id = accompany_comment.accompany_order_id where accompany_order.accompany_id = " + accompanyId;
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        ArrayList<OrderAndComment> orderAndComments = new ArrayList<>();
        while (resultSet.next()) {
            OrderAndComment orderAndComment = new OrderAndComment();
            orderAndComment.setOrderId(resultSet.getInt("order_id"));
            orderAndComment.setPatientId(resultSet.getInt("patient_id"));
            orderAndComment.setAccompanyId(resultSet.getInt("accompany_id"));
            orderAndComment.setOrderTime(resultSet.getString("order_time"));
            orderAndComment.setOrderStatus(resultSet.getInt("order_status"));
            orderAndComment.setOrderPrice(resultSet.getInt("order_price"));
            orderAndComment.setOrderDescription(resultSet.getString("order_description"));
            orderAndComment.setHospital(resultSet.getString("hospital"));
            orderAndComment.setDepartment(resultSet.getString("department"));
            orderAndComment.setBodyDetail(resultSet.getString("body_detail"));
            orderAndComment.setCommentTime(resultSet.getString("comment_time"));
            orderAndComment.setCommentContent(resultSet.getString("comment_content"));
            orderAndComment.setCommentScore(resultSet.getInt("comment_score"));
            orderAndComments.add(orderAndComment);
        }
        return orderAndComments;
    }

    // 根据患者ID和不为0的订单状态获取订单和评论
    public ArrayList<OrderAndComment> getOrderAndCommentByPatientIdAndStatus(int patientId) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 根据患者ID从订单表和评论表获取所有信息
        String sql = "select accompany_order.order_id, accompany_order.patient_id, accompany_order.accompany_id, accompany_order.order_time, accompany_order.order_status, accompany_order.order_price, accompany_order.order_description, accompany_order.hospital, accompany_order.department, accompany_order.body_detail, accompany_comment.comment_time, accompany_comment.comment_content, accompany_comment.comment_score from accompany_order left join accompany_comment on accompany_order.order_id = accompany_comment.accompany_order_id where accompany_order.patient_id = " + patientId + " and accompany_order.order_status != 0";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        ArrayList<OrderAndComment> orderAndComments = new ArrayList<>();
        while (resultSet.next()) {
            OrderAndComment orderAndComment = new OrderAndComment();
            orderAndComment.setOrderId(resultSet.getInt("order_id"));
            orderAndComment.setPatientId(resultSet.getInt("patient_id"));
            orderAndComment.setAccompanyId(resultSet.getInt("accompany_id"));
            orderAndComment.setOrderTime(resultSet.getString("order_time"));
            orderAndComment.setOrderStatus(resultSet.getInt("order_status"));
            orderAndComment.setOrderPrice(resultSet.getInt("order_price"));
            orderAndComment.setOrderDescription(resultSet.getString("order_description"));
            orderAndComment.setHospital(resultSet.getString("hospital"));
            orderAndComment.setDepartment(resultSet.getString("department"));
            orderAndComment.setBodyDetail(resultSet.getString("body_detail"));
            orderAndComment.setCommentTime(resultSet.getString("comment_time"));
            orderAndComment.setCommentContent(resultSet.getString("comment_content"));
            orderAndComment.setCommentScore(resultSet.getInt("comment_score"));
            orderAndComments.add(orderAndComment);
        }
        return orderAndComments;
    }

    // 根据陪诊员ID和不为0的订单状态获取订单和评论
    public ArrayList<OrderAndComment> getOrderAndCommentByAccompanyIdAndStatus(int accompanyId) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 根据患者ID从订单表和评论表获取所有信息
        String sql = "select accompany_order.order_id, accompany_order.patient_id, accompany_order.accompany_id, accompany_order.order_time, accompany_order.order_status, accompany_order.order_price, accompany_order.order_description, accompany_order.hospital, accompany_order.department, accompany_order.body_detail, accompany_comment.comment_time, accompany_comment.comment_content, accompany_comment.comment_score from accompany_order left join accompany_comment on accompany_order.order_id = accompany_comment.accompany_order_id where accompany_order.accompany_id = " + accompanyId + " and accompany_order.order_status != 0";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        ArrayList<OrderAndComment> orderAndComments = new ArrayList<>();
        while (resultSet.next()) {
            OrderAndComment orderAndComment = new OrderAndComment();
            orderAndComment.setOrderId(resultSet.getInt("order_id"));
            orderAndComment.setPatientId(resultSet.getInt("patient_id"));
            orderAndComment.setAccompanyId(resultSet.getInt("accompany_id"));
            orderAndComment.setOrderTime(resultSet.getString("order_time"));
            orderAndComment.setOrderStatus(resultSet.getInt("order_status"));
            orderAndComment.setOrderPrice(resultSet.getInt("order_price"));
            orderAndComment.setOrderDescription(resultSet.getString("order_description"));
            orderAndComment.setHospital(resultSet.getString("hospital"));
            orderAndComment.setDepartment(resultSet.getString("department"));
            orderAndComment.setBodyDetail(resultSet.getString("body_detail"));
            orderAndComment.setCommentTime(resultSet.getString("comment_time"));
            orderAndComment.setCommentContent(resultSet.getString("comment_content"));
            orderAndComment.setCommentScore(resultSet.getInt("comment_score"));
            orderAndComments.add(orderAndComment);
        }
        return orderAndComments;
    }


    // 获取某一陪诊订单
    public AccompanyOrder getAccompanyOrderById(int id) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 获取ID为id的陪诊订单
        String sql = "select * from accompany_order where order_id = " + id;
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        AccompanyOrder accompanyOrder = new AccompanyOrder();
        if (resultSet.next()) {
            accompanyOrder.setOrderId(resultSet.getInt("order_id"));
            accompanyOrder.setPatientId(resultSet.getInt("patient_id"));
            accompanyOrder.setAccompanyId(resultSet.getInt("accompany_id"));
            accompanyOrder.setOrderTime(resultSet.getString("order_time"));
            accompanyOrder.setOrderStatus(resultSet.getInt("order_status"));
            accompanyOrder.setOrderPrice(resultSet.getInt("order_price"));
            accompanyOrder.setOrderDescription(resultSet.getString("order_description"));
            accompanyOrder.setHospital(resultSet.getString("hospital"));
            accompanyOrder.setDepartment(resultSet.getString("department"));
            accompanyOrder.setBodyDetail(resultSet.getString("body_detail"));
        }
        return accompanyOrder;
    }

    // 更新订单状态
    public void updateOrderStatus(int orderId, int orderStatus) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 更新ID为orderId的订单状态为orderStatus
        String sql = "update accompany_order set order_status = " + orderStatus + " where order_id = " + orderId;
        System.out.println(sql);
        statement.execute(sql);
    }

    // 删除订单
    public void deleteAccompanyOrder(int id) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 删除ID为id的订单
        String sql = "delete from accompany_order where order_id = " + id;
        System.out.println(sql);
        statement.execute(sql);
    }

    // 根据患者ID获取状态为1的订单和陪诊员信息
    public ArrayList<OrderAndAccompany> getOrderAndAccompanyByPatientId(int patientId) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 根据患者ID从订单表和陪诊员表获取所有信息
        String sql = "select accompany_order.order_id, accompany_order.patient_id, accompany_order.accompany_id, accompany_order.order_time, accompany_order.order_status, accompany_order.order_price, accompany_order.order_description, accompany_order.hospital, accompany_order.department, accompany_order.body_detail, accompany.accompany_name, accompany.accompany_phone, accompany.accompany_sex, accompany.accompany_age, accompany.accompany_idCardNum, accompany.accompany_workAge, accompany.accompany_price, accompany.accompany_description from accompany_order left join accompany on accompany_order.accompany_id = accompany.accompany_id where accompany_order.patient_id = " + patientId + " and accompany_order.order_status = 1";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        ArrayList<OrderAndAccompany> orderAndAccompanies = new ArrayList<>();
        while (resultSet.next()) {
            OrderAndAccompany orderAndAccompany = new OrderAndAccompany();
            orderAndAccompany.setOrderId(resultSet.getInt("order_id"));
            orderAndAccompany.setPatientId(resultSet.getInt("patient_id"));
            orderAndAccompany.setAccompanyId(resultSet.getInt("accompany_id"));
            orderAndAccompany.setOrderTime(resultSet.getString("order_time"));
            orderAndAccompany.setOrderStatus(resultSet.getInt("order_status"));
            orderAndAccompany.setOrderPrice(resultSet.getInt("order_price"));
            orderAndAccompany.setOrderDescription(resultSet.getString("order_description"));
            orderAndAccompany.setHospital(resultSet.getString("hospital"));
            orderAndAccompany.setDepartment(resultSet.getString("department"));
            orderAndAccompany.setBodyDetail(resultSet.getString("body_detail"));
            orderAndAccompany.setAccompanyName(resultSet.getString("accompany_name"));
            orderAndAccompany.setAccompanyPhone(resultSet.getString("accompany_phone"));
            orderAndAccompany.setAccompanySex(resultSet.getString("accompany_sex"));
            orderAndAccompany.setAccompanyAge(resultSet.getInt("accompany_age"));
            orderAndAccompany.setAccompanyIdCardNum(resultSet.getString("accompany_idCardNum"));
            orderAndAccompany.setAccompanyWorkAge(resultSet.getInt("accompany_workAge"));
            orderAndAccompany.setAccompanyPrice(resultSet.getInt("accompany_price"));
            orderAndAccompany.setAccompanyDescription(resultSet.getString("accompany_description"));
            orderAndAccompanies.add(orderAndAccompany);
        }
        return orderAndAccompanies;
    }

    // 根据患者ID，对订单的四种状态进行统计计数，以map形式返回
    public Map<String, Integer> getOrderStatusCountByPatientId(int patientId) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 根据患者ID从订单表获取所有信息
        String sql = "select order_status, count(*) as count from accompany_order where patient_id = " + patientId + " group by order_status";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        Map<String, Integer> orderStatusCount = new HashMap<>();
        while (resultSet.next()) {
            orderStatusCount.put(resultSet.getString("order_status"), resultSet.getInt("count"));
        }
        return orderStatusCount;
    }

    // 根据陪诊员ID，对订单的四种状态进行统计计数，以map形式返回
    public Map<String, Integer> getOrderStatusCountByAccompanyId(int accompanyId) throws SQLException {
        Statement statement = this.cnn.createStatement();
        // 根据陪诊员ID从订单表获取所有信息
        String sql = "select order_status, count(*) as count from accompany_order where accompany_id = " + accompanyId + " group by order_status";
        System.out.println(sql);
        statement.executeQuery(sql);
        ResultSet resultSet = statement.getResultSet();
        Map<String, Integer> orderStatusCount = new HashMap<>();
        while (resultSet.next()) {
            orderStatusCount.put(resultSet.getString("order_status"), resultSet.getInt("count"));
        }
        return orderStatusCount;
    }

}
