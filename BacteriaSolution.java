import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//access modifiers for this class has been made public to allow for unit testing

public class BacteriaSolution {
   public static PetriGridDish pretriDish = new PetriGridDish();
   private static InputProcessor inputProcessor = new InputProcessor();
   private static Scanner scanner  = new Scanner(System.in);

    public static void main(String[] args) {
       beginSimulation();
   }

    private static void beginSimulation() {
        System.out.println("Enter living cells coordinates to begin: ");
        List<String> liveCells = getLiveCells();
        List<String> survivingCells = findSurvivingCells(liveCells);
        survivingCells = reviveDeadCells(survivingCells);
        outputNewGeneration(survivingCells);
    }

    public static List<String> getLiveCells() {
        List<String> liveCells = new ArrayList<>();
        String line = scanner.nextLine();

        while (!line.equals("end")) {
            int row = inputProcessor.getRow(line);
            int column = inputProcessor.getColumn(line);
            String cellPosition = row + "," + column;

            pretriDish.insertBacteria(row,column);
            liveCells.add(cellPosition);

            line = scanner.nextLine();
        }

        return liveCells;
    }

    public static List<String> findSurvivingCells(List<String> liveCells) {
        List<String> survivingCells = new ArrayList<>();

        for (String cell : liveCells) {
            if (isCellAlive(cell)) {
                int row = inputProcessor.getRow(cell);
                int column = inputProcessor.getColumn(cell);
                String cellPosition = row + "," + column;
                survivingCells.add(cellPosition);
            }
        }

        return survivingCells;
    }

    public static boolean isCellAlive(String cell){
        int row = inputProcessor.getRow(cell);
        int column = inputProcessor.getColumn(cell);
        int numOfLivingNeighbors = getNumberOfLivingNeighbors(row - 1, column - 1);

        //in order for bacteria cell to be alive it needs 2 or 3 alive bacteria cell neighbors;
        boolean isAlive = numOfLivingNeighbors == 2 || numOfLivingNeighbors == 3;
        return isAlive;
    }

    //program loops through grid finding cells with 3 neighbors. If this is true cell will be alive in the next generation
    public static List<String> reviveDeadCells(List<String> survivingCells) {
        for (int i = 0; i < pretriDish.ROWS; i++) {
            for (int j = 0; j < pretriDish.COLUMNS; j++) {
                int liveNeighbors = getNumberOfLivingNeighbors(i, j);
                int cell = pretriDish.grid[i][j];
                boolean isCellRevivable = cell == 0 && liveNeighbors == 3;

                if (isCellRevivable) {
                    survivingCells.add((i + 1) + "," + (j + 1));
                }
            }
        }

        return survivingCells;
    }

    private static void outputNewGeneration(List<String> survivingCells) {
        for (String cell : survivingCells) {
            System.out.println(cell);
        }

        System.out.println("end");
    }

    //Checks all 8 possible neighbours to see if any is alive
    public static int getNumberOfLivingNeighbors(int row, int col) {
        final int Number_Of_Possible_Neighbors = 8;
        int aliveNeighbours = 0;

        for (int i = 0; i < Number_Of_Possible_Neighbors; i++) {
            int neighbourPositionX = row + pretriDish.neighborsX[i];
            int neighbourPositionY = col + pretriDish.neighborsY[i];

            if (isPositionValid(neighbourPositionX, neighbourPositionY) && isNeighborAlive(neighbourPositionX,neighbourPositionY)) {
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

   public static boolean isPositionValid(int row, int column){
       return  column >= 0 && column < pretriDish.COLUMNS && row >= 0 && row < pretriDish.ROWS;
   }

   public static boolean isNeighborAlive(int row, int column){
       return pretriDish.grid[row][column] == 1;
   }
}
