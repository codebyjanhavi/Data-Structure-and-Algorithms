import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {

    static Node head = null;
    static Scanner sc = new Scanner(System.in);

    static void insertAtStart() {
        System.out.print("Enter data: ");
        Node newNode = new Node(sc.nextInt());
        newNode.next = head;
        head = newNode;
    }

    static void insertAtEnd() {
        System.out.print("Enter data: ");
        Node newNode = new Node(sc.nextInt());

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    static void insertAfter() {
        System.out.print("Enter position after which to insert: ");
        int pos = sc.nextInt();

        Node temp = head;
        int i = 1;

        while (temp != null && i < pos) {
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        System.out.print("Enter data: ");
        Node newNode = new Node(sc.nextInt());

        newNode.next = temp.next;
        temp.next = newNode;
    }

    static void display() {
        if (head == null) {
            System.out.println("SLL is Empty");
            return;
        }

        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void deleteFirst() {
        if (head == null)
            System.out.println("SLL is Empty");
        else
            head = head.next;
    }

    static void deleteLast() {
        if (head == null) {
            System.out.println("SLL is Empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;

        temp.next = null;
    }

    static void deleteAtPosition() {
        System.out.print("Enter position to delete: ");
        int pos = sc.nextInt();

        if (head == null) {
            System.out.println("SLL is Empty");
            return;
        }

        if (pos == 1) {
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null) {
            System.out.println("Invalid position");
            return;
        }

        temp.next = temp.next.next;
    }

    static void countNodes() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total number of nodes: " + count);
    }

    static void searchNode() {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        Node temp = head;
        int pos = 1;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }

        System.out.println("Element not found.");
    }

    public static void main(String[] args) {

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter data for node " + i + ": ");
            Node newNode = new Node(sc.nextInt());

            if (head == null)
                head = newNode;
            else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = newNode;
            }
        }

        int choice;

        do {
            System.out.println("\n1. Insert At Start");
            System.out.println("2. Insert After");
            System.out.println("3. Insert At End");
            System.out.println("4. Display");
            System.out.println("5. Delete First");
            System.out.println("6. Delete At Position");
            System.out.println("7. Delete Last");
            System.out.println("8. Count Nodes");
            System.out.println("9. Search Node");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: insertAtStart(); break;
                case 2: insertAfter(); break;
                case 3: insertAtEnd(); break;
                case 4: display(); break;
                case 5: deleteFirst(); break;
                case 6: deleteAtPosition(); break;
                case 7: deleteLast(); break;
                case 8: countNodes(); break;
                case 9: searchNode(); break;
                case 10: System.out.println("Program terminated."); break;
                default: System.out.println("Invalid choice.");
            }

        } while (choice != 10);

        sc.close();
    }
}