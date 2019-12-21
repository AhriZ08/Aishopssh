package com.Aishopssh.Entites;

import java.util.Objects;

public class PwdRest {
    private int id;
    private int userId;
    private String isAccepted;
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

    public String getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(String isAccepted) {
        this.isAccepted = isAccepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PwdRest pwdRest = (PwdRest) o;

        if (id != pwdRest.id) return false;
        if (userId != pwdRest.userId) return false;
        return Objects.equals(isAccepted, pwdRest.isAccepted);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (isAccepted != null ? isAccepted.hashCode() : 0);
        return result;
    }

    public User getTbUserByUserId() {
        return tbUserByUserId;
    }

    public void setTbUserByUserId(User tbUserByUserId) {
        this.tbUserByUserId = tbUserByUserId;
    }
}
