package sudoku.domain;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import sudoku.domain.Score;

public class ScoreTest {
    
    public ScoreTest() {
    }
    
    Score s;
    
    @Before
    public void setUp() {
        s = new Score(0, "txt", 1000);
    }
    
    @Test
    public void constructorSetsCorrectId() {
        assertTrue(s.getId() == 0);
    }
    
    @Test
    public void constructorSetsCorrectInitials() {
        assertTrue(s.getInitials().equals("txt"));
    }
    
    @Test
    public void constructorSetsCorrectTime() {
        assertTrue(s.getTime() == 1000);
    }
    
    @Test
    public void toStringReturnsTextInCorrectForm() {
        String value = s.toString();
        String expected = "txt: 1 sekuntia";
        assertEquals(value, expected);
    }
}
