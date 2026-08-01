import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = new int[100];
        System.out.print("Enter number of elements in array: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integer(s):");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter a number to search: ");
        int search = sc.nextInt();

        int i;
        for ( i = 0; i < n; i++) {
            if (array[i] == search) {
                System.out.println(search + " is present at location " + (i + 1) + ".");
                break;
            }
        }

        if (i == n) {
            System.out.println(search + " isn't present in the array.");
        }
        sc.close();
    }
}