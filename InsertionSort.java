import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[20];
        int n, temp;

        System.out.print("Enter how many elements do you want to enter: ");
        n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            temp = a[i];

            // Shift elements greater than temp one position ahead
            int j;
            for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                a[j + 1] = a[j];
            }

            // Insert temp at its correct position
            a[j + 1] = temp;
        }

        System.out.println("\nSorted order is:");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

        sc.close();
    }
}
