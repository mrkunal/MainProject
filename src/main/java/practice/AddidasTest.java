/*
package practice;

import java.util.ArrayList;
import java.util.Stack;

public class AddidasTest {


    static class BinaryTreeTest {

        int value;
        BinaryTreeTest left;
        BinaryTreeTest right;


    }


    private static ArrayList<BinaryTreeStack> list = new ArrayList<>();
    private static Integer counter = 0;

    static class BinaryTreeStack {
        int level;
        BinaryTreeTest binaryTreeTest;

        public BinaryTreeStack(BinaryTreeTest binaryTreeTest, int level) {
            this.level = level;
            this.binaryTreeTest = binaryTreeTest;
        }
    }

    public static void main(String[] args) {


        BinaryTreeTest head = new BinaryTreeTest();

        createStack(head, 1);


    }

            ->1
                    -->2,->3
                    --->4,7->9

    static void createStack(BinaryTreeTest binaryTreeTest, int level) {
        if (binaryTreeTest == null)
            return;

        list.add(new BinaryTreeStack(binaryTreeTest, level));

        if (binaryTreeTest.left != null)
            createStack(binaryTreeTest.left, level + 1);

        if (binaryTreeTest.right != null)
            createStack(binaryTreeTest.right, level + 1);

        ///

        BinaryTreeTest node = binaryTreeTest;

        ArrayList<BinaryTreeStack> list2 = new ArrayList();

        level=1;
        while (node != null) {

            list.add(new BinaryTreeStack(binaryTreeTest, level));

            level++;
            if (binaryTreeTest.left != null) {
                list.add(new BinaryTreeStack(binaryTreeTest, level));
                list2.add(new BinaryTreeStack(binaryTreeTest.left, ++level));
            }
            if (binaryTreeTest.right != null) {
                list.add(new BinaryTreeStack(binaryTreeTest, level));
                list2.add(new BinaryTreeStack(binaryTreeTest.right, ++level));
            }

            if (!list2.isEmpty())
                node = list2.get(0).binaryTreeTest;

        }

    }


    static void printLevelOrderTraversal() {
        Integer level = 1;

        list.forEach(i -> {
            if (level == i.level)
                System.out.print(" : " + i.binaryTreeTest.value);
            else if (level != i.level) {

                System.out.println(" : " + i.binaryTreeTest.value);
                level++;
            }
        });

    }

}
*/
