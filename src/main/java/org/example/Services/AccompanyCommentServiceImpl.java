package org.example.Services;

import org.example.Dao.AccompanyCommentDao;
import org.example.Entity.AccompanyComment;

import java.sql.SQLException;

public class AccompanyCommentServiceImpl implements AccompanyCommentService{
    AccompanyCommentDao accompanyCommentDao = new AccompanyCommentDao();

    public AccompanyCommentServiceImpl() throws Exception {
    }

    @Override
    public void addAccompanyComment(AccompanyComment accompanyComment) throws SQLException {
        accompanyCommentDao.addAccompanyComment(accompanyComment);
    }

    @Override
    public void deleteAccompanyComment(int id) throws SQLException {
        accompanyCommentDao.deleteComment(id);
    }
}
