import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = new int[100];
        int first, last, middle, n, search;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter value to find: ");
        search = sc.nextInt();

        first = 0;
        last = n - 1;
        middle = (first + last) / 2;

        while (first <= last) {
            if (array[middle] < search) {
                first = middle + 1;
            } else if (array[middle] == search) {
                System.out.println(search + " found at location " + (middle + 1) + ".");
                break;
            } else {
                last = middle - 1;
            }

            middle = (first + last) / 2;
        }

        if (first > last) {
            System.out.println("Not found! " + search + " isn't present in the list.");
        }

        sc.close();
    }
}