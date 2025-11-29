import java.util.Arrays;

public class ClosedHashTable {

    private final int M = 13;
    private String[] table;
    private final double A = (Math.sqrt(5) - 1) / 2;
    private final String DELETED = "<deleted>";

    public ClosedHashTable() {
        table = new String[M];
        Arrays.fill(table, null);
    }

    public int key(String word) {
        int sum = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            sum += letterValue(c);
        }
        return sum;
    }

    private int letterValue(char c) {
        String alphabet = "абвгґдежзийіїклмнопрстуфхцчшщьюяє";
        int index = alphabet.indexOf(c);
        return (index >= 0) ? (index + 1) : 0;
    }

    public int hashDivision(int key) {
        return key % M;
    }

    public int hashMultiplication(int key) {
        double fractional = (key * A) % 1;
        return (int) Math.floor(16 * fractional) % M;
    }

    public void insert(String word, boolean useMultiplication) {
        int k = key(word);
        int start = useMultiplication ? hashMultiplication(k) : hashDivision(k);
        for (int i = 0; i < M; i++) {
            int index = (start + i) % M;
            if (table[index] == null || table[index].equals(DELETED)) {
                table[index] = word;
                return;
            }
        }
        System.out.println("Таблиця переповнена");
    }

    public int search(String word, boolean useMultiplication) {
        int k = key(word);
        int start = useMultiplication ? hashMultiplication(k) : hashDivision(k);
        int comparisons = 0;
        for (int i = 0; i < M; i++) {
            int index = (start + i) % M;
            if (table[index] == null) break;
            comparisons++;
            if (word.equals(table[index])) return comparisons;
        }
        return comparisons;
    }

    public void delete(String word, boolean useMultiplication) {
        int k = key(word);
        int start = useMultiplication ? hashMultiplication(k) : hashDivision(k);
        for (int i = 0; i < M; i++) {
            int index = (start + i) % M;
            if (table[index] == null) return;
            if (word.equals(table[index])) {
                table[index] = DELETED;
                return;
            }
        }
    }

    public void display() {
        for (int i = 0; i < M; i++) {
            System.out.println(i + ": " + (table[i] == null ? "(NULL)" : table[i]));
        }
    }
}
