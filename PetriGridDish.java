public class PetriGridDish {
    public static final int ROWS  = 10;
    public static final int COLUMNS = 10;

    public static int[] neighborsX = {-1,-1,-1,0,0,1,1,1};
    public static int[] neighborsY =  {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int[][] grid = new int[ROWS][COLUMNS];
}
