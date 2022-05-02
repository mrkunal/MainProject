package com.ttn.collection.tree;

public class BstTree {

    public static void main(String[] args) {

        TreeNode t = createSampleBinaryTree();
        inOrderTranversal(t);
        System.out.println("");
        preOrderTranversal(t);
        System.out.println("");
        postOrderTranversal(t);
        System.out.println("Left View");
        leftView(t,0,0);
        System.out.println("Right View");
        rightView(t,0,0);

    }

    static TreeNode add(int value, TreeNode node) {
        if (node == null) {
            TreeNode treeNode = new TreeNode();
            treeNode.value = value;
            node = treeNode;
            System.out.println("Inserted Value at ROOT :" + value);
            return node;
        } else {
            if (node.value > value) {
                if (node.leftNode == null) {
                    TreeNode treeNode = new TreeNode();
                    treeNode.value = value;
                    node.leftNode = treeNode;
                    System.out.println("Inserted Value at LEFT :" + value);

                    return node;
                } else {
                    add(value, node.leftNode);
                }
            } else {
                if (node.rightNode == null) {

                    TreeNode treeNode = new TreeNode();
                    treeNode.value = value;
                    node.rightNode = treeNode;
                    System.out.println("Inserted Value at right :" + value);

                    return node;
                } else {
                    add(value, node.rightNode);
                }

            }
        }
        return null;
    }


    static TreeNode createSampleBinaryTree() {

        TreeNode treeNode = null;
      /*  treeNode = add(20, treeNode);
        add(30, treeNode);
        add(10, treeNode);
        add(5, treeNode);
        add(15, treeNode);
        add(25, treeNode);
        add(35, treeNode);*/
        treeNode = add(4, treeNode);
        add(5, treeNode);
        add(2, treeNode);
        add(3, treeNode);
        add(1, treeNode);
        add(6, treeNode);
        add(7, treeNode);
      return treeNode;
    }

    static void inOrderTranversal(TreeNode treeNode) {
        if (treeNode != null) {
            if (treeNode.leftNode != null) {
                inOrderTranversal(treeNode.leftNode);
            }

            System.out.print(" :: " + treeNode.value);

            if (treeNode.rightNode != null) {
                inOrderTranversal(treeNode.rightNode);
            }

        }
    }

    static void preOrderTranversal(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(" :: " + treeNode.value);

            if (treeNode.leftNode != null) {
                preOrderTranversal(treeNode.leftNode);
            }

            if (treeNode.rightNode != null) {
                preOrderTranversal(treeNode.rightNode);
            }
        }
    }

    static void postOrderTranversal(TreeNode treeNode) {
        if (treeNode != null) {
            if (treeNode.leftNode != null) {
                postOrderTranversal(treeNode.leftNode);
            }

            if (treeNode.rightNode != null) {
                postOrderTranversal(treeNode.rightNode);
            }

            System.out.print(" :: " + treeNode.value);

        }
    }

    static int leftView(TreeNode treeNode,int result,int level)
    {
        if(treeNode==null)
        {
            return result;
        }

        if(level==result)
        {
            System.out.println(" :"+treeNode.value);
            result++;
        }
        result= leftView(treeNode.leftNode,result,level+1);
        leftView(treeNode.rightNode,result,level+1);

       return result;
    }



    static int rightView(TreeNode treeNode,int result,int level)
    {
        if(treeNode==null)
        {
            return result;
        }

        if(level==result)
        {
            System.out.print( " :" +treeNode.value);
            result++;
        }
        result= rightView(treeNode.rightNode,result,level+1);
        rightView(treeNode.leftNode,result,level+1);

        return result;
    }




}
