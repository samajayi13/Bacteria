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
        List<String> livingCells = new ArrayList<>(Arrays.asList("1,2","2,2","3,2"));
        System.out.println("living cells" + livingCells);
        List<String> expected = new ArrayList<>(Arrays.asList("2,1","2,2","2,3"));
        List<String> actual = simulation.findSurvivingCells(livingCells);
        assertEquals(expected,actual);
    }
}
