package org.example.Dao;

import org.example.Entity.AccompanyComment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccompanyCommentDao {
    Connection cnn;
    public AccompanyCommentDao() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accompanimentSystem?useUnicode=true&characterEncoding=utf8", "root", "");
    }
    // 新增评论
    public void addAccompanyComment(AccompanyComment accompanyComment) throws SQLException {
        Statement statement = this.cnn.createStatement();
        String sql = "INSERT INTO accompany_comment (accompany_order_id, comment_time, comment_content, comment_score) VALUES ('" + accompanyComment.getAccompanyOrderId() + "', '" + accompanyComment.getCommentTime() + "', '" + accompanyComment.getCommentContent() + "', '" + accompanyComment.getCommentScore() + "')";
        System.out.println(sql);
        statement.execute(sql);
    }

    // 根据订单ID删除评论
    public void deleteComment(int id) throws SQLException {
        Statement statement = this.cnn.createStatement();
        String sql = "DELETE FROM accompany_comment WHERE accompany_order_id = " + id;
        statement.execute(sql);
    }

}
