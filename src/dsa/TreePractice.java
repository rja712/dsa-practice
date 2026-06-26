package dsa;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreePractice {

    public static void main(String[] args) {

        TreePractice tree = new TreePractice();

        TreeNode root = tree.createTree();

        tree.printTree(root);

        System.out.println();

        System.out.println("Height = " + tree.height(root));

        System.out.println("Count = " + tree.count(root));

        System.out.println("Max = " + tree.maxValue(root));

        System.out.println();

        System.out.print("Preorder : ");
        tree.preorder(root);

        System.out.println();

        System.out.print("Inorder : ");
        tree.inorder(root);

        System.out.println();

        System.out.print("Postorder : ");
        tree.postorder(root);

        System.out.println();

        System.out.print("DFS Stack : ");
        tree.dfsStack(root);

        System.out.println();

        System.out.print("BFS : ");
        tree.bfs(root);

        System.out.println();

        System.out.println("Level Order");
        tree.bfsLevelWise(root);

        System.out.println();

        System.out.println("Diameter = " + tree.diameter(root));
    }

    TreeNode createTree() {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;
    }

    void printTree(TreeNode root) {
        printTree(root, "", true);
    }

    void printTree(TreeNode node,
                   String indent,
                   boolean isLast) {

        if (node == null) {
            return;
        }

        System.out.println(
                indent +
                        (isLast ? "└── " : "├── ") +
                        node.val);

        indent += isLast ? "    " : "│   ";

        printTree(node.left, indent, false);
        printTree(node.right, indent, true);
    }

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    int count(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return count(node.left) + count(node.right) + 1;
    }

    boolean search(TreeNode node, int val) {

        if (node == null) {
            return false;
        }

        if (node.val == val) {
            return true;
        }

        return search(node.left, val) || search(node.right, val);

    }


    Integer maxValue(TreeNode node) {
        if (node == null) {
            return null;
        }

        return max(maxValue(node.left), maxValue(node.right), node.val);
    }

    private Integer max(Integer a, Integer b, int c) {
        return Math.max(Math.max(a != null ? a : Integer.MIN_VALUE, b != null ? b : Integer.MIN_VALUE), c);
    }

    TreeNode lca(TreeNode node, TreeNode a, TreeNode b) {
        if (node == null) {
            return null;
        }

        if (node == a || node == b) {
            return node;
        }

        TreeNode leftFound = lca(node.left, a, b);
        TreeNode rightFound = lca(node.right, a, b);

        if (leftFound != null && rightFound != null) {
            return node;
        }

        return leftFound == null ? rightFound : leftFound;
    }

    boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        var left = isValidBST(node.left, min, node.val);
        var right = isValidBST(node.right, node.val, max);

        return left && right;
    }

    TreeNode previousNode = null;

    boolean isValidBSTInorderWrapper(TreeNode node) {
        previousNode = null;
        return isValidBSTInorder(node);
    }

    boolean isValidBSTInorder(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean currentVerdict = false;
        boolean leftVerdict = isValidBSTInorder(node.left);

        if (previousNode == null || node.val > previousNode.val) {
            previousNode = node;
            currentVerdict = true;
        }

        boolean rightVerdict = isValidBSTInorder(node.right);

        return currentVerdict && leftVerdict && rightVerdict;
    }

    void preorder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    void postorder(TreeNode node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }

    void dfsStack(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {

            TreeNode currentNode = stack.pop();
            System.out.println(currentNode.val);

            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

        }
    }

    void bfs(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            TreeNode currentNode = queue.poll();

            System.out.print(currentNode.val + " ");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }


    void bfsLevelWise(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            int currentLevelSize = queue.size();

            for (int i = 0; i < currentLevelSize; i++) {

                TreeNode currentNode = queue.poll();

                System.out.print(currentNode.val + " ");

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }

            }

            System.out.println();
        }
    }

    int globalMaxDiameter = 0;

    int diameter(TreeNode node) {
        globalMaxDiameter = 0;
        getHeightUpdateDiameter(node);
        return globalMaxDiameter;
    }

    int getHeightUpdateDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeightUpdateDiameter(node.left);
        int rightHeight = getHeightUpdateDiameter(node.right);

        globalMaxDiameter = Math.max(globalMaxDiameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    record DiameterInfo(int height, int maxDiameter) {};


    DiameterInfo diameterWithCompositeReturnObject(TreeNode node) {
        if (node == null) {
            return new DiameterInfo(0, 0);
        }


        DiameterInfo leftValue = diameterWithCompositeReturnObject(node.left);
        DiameterInfo rightValue = diameterWithCompositeReturnObject(node.right);
        int diameterViaCurrentNode = leftValue.height() + rightValue.height();
        int heightAtCurrentNode = Math.max(leftValue.height(), rightValue.height()) + 1;

        return new DiameterInfo(heightAtCurrentNode, max(diameterViaCurrentNode, leftValue.maxDiameter(), rightValue.maxDiameter()));
    }


}

