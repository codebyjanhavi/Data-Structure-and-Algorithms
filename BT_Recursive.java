import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BT_Recursive {

    Node root;

    BT_Recursive() {
        root = null;
    }

    void preorder(Node current) {
        if (current == null)
            return;

        System.out.print(current.data + " ");
        preorder(current.left);
        preorder(current.right);
    }

    void inorder(Node current) {
        if (current == null)
            return;

        inorder(current.left);
        System.out.print(current.data + " ");
        inorder(current.right);
    }

    void postorder(Node current) {
        if (current == null)
            return;

        postorder(current.left);
        postorder(current.right);
        System.out.print(current.data + " ");
    }

    // BFS (Level Order Traversal)
    void bfs(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
    }

    // DFS (Using Stack)
    void dfs(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");

            // Push right first so left is visited first
            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    void preorder() {
        preorder(root);
    }

    void inorder() {
        inorder(root);
    }

    void postorder() {
        postorder(root);
    }

    public static void main(String args[]) {

        BT_Recursive b = new BT_Recursive();

        b.root = new Node(1);
        b.root.left = new Node(2);
        b.root.right = new Node(3);
        b.root.left.left = new Node(4);
        b.root.left.right = new Node(5);

        System.out.print("Preorder Traversal: ");
        b.preorder();

        System.out.print("\nInorder Traversal: ");
        b.inorder();

        System.out.print("\nPostorder Traversal: ");
        b.postorder();

        System.out.print("\nBFS Traversal: ");
        b.bfs(b.root);

        System.out.print("\nDFS Traversal: ");
        b.dfs(b.root);
    }
}