package com.Aishopssh.Entites;

import java.io.Serializable;
import java.util.Objects;

public class Type3 implements Serializable {
    private int id;
    private String typeName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type3 type3 = (Type3) o;

        if (id != type3.id) return false;
        return Objects.equals(typeName, type3.typeName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
    public Type2 getTbType2ByTypeIdLevel2() {
        return tbType2ByTypeIdLevel2;
    }

    public void setTbType2ByTypeIdLevel2(Type2 tbType2ByTypeIdLevel2) {
        this.tbType2ByTypeIdLevel2 = tbType2ByTypeIdLevel2;
    }
}
