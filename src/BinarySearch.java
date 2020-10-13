public class BinarySearch {
    public static void main(String[] args) {
        int values[] = {1, 2, 4, 8, 17, 19, 22};

        for (int i=0; i<25; ++i) {
            System.out.println(i + " - " + binarySearch(i, values, 0, values.length-1));
        }
    }

    //Search in the interval [left, right]
    static int binarySearch(int search_value, int[] values, int left, int right) {
        int middle = (left + right) / 2;

        if  (right - left == 0) {
            if (values[middle] == search_value) {
                return middle;
            }
            else {
                return -middle;
            }
        }

        if (values[middle] <= search_value) {
            if (values[middle] == search_value) {
                return middle;
            }
            return binarySearch(search_value, values, middle+1, right);
        }
        else {
            return binarySearch(search_value, values, left, middle-1);
        }
    }
}
