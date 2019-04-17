
package sudoku.domain;

public class Score {
    
    private int id;
    private String initials;
    private long time;

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
        return this.getInitials() + ": " + (this.getTime()/1000) + " sekuntia";
    }
    
}
