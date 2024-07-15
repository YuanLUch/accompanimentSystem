package org.example.Actions;

import com.alibaba.fastjson.JSONObject;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.example.Entity.Admin;
import org.example.Entity.Patient;
import org.example.Services.PatientService;
import org.example.Services.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;



public class PatientAction extends Action {
    public PatientAction() throws Exception {
    }

    private String encoding = "UTF-8";
    private String contentType = "application/json";
    PatientService patientService = new PatientServiceImpl();

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        this.contentType = contentType + ";charset=" + encoding;
        response.setContentType(contentType);
        response.setCharacterEncoding(encoding);
        switch (type) {
            case "addPatient":
                String patientName = request.getParameter("patientName");
                String patientPassword = request.getParameter("patientPassword");
                String patientPhone = request.getParameter("patientPhone");
                String patientSex = request.getParameter("patientSex");
                String patientAge = request.getParameter("patientAge");
                String patientIdCard = request.getParameter("patientIdCardNum");
                Patient patient = new Patient();
                patient.setPatientName(patientName);
                patient.setPatientPassword(patientPassword);
                patient.setPatientPhone(patientPhone);
                patient.setPatientSex(patientSex);
                patient.setPatientAge(Integer.parseInt(patientAge));
                patient.setPatientIdCardNum(patientIdCard);
                patientService.addPatient(patient);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", "success");
                response.getWriter().write(jsonObject.toJSONString());

                break;
            case "getList":
                List<Patient> patients = patientService.getAllPatients();
                JSONObject jsonObject_list = new JSONObject();
                jsonObject_list.put("patients", patients);
                response.getWriter().write(jsonObject_list.toJSONString());

                break;
            case "getInfo":
                Patient patient_info = patientService.getPatientById((Integer) session.getAttribute("userId"));
                JSONObject jsonObject_info = new JSONObject();
                jsonObject_info.put("patientId", patient_info.getPatientId());
                jsonObject_info.put("patientName", patient_info.getPatientName());
                jsonObject_info.put("patientPhone", patient_info.getPatientPhone());
                jsonObject_info.put("patientPassword", patient_info.getPatientPassword());
                jsonObject_info.put("patientSex", patient_info.getPatientSex());
                jsonObject_info.put("patientAge", patient_info.getPatientAge());
                jsonObject_info.put("patientIdCardNum", patient_info.getPatientIdCardNum());
                response.getWriter().write(jsonObject_info.toJSONString());

                break;
            case "getPatientById":
                Patient patientById = patientService.getPatientById(Integer.parseInt(request.getParameter("patientId")));
                JSONObject jsonObject_getPatientById = new JSONObject();
                jsonObject_getPatientById.put("patientId", patientById.getPatientId());
                jsonObject_getPatientById.put("patientName", patientById.getPatientName());
                jsonObject_getPatientById.put("patientPhone", patientById.getPatientPhone());
                jsonObject_getPatientById.put("patientPassword", patientById.getPatientPassword());
                jsonObject_getPatientById.put("patientSex", patientById.getPatientSex());
                jsonObject_getPatientById.put("patientAge", patientById.getPatientAge());
                jsonObject_getPatientById.put("patientIdCardNum", patientById.getPatientIdCardNum());
                response.getWriter().write(jsonObject_getPatientById.toJSONString());

                break;
            case "update":
                String update_id = session.getAttribute("userId").toString();
                String patientName_update = request.getParameter("patientName");
                String patientPhone_update = request.getParameter("patientPhone");
                String patientSex_update = request.getParameter("patientSex");
                String patientAge_update = request.getParameter("patientAge");
                String patientIdCard_update = request.getParameter("patientIdCardNum");
                Patient patient_update = new Patient();
                patient_update.setPatientId(Integer.parseInt(update_id));
                patient_update.setPatientName(patientName_update);
                patient_update.setPatientPassword(patientService.getPatientById(Integer.parseInt(update_id)).getPatientPassword());
                patient_update.setPatientPhone(patientPhone_update);
                patient_update.setPatientSex(patientSex_update);
                patient_update.setPatientAge(Integer.parseInt(patientAge_update));
                patient_update.setPatientIdCardNum(patientIdCard_update);
                patientService.updatePatient(patient_update);
                JSONObject jsonObject_update = new JSONObject();
                jsonObject_update.put("status", "success");
                response.getWriter().write(jsonObject_update.toJSONString());

                break;
            case "updateByAdmin":
                String id = request.getParameter("patientId");
                String patientName1 = request.getParameter("patientName");
                String patientPhone1 = request.getParameter("patientPhone");
                String patientSex1 = request.getParameter("patientSex");
                String patientAge1 = request.getParameter("patientAge");
                String patientIdCard1 = request.getParameter("patientIdCardNum");
                Patient patient1 = new Patient();
                patient1.setPatientId(Integer.parseInt(id));
                patient1.setPatientName(patientName1);
                patient1.setPatientPhone(patientPhone1);
                patient1.setPatientSex(patientSex1);
                patient1.setPatientAge(Integer.parseInt(patientAge1));
                patient1.setPatientIdCardNum(patientIdCard1);
                patient1.setPatientPassword(patientService.getPatientById(Integer.parseInt(id)).getPatientPassword());
                patientService.updatePatient(patient1);
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("status", "success");
                response.getWriter().write(jsonObject1.toJSONString());
                break;
            case "resetPassword":
                Patient patient_rp = patientService.getPatientById((Integer) session.getAttribute("userId"));
                String new_password = request.getParameter("new_password");
                patientService.updatePassword(patient_rp.getPatientId(), new_password);
                JSONObject jsonObject_rp = new JSONObject();
                jsonObject_rp.put("status", "success");
                response.getWriter().write(jsonObject_rp.toJSONString());
                break;
            case "delete":
                int patientId = Integer.parseInt(request.getParameter("patientId"));
                patientService.deletePatient(patientId);
                JSONObject jsonObject_del = new JSONObject();
                jsonObject_del.put("status", "success");
                response.getWriter().write(jsonObject_del.toJSONString());
                break;
            default:
                break;
        }
        return mapping.findForward(null);
    }
}
