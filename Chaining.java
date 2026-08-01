import java.util.*;

class Node {
    int key;
    public Node(int k) {
        key = k;
    }
}
public class Chaining {
    int ts;
    List<List<Node>> hash;

    public Chaining(int ts) {
        this.ts = ts;
        hash = new ArrayList<>(ts);
        for (int i = 0; i < ts; i++) {
            hash.add(new LinkedList<Node>());
        }
    }

    void insert(int key) {
        int idx = key % ts;
        hash.get(idx).add(new Node(key));
    }

    void display() {
        for (int i = 0; i < ts; i++) {
            System.out.print(i + "->");
            for (Node n : hash.get(i)) {
                System.out.print(n.key + "->");
            }
            System.out.println("null");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter table size:");
        int ts = sc.nextInt();

        Chaining c = new Chaining(ts);

        System.out.println("Enter number of keys:");
        int n = sc.nextInt();

        System.out.println("Enter the keys:");
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            c.insert(key);
        }

        System.out.println("Hash Table:");
        c.display();

        sc.close();
    }
}
