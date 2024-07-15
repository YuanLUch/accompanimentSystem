package org.example.Entity;

public class AccompanyOrder {
    private Integer orderId;
    private Integer patientId;
    private Integer accompanyId;
    private String orderTime;
    private Integer orderStatus;
    private Integer orderPrice;
    private String orderDescription;
    private String hospital;
    private String department;
    private String bodyDetail;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getAccompanyId() {
        return accompanyId;
    }

    public void setAccompanyId(Integer accompanyId) {
        this.accompanyId = accompanyId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBodyDetail() {
        return bodyDetail;
    }

    public void setBodyDetail(String bodyDetail) {
        this.bodyDetail = bodyDetail;
    }
}
