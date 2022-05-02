package problems;

public class MarsRover {

    public static void main(String[] args) {

        Rover rover1 = new Rover();
        rover1.x = 1;
        rover1.y = 2;
        rover1.d = 'N';

        Rover rover2 = new Rover();
        rover2.x = 3;
        rover2.y = 3;
        rover2.d = 'E';

        char[] r1pos = {'L', 'M', 'L', 'M', 'L', 'M', 'L', 'M', 'M' };
        char[] r2pos = {'M', 'M', 'R', 'M', 'M', 'R', 'M', 'R', 'R', 'M' };


        for (int i = 0; i < r1pos.length; i++) {
           rover1.moveDirection(r1pos[i]);
        }

        for (int i = 0; i < r2pos.length; i++) {
            rover2.moveDirection(r2pos[i]);
        }

        System.out.println(rover1.x + " " + rover1.y + " " + rover1.d);
        System.out.println(rover2.x + " " + rover2.y + " " + rover2.d);
    }

}

class Rover {
    int x;
    int y;
    char d;

    static char[] directions = {'N', 'E', 'S', 'W' };

    @Override
    public String toString() {
        return "x :" + x + "y :" + y + "d :" + d;
    }

    public void moveDirection(char mov) {

        switch (mov) {
            case 'L':
                this.rotateLeft();
                break;
            case 'R':
                this.rotateRight();
                break;
            case 'M':
                this.moveRover();
                break;
        }
    }

    public void moveRover() {

        switch (this.d) {
            case 'N':
                this.y++;
                break;
            case 'E':
                this.x++;
                break;
            case 'S':
                this.y--;
                break;
            case 'W':
                this.x--;
                break;
        }
    }

    public void rotateRight() {

        int existingPosition = getDirectionIndex();
        this.d = directions[(existingPosition + 1) % directions.length];
    }

    public void rotateLeft() {
        int existingPosition = this.getDirectionIndex();
        this.d = directions[(existingPosition + directions.length - 1) % directions.length];
    }

    public int getDirectionIndex() {

        for (int i = 0; i < directions.length; i++) {
            if (this.d == directions[i]) {
                return i;
            }
        }
        return 0;
    }
}

