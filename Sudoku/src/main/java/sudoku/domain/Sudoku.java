
package sudoku.domain;

import java.util.Random;

public class Sudoku {
    
    private int[][] sudoku;
    
    /**
     * Initializes a new sudoku and fills in some numbers.
     * Constructor.
     */
    public Sudoku() {
        sudoku  = new int[9][9];
        newSudoku();
    }
    
    /**
     * Method creates a new sudoku.
     * First it fills the grid so that it is a solved sudoku.
     * Then it replaces some of the numbers with zeros.
     */
    public void newSudoku() {
        Random random = new Random();
        for (int i = 0; i < 9; i += 3) {
            int row = i;
            int column = i;
            int number;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    number = random.nextInt(9)+1;
                    while (!notInBox(row, column, number)) {
                        sudoku[row+j][column+k] = number;
                    }
                }
            }
        }
        
        fillRestOfGrid(0, 3);
        
        replaceValuesWithZero();
        
        
        
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(sudoku[i][j]);
//            }
//            System.out.println("");
//        }
    }
    
    /**
     * Method checks that the given number is not in the
     * 3 by 3 subgrid.
     * 
     * @param row The row from which the subgrid starts
     * @param column The column from which the subgrid starts
     * @param number We are checking if this number is in the subgrid already
     * @return Tells whether the given number was in the subgrid already
     */
    public boolean notInBox(int row, int column, int number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[row+i][column+j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkSudoku() {
        
        return true;
    }
    
    public boolean fillRestOfGrid(int i, int j) {
            
        return false;
    }
    
    public boolean isOk(int i, int j, int number) {
        return false;
    }
    
    public void replaceValuesWithZero() {
        
    }
    
    /**
     * Method sets the given number in the given coordinates to the sudoku.
     * @param x The row to which the number is put
     * @param y The column to which the number is put
     * @param value  The number that is put into the sudoku
     */
    public void setValue(int x, int y, int value) {
        sudoku[x][y] = value;
    }
    
    /**
     * Method returns the value that is in the given coordinates of the sudoku.
     * @param x The row from which the number is returned
     * @param y The column from which the number is returned
     * @return The value in the given coordinates of the sudoku
     */
    public int getValue(int x, int y) {
        return sudoku[x][y];
    }
    
    /**
     * Method returns the current sudoku
     * @return Returns current sudoku grid
     */
    public int[][] getSudoku() {
        return this.sudoku;
    }
    
}
