import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackUsingSLL {

    static Node head = null;
    static Scanner sc = new Scanner(System.in);

    static void push() {
        System.out.print("Enter the value for new node: ");
        Node newNode = new Node(sc.nextInt());

        // Insert new node at the beginning
        newNode.next = head;
        head = newNode;

        System.out.println("Item pushed");
    }

    static void pop() {
        if (head == null) {
            System.out.println("Underflow");
        } else {
            head = head.next; // Remove the top node
            System.out.println("Item popped");
        }
    }

    static void display() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Printing Stack elements");
            Node temp = head;

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {

        int choice = 0;

        System.out.println("********* Stack Operations Using Linked List *********");

        while (choice != 4) {

            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Show");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    push();
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Please enter a valid choice.");
            }
        }

        sc.close();
    }
}