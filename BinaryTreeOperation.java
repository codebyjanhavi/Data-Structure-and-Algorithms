import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Bt {
    Node root;
    Scanner sc;

    Bt(Scanner sc) {
        this.sc = sc;
    }

    void insertroot() {
        System.out.print("Enter the root value: ");
        int val = sc.nextInt();
        if (root == null) {
            root = new Node(val);
        }
        insertNode();
    }

    void insertNode() {
        while (true) {
            System.out.print("Do you want to insert more node? (yes/no): ");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("no"))
                return;

            System.out.print("Enter value to insert: ");
            int val = sc.nextInt();
            Node newnode = new Node(val);

            Node current = root; // Start from root for each insertion

            while (true)
            {
                System.out.print("Current Node: " + current.data + " - Insert left or right? ");
                String dir = sc.next();
                if (dir.equalsIgnoreCase("left")) {
                    if (current.left == null) {
                        current.left = newnode;
                        break;
                    } else {
                        current = current.left;
                    }
                } else if (dir.equalsIgnoreCase("right")) {
                    if (current.right == null) {
                        current.right = newnode;
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    System.out.println("Invalid direction. Enter left or right.");
                }
            }
        }
    }

    void displayTree() {
        System.out.println("\nRecursive Traversals:");
        System.out.print("Inorder: ");
        inorder(root);
        System.out.print("\nPreorder: ");
        preorder(root);
        System.out.print("\nPostorder: ");
        postorder(root);
        System.out.println("\nBFS traversal:");
        bfs(root);

        System.out.println("\n\nNon-Recursive Traversals:");
        System.out.print("Inorder: ");
        inorderIterative(root);
        System.out.print("\nPreorder: ");
        preorderIterative(root);
        System.out.print("\nPostorder: ");
        postorderIterative(root);
        System.out.println();
    }

    // Recursive Traversals
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Non-Recursive Traversals
    void inorderIterative(Node root) {
        if (root == null)
            return;

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

    void preorderIterative(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
    }

    void postorderIterative(Node root) {
        if (root == null)
            return;

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

        while (!s2.isEmpty()) {
            Node temp = s2.pop();
            System.out.print(temp.data + " ");
        }
    }
    //bfs traversal(level order Traversal)
    void bfs(Node root)
    {
        if(root==null)return;
        Queue<Node>q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node current= q.poll();
            System.out.println(current.data+" ");
            if(current.left!=null)
                q.add(current.left);
            if(current.right!=null)
                q.add(current.right);
        }
    }

    // Search using Non-Recursive Preorder
    void search(Node root, int key) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            Node current = s.pop();

            if (current.data == key) {
                System.out.println("Key " + key + " found in the tree.");
                return;
            }
            if (current.right != null)
                s.push(current.right);
            if (current.left != null)
                s.push(current.left);
        }
        System.out.println("Key " + key + " not found in the tree.");
    }
}

public class BinaryTreeOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bt bt1 = new Bt(sc);

        bt1.insertroot();
        bt1.displayTree();

        System.out.print("\nEnter value to search: ");
        int searchVal = sc.nextInt();
        bt1.search(bt1.root, searchVal);

        sc.close();
    }
}
