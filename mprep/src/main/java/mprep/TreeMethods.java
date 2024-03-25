package mprep;

import java.util.List;
import java.util.ArrayList;

public class TreeMethods {

    public static class Node {
        int id;
        Node left, right;
        int redundancy = 0;

        public Node() {

        }

        public Node(int item) {
            id = item;
            left = right = null;
        }
    }

    public static class BinaryTree {
        Node root = new Node();

        public void add(int i) {
            Node newNode = new TreeMethods.Node();
            newNode.id = i;
            Node node = this.root;
            boolean locationNotFound = true;

            while (locationNotFound) {
                while (newNode.id <= node.id) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        locationNotFound = false;
                        break;
                    }
                }
                while (newNode.id > node.id) {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        locationNotFound = false;
                        break;
                    }
                }
            }
            if (node.left != null && newNode.id >= node.left.id
                    || node.right != null && newNode.id <= node.right.id) {
                locationNotFound = false;
            }

            if (!locationNotFound) {
                boolean located = false;
                while (!located) {
                    if (newNode.id <= node.id) {
                        while (node.left != null) {
                            node = node.left; // navigate to leaf node
                        }
                        located = true;
                    } else {
                        while (node.right != null) {
                            node = node.right; // navigate to leaf node
                        }
                        located = true;
                    }
                }

                if (located && newNode.id <= node.id && node.left == null) {
                    node.left = newNode;
                } else if (located && newNode.id > node.id && node.right == null) {
                    node.right = newNode;
                }
            }
        }
    }

    public BinaryTree buildTree(List<Integer> nodeDataList) {
        BinaryTree tree = new BinaryTree();

        tree.root.id = nodeDataList.get(0);
        for (int i = 1; i < nodeDataList.size(); i++) {
            tree.add(nodeDataList.get(i));
        }
        return tree;
    }

    public void traverseTree(Node node) {
        if (node != null) {
            traverseTree(node.left);
            System.out.print(node.id + ", ");
            traverseTree(node.right);
        }
    }

    public List<Integer> binaryTreeToList(Node root) {
        List<Integer> treeNodes = new ArrayList<>();

        treeNodes = traversalHelper(root, treeNodes);

        return treeNodes;
    }

    private List<Integer> traversalHelper(Node root, List<Integer> treeNodesList) {
        if (root != null) {
            traversalHelper(root.left, treeNodesList);
            treeNodesList.add(root.id);
            traversalHelper(root.right, treeNodesList);
        }
        return treeNodesList;
    }
}
