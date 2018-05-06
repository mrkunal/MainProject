package problems;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class ThoughtWorksTwo {

    public static void main(String[] args) {


        Scanner records = new Scanner(System.in);
        String firstLine = records.nextLine();                 // Reading input from STDIN
        String secondLine = records.nextLine();
        String thirdLine = records.nextLine();

        StringBuilder b = new StringBuilder(thirdLine);
        StringBuilder a = new StringBuilder(secondLine);



        LinkedList<BigInteger> list = new LinkedList<>();

        String[] s= firstLine.split(" ");

        for(int i=0;i<Integer.parseInt(s[1]);i++)
        {
            int k=records.nextInt();
            b.setCharAt(k,'1');
             if(b.toString().compareTo(secondLine) > -1)
             {
                 System.out.println("YES");
             }else {
                 System.out.println("NO");
             }


        }



    }
}
