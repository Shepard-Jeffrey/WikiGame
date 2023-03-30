import java.util.Map;
import java.util.HashMap;

public class Challenge {
    String StartingPoint;
    String EndingPoint;
    int DifficultyLevel;
    Map<String, String> PlayerScores = new HashMap<String,String>();

    public int getDifficultyLevel() {
        return DifficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        DifficultyLevel = difficultyLevel;
    }

    public String getEndingPoint() {
        return EndingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        EndingPoint = endingPoint;
    }

    public String getStartingPoint() {
        return StartingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        StartingPoint = startingPoint;
    }
}
