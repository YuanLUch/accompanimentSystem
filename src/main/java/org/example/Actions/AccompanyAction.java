package org.example.Actions;

import com.alibaba.fastjson.JSONObject;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.example.Entity.Accompany;
import org.example.Entity.Patient;
import org.example.Services.AccompanyService;
import org.example.Services.AccompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;


public class AccompanyAction extends Action {
    public AccompanyAction() throws Exception {
    }

    private String encoding = "UTF-8";
    private String contentType = "application/json";
    AccompanyService accompanyService = new AccompanyServiceImpl();

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        this.contentType = contentType + ";charset=" + encoding;
        response.setContentType(contentType);
        response.setCharacterEncoding(encoding);
        switch (type) {
            case "addAccompany":
                String accompanyName = request.getParameter("accompanyName");
                String accompanyPassword = request.getParameter("accompanyPassword");
                String accompanyPhone = request.getParameter("accompanyPhone");
                String accompanySex = request.getParameter("accompanySex");
                String accompanyAge = request.getParameter("accompanyAge");
                String accompanyIdCard = request.getParameter("accompanyIdCardNum");
                String accompanyWorkAge = request.getParameter("accompanyWorkAge");
                String accompanyPrice = request.getParameter("accompanyPrice");
                String accompanyDescription = request.getParameter("accompanyDescription");
                Accompany accompany = new Accompany();
                accompany.setAccompanyName(accompanyName);
                accompany.setAccompanyPassword(accompanyPassword);
                accompany.setAccompanyPhone(accompanyPhone);
                accompany.setAccompanySex(accompanySex);
                accompany.setAccompanyAge(Integer.parseInt(accompanyAge));
                accompany.setAccompanyIdCardNum(accompanyIdCard);
                accompany.setAccompanyWorkAge(Integer.parseInt(accompanyWorkAge));
                accompany.setAccompanyPrice(Integer.parseInt(accompanyPrice));
                accompany.setAccompanyDescription(accompanyDescription);
                accompanyService.addAccompany(accompany);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", "success");
                response.getWriter().write(jsonObject.toJSONString());
                break;
            case "resetPassword":
                Accompany accompany_rp = accompanyService.getAccompanyById((Integer) session.getAttribute("userId"));
                String new_password = request.getParameter("new_password");
                accompanyService.updatePassword(accompany_rp.getAccompanyId(), new_password);
                JSONObject jsonObject_rp = new JSONObject();
                jsonObject_rp.put("status", "success");
                response.getWriter().write(jsonObject_rp.toJSONString());
                break;
            case "getList":
                List<Accompany> accompanies = accompanyService.getAllAccompanys();
                JSONObject jsonObject_list = new JSONObject();
                jsonObject_list.put("accompanies", accompanies);
                response.getWriter().write(jsonObject_list.toJSONString());

                break;
            case "getAccompanyById":
                String accompany_id_get = request.getParameter("accompanyId");
                Accompany accompany_get = accompanyService.getAccompanyById(Integer.parseInt(accompany_id_get));
                JSONObject jsonObject_get = new JSONObject();
                jsonObject_get.put("accompanyId", accompany_get.getAccompanyId());
                jsonObject_get.put("accompanyName", accompany_get.getAccompanyName());
                jsonObject_get.put("accompanyPhone", accompany_get.getAccompanyPhone());
                jsonObject_get.put("accompanySex", accompany_get.getAccompanySex());
                jsonObject_get.put("accompanyAge", accompany_get.getAccompanyAge());
                jsonObject_get.put("accompanyIdCardNum", accompany_get.getAccompanyIdCardNum());
                jsonObject_get.put("accompanyWorkAge", accompany_get.getAccompanyWorkAge());
                jsonObject_get.put("accompanyPrice", accompany_get.getAccompanyPrice());
                jsonObject_get.put("accompanyDescription", accompany_get.getAccompanyDescription());
                response.getWriter().write(jsonObject_get.toJSONString());

                break;
            case "getInfo":
                String accompany_id_get1 = session.getAttribute("userId").toString();
                Accompany accompany_get1 = accompanyService.getAccompanyById(Integer.parseInt(accompany_id_get1));
                JSONObject jsonObject_get1 = new JSONObject();
                jsonObject_get1.put("accompanyId", accompany_id_get1);
                jsonObject_get1.put("accompanyName", accompany_get1.getAccompanyName());
                jsonObject_get1.put("accompanyPhone", accompany_get1.getAccompanyPhone());
                jsonObject_get1.put("accompanySex", accompany_get1.getAccompanySex());
                jsonObject_get1.put("accompanyAge", accompany_get1.getAccompanyAge());
                jsonObject_get1.put("accompanyIdCardNum", accompany_get1.getAccompanyIdCardNum());
                jsonObject_get1.put("accompanyWorkAge", accompany_get1.getAccompanyWorkAge());
                jsonObject_get1.put("accompanyPrice", accompany_get1.getAccompanyPrice());
                jsonObject_get1.put("accompanyDescription", accompany_get1.getAccompanyDescription());
                response.getWriter().write(jsonObject_get1.toJSONString());

                break;
            case "updateByAdmin":
                String accompany_id_update = request.getParameter("accompanyId");
                Accompany accompany_raw = accompanyService.getAccompanyById(Integer.parseInt(accompany_id_update));
                String accompanyName1 = request.getParameter("accompanyName");
                String accompanyPhone1 = request.getParameter("accompanyPhone");
                String accompanySex1 = request.getParameter("accompanySex");
                String accompanyAge1 = request.getParameter("accompanyAge");
                String accompanyIdCard1 = request.getParameter("accompanyIdCardNum");
                String accompanyWorkAge1 = request.getParameter("accompanyWorkAge");
                String accompanyPrice1 = request.getParameter("accompanyPrice");
                String accompanyDescription1 = request.getParameter("accompanyDescription");
                Accompany accompany_update = new Accompany();
                accompany_update.setAccompanyId(Integer.parseInt(accompany_id_update));
                accompany_update.setAccompanyName(accompanyName1);
                accompany_update.setAccompanyPhone(accompanyPhone1);
                accompany_update.setAccompanySex(accompanySex1);
                accompany_update.setAccompanyAge(Integer.parseInt(accompanyAge1));
                accompany_update.setAccompanyIdCardNum(accompanyIdCard1);
                accompany_update.setAccompanyWorkAge(Integer.parseInt(accompanyWorkAge1));
                accompany_update.setAccompanyPrice(Integer.parseInt(accompanyPrice1));
                accompany_update.setAccompanyDescription(accompanyDescription1);
                accompany_update.setAccompanyPassword(accompany_raw.getAccompanyPassword());
                accompanyService.updateAccompany(accompany_update);
                JSONObject jsonObject_update = new JSONObject();
                jsonObject_update.put("status", "success");
                response.getWriter().write(jsonObject_update.toJSONString());

                break;
            case "update":
                String accompany_id_update1 = session.getAttribute("userId").toString();
                String accompanyName_update = request.getParameter("accompanyName");
                String accompanyPhone_update = request.getParameter("accompanyPhone");
                String accompanySex_update = request.getParameter("accompanySex");
                String accompanyAge_update = request.getParameter("accompanyAge");
                String accompanyIdCard_update = request.getParameter("accompanyIdCardNum");
                String accompanyWorkAge_update = request.getParameter("accompanyWorkAge");
                String accompanyPrice_update = request.getParameter("accompanyPrice");
                String accompanyDescription_update = request.getParameter("accompanyDescription");
                Accompany accompany_update1 = new Accompany();
                accompany_update1.setAccompanyId(Integer.parseInt(accompany_id_update1));
                accompany_update1.setAccompanyName(accompanyName_update);
                accompany_update1.setAccompanyPassword(accompanyService.getAccompanyById(Integer.parseInt(accompany_id_update1)).getAccompanyPassword());
                accompany_update1.setAccompanyPhone(accompanyPhone_update);
                accompany_update1.setAccompanySex(accompanySex_update);
                accompany_update1.setAccompanyAge(Integer.parseInt(accompanyAge_update));
                accompany_update1.setAccompanyIdCardNum(accompanyIdCard_update);
                accompany_update1.setAccompanyWorkAge(Integer.parseInt(accompanyWorkAge_update));
                accompany_update1.setAccompanyPrice(Integer.parseInt(accompanyPrice_update));
                accompany_update1.setAccompanyDescription(accompanyDescription_update);
                accompanyService.updateAccompany(accompany_update1);
                JSONObject jsonObject_update1 = new JSONObject();
                jsonObject_update1.put("status", "success");
                response.getWriter().write(jsonObject_update1.toJSONString());

                break;
            case "delete":
                String accompany_id = request.getParameter("accompanyId");
                accompanyService.deleteAccompany(Integer.parseInt(accompany_id));
                JSONObject jsonObject_delete = new JSONObject();
                jsonObject_delete.put("message", "success");
                response.getWriter().write(jsonObject_delete.toString());

                break;
        }

        return mapping.findForward(null);
    }
}
