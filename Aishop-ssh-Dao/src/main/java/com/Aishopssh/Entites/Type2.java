package com.Aishopssh.Entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class Type2 implements Serializable {
    private int id;
    private String typeName;
    private Type1 tbType1ByTypeIdLevel1;
    private Set<Type3> tbType3sById;

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

        Type2 type2 = (Type2) o;

        if (id != type2.id) return false;
        return Objects.equals(typeName, type2.typeName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }

    public Type1 getTbType1ByTypeIdLevel1() {
        return tbType1ByTypeIdLevel1;
    }

    public void setTbType1ByTypeIdLevel1(Type1 tbType1ByTypeIdLevel1) {
        this.tbType1ByTypeIdLevel1 = tbType1ByTypeIdLevel1;
    }

    public Set<Type3> getTbType3sById() {
        return tbType3sById;
    }

    public void setTbType3sById(Set<Type3> tbType3sById) {
        this.tbType3sById = tbType3sById;
    }
}
