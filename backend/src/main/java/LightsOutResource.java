import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Problem;
import model.Solution;
import model.SolutionStep;

import java.util.List;


@Path("/")
public class LightsOutResource {

    @GET
    @Path("/helloworld")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World!";
    }

    @GET
    @Path("problems/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProblem(@PathParam("id") int id) {
        Problem problem = Problem.findById((Integer) id);
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
    public List<Problem> getProblems() {
        return Problem.listAll(Sort.by("dimension"));
    }

    @POST
    @Path("/problems")
    @Transactional
    public Response createProblem(Problem problem) {
        if (problem.getDimension() <= 2 || problem.getDescription() == null || problem.getDescription().length != problem.getDimension() * problem.getDimension()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid problem data").build();
        }

        int[] steps = LightsOutSolver.solverBFS(problem.getDescription(), problem.getDimension());

        if (steps == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Unsolvable problem").build();
        } else {
            problem.persist();

            Solution newSolution = new Solution();
            newSolution.setProblemId(problem.getId());
            int stepsNr = LightsOutSolver.countLightsOn(steps);
            newSolution.setStepsNr(stepsNr);

            newSolution.persist();

            SolutionStep solutionStep = new SolutionStep();
            solutionStep.setSolutionId(newSolution.getId());
            solutionStep.setStep(steps);
            solutionStep.setStepIx(1);

            solutionStep.persist();
        }

        return Response.ok(problem).status(201).build();
    }




    //Solution
    @GET
    @Path("/solutions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Solution> getSolutions() {
        return Solution.listAll(Sort.by("id"));
    }

    @GET
    @Path("solutions/problem/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSolutionToProblem(@PathParam("id") int id) {
        List<Solution> solutions = Solution.list("problem_id", id);
        if (!solutions.isEmpty()) {
            Solution solution = solutions.get(0); // Assuming there's only one solution per problem_id
            return Response.ok(solution).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}

