
package sudoku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sudoku.domain.Score;

public class EasyScoreDao implements SQLDao {
    
    private String database;
    
    /**
     * Constructor method. Creates a table if it doesn't exist to avoid errors.
     * @throws SQLException if an error emerges while connecting to the database or carrying out an SQL-statement.
     */
    public EasyScoreDao() throws SQLException {
        this.database = "jdbc:sqlite:./scores.db";
        createTable();
    }
    
    /**
     * Method creates the EasyScores-table if it does not yet exist in the database.
     * @throws SQLException if an error is faced when trying to connect to the database or carry out the SQL-statement.
     */
    @Override
    public void createTable() throws SQLException {
        Connection connection = DriverManager.getConnection(this.database);
        
        PreparedStatement stmt = connection.prepareStatement(""
                + "CREATE TABLE IF NOT EXISTS EasyScores"
                + " (id SERIAL,"
                + " initials VARCHAR(3),"
                + " time BIGINT)");
        
        stmt.executeUpdate();
        stmt.close();
        
        connection.close();
    }
    
    /**
     * Method adds a new score to the database table EasyScores.
     * @param score The Score-object's initials and time will be added to the new row to be added to the database.
     */
    @Override
    public void create(Score score) {
        try {
            Connection connection = DriverManager.getConnection(this.database);
        
            PreparedStatement stmt = connection.prepareStatement(
                  "INSERT INTO EasyScores (initials, time)"
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
    @Override
    public List<Score> list() {
        List<Score> scores = new ArrayList<>();
        
        try {
            Connection connection = DriverManager.getConnection(this.database);
        
            PreparedStatement stmt = connection.prepareStatement(
                  "SELECT * FROM EasyScores"
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
    
    /**
     * Method used to set path to the database. Used for testing the class.
     * @param database Path to the database to be used.
     */
    @Override
    public void setDatabase(String database) {
        this.database = database;
    }
    
}
