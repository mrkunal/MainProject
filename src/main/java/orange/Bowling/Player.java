package orange.Bowling;

import java.util.ArrayList;

public class Player {

    private String name;
    private Integer score;
    private ArrayList<BowlingFrame> bowlingFrameArrayList;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public ArrayList<BowlingFrame> getBowlingFrameArrayList() {
        return bowlingFrameArrayList;
    }

    public void setBowlingFrameArrayList(ArrayList<BowlingFrame> bowlingFrameArrayList) {
        this.bowlingFrameArrayList = bowlingFrameArrayList;
    }
}
