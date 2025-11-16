public class QuickSortTrace {
    static int comparisons = 0;
    static int swaps = 0;

    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};

        System.out.print("Початковий масив: ");
        printArray(arr);
        System.out.println();

        quickSort(arr, 0, arr.length - 1);

        System.out.print("\nВідсортований масив: ");
        printArray(arr);

        System.out.printf("\nКількість порівнянь: %d\n", comparisons);
        System.out.printf("Кількість обмінів: %d\n", swaps);
    }

    static void quickSort(int[] arr, int left, int right) {
        System.out.printf("Виклик quickSort(l=%d, r=%d): ", left, right);
        printArray(arr);

        if (left < right) {
            int p = partition(arr, left, right);
            System.out.printf("  → Після partition (pivot pos=%d): ", p);
            printArray(arr);

            quickSort(arr, left, p);
            quickSort(arr, p + 1, right);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        int i = left;
        int j = right;
        System.out.printf("    Partition: pivot=%d (між %d і %d)\n", pivot, left, right);

        while (true) {
            while (arr[i] < pivot) { i++; comparisons++; }
            while (arr[j] > pivot) { j--; comparisons++; }

            if (i >= j) return j;

            System.out.printf("      swap(%d, %d): %d ↔ %d\n", i, j, arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            swaps++;

            i++;
            j--;
            System.out.print("      Після swap: ");
            printArray(arr);
        }
    }

    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
