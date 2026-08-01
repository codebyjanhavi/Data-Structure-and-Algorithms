import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueUsingSLL
 {

    static Node front = null;
    static Node rear = null;
    static Scanner sc = new Scanner(System.in);

    static void enqueue() {

        System.out.print("Enter value for new node: ");
        Node newNode = new Node(sc.nextInt());

        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        rear.next = null;
    }

    static void dequeue() {

        if (front == null) {
            System.out.println("UNDERFLOW");
        } else {
            front = front.next; // Remove the front node

            // Queue becomes empty
            if (front == null) {
                rear = null;
            }
        }
    }

    static void display() {

        if (front == null) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Printing Queue Elements:");

            Node temp = front;

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n************ MAIN MENU ************");
            System.out.println("1. Insert (Enqueue)");
            System.out.println("2. Delete (Dequeue)");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    enqueue();
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Enter a valid choice.");
            }
        }

        sc.close();
    }
}