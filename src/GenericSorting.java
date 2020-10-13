import java.util.Arrays;

public class GenericSorting {

    public static class Person implements Comparable<Person> {
        String first_name;
        String last_name;

        Person(String first_name, String last_name) {
            this.first_name = first_name;
            this.last_name = last_name;
        }

        public int compareTo(Person other) {
            int last_compare = this.last_name.compareTo(other.last_name);
            if (last_compare == 0) {
                return this.first_name.compareTo(other.first_name);
            }
            else {
                return last_compare;
            }
        }

        public String toString() {
            return first_name + " " + last_name;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 8, 9, 18, 98, 2, 3, 9};
        Character[] b = {'A', 'C', 'K', 'Z', 'L', 'Y', 'M'};
        String[] c = {"ASF", "Kari", "poteter", "lammelår", "eple", "Petter"};
        Person[] d = {new Person("Petter", "Pettersen"), new Person("Kari", "Pettersen"), new Person("Nils", "Abrahamsen"), new Person("Tor", "Toresen")};

        int person_max_index = maks(d, 0, d.length);
        System.out.println("Siste person, leksikografisk, er " + d[person_max_index]);

        System.out.println("Sorterer personer");
        System.out.println("Før: " + Arrays.toString(d));
        sort(d);
        System.out.println("Etter: " + Arrays.toString(d));
    }

    static
    <T extends Comparable<? super T>>
    void sort(T[] values) {
        //Looper over alle unntatt siste element.
        for (int i=0; i<values.length-1; ++i) {
            //Finn største element i intervallet [i, a.length)
            int max_index = maks(values, i, values.length);

            //bytt største element til posisjon i
            T temp = values[i];
            values[i] = values[max_index];
            values[max_index] = temp;
        }
    }

    static
    <T extends Comparable<? super T>>
    int maks(T[] values, int begin, int end) {
        T current_max = values[begin];
        int current_index = begin;

        for (int i=begin+1; i<end; ++i) {
            //if (values[i] > current_max) {
            if (values[i].compareTo(current_max) > 0) {
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }

}
