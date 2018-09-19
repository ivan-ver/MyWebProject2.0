package system.entity;

public class Type {
    private String typeName;
    private Integer count;
    private String necessity;

    public Type(String typeName, Integer count, String necessity) {
        this.typeName = typeName;
        this.count = count;
        this.necessity = necessity;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNecessity() {
        return necessity;
    }

    public void setNecessity(String necessity) {
        this.necessity = necessity;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeName='" + typeName + '\'' +
                ", count=" + count +
                ", necessity=" + necessity +
                '}';
    }
}
