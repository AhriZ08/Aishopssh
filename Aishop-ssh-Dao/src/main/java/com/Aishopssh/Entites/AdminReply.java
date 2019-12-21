package com.Aishopssh.Entites;

import java.io.Serializable;
import java.util.Objects;

public class AdminReply implements Serializable {
    private int id;
    private int userId;
    private int leavewordId;
    private String title;
    private String content;
    private String replyTime;
    private int isRead;
    private User tbUserByUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLeavewordId() {
        return leavewordId;
    }

    public void setLeavewordId(int leavewordId) {
        this.leavewordId = leavewordId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminReply that = (AdminReply) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (leavewordId != that.leavewordId) return false;
        if (isRead != that.isRead) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(content, that.content)) return false;
        return Objects.equals(replyTime, that.replyTime);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + leavewordId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
        result = 31 * result + isRead;
        return result;
    }

    public User getTbUserByUserId() {
        return tbUserByUserId;
    }

    public void setTbUserByUserId(User tbUserByUserId) {
        this.tbUserByUserId = tbUserByUserId;
    }
}
