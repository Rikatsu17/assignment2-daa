import java.util.Random;
import java.util.Scanner;

public class BenchmarkRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        System.out.print("Enter array size: ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Array size must be a positive integer.");
                return;
            }
        } else {
            System.out.println("Invalid input. Please enter a positive integer.");
            return;
        }

        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(1000);
        }

        InsertionSort sorter = new InsertionSort();
        long startTime = System.nanoTime();
        sorter.sort(array);
        long endTime = System.nanoTime();

        System.out.println("Sorting completed.");
        System.out.println(sorter.getTracker());
        System.out.println("Execution time (ns): " + (endTime - startTime));

        boolean sorted = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                sorted = false;
                break;
            }
        }
        System.out.println("Array sorted correctly: " + sorted);
    }
}
