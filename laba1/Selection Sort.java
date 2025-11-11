public class SortLabVar8 {
    public static void main(String[] args) {
        int[] arr1 = {69, 52, 97, 27, 10, 88, 29, 1, 24};
        int[] arr2 = arr1.clone();

        System.out.println("\n=== Вхідна послідовність (варіант 8) ===");
        printArray(arr1);

        selectionSort(arr1);
        System.out.println("\n=== Сортування вибором (Selection Sort) ===");
        printArray(arr1);

        insertionSort(arr2);
        System.out.println("\n=== Сортування вставками (Insertion Sort) ===");
        printArray(arr2);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


