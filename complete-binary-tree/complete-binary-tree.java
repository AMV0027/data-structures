import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class CompleteBinaryTree {
    TreeNode root;

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left == null) {
                current.left = new TreeNode(data);
                break;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = new TreeNode(data);
                break;
            } else {
                queue.add(current.right);
            }
        }
    }

    public void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        System.out.print("Inorder Traversal of the Complete Tree: ");
        tree.inorderTraversal(tree.root);
        System.out.println();
    }
}
