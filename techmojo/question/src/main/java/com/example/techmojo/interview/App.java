package com.example.techmojo.interview;

/**
 * Hello world!
 *
 *             5
 *       4         3
 *    2     6
 *  1          7
 *               8
 * 
 * 1,2,4,6,7,8
 * 
 */              
public class App 
{
    public static void main( String[] args )
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(1);
        root.left.right.right = new TreeNode(7);
        root.left.right.right.right = new TreeNode(8);

        //System.out.println("Height = " + new BinaryTree().getHeignt(root));
        System.out.println("Diameter = " + new BinaryTree().getDiameter(root));
    }
}
