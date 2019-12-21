package com.Aishopssh.Entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

public class Type2 implements Serializable {
    private int id;
    private String typeName;
    private int typeIdLevel1;
    private Type1 tbType1ByTypeIdLevel1;
    private Collection<Type3> tbType3sById;

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

    public int getTypeIdLevel1() {
        return typeIdLevel1;
    }

    public void setTypeIdLevel1(int typeIdLevel1) {
        this.typeIdLevel1 = typeIdLevel1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type2 type2 = (Type2) o;

        if (id != type2.id) return false;
        if (typeIdLevel1 != type2.typeIdLevel1) return false;
        return Objects.equals(typeName, type2.typeName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + typeIdLevel1;
        return result;
    }

    public Type1 getTbType1ByTypeIdLevel1() {
        return tbType1ByTypeIdLevel1;
    }

    public void setTbType1ByTypeIdLevel1(Type1 tbType1ByTypeIdLevel1) {
        this.tbType1ByTypeIdLevel1 = tbType1ByTypeIdLevel1;
    }

    public Collection<Type3> getTbType3sById() {
        return tbType3sById;
    }

    public void setTbType3sById(Collection<Type3> tbType3sById) {
        this.tbType3sById = tbType3sById;
    }
}
