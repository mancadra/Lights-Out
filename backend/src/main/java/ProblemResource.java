import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Problem;
import repository.ProblemRepository;

import java.util.List;
import java.util.Optional;

@Path("/")
public class ProblemResource {
    @Inject
    ProblemRepository problemRepository;

    @GET
    @Path("/helloworld")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World!";
    }

    @GET
    @Path("problem/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProblem(@PathParam("id") int id) {
        Problem problem = Problem.findById(id);
        if (problem != null) {
            int[] description = problem.getDescription();
            return Response.ok(description).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/problems")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Problem> get() {
        return Problem.listAll(Sort.by("dimension"));
    }

    @POST
    @Path("/problems")
    @Transactional
    public Response createProblem(Problem problem) {
        if (problem.getDimension() <= 2 || problem.getDescription() == null || problem.getDescription().length != problem.getDimension() * problem.getDimension()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid problem data").build();
        }

        problem.persist();

        return Response.ok(problem).status(201).build();
    }

}
