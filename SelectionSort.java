import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[20];
        int n, swap;

        System.out.print("Enter how many elements do you want to enter: ");
        n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Selection Sort
        for (int i = 0; i < n - 1; i++) {
            // Compare current element with remaining elements
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    // Swap if a smaller element is found
                    swap = a[i];
                    a[i] = a[j];
                    a[j] = swap;
                }
            }
        }

        System.out.println("Sorted list in ascending order:");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

        sc.close();
    }
}