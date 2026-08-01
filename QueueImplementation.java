import java.util.Scanner;

public class QueueImplementation {

    static final int MAXSIZE = 10;
    static int[] q = new int[MAXSIZE];
    static int fr = -1, rr = -1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int ch;

        System.out.println("PROGRAM FOR IMPLEMENTATION OF QUEUE USING ARRAY");

        do {
            System.out.println("\n1. INSERT (Enqueue)");
            System.out.println("2. DELETE (Dequeue)");
            System.out.println("3. DISPLAY");
            System.out.println("4. EXIT");
            System.out.print("ENTER THE CHOICE: ");
            ch = sc.nextInt();

            switch (ch) {
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
                    System.out.println("Invalid choice!");
            }

        } while (ch != 4);

        sc.close();
    }

    static void enqueue() {
        if (rr == MAXSIZE - 1) {
            System.out.println("QUEUE IS FULL.");
        } else {
            rr++;
            System.out.print("ENTER THE DATA: ");
            q[rr] = sc.nextInt();

            // Initialize front when first element is inserted
            if (rr == 0) {
                fr++;
            }
        }
    }

    static void dequeue() {
        if (rr == -1 || fr > rr) {
            System.out.println("QUEUE IS EMPTY.");
        } else {
            System.out.println(q[fr] + " DATA IS DELETED.");
            fr++; // Move front to the next element
        }
    }

    static void display() {
        if (rr == -1 || fr > rr) {
            System.out.println("QUEUE IS EMPTY.");
        } else {
            System.out.println("Queue elements are:");

            // Display elements from front to rear
            for (int i = fr; i <= rr; i++) {
                System.out.print(q[i] + "\t");
            }
            System.out.println();
        }
    }
}