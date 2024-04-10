package repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Problem;
import model.Problem$;

import java.util.Optional;

@ApplicationScoped
public class ProblemRepository {

    @Inject
    JPAStreamer jpaStreamer;

    public Optional<Problem> getProblem(int id) {
        return jpaStreamer.stream(Problem.class)
                .filter(Problem$.id.equal(id))
                .findFirst();
    }
}
