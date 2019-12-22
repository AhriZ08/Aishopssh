package com.Aishopssh.Entites;

import java.io.Serializable;
import java.util.Objects;

public class Comments implements Serializable {
    private int id;
    private String title;
    private String content;
    private String time;
    private User tbUserByUserId;
    private Goods tbGoodsByGoodsId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comments comments = (Comments) o;

        if (id != comments.id) return false;

        if (!Objects.equals(title, comments.title)) return false;
        if (!Objects.equals(content, comments.content)) return false;
        return Objects.equals(time, comments.time);
    }

    @Override
    public int hashCode() {
        int result = id;

        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    public User getTbUserByUserId() {
        return tbUserByUserId;
    }

    public void setTbUserByUserId(User tbUserByUserId) {
        this.tbUserByUserId = tbUserByUserId;
    }

    public Goods getTbGoodsByGoodsId() {
        return tbGoodsByGoodsId;
    }

    public void setTbGoodsByGoodsId(Goods tbGoodsByGoodsId) {
        this.tbGoodsByGoodsId = tbGoodsByGoodsId;
    }
}
