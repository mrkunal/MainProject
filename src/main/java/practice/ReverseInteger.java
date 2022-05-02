package practice;
/*

Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range
 [-231, 231 - 1], then return 0.
*/

import org.junit.platform.commons.util.StringUtils;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseInteger {

    public static void main(String[] args) {

        System.out.println(reverse(2147483647));  // 21 += 0*10^2 => 21
    }

    public static int reverse(int x) {

//        Integer.MAX_VALUE;

        boolean isNegative = x < 0;
        if (isNegative) {
            x *= -1;
        }
        String str = new String(new Integer(x).toString());
        StringBuilder stringBuilder = new StringBuilder(str);
        int value = 0;
        try {
            value = Integer.parseInt(stringBuilder.reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        if (isNegative)
            value *= -1;


        return value;

    }

}
