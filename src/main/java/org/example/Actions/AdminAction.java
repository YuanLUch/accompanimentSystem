package org.example.Actions;

import com.alibaba.fastjson.JSONObject;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.example.Entity.Admin;
import org.example.Services.AdminService;
import org.example.Services.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

public class AdminAction extends Action {
    public AdminAction() throws Exception {

    }

    private String encoding = "UTF-8";
    private String contentType = "application/json";
    AdminService adminService = new AdminServiceImpl();

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        this.contentType = contentType + ";charset=" + encoding;
        response.setContentType(contentType);
        response.setCharacterEncoding(encoding);
        switch (type) {
            case "addAdmin":
                String adminName = request.getParameter("adminName");
                String adminPassword = request.getParameter("adminPassword");
                String adminPhone = request.getParameter("adminPhone");
                Admin admin = new Admin();
                admin.setAdminName(adminName);
                admin.setAdminPassword(adminPassword);
                admin.setAdminPhone(adminPhone);
                adminService.addAdmin(admin);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", "success");
                response.getWriter().write(jsonObject.toJSONString());

                break;
            case "getAdminList":

                break;

            case "resetPassword":
                Admin admin_rp = adminService.getAdminById((Integer) session.getAttribute("userId"));
                String new_password = request.getParameter("new_password");
                adminService.updatePassword(admin_rp.getAdminId(), new_password);
                JSONObject jsonObject_rp = new JSONObject();
                jsonObject_rp.put("status", "success");
                response.getWriter().write(jsonObject_rp.toJSONString());
                break;
            case "getInfo":
                Admin admin1 = adminService.getAdminById((Integer) session.getAttribute("userId"));
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("adminName", admin1.getAdminName());
                jsonObject1.put("adminPhone", admin1.getAdminPhone());
                jsonObject1.put("adminPassword", admin1.getAdminPassword());
                response.getWriter().write(jsonObject1.toJSONString());
                break;
            case "updateAdmin":
                Admin admin_raw = adminService.getAdminById((Integer) session.getAttribute("userId"));
                String adminName1 = request.getParameter("adminName");
                String adminPhone1 = request.getParameter("adminPhone");
                Admin admin2 = new Admin();
                admin2.setAdminId(admin_raw.getAdminId());
                admin2.setAdminName(adminName1);
                admin2.setAdminPhone(adminPhone1);
                admin2.setAdminPassword(admin_raw.getAdminPassword());
                adminService.updateAdmin(admin2);
                JSONObject jsonObject2 = new JSONObject();
                jsonObject2.put("status", "success");
                response.getWriter().write(jsonObject2.toJSONString());
                break;
            case "delete":

                break;
        }
        return mapping.findForward(null);
    }
}
