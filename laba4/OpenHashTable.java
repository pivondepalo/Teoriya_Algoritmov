import java.util.*;

public class OpenHashTable {

    private final int M = 13;
    private List<String>[] table;
    private final double A = (Math.sqrt(5) - 1) / 2;

    public OpenHashTable() {
        table = new List[M];
        for (int i = 0; i < M; i++) {
            table[i] = new LinkedList<>();
        }
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
        int index = useMultiplication ? hashMultiplication(k) : hashDivision(k);
        table[index].add(word);
    }

    public int search(String word, boolean useMultiplication) {
        int k = key(word);
        int index = useMultiplication ? hashMultiplication(k) : hashDivision(k);
        int comparisons = 0;
        for (String s : table[index]) {
            comparisons++;
            if (s.equals(word)) return comparisons;
        }
        return comparisons;
    }

    public void display() {
        for (int i = 0; i < M; i++) {
            System.out.println(i + ": " + table[i]);
        }
    }
}
