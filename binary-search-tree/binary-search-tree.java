import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree {
    private TreeNode root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public TreeNode search(int key) {
        return searchRec(root, key);
    }

    private TreeNode searchRec(TreeNode root, int key) {
        if (root == null || root.data == key) return root;
        if (key < root.data)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) return root;
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.data = findMin(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int findMin(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root.data;
    }
}

public class BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        while (true) {
            System.out.println("1. Insert\n2. Delete\n3. Search\n4. Inorder\n5. Preorder\n6. Postorder\n7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int ele = sc.nextInt();
                    tree.insert(ele);
                    break;
                case 2:
                    System.out.print("Enter element to delete: ");
                    ele = sc.nextInt();
                    tree.delete(ele);
                    break;
                case 3:
                    System.out.print("Enter element to search: ");
                    ele = sc.nextInt();
                    TreeNode result = tree.search(ele);
                    if (result != null)
                        System.out.println(ele + " found in the tree.");
                    else
                        System.out.println(ele + " not found in the tree.");
                    break;
                case 4:
                    System.out.print("Inorder Traversal: ");
                    tree.inorder();
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Preorder Traversal: ");
                    tree.preorder();
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Postorder Traversal: ");
                    tree.postorder();
                    System.out.println();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}
