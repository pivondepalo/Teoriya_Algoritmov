public class HeapSort {

    public static void heapSort(int[] A) {
        int n = A.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(A, i, n);
        }

        for (int end = n - 1; end > 0; end--) {
            swap(A, 0, end);    
            sink(A, 0, end);    
        }
    }

    private static void sink(int[] A, int i, int n) {
        while (2 * i + 1 < n) {           
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int maxChild = left;

            if (right < n && A[right] > A[left]) {
                maxChild = right;
            }

            if (A[i] >= A[maxChild]) {
                break;
            }

            swap(A, i, maxChild);
            i = maxChild;
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};

        heapSort(arr);

        System.out.print("Результат: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
