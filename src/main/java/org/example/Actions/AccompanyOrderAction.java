package org.example.Actions;

import com.alibaba.fastjson.JSONObject;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.example.Entity.AccompanyOrder;
import org.example.Entity.OrderAndAccompany;
import org.example.Entity.OrderAndComment;
import org.example.Entity.OrderAndPatient;
import org.example.Services.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

public class AccompanyOrderAction extends Action {
    public AccompanyOrderAction() throws Exception {
    }

    private String encoding = "UTF-8";
    private String contentType = "application/json";
    AccompanyOrderService accompanyOrderService = new AccompanyOrderServiceImpl();
    AccompanyService accompanyService = new AccompanyServiceImpl();
    AccompanyCommentService accompanyCommentService = new AccompanyCommentServiceImpl();

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        this.contentType = contentType + ";charset=" + encoding;
        response.setContentType(contentType);
        response.setCharacterEncoding(encoding);
        switch (type) {
            case "addOrder":
                String patientId = session.getAttribute("userId").toString();
                String accompanyId = request.getParameter("accompanyId");
                String accompanyOrderTime = request.getParameter("accompanyOrderTime");
                String accompanyOrderStatus = "0"; // "0" means "unpaid
                int accompanyOrderPrice = accompanyService.getAccompanyById(Integer.parseInt(accompanyId)).getAccompanyPrice();
                String accompanyOrderDescription = request.getParameter("accompanyOrderDescription");
                String hospital = request.getParameter("hospital");
                String department = request.getParameter("department");
                String bodyDetail = request.getParameter("bodyDetail");

                AccompanyOrder accompanyOrder = new AccompanyOrder();
                accompanyOrder.setPatientId(Integer.parseInt(patientId));
                accompanyOrder.setAccompanyId(Integer.parseInt(accompanyId));
                accompanyOrder.setOrderTime(accompanyOrderTime);
                accompanyOrder.setOrderStatus(Integer.valueOf(accompanyOrderStatus));
                accompanyOrder.setOrderPrice(accompanyOrderPrice);
                accompanyOrder.setOrderDescription(accompanyOrderDescription);
                accompanyOrder.setHospital(hospital);
                accompanyOrder.setDepartment(department);
                accompanyOrder.setBodyDetail(bodyDetail);
                accompanyOrderService.addAccompanyOrder(accompanyOrder);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", "success");
                response.getWriter().write(jsonObject.toJSONString());
                break;
            case "updateOrderStatus":
                String orderId = request.getParameter("orderId");
                String status = request.getParameter("status");
                accompanyOrderService.updateOrderStatus(Integer.parseInt(orderId), Integer.parseInt(status));
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("status", "success");
                response.getWriter().write(jsonObject1.toJSONString());
                break;
            case "getListByAccompanyId":
                String accompanyId1 = session.getAttribute("userId").toString();
                ArrayList<OrderAndComment> orderAndComments = accompanyOrderService.getOrderAndCommentByAccompanyIdAndStatus(Integer.parseInt(accompanyId1));
                JSONObject jsonObject2 = new JSONObject();
                jsonObject2.put("orders", orderAndComments);
                response.getWriter().write(jsonObject2.toJSONString());
                break;
            case "getListByPatientId":
                String patientId1 = session.getAttribute("userId").toString();
                ArrayList<OrderAndComment> orderAndComments1 = accompanyOrderService.getOrderAndCommentByPatientId(Integer.parseInt(patientId1));
                JSONObject jsonObject3 = new JSONObject();
                jsonObject3.put("orders", orderAndComments1);
                response.getWriter().write(jsonObject3.toJSONString());
                break;

            case "getOrderAndAccompanyById":
                String patientId2 = session.getAttribute("userId").toString();
                ArrayList<OrderAndAccompany> orderAndAccompanies = accompanyOrderService.getOrderAndAccompanyById(Integer.parseInt(patientId2));
                JSONObject jsonObject4 = new JSONObject();
                jsonObject4.put("orders", orderAndAccompanies);
                response.getWriter().write(jsonObject4.toString());

                break;
            case "getOrderAndPatientById":
                ArrayList<OrderAndPatient> orderAndPatients = accompanyOrderService.getOrderAndPatientById(Integer.parseInt(session.getAttribute("userId").toString()));
                JSONObject jsonObject7 = new JSONObject();
                jsonObject7.put("orders", orderAndPatients);
                response.getWriter().write(jsonObject7.toString());

                break;
            case "patientOrders":
                ArrayList<OrderAndComment> orderAndComments2 = accompanyOrderService.getOrderAndCommentByPatientId(Integer.parseInt(session.getAttribute("userId").toString()));
                JSONObject jsonObject5 = new JSONObject();
                jsonObject5.put("orders", orderAndComments2);
                response.getWriter().write(jsonObject5.toJSONString());

                break;
            case "accompanyOrders":
                ArrayList<OrderAndComment> orderAndComments3 = accompanyOrderService.getOrderAndCommentByAccompanyId(Integer.parseInt(session.getAttribute("userId").toString()));
                JSONObject jsonObject8 = new JSONObject();
                jsonObject8.put("orders", orderAndComments3);
                response.getWriter().write(jsonObject8.toJSONString());

                break;
            case "deleteOrder":
                String orderId1 = request.getParameter("orderId");
                accompanyOrderService.deleteAccompanyOrder(Integer.parseInt(orderId1));
                accompanyCommentService.deleteAccompanyComment(Integer.parseInt(orderId1));
                JSONObject jsonObject6 = new JSONObject();
                jsonObject6.put("status", "success");
                response.getWriter().write(jsonObject6.toJSONString());

                break;
            case "getOrderStatusCountByPatientId":
                String patientId3 = session.getAttribute("userId").toString();
//                String patientId3 = request.getParameter("patientId");
                Map<String, Integer> orderStatusCountByPatientId = accompanyOrderService.getOrderStatusCountByPatientId(Integer.parseInt(patientId3));
                JSONObject jsonObject9 = new JSONObject();
                jsonObject9.put("orderStatusCount", orderStatusCountByPatientId);
                response.getWriter().write(jsonObject9.toJSONString());

                break;
            case "getOrderStatusCountByAccompanyId":
                String accompanyId2 = session.getAttribute("userId").toString();
                Map<String, Integer> orderStatusCountByAccompanyId = accompanyOrderService.getOrderStatusCountByAccompanyId(Integer.parseInt(accompanyId2));
                JSONObject jsonObject10 = new JSONObject();
                jsonObject10.put("orderStatusCount", orderStatusCountByAccompanyId);
                response.getWriter().write(jsonObject10.toJSONString());

                break;
            default:
                break;
        }
        return mapping.findForward(null);
    }
}
