package org.example.Actions;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.example.Services.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;


public class LoginAction extends Action {
    PatientService patientService = new PatientServiceImpl();
    AdminService adminService = new AdminServiceImpl();
    AccompanyService accompanyService = new AccompanyServiceImpl();


    public LoginAction() throws Exception {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userType = request.getParameter("userType");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        System.out.println("userType: " + userType);
        System.out.println("userName: " + userName);

        try {
            if (Objects.equals(userType, "admin")) {
                boolean admin_login = adminService.CheckLogin(userName, password);
                if (admin_login) {
                    int userId = adminService.getAdminByName(userName).getAdminId();
                    session.setAttribute("userId", userId);
                    return mapping.findForward("Admin_SUCCESS");
                }
            } else if (Objects.equals(userType, "patient")) {
                boolean patient_login = patientService.checkPatientLogin(userName, password);
                if (patient_login) {
                    int userId = patientService.getPatientByName(userName).getPatientId();
                    session.setAttribute("userId", userId);
                    return mapping.findForward("Patient_SUCCESS");
                }
            } else if (Objects.equals(userType, "accompany")) {
                boolean accompany_login = accompanyService.checkAccompanyLogin(userName, password);
                if (accompany_login) {
                    int userId = accompanyService.getAccompanyByName(userName).getAccompanyId();
                    session.setAttribute("userId", userId);
                    return mapping.findForward("Accompany_SUCCESS");
                }
            } else {
                return mapping.findForward("FAIL");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mapping.findForward("FAIL");
    }
}

