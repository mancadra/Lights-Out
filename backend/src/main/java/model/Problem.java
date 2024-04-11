package model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
@Table(name = "problem")
public class Problem extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dimension")
    private int dimension;

    @Column(name = "description")
    private int[] description;

    public Problem() {}

    public Problem(Integer id, int dimension, int[] description) {
        this.id = id;
        this.dimension = dimension;
        this.description = description;
    }

    public int getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDimension() { return dimension; }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int[] getDescription() { return description; }

    public void setDescription(int[] description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "problemId=" + id +
                ", dimension='" + dimension + '\'' +
                ", description='" + Arrays.toString(description) + '\'' +
                '}';
    }

}
