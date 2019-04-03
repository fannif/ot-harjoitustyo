
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import sudoku.domain.Sudoku;


public class SudokuTest {
    
    Sudoku s;
    
    @Before
    public void setUp() {
        s = new Sudoku();
    }
    
    @Test
    public void konstruktoriLuoOikeanLevyisenSudokun() {
        assertTrue(s.getSudoku()[0].length == 9);
    }
    
    @Test
    public void konstruktoriLuoOikeanKorkuisenTaulukon() {
        assertTrue(s.getSudoku().length == 9);
    }
    
    @Test
    public void getValuePalauttaaSallitunArvon() {
        assertTrue(s.getValue(0, 0) < 10 && s.getValue(0, 0) >= 0);
    }
    
    @Test
    public void setValueAsettaaArvon() {
        s.setValue(1, 1, 9);
        assertTrue(s.getValue(1, 1) == 9);
    }
    
    @Test
    public void setValueKorvaaLiianPienenArvonYhdella() {
        s.setValue(0, 0, -1);
        assertTrue(s.getValue(0, 0) == 1);
    }
    
    @Test
    public void setValueKorvaaLiianSuurenArvonYhdella() {
        s.setValue(0, 0, 10);
        assertTrue(s.getValue(0, 0) == 1);
    }
    
    @Test
    public void emptySudokunJalkeenSudokussaPelkkiaNollia() {
        s.emptySudoku();
        int nollia = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (s.getValue(i, j) == 0) {
                    nollia++;
                }
            }
        }
        
        assertTrue(nollia == 81);
    }
    
    @Test
    public void isOkReturnsFalseIfNumberAlreadyInTheRow() {
        s.setValue(0, 0, 9);
        assertTrue(!s.isOk(0, 1, 9));
    }
    
    @Test
    public void isOkReturnsFalseIfNumberAlreadyInTheColumn() {
        s.setValue(0, 0, 9);
        assertTrue(!s.isOk(1, 0, 9));
    }
    
    @Test
    public void isOkReturnsFalseIfNumberAlreadyInSubGrid() {
        s.setValue(0, 0, 9);
        assertTrue(!s.isOk(1, 1, 9));
    }
    
    @Test
    public void isOkReturnsTrueIfNumberIsAllowed() {
        assertTrue(s.isOk(0, 0, 9));
    }
    
    @Test
    public void isOkPicksSubGridFromRow0IfRowIsLessThan3() {
        s.setValue(2, 0, 9);
        assertTrue(!s.isOk(1, 1, 9));
    }
    
    @Test
    public void isOkPicksSubGridFromRow3IfRowIsLessThan6MoreThan2() {
        s.setValue(5, 0, 9);
        assertTrue(!s.isOk(3, 1, 9));
    }
    
    @Test
    public void isOkPicksSubGridFromRow6IfRowIsMoreThan5() {
        s.setValue(6, 0, 9);
        assertTrue(!s.isOk(7, 1, 9));
    }
    
    @Test
    public void isOkPicksSubGridFromColumn0IfColumnIsLessThan3() {
        s.setValue(0, 2, 9);
        assertTrue(!s.isOk(1, 1, 9));
    }
    
    @Test
    public void isOkPicksSubGridFromColumn3IfColumnIsLessThan6MoreThan2() {
        s.setValue(0, 5, 9);
        assertTrue(!s.isOk(1, 3, 9));
    }
    
    @Test
    public void isOkPicksSubGridFromColumn6IfColumnIsMoreThan5() {
        s.setValue(0, 6, 9);
        assertTrue(!s.isOk(1, 7, 9));
    }
}
