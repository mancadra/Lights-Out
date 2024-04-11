package model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "solution")
public class Solution extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "problem_id")
    private Integer problem_id;

    @Column(name = "steps_nr")
    private int steps_nr;


    public Solution() {}

    public Solution(Integer id, Integer problem_id, int steps_nr) {
        this.id = id;
        this.problem_id = problem_id;
        this.steps_nr = steps_nr;
    }

    public int getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProblemId() { return problem_id; }

    public void setProblemId(Integer problem_id) {
        this.problem_id = problem_id;
    }

    public int getStepsNr() { return steps_nr; }

    public void setStepsNr(int steps_nr) {
        this.steps_nr = steps_nr;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "solutionId=" + id +
                ", problemId='" + problem_id + '\'' +
                ", Nr od steps='" + steps_nr + '\'' +
                '}';
    }
}
