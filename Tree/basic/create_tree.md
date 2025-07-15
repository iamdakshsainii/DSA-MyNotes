
```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeBuilder {
    static Scanner sc = new Scanner(System.in);

    public static TreeNode buildTree() {
        System.out.print("Enter node value (-1 for null): ");
        int val = sc.nextInt();

        if (val == -1) return null;

        TreeNode root = new TreeNode(val);
        System.out.println("Enter left child of " + val);
        root.left = buildTree();
        System.out.println("Enter right child of " + val);
        root.right = buildTree();

        return root;
    }

    // Optional: Inorder print
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        System.out.println("Inorder traversal:");
        printInorder(root);
    }
}
```
