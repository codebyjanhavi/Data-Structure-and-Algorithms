import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BT_NonRecursive {

    Node root;

    void inorder() {
        if (root == null) return;

        Stack<Node> s = new Stack<>();
        Node current = root;

        while (current != null || !s.isEmpty()) {
            while (current != null) {
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    void preorder() {
        if (root == null) return;

        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            Node current = s.pop();
            System.out.print(current.data + " ");

            if (current.right != null)
                s.push(current.right);
            if (current.left != null)
                s.push(current.left);
        }
    }

    void postorder() {
        if (root == null) return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            Node p = s1.pop();
            s2.push(p);

            if (p.left != null)
                s1.push(p.left);
            if (p.right != null)
                s1.push(p.right);
        }

        while (!s2.isEmpty())
            System.out.print(s2.pop().data + " ");
    }

    // BFS using Queue
    void bfs() {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node current = q.poll();
            System.out.print(current.data + " ");

            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);
        }
    }

    // DFS using Stack
    void dfs() {
        if (root == null) return;

        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            Node current = s.pop();
            System.out.print(current.data + " ");

            if (current.right != null)
                s.push(current.right);
            if (current.left != null)
                s.push(current.left);
        }
    }

    public static void main(String[] args) {

        BT_NonRecursive b = new BT_NonRecursive();

        b.root = new Node(1);
        b.root.left = new Node(2);
        b.root.right = new Node(3);
        b.root.left.left = new Node(4);
        b.root.left.right = new Node(5);
        b.root.right.left = new Node(6);
        b.root.right.right = new Node(7);

        System.out.print("Non-Recursive Preorder: ");
        b.preorder();

        System.out.print("\nNon-Recursive Inorder: ");
        b.inorder();

        System.out.print("\nNon-Recursive Postorder: ");
        b.postorder();

        System.out.print("\nBFS Traversal: ");
        b.bfs();

        System.out.print("\nDFS Traversal: ");
        b.dfs();
    }
}