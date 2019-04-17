package sudoku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sudoku.domain.Score;

public class SQLDao {
    
    /**
     * Constructor method. Calls createTable to create a table if the database is empty to avoid errors.
     * @throws SQLException if an error emerges while connecting to the database or carrying out an SQL-statement.
     */
    public SQLDao() throws SQLException {
        createTable();
    }
    
    /**
     * Method that creates the Scores-table into the database if it does not yet exist.
     * @throws SQLException if an error is faced when trying to connect to the database or carry out the SQL-statement.
     */
    public void createTable() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:./scores.db");
        
        PreparedStatement stmt = connection.prepareStatement(""
                + "CREATE TABLE IF NOT EXISTS Scores"
                + " (id SERIAL,"
                + " initials VARCHAR(3),"
                + " time BIGINT)");
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
    
    /**
     * Method adds a new score to the database.
     * @param score The Score-object's initials and time will be used for the new row to be added to the database.
     */
    public void create(Score score) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./scores.db");
        
            PreparedStatement stmt = connection.prepareStatement(
                  "INSERT INTO Scores (initials, time)"
                  + " VALUES (?, ?)"
            );
            stmt.setString(1, score.getInitials());
            stmt.setLong(2, score.getTime());
        
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Method used to list the scores in the database, sorted by time in an ascending order.
     * @return Returns a list of the scores in the database sorted by column time in an ascending order.
     */
    public List<Score> list() {
        List<Score> scores = new ArrayList<>();
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./scores.db");
        
            PreparedStatement stmt = connection.prepareStatement(
                  "SELECT * FROM Scores"
                  + " ORDER BY time ASC;"
            );
        
            ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {
                scores.add(new Score(rs.getInt("id"), rs.getString("initials"), rs.getLong("time")));
            }
        
            stmt.close();
            connection.close();
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return scores;
    }
    
}
