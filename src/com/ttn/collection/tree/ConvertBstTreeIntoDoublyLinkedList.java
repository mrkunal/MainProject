package com.ttn.collection.tree;

/**
 * Created by kunal on 27/8/17.
 */
public class ConvertBstTreeIntoDoublyLinkedList {

    public static void main(String[] args) {

        TreeNode treeNode = BstTree.createSampleBinaryTree();
    }

    static DoublyLLNode convertBstTreeIntoDLL(TreeNode treeNode, DoublyLLNode doublyLLNode) {
        if (treeNode != null) {

            if (treeNode.leftNode != null) {
                convertBstTreeIntoDLL(treeNode.leftNode,doublyLLNode);
            }
            doublyLLNode=new DoublyLLNode();
            doublyLLNode.value=treeNode.value;
            doublyLLNode.prevNode=doublyLLNode.prevNode;
            System.out.print(" :: " + treeNode.value);


            if (treeNode.rightNode != null) {
                //convertBstTreeIntoDLL(treeNode.rightNode);
            }

        }

        return doublyLLNode;
    }

}
