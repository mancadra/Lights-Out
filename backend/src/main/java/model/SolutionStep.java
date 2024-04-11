package model;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "solution_step")
public class SolutionStep extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "solution_id")
    private Integer solution_id;

    @Column(name = "step")
    private int[] step;

    @Column(name="step_ix")
    private int step_ix;

    public SolutionStep() {}

    public SolutionStep(Integer id, Integer solution_id, int[] step, int step_ix) {
        this.id = id;
        this.solution_id = solution_id;
        this.step = step;
        this.step_ix = step_ix;
    }

    public int getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSolutionId() { return solution_id; }

    public void setSolutionId(Integer solution_id) {
        this.solution_id = solution_id;
    }

    public int[] getStep() { return step; }

    public void setStep(int[] step) {
        this.step = step;
    }

    public int getStepIx() { return step_ix; }

    public void setStepIx(int step_ix) {
        this.step_ix = step_ix;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "problemId=" + id +
                ", solutionId='" + solution_id + '\'' +
                ", step='" + Arrays.toString(step) + '\'' +
                ", stepIx='" + step_ix + '\'' +
                '}';
    }

}
