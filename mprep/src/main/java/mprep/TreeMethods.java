package mprep;

import java.util.List;
import java.util.ArrayList;

public class TreeMethods {

    // #region Int BinaryTree

    public static class Node {
        int id;
        Node left, right;

        public Node() {

        }

        public Node(int item) {
            id = item;
            left = right = null;
        }
    }

    public class BinaryTree {
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

    // #endregion

    // #region CharBinaryTree

    public static class CharNode {
        char value;
        CharNode left, right;

        public CharNode() {

        }

        public CharNode(char c) {
            value = c;
            left = right = null;
        }
    }

    public class CharBinaryTree {
        CharNode root = new CharNode();

        public void add(char c) {
            CharNode newNode = new TreeMethods.CharNode();
            newNode.value = c;
            CharNode node = new CharNode();
            node = this.root;
            boolean locationNotFound = true;

            while (locationNotFound) {
                while (newNode.value <= node.value) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        locationNotFound = false;
                        break;
                    }
                }
                while (newNode.value > node.value) {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        locationNotFound = false;
                        break;
                    }
                }
            }
            if (node.left != null && newNode.value >= node.left.value
                    || node.right != null && newNode.value <= node.right.value) {
                locationNotFound = false;
            }

            if (!locationNotFound) {
                boolean located = false;
                while (!located) {
                    if (newNode.value <= node.value) {
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

                if (located && newNode.value <= node.value && node.left == null) {
                    node.left = newNode;
                } else if (located && newNode.value > node.value && node.right == null) {
                    node.right = newNode;
                }
            }
        }
    }

    public CharBinaryTree buildCharTree(List<Character> nodeDataList) {
        CharBinaryTree tree = new CharBinaryTree();

        tree.root.value = nodeDataList.get(0);
        for (int i = 1; i < nodeDataList.size(); i++) {
            tree.add(nodeDataList.get(i));
        }
        return tree;
    }

    public void traverseCharTree(CharNode node) {
        if (node != null) {
            traverseCharTree(node.left);
            System.out.print(node.value + ", ");
            traverseCharTree(node.right);
        }
    }

    public List<Character> binaryCharTreeToList(CharNode root) {
        List<Character> treeNodes = new ArrayList<>();

        treeNodes = traversalCharHelper(root, treeNodes);

        return treeNodes;
    }

    private List<Character> traversalCharHelper(CharNode root, List<Character> treeNodesList) {
        if (root != null) {
            traversalCharHelper(root.left, treeNodesList);
            treeNodesList.add(root.value);
            traversalCharHelper(root.right, treeNodesList);
        }
        return treeNodesList;
    }

    // #endregion
}
