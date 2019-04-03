
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import sudoku.domain.Sudoku;


public class SudokuTest {
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void konstruktoriLuoOikeanLevyisenSudokun() {
        Sudoku s = new Sudoku();
        assertTrue(s.getSudoku()[0].length == 9);
    }
    
    @Test
    public void konstruktoriLuoOikeanKorkuisenTaulukon() {
        Sudoku s = new Sudoku();
        assertTrue(s.getSudoku().length == 9);
    }
    
    @Test
    public void getValuePalauttaaSallitunArvon() {
        Sudoku s = new Sudoku();
        assertTrue(s.getValue(0, 0) < 10 && s.getValue(0, 0) >= 0);
    }
}
