package practice;

import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversalBinaryTree {

    class BinaryTree {
        BinaryTree left;
        BinaryTree right;
        int value;

        public BinaryTree(BinaryTree left, BinaryTree right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }


    public static void main(String[] args) {

        LevelOrderTraversalBinaryTree obj = new LevelOrderTraversalBinaryTree();
        BinaryTree binaryTree = obj.validBinaryTree();

        System.out.println("Level order traversal");
        obj.displayLevelOrderTraversal(binaryTree);


        System.out.println("The tree is not valid Binary tree :"+obj.isBinaryTreeValid(obj.invalidBinaryTree()));
        System.out.println("The tree is valid Binary tree :"+obj.isBinaryTreeValid(obj.validBinaryTree()));
    }


    void displayLevelOrderTraversal(BinaryTree binaryTree) {

        LinkedList<BinaryTree> list = new LinkedList<>();
        BinaryTree node = binaryTree;
        list.add(node);
        while (!list.isEmpty()) {
            BinaryTree elem = list.removeFirst();
            System.out.println(elem.value);
            if (elem.left != null)
                list.add(elem.left);
            if (elem.right != null)
                list.add(elem.right);
        }

    }

    boolean isBinaryTreeValid(BinaryTree binaryTree) {
        return isValid(binaryTree, null, null);
    }

    boolean isValid(BinaryTree binaryTree, Integer min, Integer max) {
        boolean minresult = true;
        boolean maxresult = true;

        if (min != null)
            minresult = binaryTree.value > min ? true : false;

        if (max != null)
            maxresult = binaryTree.value < max ? true : false;
        boolean val=true,val2=true;
        if (binaryTree.left != null)
             val = isValid(binaryTree.left, min, binaryTree.value);
        if (binaryTree.right != null)
             val2 = isValid(binaryTree.right, binaryTree.value, max);

        return maxresult && minresult && val && val2;
    }

    BinaryTree validBinaryTree() {
        BinaryTree node25 = new BinaryTree(null, null, 25);
        BinaryTree node75 = new BinaryTree(null, null, 75);
        BinaryTree node50 = new BinaryTree(node25, node75, 50);
        BinaryTree node350 = new BinaryTree(null, null, 350);
        BinaryTree node200 = new BinaryTree(null, node350, 200);

        BinaryTree node100 = new BinaryTree(node50, node200, 100);
        return node100;
    }


    BinaryTree invalidBinaryTree() {
        BinaryTree node25 = new BinaryTree(null, null, 25);
        BinaryTree node75 = new BinaryTree(null, null, 75);
        BinaryTree node50 = new BinaryTree(node25, node75, 50);
        BinaryTree node350 = new BinaryTree(null, null, 350);
        BinaryTree node90 = new BinaryTree(null, null, 90);
        BinaryTree node200 = new BinaryTree(node90, node350, 200);

        BinaryTree node100 = new BinaryTree(node50, node200, 100);
        return node100;
    }
}
