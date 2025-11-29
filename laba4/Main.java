public class Main {
    public static void main(String[] args) {

        String[] words = {
            "хто", "людям", "добра", "бажає", "той", "і", "собі", "має", "добра"
        };

        System.out.println("=== Відкрите хешування (ланцюжки) ===");
        OpenHashTable open = new OpenHashTable();
        for (String w : words) open.insert(w, false);
        open.display();

        System.out.println("\nПошук у відкритій таблиці:");
        for (String w : words) {
            int c = open.search(w, false);
            System.out.println(w + " — порівнянь: " + c);
        }

        System.out.println("\n=== Закрите хешування (відкрита адресація) ===");
        ClosedHashTable closed = new ClosedHashTable();
        for (String w : words) closed.insert(w, false);
        closed.display();

        System.out.println("\nПошук у закритій таблиці:");
        for (String w : words) {
            int c = closed.search(w, false);
            System.out.println(w + " — порівнянь: " + c);
        }
    }
}
