package orange.Bowling;

import java.util.ArrayList;

public class BowlingGameApplication {


    public static void main(String[] args) {

        Player player1=new Player("Kunal Kumar");

        String firstPlayerRolls="X X X X X X X X X X X X";

        String[] rolls = firstPlayerRolls.split(" ");

        ArrayList<BowlingFrame> frames=new ArrayList<>();



    }

    Player gameStart(Player player,String rolls){

        String[] playerRolls=rolls.split(" ");

        int score=0;

        int frameScore=0;

        for(int i=0;i<playerRolls.length;i++){

            if(Character.isDigit(playerRolls[i].charAt(0)))
            {
                 frameScore +=Integer.parseInt(playerRolls[i]);
            }


        }


        return null;
    }
}
