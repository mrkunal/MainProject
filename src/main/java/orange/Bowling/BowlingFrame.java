package orange.Bowling;

public class BowlingFrame {
     private int pins;
     private char value;

    public int getPins() {
        return pins;
    }

    public void setPins(int pins) {
        this.pins = pins;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public BowlingFrame(int pins, char value) {
        this.pins = pins;
        this.value = value;
    }
}
