import java.util.Scanner;

class DNode {
    int data;
    DNode prev, next;

    DNode(int data) {
        this.data = data;
    }
}

public class DoublyLinkedList {

    static DNode head = null;
    static Scanner sc = new Scanner(System.in);

    static void insertAtStart() {
        System.out.print("Enter data: ");
        DNode newNode = new DNode(sc.nextInt());

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    static void insertAtEnd() {
        System.out.print("Enter data: ");
        DNode newNode = new DNode(sc.nextInt());

        if (head == null) {
            head = newNode;
            return;
        }

        DNode temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    static void insertAfter() {
        System.out.print("Enter position after which to insert: ");
        int pos = sc.nextInt();

        DNode temp = head;
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
        DNode newNode = new DNode(sc.nextInt());

        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null)
            temp.next.prev = newNode;
        temp.next = newNode;
    }

    static void display() {
        if (head == null) {
            System.out.println("DLL is Empty");
            return;
        }

        DNode temp = head;
        System.out.print("DLL: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void deleteFirst() {
        if (head == null) {
            System.out.println("DLL is Empty");
        } else if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    static void deleteLast() {
        if (head == null) {
            System.out.println("DLL is Empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        DNode temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.prev.next = null;
    }

    static void deleteAtPosition() {
        System.out.print("Enter position to delete: ");
        int pos = sc.nextInt();

        if (head == null) {
            System.out.println("DLL is Empty");
            return;
        }
        if (pos == 1) {
            deleteFirst();
            return;
        }

        DNode temp = head;
        int i = 1;
        while (temp != null && i < pos) {
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        if (temp.next != null)
            temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
    }

    public static void main(String[] args) {

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter data for node " + i + ": ");
            DNode node = new DNode(sc.nextInt());

            if (head == null)
                head = node;
            else {
                DNode temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = node;
                node.prev = temp;
            }
        }

        int choice;
        do {
            System.out.println("\n1.Insert At Start");
            System.out.println("2.Insert After");
            System.out.println("3.Insert At End");
            System.out.println("4.Display");
            System.out.println("5.Delete First");
            System.out.println("6.Delete At Position");
            System.out.println("7.Delete Last");
            System.out.println("8.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> insertAtStart();
                case 2 -> insertAfter();
                case 3 -> insertAtEnd();
                case 4 -> display();
                case 5 -> deleteFirst();
                case 6 -> deleteAtPosition();
                case 7 -> deleteLast();
                case 8 -> System.out.println("Program terminated.");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 8);

        sc.close();
    }
}