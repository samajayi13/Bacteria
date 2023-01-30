import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BacteriaSolutionTest {
    BacteriaSolution simulation = new BacteriaSolution();
    @Test
    public void givenLiveCellsFindSurvingCells(){
        simulation.pretriDish.grid = getMockDish();
        List<String> livingCells = new ArrayList<>(Arrays.asList("1,2","2,2","3,2"));
        List<String> expected = new ArrayList<>(Arrays.asList("2,2"));
        List<String> actual = simulation.findSurvivingCells(livingCells);
        assertEquals(expected,actual);
    }

    @Test
    public void givenCellGetNumberOfLivingNeighbors(){
        simulation.pretriDish.grid = getMockDish();
        int expected = 1;
        int actual = simulation.getNumberOfLivingNeighbors(2,1);
        assertEquals(expected,actual);
    }

    @Test
    public void givenNeighbourPositionCheckIfValid(){
        boolean expected = true;
        boolean actual =  simulation.isPositionValid(1,2);
        assertEquals(expected,actual);
    }


    @Test
    public void givenNeighbourPositionCheckIfInValid(){
        boolean expected = true;
        boolean actual =  simulation.isPositionValid(-1,11);
        assertNotEquals(expected,actual);
    }

    @Test

    public void givenNeighbourCheckIfAlive(){
        simulation.pretriDish.grid = getMockDish();
        boolean expected = true;
        boolean actual = simulation.isNeighborAlive(0,1);
        assertEquals(expected,actual);
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
