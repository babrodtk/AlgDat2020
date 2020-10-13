import java.util.Arrays;

public class RecursivePermutation {

    public static void main(String[] args) {
        System.out.println("Recursive permutations!");

        int values[] = {1, 2, 3};
        recursive_permutation(values, 0);
    }



    public static void recursive_permutation(int[] values, int k) {
        if (k == values.length-1) {
            System.out.println(Arrays.toString(values));
        }

        for (int i=k; i<values.length; ++i) {
            swap(values, i, k);
            recursive_permutation(values, k+1);
            swap(values, k, i);
        }
    }












    public static void swap(int[] values, int m, int n) {
        //eksempel: m = 2, n=3
        //tmp = values[2]
        int tmp = values[m];

        //values[2] = values[3]
        values[m] = values[n];

        //values[3] = tmp = values[2]
        values[n] = tmp;
    }
}




































