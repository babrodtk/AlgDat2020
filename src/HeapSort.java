import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int values[] = {-99, 5, 9, 8, 3, 1};

        heapsort(values);

    }

    static void heapsort(int[] values) {
        System.out.println("Array før heapify: " + Arrays.toString(values));
        heapify(values);

        System.out.println("Array etter heapify: " + Arrays.toString(values));

        for (int i=1; i<values.length; ++i) {
            int first = 1;
            int last = values.length - i;

            System.out.println("Bytter " + first + " med " + last);

            int tmp = values[first];
            values[first] = values[last];
            values[last] = tmp;

            int current = first;
            int left_child = current*2;
            int right_child = current*2 + 1;
            while (true) {
                //Venstre barn er minst av barna, og mindre enn parent
                if (left_child < last
                        && values[left_child] < values[right_child]
                        && values[left_child] < values[current]) {
                    System.out.println("Bytter " + current + " med " + left_child);
                    int tmp2 = values[left_child];
                    values[left_child] = values[current];
                    values[current] = tmp2;
                    current = left_child;
                }
                //Høyre barn er minst av barna, og mindre enn parent
                else if (right_child < last
                        && values[right_child] < values[left_child]
                        && values[right_child] < values[current]) {
                    System.out.println("Bytter " + current + " med " + right_child);
                    int tmp2 = values[right_child];
                    values[right_child] = values[current];
                    values[current] = tmp2;
                    current = right_child;
                }
                //Vi har funnet riktig plass til elementet.
                else {
                    break;
                }
                left_child = current*2;
                right_child = current*2 + 1;
            }
        }

        System.out.println("Array etter uttak: " + Arrays.toString(values));

    }

    static void heapify(int[] values) {
        for (int i=1; i<values.length; ++i) {

            int current = i;
            int parent = i / 2;

            while (parent > 0 && values[parent] > values[current]) {
                System.out.println("Bytter " + current + " med " + parent);
                int tmp = values[parent];
                values[parent] = values[current];
                values[current] = tmp;
                current = parent;
                parent = current / 2;
            }
        }
    }
}
