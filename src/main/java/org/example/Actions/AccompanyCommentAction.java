package org.example.Actions;

import com.alibaba.fastjson.JSONObject;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.example.Entity.AccompanyComment;
import org.example.Services.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AccompanyCommentAction extends Action{
    public AccompanyCommentAction() throws Exception {
    }
    private String encoding = "UTF-8";
    private String contentType = "application/json";
    AccompanyCommentService accompanyCommentService = new AccompanyCommentServiceImpl();
    AccompanyOrderService accompanyOrderService = new AccompanyOrderServiceImpl();


    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        this.contentType = contentType + ";charset=" + encoding;
        response.setContentType(contentType);
        response.setCharacterEncoding(encoding);
        switch (type) {
            case "addComment":
                String accompanyOrderId = request.getParameter("accompanyOrderId");
                LocalDateTime now = LocalDateTime.now().withNano(0);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String commentTime = now.format(formatter);
                String commentContent = request.getParameter("commentContent");
                String commentScore = request.getParameter("commentScore");
                AccompanyComment accompanyComment = new AccompanyComment();
                accompanyComment.setAccompanyOrderId(Integer.parseInt(accompanyOrderId));
                accompanyComment.setCommentTime(commentTime);
                accompanyComment.setCommentContent(commentContent);
                accompanyComment.setCommentScore(Integer.parseInt(commentScore));
                accompanyCommentService.addAccompanyComment(accompanyComment);
                accompanyOrderService.updateOrderStatus(Integer.parseInt(accompanyOrderId), 2);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", "success");
                response.getWriter().write(jsonObject.toJSONString());

                break;
            default:
                break;
        }

        return mapping.findForward(null);
    }
}
