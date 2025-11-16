public class RecursiveMergeSort {
    static int comparisons = 0;
    static int swaps = 0;

    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};

        System.out.print("Початковий масив: ");
        printArray(arr);
        System.out.println();

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("\nВідсортований масив: ");
        printArray(arr);

        System.out.printf("\nКількість порівнянь: %d\n", comparisons);
        System.out.printf("Кількість обмінів: %d\n", swaps);
    }

    static void mergeSort(int[] arr, int left, int right) {
        System.out.printf("Виклик mergeSort(l=%d, r=%d): ", left, right);
        printArray(arr);

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        System.out.printf("  → Об’єднання (l=%d, m=%d, r=%d)\n", left, mid, right);

        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
                swaps++;
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];

        System.out.print("    Після merge: ");
        printArray(arr);
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
