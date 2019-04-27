package sudoku.domain;


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
    public void constructorCreatesASudokuOfCorrectWidth() {
        assertTrue(s.getSudoku()[0].length == 9);
    }
    
    @Test
    public void constructorCreatesASudokuOfCorrectHeight() {
        assertTrue(s.getSudoku().length == 9);
    }
    
    @Test
    public void getValueReturnsAnAllowedValue() {
        assertTrue(s.getValue(0, 0) < 10 && s.getValue(0, 0) >= 0);
    }
    
    @Test
    public void setValueSetsTheValue() {
        s.setValue(1, 1, 9);
        assertTrue(s.getValue(1, 1) == 9);
    }
    
    @Test
    public void setValueReplacesTooSmallValuesWithOne() {
        s.setValue(0, 0, -1);
        assertTrue(s.getValue(0, 0) == 1);
    }
    
    @Test
    public void setValueReplacesTooBigValuesWithOne() {
        s.setValue(0, 0, 10);
        assertTrue(s.getValue(0, 0) == 1);
    }
    
    @Test
    public void setAndGetDifficultyWork() {
        s.setDifficulty(1);
        assertTrue(s.getDifficulty() == 1);
    }
    
    @Test
    public void emptySudokuFillsSudokuWithZeros() {
        s.emptySudoku();
        int zeros = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (s.getValue(i, j) == 0) {
                    zeros++;
                }
            }
        }
        
        assertTrue(zeros == 81);
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
    
    @Test
    public void checkSudokuReturnsFalseIfEmptyGrid() {
        assertTrue(!s.checkSudoku());
    }
    
    @Test
    public void checkSudokuReturnsTrueIfCorrectSudoku() {
        int[][] grid = new int[][]{
            {1,2,3,4,5,6,7,8,9},
            {4,5,6,7,8,9,1,2,3},
            {7,8,9,1,2,3,4,5,6},
            {2,3,4,5,6,7,8,9,1},
            {5,6,7,8,9,1,2,3,4},
            {8,9,1,2,3,4,5,6,7},
            {3,4,5,6,7,8,9,1,2},
            {6,7,8,9,1,2,3,4,5},
            {9,1,2,3,4,5,6,7,8}
            };
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                s.setValue(i, j, grid[i][j]);
            }
        }
        
        assertTrue(s.checkSudoku());
    }
    
    @Test
    public void replaceZeroReplacesTheRightAmount() {
        int[][] grid = new int[][]{
            {1,2,3,4,5,6,7,8,9},
            {4,5,6,7,8,9,1,2,3},
            {7,8,9,1,2,3,4,5,6},
            {2,3,4,5,6,7,8,9,1},
            {5,6,7,8,9,1,2,3,4},
            {8,9,1,2,3,4,5,6,7},
            {3,4,5,6,7,8,9,1,2},
            {6,7,8,9,1,2,3,4,5},
            {9,1,2,3,4,5,6,7,8}
            };
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                s.setValue(i, j, grid[i][j]);
            }
        }
        s.replaceValuesWithZero(40);
        int amount = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (s.getValue(i, j) == 0) {
                    amount++;
                }
            }
        }
        assertTrue(amount == 40);
    }
    
    @Test
    public void notInBoxReturnsTrueIfValueIsNotInSubGrid() {
        s.setValue(1, 1, 1);
        assertTrue(s.notInBox(0, 0, 2, 0, 0));
    }
    
    @Test
    public void notInBoxReturnsFalseIfValueIsInSubGrid() {
        s.setValue(1, 1, 1);
        assertTrue(!s.notInBox(0, 0, 1, 0, 0));
    }
    
    @Test
    public void fillRestOfGridFillsNonDiagonalSubgridsCorrectly() {
        s.fillRestOfGrid(0, 3);
        boolean works = true;
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i < 3 && j < 3) {
                    if (s.getValue(i, j) != 0) {
                        works = false;
                    }
                } else if (i < 3) {
                    if(!s.isOk(i, j, s.getValue(i, j))) {
                        works = false;
                    }
                } else if (i < 6 && j < 3) {
                    if(!s.isOk(i, j, s.getValue(i, j))) {
                        works = false;
                    }
                } else if (i < 6 && j < 6) {
                    if (s.getValue(i, j) != 0) {
                        works = false;
                    }
                } else if (i < 6) {
                    if(!s.isOk(i, j, s.getValue(i, j))) {
                        works = false;
                    }
                } else if (j < 6) {
                    if(!s.isOk(i, j, s.getValue(i, j))) {
                        works = false;
                    }
                } else {
                    if (s.getValue(i, j) != 0) {
                        works = false;
                    }
                }
            }
        }
        
        assertTrue(works);
    }
    
    @Test
    public void afterNewSudokuGridIsFilledCorrectly() {
        s.newSudoku();
        boolean correct = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (s.getValue(i, j) == 0) {
                    continue;
                } 
                if (!s.isOk(i, j, s.getValue(i, j))) {
                    correct = false;
                    break;
                }
            }
        }
        
        assertTrue(correct);
    }
}
