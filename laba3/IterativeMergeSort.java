public class IterativeMergeSort {
    static int comparisons = 0;
    static int swaps = 0;

    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};

        System.out.print("Початковий масив: ");
        printArray(arr);
        System.out.println();

        iterativeMergeSort(arr);

        System.out.print("\nВідсортований масив: ");
        printArray(arr);

        System.out.printf("\nКількість порівнянь: %d\n", comparisons);
        System.out.printf("Кількість обмінів: %d\n", swaps);
    }

    static void iterativeMergeSort(int[] arr) {
        int n = arr.length;

        for (int currentSize = 1; currentSize < n; currentSize *= 2) {
            System.out.println("\nРозмір підмасивів = " + currentSize);

            for (int left = 0; left < n - 1; left += 2 * currentSize) {
                int mid = Math.min(left + currentSize - 1, n - 1);
                int right = Math.min(left + 2 * currentSize - 1, n - 1);

                System.out.printf("  → Об’єднання (l=%d, m=%d, r=%d)\n", left, mid, right);
                merge(arr, left, mid, right);
                System.out.print("    Після merge: ");
                printArray(arr);
            }
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else {
                arr[k++] = R[j++];
                swaps++;
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
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
