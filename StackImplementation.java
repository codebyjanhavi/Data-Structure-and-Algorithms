import java.util.Scanner;

public class StackImplementation {

    static final int MAXSIZE = 10;
    static int[] a = new int[MAXSIZE];
    static int top = -1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int c;

        System.out.println("\t\tPROGRAM FOR STACK IMPLEMENTATION");

        do {
            System.out.println("\n1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. DISPLAY");
            System.out.println("4. QUIT");
            System.out.print("ENTER YOUR CHOICE: ");
            c = sc.nextInt();

            switch (c) {
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
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a choice between 1 and 4.");
            }

        } while (c != 4);

        sc.close();
    }

    static void push() {
        if (top == MAXSIZE - 1) {
            System.out.println("STACK IS FULL. No elements can be pushed.");
        } else {
            top++; // Move top to the next position
            System.out.print("ENTER DATA TO BE PUSHED: ");
            a[top] = sc.nextInt();
        }
    }

    static void pop() {
        if (top == -1) {
            System.out.println("STACK IS EMPTY. No element can be popped.");
        } else {
            System.out.println("POPPED DATA IS: " + a[top]);
            top--; // Remove the top element
        }
    }

    static void display() {
        if (top == -1) {
            System.out.println("STACK IS EMPTY. No data to display.");
        } else {
            // Display elements from top to bottom
            System.out.println("Elements in the stack are:");
            for (int i = top; i >= 0; i--) {
                System.out.println(a[i]);
            }
        }
    }
}