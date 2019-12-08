package com.Aishopssh.Entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_pwd_rest", schema = "e_shopwebsite")
public class TbPwdRest {
    private int id;
    private String isAccepted;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Is_Accepted")
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

        TbPwdRest tbPwdRest = (TbPwdRest) o;

        if (id != tbPwdRest.id) return false;
        return Objects.equals(isAccepted, tbPwdRest.isAccepted);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isAccepted != null ? isAccepted.hashCode() : 0);
        return result;
    }
}
