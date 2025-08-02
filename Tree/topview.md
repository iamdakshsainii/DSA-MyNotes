# Top View of Binary Tree in Java

This document explains two different methods to compute the **Top View** of a binary tree in Java:

* Iterative approach using **BFS (Breadth-First Search)**
* Recursive approach using **DFS (Depth-First Search)**

---

## ✅ 1. Iterative (BFS) Approach

```java
import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int val) {
        data = val;
    }
}

public class TopViewTree {

    public static List<Integer> topView(TreeNode root) {
        int[] minmax = new int[2]; // [min, max] horizontal distance
        findWidth(root, 0, minmax);

        int left = minmax[0], right = minmax[1];
        int width = right - left + 1;
        int offset = -left;

        int[] ans = new int[width];
        boolean[] filled = new boolean[width];

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();

        q.add(root);
        index.add(offset);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int pos = index.poll();

            if (!filled[pos]) {
                filled[pos] = true;
                ans[pos] = curr.data;
            }

            if (curr.left != null) {
                q.add(curr.left);
                index.add(pos - 1);
            }
            if (curr.right != null) {
                q.add(curr.right);
                index.add(pos + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int val : ans) result.add(val);
        return result;
    }

    private static void findWidth(TreeNode node, int hd, int[] minmax) {
        if (node == null) return;
        minmax[0] = Math.min(minmax[0], hd);
        minmax[1] = Math.max(minmax[1], hd);
        findWidth(node.left, hd - 1, minmax);
        findWidth(node.right, hd + 1, minmax);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        List<Integer> result = topView(root);
        System.out.println("Top View: " + result);
    }
}
```

---

## ✅ 2. Recursive (DFS) Approach

```java
import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int val) {
        data = val;
    }
}

public class TopViewRecursive {

    public static void find(TreeNode root, int pos, int[] minmax) {
        if (root == null) return;
        minmax[0] = Math.min(minmax[0], pos);
        minmax[1] = Math.max(minmax[1], pos);
        find(root.left, pos - 1, minmax);
        find(root.right, pos + 1, minmax);
    }

    public static void Tview(TreeNode root, int pos, int[] ans, int[] level, int depth) {
        if (root == null) return;

        if (level[pos] > depth) {
            ans[pos] = root.data;
            level[pos] = depth;
        }

        Tview(root.left, pos - 1, ans, level, depth + 1);
        Tview(root.right, pos + 1, ans, level, depth + 1);
    }

    public static List<Integer> topView(TreeNode root) {
        int[] minmax = new int[2];
        find(root, 0, minmax);
        int left = minmax[0];
        int right = minmax[1];
        int width = right - left + 1;
        int offset = -left;

        int[] ans = new int[width];
        int[] level = new int[width];
        Arrays.fill(level, Integer.MAX_VALUE);

        Tview(root, offset, ans, level, 0);

        List<Integer> topView = new ArrayList<>();
        for (int val : ans) topView.add(val);
        return topView;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = topView(root);
        System.out.println("Top View: " + result);
    }
}
```

---

## 🔍 Differences

| Approach  | Method | Key Feature                                      | Space | Logic                        |
| --------- | ------ | ------------------------------------------------ | ----- | ---------------------------- |
| Iterative | BFS    | Uses Queue and index tracking                    | O(W)  | Processes level by level     |
| Recursive | DFS    | Tracks minimum depth at each horizontal distance | O(H)  | Uses depth-based replacement |

* **Offset** is used in both methods to shift negative indexes to 0-based array.
* Recursive needs a `level[]` array to track the smallest depth for each horizontal position.

  Iterative fills the first seen value for each horizontal distance.
