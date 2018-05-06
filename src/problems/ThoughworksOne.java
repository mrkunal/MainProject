package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ThoughworksOne {

    static ArrayList<BigInteger> series = new ArrayList<>();
    static   BigInteger maxSeriesNum=new BigInteger("3");
    static  BigInteger minSeriesNum=new BigInteger("0");
    static  BigInteger oneSeriesNum=new BigInteger("1");


    public static void main(String args[] ) throws Exception {
        Scanner records = new Scanner(System.in);
        int inputs = records.nextInt();                 // Reading input from STDIN
        LinkedList<BigInteger> list = new LinkedList<>();

        series.add(new BigInteger("0"));
        series.add(new BigInteger("1"));
        series.add(new BigInteger("2"));
        series.add(new BigInteger("3"));

        for (int i = 0; i < inputs; i++) {
            BigInteger k = records.nextBigInteger();
            list.add(k);
        }

        for (BigInteger num : list) {

            System.out.println(getStringVal(num).length());
        }
    }

    static String getStringVal(BigInteger num){


        if(num.compareTo(maxSeriesNum)<0)
        {
            return ""+series.get(num.intValue());
        }else {
            BigInteger divisor =  num.divide(maxSeriesNum);
            BigInteger remainder = num.mod(maxSeriesNum);

            if(remainder.compareTo(minSeriesNum)==0)
            {   divisor.subtract(oneSeriesNum);
                remainder=new BigInteger("3");
            }
            String val=getStringVal(divisor);
            return val+series.get(remainder.intValue());

        }
    }



}
