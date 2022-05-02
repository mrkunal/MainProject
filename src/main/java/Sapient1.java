/*
 **  Below formation is called Pascals Triangle.
 **
 **  Example:
 **               1
 **              1 1
 **             1 2 1
 **            1 3 3 1
 **           1 4 6 4 1
 **         1 5 10 10 5 1
 **        1 6 15 20 15 6 1
 **
 **  Complete the 'pascal' function below so that given a
 **  col and a row it will return the value in that positon.
 **
 **  Example, pascal(1,2) should return 2
 **
 */

import org.junit.Assert;

public class Sapient1 {


    public static int pascal(int c, int r) {
        if (c == r || c == 0) {
            return 1;
        }
        return pascal(c - 1, r - 1) + pascal(c , r-1);
    }
    public static void main(String[] args) {
        Assert.assertEquals(1,Sapient1.pascal(0, 0));
        Assert.assertEquals(2,Sapient1.pascal(1, 2));
        Assert.assertEquals(6,Sapient1.pascal(5, 6));
        Assert.assertEquals(70,Sapient1.pascal(4, 8));
        Assert.assertEquals(1,Sapient1.pascal(6, 6));
        System.out.println("all are passed");
    }
}
