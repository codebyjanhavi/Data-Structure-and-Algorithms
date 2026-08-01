import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = new int[20];
        int n, swap;

        System.out.print("Enter the number of elements that you want: ");
        n = sc.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            // After each pass, the largest element is placed at the end
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap adjacent elements
                    swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }

        System.out.println("The sorted elements are:");
        for (int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }

        sc.close();
    }
}