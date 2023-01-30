import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BacteriaSolution {
   private static PetriGridDish pretriDish = new PetriGridDish();
   private static InputProcessor inputProcessor = new InputProcessor();
   private static Scanner scanner  = new Scanner(System.in);

    public static void main(String[] args) {
       beginSimulation();
   }
   
    public static void beginSimulation() {
        List<String> liveCells = getLiveCells();
        List<String> survivingCells = findSurvivingCells(liveCells);
    }
   
    public static List<String> getLiveCells() {
        String line = scanner.nextLine();
        List<String> liveCells = new ArrayList<>();

        while (!line.equals("end")) {
            int row = inputProcessor.getRow(line);
            int column = inputProcessor.getColumn(line);
            pretriDish.insertBacteria(row,column);
            liveCells.add(row + "," + column);
            line = scanner.nextLine();
        }
       
        return liveCells;
    }
   
    public static List<String> findSurvivingCells(List<String> liveCells) {
        List<String> survivingCells = new ArrayList<>();

        for (String cell : liveCells) {
            int row = inputProcessor.getRow(cell);
            int column = inputProcessor.getColumn(cell);
            int numOfLivingNeighbors = getNumberOfLivingNeighbors(row - 1, column - 1);

            if (numOfLivingNeighbors == 2 || numOfLivingNeighbors == 3) {
                String position = row + "," + column;
                survivingCells.add(row + "," + column);
            }
        }

        return survivingCells;
    }
   
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
}
