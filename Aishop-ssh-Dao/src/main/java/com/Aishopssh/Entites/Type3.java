package com.Aishopssh.Entites;

import java.io.Serializable;
import java.util.Objects;

public class Type3 implements Serializable {
    private int id;
    private String typeName;
    private int typeIdLevel2;
    private Type2 tbType2ByTypeIdLevel2;

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

    public int getTypeIdLevel2() {
        return typeIdLevel2;
    }

    public void setTypeIdLevel2(int typeIdLevel2) {
        this.typeIdLevel2 = typeIdLevel2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type3 type3 = (Type3) o;

        if (id != type3.id) return false;
        if (typeIdLevel2 != type3.typeIdLevel2) return false;
        return Objects.equals(typeName, type3.typeName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + typeIdLevel2;
        return result;
    }

    public Type2 getTbType2ByTypeIdLevel2() {
        return tbType2ByTypeIdLevel2;
    }

    public void setTbType2ByTypeIdLevel2(Type2 tbType2ByTypeIdLevel2) {
        this.tbType2ByTypeIdLevel2 = tbType2ByTypeIdLevel2;
    }
}
