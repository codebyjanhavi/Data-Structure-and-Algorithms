import java.util.Scanner;

public class CircularQueue {

    static final int SIZE = 5;
    static int[] q = new int[SIZE];
    static int front = -1, rear = -1;
    static Scanner sc = new Scanner(System.in);

    static void enQueue(int element) {

        if (rear == -1 && front == -1) {
            front = 0;
            rear = 0;
            q[rear] = element;
        }

        // Check if the queue is full
        else if (front == (rear + 1) % SIZE) {
            System.out.println("Queue Full");
        }

        else {
            rear = (rear + 1) % SIZE;
            q[rear] = element;
        }
    }

    static void deQueue() {

        if (rear == -1 && front == -1) {
            System.out.println("Queue Empty");
        }

        else if (front == rear) {
            System.out.println("Deleted element: " + q[front]);
            front = -1;
            rear = -1;
        }

        else {
            System.out.println("Deleted element: " + q[front]);
            front = (front + 1) % SIZE; // Move front circularly
        }
    }

    static void display() {

        if (rear == -1 && front == -1) {
            System.out.println("Empty Queue");
        }

        else {
            System.out.println("Front -> " + front);
            System.out.print("Items -> ");

            int i;
            for (i = front; i != rear; i = (i + 1) % SIZE) {
                System.out.print(q[i] + " ");
            }

            System.out.print(q[i] + " ");
            System.out.println("\nRear -> " + rear);
        }
    }

    public static void main(String[] args) {

        int choice, element;

        do {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    element = sc.nextInt();
                    enQueue(element);
                    break;

                case 2:
                    deQueue();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}