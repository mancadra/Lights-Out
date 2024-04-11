import java.util.*;
//import org.apache.commons.math3.linear.*;

public class LightsOutSolver {

    static class State {
        int[] grid;
        List<Integer> clicks;
        int lightsOn;

        State(int[] grid, List<Integer> clicks, int lightsOn) {
            this.grid = grid.clone();
            this.clicks = new ArrayList<>(clicks);
            this.lightsOn = lightsOn;
        }
    }

    public static int[] solverBFS(int[] grid, int dimension) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();

        State initialState = new State(grid, new ArrayList<>(), countLightsOn(grid));
        queue.offer(initialState);
        visited.add(Integer.valueOf(Arrays.hashCode(grid)));

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            if (currentState.lightsOn == 0) {
                return clicksToIntArr(currentState.clicks, dimension);
            }
            for (int i = 0; i < dimension * dimension; i++) {
                int[] newGrid = currentState.grid.clone();
                int lOn = toggle(newGrid, dimension, i, currentState.lightsOn);
                State nextState = new State(newGrid, currentState.clicks, lOn);
                nextState.clicks.add(Integer.valueOf(i));
                int hash = Arrays.hashCode(newGrid);
                if (!visited.contains(Optional.of(hash))) {
                    visited.add(Integer.valueOf(hash));
                    queue.offer(nextState);
                }
            }
        }
        System.out.println("Unsolvable");
        return null;
    }

    public static int[] solverDFS(int[] grid, int dimension) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<State> stack = new Stack<>();

        State initialState = new State(grid, new ArrayList<>(), countLightsOn(grid));
        stack.push(initialState);
        visited.add(Integer.valueOf(Arrays.hashCode(grid)));

        while (!stack.isEmpty()) {
            State currentState = stack.pop();
            if (currentState.lightsOn == 0) {
                return clicksToIntArr(currentState.clicks, dimension);
            }
            for (int i = 0; i < dimension * dimension; i++) {
                int[] newGrid = currentState.grid.clone();
                int lOn = toggle(newGrid, dimension, i, currentState.lightsOn);
                State nextState = new State(newGrid, currentState.clicks, lOn);
                nextState.clicks.add(Integer.valueOf(i));
                int hash = Arrays.hashCode(newGrid);
                if (!visited.contains(Optional.of(hash))) {
                    visited.add(Integer.valueOf(hash));
                    stack.push(nextState);
                }
            }
        }
        System.out.println("Unsolvable");
        return null;
    }


    // The method toggles the values of the neighbouring cells and updates the number of lights turned on accordingly
    private static int toggle(int[] grid, int dimension, int index, int lightsOn) {
        int row = index / dimension;
        int col = index % dimension;
        grid[index] ^= 1; // Toggle the current cell
        if (grid[index] == 1) {
            lightsOn++;
        } else {
            lightsOn--;
        }

        // Toggle adjacent cells
        if (row > 0) {
            grid[index - dimension] ^= 1; // Up
            if (grid[index - dimension] == 1) {
                lightsOn++;
            } else {
                lightsOn--;
            }
        }
        if (row < dimension - 1) {
            grid[index + dimension] ^= 1; // Down
            if (grid[index + dimension] == 1) {
                lightsOn++;
            } else {
                lightsOn--;
            }
        }
        if (col > 0) {
            grid[index - 1] ^= 1; // Left
            if (grid[index - 1] == 1) {
                lightsOn++;
            } else {
                lightsOn--;
            }
        }
        if (col < dimension - 1)  {
            grid[index + 1] ^= 1; // Right
            if (grid[index + 1] == 1) {
                lightsOn++;
            } else {
                lightsOn--;
            }
        }

        return lightsOn;
    }

    private static int[] clicksToIntArr(List<Integer> clicks, int dimension) {
        int[] solution_step = new int[dimension*dimension];
        for (int click : clicks) {
            System.out.println("clicked indexes: " + click);
            solution_step[click] = 1;
        }

        return solution_step;
    }

    public static int countLightsOn(int[] grid) {
        int count = 0;
        for (int cell : grid) {
            if (cell == 1) {
                count++;
            }
        }
        return count;
    }

    private int[][] convertToMatrix(int dimension, int[] description) {
        // Convert the 1D description array to a 2D matrix representation
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = description[i * dimension + j];
            }
        }
        return matrix;
    }


    public static void main(String[] args) {
        /*int dimensionUNSOLV = 4;
        int[] gridUNSOLV = {1, 0, 1, 0,
                0, 1, 0, 1,
                1, 0, 1, 0,
                0, 1, 0, 1}; // Example grid
        //int[] stepsUNSOLV = solverBFS(gridUNSOLV, dimensionUNSOLV);
        //int[] stepsUNSOLV = solverDFS(gridUNSOLV, dimensionUNSOLV);
        for (int i = 0; i < dimensionUNSOLV * dimensionUNSOLV; i++) {
            System.out.println(stepsUNSOLV[i]);
        }*/

        int dimension = 3;
        int[] grid = { 0, 0, 0, 0, 0, 1, 0, 1, 1};
        int[] steps = solverBFS(grid, dimension);
        for (int i = 0; i < dimension * dimension; i++) {
            System.out.println(steps[i]);
        }
    }

}
