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
import sudoku.dao.EasyScoreDao;
import sudoku.dao.SQLDao;
import sudoku.domain.Score;

public class EasyScoreDaoTest {
    
    private SQLDao easy;
    
    @Before
    public void setUp() throws Exception {
        easy = new EasyScoreDao();
        easy.setDatabase("jdbc:sqlite:./testDB.db");
        easy.createTable();
    }
    
    @After
    public void tearDown() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./testDB.db");
            PreparedStatement stmt = connection.prepareStatement("DROP TABLE IF EXISTS EasyScores");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void listReturnsAList() {
        boolean works = easy.list() instanceof List;
        assertTrue(works);
    }
    
    @Test
    public void createAddsARowToTheDatabase() {
        int start = easy.list().size();
        easy.create(new Score(0, "aaa", 100));
        int end = easy.list().size();
        assertTrue(end == start + 1);
    }
    
}
