package problems;

import java.util.*;

class StringBalancedProblem {

    private static LinkedHashMap<Character, Character> pattern = new LinkedHashMap<>();

    static {
        pattern.put(')', '(');
        pattern.put(']', '[');
        pattern.put('}', '{');
    }

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

//        while (sc.hasNext()) {
//            String input=sc.next();
        String input = "[{A}";
        System.out.println(stringIsBalanced(input));

        //      }
    }

    private static boolean stringIsBalanced(String str) {
        Stack<Character> stk = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {

            if (!checkBalance(stk, str.charAt(i))) {
                return false;
            }
        }
        return stk.isEmpty();
    }

    private static boolean checkBalance(Stack stk, char c) {
        if (pattern.keySet().contains(c)) {
            if (stk.isEmpty()) {
                return false;
            }
            return stk.pop().equals(pattern.get(c));
        } else if (pattern.values().contains(c)) {
            stk.push(c);
            return true;
        }

        return true;
    }


}
