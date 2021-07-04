package io.lcalmsky.coupang.problem2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution2 {
    private int count = 0;

    public static void main(String[] args) {
        new Solution2().solution(new int[]{-1, 0, 0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8, 9, 10, 10, 11, 11}, 6, 9);
        new Solution2().solution(new int[]{-1, 0, 0, 1, 2, 2, 3, 3, 4, 5, 5}, 6, 9);
    }

    public int solution(int[] matches, int me, int opposite) {
        TreeNode root = new TreeNode(matches[0]);
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> integerQueue = new LinkedList<>();
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 1; i < matches.length; i++) {
            int number = matches[i];
            integerMap.put(number, integerMap.getOrDefault(number, 0) + 1);
            integerQueue.offer(number);
        }
        treeNodeQueue.offer(root);
        TreeNode myNode = null;
        TreeNode oppositeNode = null;
        int index = 1;
        while (!integerQueue.isEmpty()) {
            if (treeNodeQueue.isEmpty()) {
                break;
            }
            TreeNode currentNode = treeNodeQueue.poll();
            Integer leftValue = integerQueue.poll();
            TreeNode leftNode = new TreeNode(leftValue);
            if (index == me) {
                myNode = leftNode;
            } else if (index == opposite) {
                oppositeNode = leftNode;
            }
            leftNode.setIndex(index++);
            currentNode.left = leftNode;
            treeNodeQueue.offer(leftNode);
            if (integerMap.get(leftValue) > 1 && !integerQueue.isEmpty()) {
                Integer rightValue = integerQueue.poll();
                TreeNode rightNode = new TreeNode(rightValue);
                if (index == me) {
                    myNode = leftNode;
                } else if (index == opposite) {
                    oppositeNode = leftNode;
                }
                rightNode.setIndex(index++);
                currentNode.right = rightNode;
                treeNodeQueue.offer(rightNode);
            }
        }

        findLowestCommonAncestorThenCount(root, myNode, oppositeNode);
        return count / 2 + 1;
    }

    private TreeNode findLowestCommonAncestorThenCount(TreeNode currentNode, TreeNode myNode, TreeNode oppositeNode) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.hasSibling()) {
            count++;
        }
        if (currentNode == myNode || currentNode == oppositeNode) {
            return currentNode;
        }
        TreeNode left = findLowestCommonAncestorThenCount(currentNode.left, myNode, oppositeNode);
        TreeNode right = findLowestCommonAncestorThenCount(currentNode.right, myNode, oppositeNode);
        if (left != null && right != null) {
            return currentNode;
        }
        return left == null ? right : left;
    }

    static class TreeNode {
        int index;
        Integer value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public boolean hasSibling() {
            return right != null;
        }
    }
}
