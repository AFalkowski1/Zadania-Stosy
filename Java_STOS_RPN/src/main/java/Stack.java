import java.util.Arrays;

public class Stack {
    private String[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public Stack() {
        elements = new String[INITIAL_CAPACITY];
        size = 0;
    }

    // Dodaje element na stos
    public void push(String element) {
        if (size == elements.length) {
            expandCapacity();
        }
        elements[size] = element;
        size++;
    }

    // Usuwa i zwraca ostatni element ze stosu
    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stos jest pusty");
        }
        String topElement = elements[size - 1];
        elements[size - 1] = null; // Czyszczenie referencji dla bezpieczeństwa
        size--;
        return topElement;
    }

    // Zwraca ostatni element na stosie bez usuwania go
    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stos jest pusty");
        }
        return elements[size - 1];
    }

    // Sprawdza, czy stos jest pusty
    public boolean isEmpty() {
        return size == 0;
    }

    // Rozszerza pojemność tablicy, gdy stos jest pełny
    private void expandCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }
}