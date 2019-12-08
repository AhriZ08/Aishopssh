package com.Aishopssh.Entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_type_2", schema = "e_shopwebsite")
public class TbType2 {
    private int id;
    private String typeName;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TypeName")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbType2 tbType2 = (TbType2) o;

        if (id != tbType2.id) return false;
        return Objects.equals(typeName, tbType2.typeName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
