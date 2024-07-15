package org.example.Services;

import org.example.Entity.AccompanyComment;

import java.sql.SQLException;

public interface AccompanyCommentService {
    void addAccompanyComment(AccompanyComment accompanyComment) throws SQLException;
    void deleteAccompanyComment(int id) throws SQLException;
}
