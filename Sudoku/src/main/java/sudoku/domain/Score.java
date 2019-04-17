
package sudoku.domain;

public class Score {
    
    private int id;
    private String initials;
    private long time;

    /**
     * Method is a constructor.
     * It sets the initial id, initials and time variables of the score.
     * @param id Unique number used to identify scores. When creating a score and adding it to the database, 
     * this value doesn't matter, because the database will generate the final id.
     * @param initials The 1 - 3 characters long name or initials of the user who got the score.
     * @param time The time it took the user to finish their sudoku.
     */
    public Score(int id, String initials, long time) {
        this.id = id;
        this.initials = initials;
        this.time = time;
    }

    public String getInitials() {
        return initials;
    }

    public long getTime() {
        return time;
    }
    
    @Override
    public String toString() {
        return this.getInitials() + ": " + (this.getTime() / 1000) + " sekuntia";
    }
    
}
