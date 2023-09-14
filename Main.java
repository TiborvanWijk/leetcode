public class Main {
    public static void main(String[] args) throws InterruptedException {

        int[][] grid =
       {{0,0,1,1,0,1,0,0,1,0},
        {1,1,0,1,1,0,1,1,1,0},
        {1,0,1,1,1,0,0,1,1,0},
        {0,1,1,0,0,0,0,1,0,1},
        {0,0,0,0,0,0,1,1,1,0},
        {0,1,0,1,0,1,0,1,1,1},
        {1,0,1,0,1,1,0,0,0,1},
        {1,1,1,1,1,1,0,0,0,0},
        {1,1,1,0,0,1,0,1,0,1},
        {1,1,1,0,1,1,0,1,1,0}};

        solutions solutions = new solutions();
        solutions.closedIsland(grid);

    }
}