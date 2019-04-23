
package sudoku.domain;

import java.util.Arrays;
import java.util.Random;

/**
 * Class represents and maintains a sudoku.
 */
public class Sudoku {

    private int[][] grid;
    private int difficulty;

    /**
     * Initializes a new sudoku-grid with all zeros.
     * Constructor.
     */
    public Sudoku() {
        grid  = new int[9][9];
        difficulty = 50;
    }

    /**
     * Method creates a new sudoku.
     * First it empties and then fills the grid so that it is a solved sudoku.
     * Starts by filling it diagonally.
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
                    while (!notInBox(row, column, number, row + j, column + k)) { 
                        number = random.nextInt(9) + 1;
                    }
                    grid[row + j][column + k] = number;
                }
            }
        }

        fillRestOfGrid(0, 3);

        replaceValuesWithZero(this.difficulty);

    }

    /**
     * Method checks that the given number is not in the
     * 3 by 3 sub-grid.
     *
     * @param row The row from which the sub-grid starts
     * @param column The column from which the sub-grid starts
     * @param number We are checking if this number is in the sub-grid already
     * @param skipRow The row to for the number
     * @param skipColumn The column for the number
     * @return Tells whether the given number was in the sub-grid already
     */
    public boolean notInBox(int row, int column, int number, int skipRow, int skipColumn) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (row + i == skipRow && column + j == skipColumn) {
                    continue;
                }
                if (number == grid[row + i][column + j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Method checks if the numbers in the filled sudoku
     * break the rules of the game or not. (No same number in the
     * same row, column or sub-grid.)
     *      * 
     * @return Returns true if the sudoku is filled correctly.
     * Otherwise returns false.
     */
    public boolean checkSudoku() {
        boolean checkResult = true;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (!isOk(row, column, grid[row][column])) {
                    checkResult = false;
                }
            }
        }
        
        return checkResult;
    }

    /**
     * Method fills the remaining squares of a grid
     * whose diagonal (from top right to bottom left) sub-grids have been filled.
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

        if (row < 3 && column < 3) {
            column = 3;
        } else if (row > 2 && row < 6 && column == 3) {
            column += 3;
        } else {
            // If column == 6 we will be in the last box
            // which is one of the diagonals, so skip to
            // next row, because we don't wanna touch it
            if (column == 6 && row > 5) {
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
        
        if (!okRow(row, column, number)) {
            return false;
        } else if (!okColumn(row, column, number)) {
            return false;
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
        
        return notInBox(rowStart, columnStart, number, row, column);
    }
    
    /**
     * Method checks that the given number is not yet in the given row.
     * @param row The row for the number given.
     * @param column The column for the number given.
     * @param number The number to check from the row.
     * @return Return true if the number is not yet in the row. Otherwise return false;
     */
    public boolean okRow(int row, int column, int number) {
        for (int i = 0; i < 9; i++) {
            if (i == column) {
                continue;
            }
            if (grid[row][i] == number) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Method checks that the given number is not yet in the given row.
     * @param row The row in which the number might be put.
     * @param column The column in which the number might be put.
     * @param number The number to check from the column.
     * @return Return true if the number is not yet in the column. Otherwise return false;
     */
    public boolean okColumn(int row, int column, int number) {
        for (int i = 0; i < 9; i++) {
            if (i == row) {
                continue;
            }
            if (grid[i][column] == number) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Method replaces some of the numbers in the grid with
     * the number zero. These zeros represent the empty squares
     * for the player to fill. The number of squares to be set to
     * zero equal to the value of the integer empty.
     * @param zeros The amount of numbers to be switched to zeros.
     */
    public void replaceValuesWithZero(int zeros) {

        int empty = zeros;
        Random square = new Random();

        while (empty > 0) {
            int squareNumber = square.nextInt(81);
            int row = squareNumber / 9;
            int column = squareNumber % 9;

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
     * The given number needs to be from 1 to 9 or else it is interpreted as 1.
     * @param x The row to which the number is put
     * @param y The column to which the number is put
     * @param value  The number that is put into the sudoku
     */
    public void setValue(int x, int y, int value) {
        if (value > 9 || value < 1) {
            grid[x][y] = 1;
            return;
        }
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
     * Sets the number of spaces to be left blank at first.
     * @param difficulty The number of spaces to be blank at first.
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    
    /**
     * Returns the number of spaces to be blank in an unfilled grid.
     * @return The number of blank spaces in unfilled grid.
     */
    public int getDifficulty() {
        return this.difficulty;
    }

    /**
     * Method returns the current sudoku.
     * Used for testing the constructor.
     * @return Returns current sudoku grid
     */
    public int[][] getSudoku() {
        return this.grid;
    }

}
