package com.Aishopssh.Entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_admin_reply", schema = "e_shopwebsite")
public class TbAdminReply {
    private int id;
    private int leavewordId;
    private String title;
    private String content;
    private String replyTime;
    private int isRead;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "leavewordID")
    public int getLeavewordId() {
        return leavewordId;
    }

    public void setLeavewordId(int leavewordId) {
        this.leavewordId = leavewordId;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "ReplyTime")
    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    @Basic
    @Column(name = "Is_Read")
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

        TbAdminReply that = (TbAdminReply) o;

        if (id != that.id) return false;
        if (leavewordId != that.leavewordId) return false;
        if (isRead != that.isRead) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(content, that.content)) return false;
        return Objects.equals(replyTime, that.replyTime);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + leavewordId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
        result = 31 * result + isRead;
        return result;
    }
}
