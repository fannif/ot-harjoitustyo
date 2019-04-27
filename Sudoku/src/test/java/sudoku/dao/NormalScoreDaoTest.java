package sudoku.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import sudoku.dao.NormalScoreDao;
import sudoku.dao.SQLDao;
import sudoku.domain.Score;

public class NormalScoreDaoTest {
    
    private SQLDao normal;
    
    @Before
    public void setUp() throws Exception {
        normal = new NormalScoreDao();
        normal.setDatabase("jdbc:sqlite:./testDB.db");
        normal.createTable();
    }
    
    @After
    public void tearDown() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./testDB.db");
            PreparedStatement stmt = connection.prepareStatement("DROP TABLE IF EXISTS NormalScores");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void listReturnsAList() {
        boolean works = normal.list() instanceof List;
        assertTrue(works);
    }
    
    @Test
    public void createAddsARowToTheDatabase() {
        int start = normal.list().size();
        normal.create(new Score(0, "aaa", 100));
        int end = normal.list().size();
        assertTrue(end == start + 1);
    }
    
}