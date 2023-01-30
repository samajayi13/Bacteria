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

}
