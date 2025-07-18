import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        runEjerciciosPD();
        runMaze();
    }

    private static void runEjerciciosPD() {
        EjercicioPD ejerciciosPD = new EjercicioPD();
    
        int n = 50;
        System.out.println("Ingrese el valor de n: " + n);
    
        System.out.println("Fibonaci Recursivo");
        long start = System.nanoTime();
        long resultado = ejerciciosPD.getFibonacci(n);
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration);
    
        System.out.println("Fibonaci Recursivo Caching");
        start = System.nanoTime();
        resultado = ejerciciosPD.getFibonacciPD(n);
        end = System.nanoTime();
        duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration);
    }

    private static void runMaze(){
        boolean[][] predefineMaze = {
            {true,true,true,true},
            {false,true,true,true},
            {true,true,false,false},
            {true,true,true,true}
        };
        Maze maze = new Maze(predefineMaze);
        System.out.println("Laberinto cargado:");
        maze.printMaze();

        Cell start = new Cell(0,0);
        Cell end = new Cell(3,3);
        List<MazeSolver> solvers = Arrays.asList(new MazeSolverRecursivo());

        MazeSolver solver = solvers.get(0);
        List<Cell> path;
        path = solver.getPath(maze.getMaze(), start, end);

        System.out.println("Camino encontrado: ");
        System.out.println(path);
    }
}
