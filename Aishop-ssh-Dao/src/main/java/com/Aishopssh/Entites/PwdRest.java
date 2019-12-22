package com.Aishopssh.Entites;

import java.io.Serializable;
import java.util.Objects;

public class PwdRest implements Serializable {
    private int id;
    private String isAccepted;
    private User tbUserByUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return Objects.equals(isAccepted, pwdRest.isAccepted);
    }

    @Override
    public int hashCode() {
        int result = id;
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
