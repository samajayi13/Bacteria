import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetriGridDishTest {
    @Test
    public void insertBacteria(){
        int[][] expected = getMockDish();

        PetriGridDish dish = new PetriGridDish();
        dish.insertBacteria(1,2);
        dish.insertBacteria(2,2);
        dish.insertBacteria(3,2);
        int[][]actual = dish.grid;
        
        assertArrayEquals(expected,actual);
    }

    private int[][] getMockDish(){
        return new int[][] {
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    }
}
