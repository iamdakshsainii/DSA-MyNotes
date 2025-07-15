# 🌳 Binary Tree Traversals in Java

## 🔹 TreeNode Class (Used for All Traversals)

```java
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}
```

---

## 1️⃣ Inorder Traversal (Left → Root → Right)

### ✅ Code:

```java
public static void inorder(TreeNode root) {
    if (root == null) return;

    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

### 📌 Example Tree:

```
      1
     / \
    2   3
```

### 🔄 Output:

```
2 1 3
```

---

## 2️⃣ Preorder Traversal (Root → Left → Right)

### ✅ Code:

```java
public static void preorder(TreeNode root) {
    if (root == null) return;

    System.out.print(root.val + " ");
    preorder(root.left);
    preorder(root.right);
}
```

### 📌 Example Tree:

```
      1
     / \
    2   3
```

### 🔄 Output:

```
1 2 3
```

---

## 3️⃣ Postorder Traversal (Left → Right → Root)

### ✅ Code:

```java
public static void postorder(TreeNode root) {
    if (root == null) return;

    postorder(root.left);
    postorder(root.right);
    System.out.print(root.val + " ");
}
```

### 📌 Example Tree:

```
      1
     / \
    2   3
```

### 🔄 Output:

```
2 3 1
```

|   |
| - |
