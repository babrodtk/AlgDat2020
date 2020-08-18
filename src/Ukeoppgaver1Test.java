import static org.junit.jupiter.api.Assertions.*;

class Ukeoppgaver1Test {

    @org.junit.jupiter.api.Test
    void min() {
        int[] a = {8, 4, 17, 10, 6, 20, 1, 11, 15, 3, 18, 9, 2, 7, 19};

        int minimum = Ukeoppgaver1.min(a);

        assertEquals(6, minimum);
        assertEquals(1, a[minimum]);

        //Test for alle permutasjoner for 4 tall.
        {
            int[][] a4 = {
                    {1, 2, 3, 4},{1, 2, 4, 3},{1, 3, 2, 4},{1, 3, 4, 2},{1, 4, 2, 3},{1, 4, 3, 2},
                    {2, 1, 3, 4},{2, 1, 4, 3},{2, 3, 1, 4},{2, 3, 4, 1},{2, 4, 1, 3},{2, 4, 3, 1},
                    {3, 2, 1, 4},{3, 2, 4, 1},{3, 1, 2, 4},{3, 1, 4, 2},{3, 4, 2, 1},{3, 4, 1, 2},
                    {4, 2, 3, 1},{4, 2, 1, 3},{4, 3, 2, 1},{4, 3, 1, 2},{4, 1, 2, 3},{4, 1, 3, 2}
            };
            int expected[] = {
                    0, 0, 0, 0, 0, 0,
                    1, 1, 2, 3, 2, 3,
                    2, 3, 1, 1, 3, 2,
                    3, 2, 3, 2, 1, 1
            };

            for (int i=0; i<a4.length; ++i) {
                assertEquals(expected[i], Ukeoppgaver1.min(a4[i]));
            }
        }

        //Test corner cases - "Spesialtilfeller"
        int[] b = {1, 4, 17, 10, 6, 20, 8};
        assertEquals(0, Ukeoppgaver1.min(b));

        int[] c = {8, 4, 17, 10, 6, 20, 1};
        assertEquals(6, Ukeoppgaver1.min(c));

    }
}