public class PetriGridDish {
    public static final int ROWS  = 10;
    public static final int COLUMNS = 10;

    //Below two fields is used to find all possible 8 neighbours a cell can have
    public static int[] neighborsX = {-1,-1,-1,0,0,1,1,1};
    public static int[] neighborsY =  {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int[][] grid = new int[ROWS][COLUMNS];

    public void insertBacteria(int row,int column){
        this.grid[row - 1][column - 1] = 1;
    }
}
