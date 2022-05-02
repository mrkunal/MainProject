package problems;

public class InterleavedString {

    public static void main(String[] args) {

        System.out.println(isInterLeave("YX", "X", "XXY"));
        System.out.println(isInterLeave("YXXYXX", "YYYXX", "YXXYYXXXXYX"));
    }

    public static boolean isInterLeave(String a, String b, String c) {

        int pointerA = 0;
        int pointerB = 0;

        for (int i = 0; i < c.length(); i++) {
            if (pointerA < a.length()) {
                if (c.charAt(i) == a.charAt(pointerA)) {
                    pointerA++;
                }
            }
            if (pointerB < b.length()) {
                if (c.charAt(i) == b.charAt(pointerB)) {
                    pointerB++;
                }
            }

        }
        if (pointerA < a.length() || pointerB < b.length()) {
            return false;
        }

        return true;

    }
}
