package system.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detail", schema = "test")
public class Detail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,insertable = false, updatable = false)
    private Integer id;
    private String type;
    private Integer count;
    private Byte necessity;
    private String name;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "necessity")
    public Byte getNecessity() {
        return necessity;
    }

    public void setNecessity(Byte necessity) {
        this.necessity = necessity;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Detail detail = (Detail) o;

        if (id != null ? !id.equals(detail.id) : detail.id != null) return false;
        if (type != null ? !type.equals(detail.type) : detail.type != null) return false;
        if (count != null ? !count.equals(detail.count) : detail.count != null) return false;
        if (necessity != null ? !necessity.equals(detail.necessity) : detail.necessity != null) return false;
        if (name != null ? !name.equals(detail.name) : detail.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (necessity != null ? necessity.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", count=" + count +
                ", necessity=" + necessity +
                ", name='" + name + '\'' +
                '}';
    }
}
