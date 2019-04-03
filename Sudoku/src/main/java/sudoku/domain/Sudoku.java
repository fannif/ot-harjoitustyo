
package sudoku.domain;

import java.util.Arrays;
import java.util.Random;

/**
 * Class represents a sudoku.
 * @author f
 */
public class Sudoku {

    private int[][] grid;

    /**
     * Initializes a new sudoku-grid and fills in some numbers.
     * Constructor.
     */
    public Sudoku() {
        grid  = new int[9][9];
//        newSudoku();
    }

    /**
     * Method creates a new sudoku.
     * First it fills the grid so that it is a solved sudoku.
     * Then it replaces some of the numbers with zeros.
     */
    public void newSudoku() {

        emptySudoku();

        Random random = new Random();
        for (int i = 0; i < 9; i += 3) {
            int row = i;
            int column = i;
            int number = 1;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    while (!notInBox(row, column, number)) { 
                        number = random.nextInt(9) + 1;
                    }
                    grid[row + j][column + k] = number;
                }
            }
        }

        fillRestOfGrid(0, 3);

        replaceValuesWithZero();



//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(grid[i][j]);
//            }
//            System.out.println("");
//        }
    }

    /**
     * Method checks that the given number is not in the
     * 3 by 3 sub-grid.
     *
     * @param row The row from which the sub-grid starts
     * @param column The column from which the sub-grid starts
     * @param number We are checking if this number is in the sub-grid already
     * @return Tells whether the given number was in the sub-grid already
     */
    public boolean notInBox(int row, int column, int number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (number == grid[row + i][column + j]) {
                    return false;
                }
            }
        }
        return true;
    }

//    public boolean checkSudoku() {
//
//        return true;
//    }

    /**
     * Method fills the remaining squares of a grid
     * whose diagonal boxes have been filled.
     * @param row The row that is currently being looked at.
     * @param column The column that is currently being looked at.
     * @return Returns true if the grid was filled.
     */
    public boolean fillRestOfGrid(int row, int column) {

        if (column >= 9 && row < 8) {
            row++;
            column = 0;
        }

        if (column >= 9 && row >= 9) {
            return true;
        }

        if (row < 3) {
            if (column < 3) {
                column = 3;
            }
        } else if (row < 6) {
            if (column == (int) (row / 3) * 3) {
                column += 3;
            }
        } else {
            if (column == 6) {
                row++;
                column = 0;
                if (row >= 9) {
                    return true;
                }
            }
        }

        for (int number = 1; number <= 9; number++) {
            if (isOk(row, column, number)) {
                grid[row][column] = number;
                if (fillRestOfGrid(row, column + 1)) {
                    return true;
                }
                grid[row][column] = 0;
            }
        }

        return false;
    }

    /**
     * Method checks whether the given number can be put
     * into the given coordinates. In other words, checks
     * that the number is not yet in the given row or column
     * or 3x3 sub-grid.
     * @param row The row in which the given number is.
     * @param column The column of the grid in which the number is.
     * @param number The number being tested to see if it can be put to given coordinates.
     * @return Returns true if the given number is not yet in the row, column or sub-grid. Otherwise, returns false.
     */
    public boolean isOk(int row, int column, int number) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == number) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (grid[i][column] == number) {
                return false;
            }
        }

        int rowStart = 0;

        if (row > 5) {
            rowStart = 6;
        }  else if (row > 2) {
            rowStart = 3;
        }

        int columnStart = 0;

        if (column > 5) {
            columnStart = 6;
        } else if (column > 2) {
            columnStart = 3;
        }

        for (int r = rowStart; r < rowStart + 3; r++) {
            for (int s = columnStart; s < columnStart + 3; s++) {
                if (grid[r][s] == number) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Method replaces some of the numbers in the grid with
     * the number zero. These zeros represent the empty squares
     * for the player to fill. The number of squares to be set to
     * zero equal to the value of the integer empty.
     */
    public void replaceValuesWithZero() {

        int empty = 45;
        Random square = new Random();

        while (empty > 0) {
            int squareNumber = square.nextInt(81);
            int row = squareNumber / 9;
            int column = squareNumber % 9;

            if (column != 0) {
                column--;
            }

            if (grid[row][column] == 0) {
                continue;
            }

            grid[row][column] = 0;
            empty--;
        }

    }

    /**
     * Method fills the grid with all zeros.
     */
    public void emptySudoku() {
        for (int i = 0; i < 9; i++) {
            Arrays.fill(grid[i], 0);
        }        
    }

    /**
     * Method sets the given number in the given coordinates to the sudoku.
     * @param x The row to which the number is put
     * @param y The column to which the number is put
     * @param value  The number that is put into the sudoku
     */
    public void setValue(int x, int y, int value) {
        grid[x][y] = value;
    }

    /**
     * Method returns the value that is in the given coordinates of the sudoku.
     * @param x The row from which the number is returned
     * @param y The column from which the number is returned
     * @return The value in the given coordinates of the sudoku
     */
    public int getValue(int x, int y) {
        return grid[x][y];
    }

    /**
     * Method returns the current sudoku.
     * @return Returns current sudoku grid
     */
    public int[][] getSudoku() {
        return this.grid;
    }

}
