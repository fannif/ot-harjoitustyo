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
    
    public SQLDao() throws SQLException {
        createTable();
    }
    
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
    
    public void create(Score score) throws SQLException {
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
    }
    
    public List<Score> list() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:./scores.db");
        
        PreparedStatement stmt = connection.prepareStatement(
              "SELECT * FROM Scores"
              + " ORDER BY time DESC"
        );
        
        ResultSet rs = stmt.executeQuery();
        
        List<Score> scores = new ArrayList<>();
        
        while (rs.next()) {
            scores.add(new Score(rs.getInt("id"), rs.getString("initials"), rs.getLong("time")));
        }
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();
        
        return scores;
    }
    
}
