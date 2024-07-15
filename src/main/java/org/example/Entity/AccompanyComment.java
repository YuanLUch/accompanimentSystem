package org.example.Entity;

public class AccompanyComment {
    private Integer commentId;
    private Integer accompanyOrderId;
    private String commentTime;
    private String commentContent;
    private Integer commentScore;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getAccompanyOrderId() {
        return accompanyOrderId;
    }

    public void setAccompanyOrderId(Integer accompanyOrderId) {
        this.accompanyOrderId = accompanyOrderId;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Integer commentScore) {
        this.commentScore = commentScore;
    }
}
