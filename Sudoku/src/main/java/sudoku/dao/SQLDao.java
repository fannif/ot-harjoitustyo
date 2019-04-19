package sudoku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sudoku.domain.Score;

public interface SQLDao {
    
    /**
     * Method that creates the Scores-table into the database if it does not yet exist.
     * @throws SQLException if an error is faced when trying to connect to the database or carry out the SQL-statement.
     */
    public void createTable() throws SQLException;
    
    /**
     * Method adds a new score to the database.
     * @param score The Score-object's initials and time will be used for the new row to be added to the database.
     */
    public void create(Score score);
    
    /**
     * Method used to list the scores in the database, sorted by time in an ascending order.
     * @return Returns a list of the scores in the database sorted by column time in an ascending order.
     */
    public List<Score> list();
    
    /**
     * Method used to set path to the database. Used for testing the class.
     * @param database Path to the database to be used.
     */
    public void setDatabase(String database);
    
}
