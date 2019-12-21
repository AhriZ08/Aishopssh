package com.Aishopssh.Entites;

import java.util.Collection;
import java.util.Objects;

public class Type1 {
    private int id;
    private String typeName;
    private Collection<Type2> tbType2sById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

        Type1 type1 = (Type1) o;

        if (id != type1.id) return false;
        return Objects.equals(typeName, type1.typeName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }

    public Collection<Type2> getTbType2sById() {
        return tbType2sById;
    }

    public void setTbType2sById(Collection<Type2> tbType2sById) {
        this.tbType2sById = tbType2sById;
    }
}
