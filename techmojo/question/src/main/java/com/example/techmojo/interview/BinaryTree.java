package com.example.techmojo.interview;

class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;
        public Integer height;

        public TreeNode() {}

        public TreeNode(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
                height = null;
        }
}


public class BinaryTree {
        public int getHeignt(TreeNode root) {
                if (root == null) {
                        return 0;
                } else if(root.left == null && root.right == null) {
                        return 1;
                } else if (root.height == null) {
                        int leftHeight = getHeignt(root.left);
                        int rightHeight = getHeignt(root.right);
                        root.height = Math.max(leftHeight, rightHeight) + 1;
                } 
                return root.height;
        }

        public int getDiameter(TreeNode root) {
                if(root == null || (root.left == null && root.right == null)) {
                        return 0;
                }
                else {
                        int leftDiameter = getDiameter(root.left);
                        int rightDiameter = getDiameter(root.right);
                        int leftHeight = getHeignt(root.left);
                        int rightHeight = getHeignt(root.right);

                        return Math.max(Math.max(leftDiameter, rightDiameter), (leftHeight + rightHeight + 1)); 
                }
        }
}
