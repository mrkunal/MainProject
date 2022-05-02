package problems;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LongestValidParenthesis {


    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        while (n != 0) {
            String s=scanner.nextLine();
            System.out.println(checkExpression(s));
            n--;
        }
        String exp1 = "((()";
        //

        String exp2 = ")()())";
        String exp3 = "()(()))))";
//        System.out.println(checkExpression(exp2));
        //   System.out.println(checkExpression(exp3));


    }


    static Boolean evalCharacter(Character c) {
        if (c.equals('(' )) {
            stack.push('(' );
            return null;
        } else if (c.equals(')' )) {
            if (!stack.isEmpty()) {
                if (stack.peek().equals('(' )) {
                    stack.pop();
                    return true;
                } else {
                    stack.clear();
                    return false;
                }
            } else {
                stack.clear();
                return false;
            }
        }
        return null;
    }

    static int checkExpression(String s) {
        stack.clear();
        int max = 0;
        int t = 0;

        for (Character c : s.toCharArray()) {
            Boolean result = evalCharacter(c);

            if (result != null) {
                if (result.equals(true)) {
                    t += 2;
                    if (t > max) {
                        max = t;
                    }
                } else {
                    if (t > 0) {
                        t = 0;
                    }
                }
            }
        }
        return max;
    }

}
