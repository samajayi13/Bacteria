import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputProcessorTest {
    
    @Test
    public void Get_Column_From_Input(){
        InputProcessor inputProcessor = new InputProcessor();
        int expected = 2;
        int actual = inputProcessor.getColumn("1,2");

        assertEquals(expected,actual);
    }

    @Test
    public void Get_Row_From_Input(){
        InputProcessor inputProcessor = new InputProcessor();
        int expected = 1;
        int actual = inputProcessor.getRow("1,2");

        assertEquals(expected,actual);
    }
}
