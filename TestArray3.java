import java.util.Arrays;

public class TestArray3 {
    // Bubble sort
    public static int[] ascend(int[] a) {
        boolean sorted = Boolean.FALSE;
        while (sorted != Boolean.TRUE) {
            sorted = Boolean.TRUE;
            for (int i = 0; i < a.length - 1; i += 1) {
                if (a[i] > a[i + 1]) {
                    int x = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = x;
                    sorted = Boolean.FALSE;
                }
            }
        }
        return a;
    }

    public static int[] descend(int[] b) {
        boolean sorted = Boolean.FALSE;
        while (sorted != Boolean.TRUE) {
            sorted = Boolean.TRUE;
            for (int i = 0; i < b.length - 1; i += 1) {
                if (b[i] < b[i + 1]) {
                    int x = b[i];
                    b[i] = b[i + 1];
                    b[i + 1] = x;
                    sorted = Boolean.FALSE;
                }
            }
        }
        return b;
    }


    public static void main(String[] args) {
        System.out.println("Question 4");
        int[] array = {2, 3, 55, 65, 42, 67};

        for (int j : array) {
            if (j % 2 == 0) {
                System.out.println(j);
            }
        }
        System.out.println(" ");
        System.out.println("Question 5");
        int[] even_array = new int[25];
        int[] odd_array = new int[25];
        int even = 0;
        int odd = 0;

        for (int i = 1; i <= 50; i += 1) {
            if (i % 2 == 0) {
                even_array[even] = i;
                even += 1;
            } else {
                odd_array[odd] = i;
                odd += 1;
            }
        }
        System.out.println("Even numbers: " +Arrays.toString(even_array));
        System.out.println("Odd numbers: " +Arrays.toString(odd_array));

        System.out.println(" ");
        System.out.println("Question 6");
        int[] a = {2, 34, 56, 12, 34, 1, 5};
        int[] b = {2, 34, 56, 12, 34, 1, 5};
        int[] ascend_a = ascend(a);
        int[] descend_b = descend(b);
        System.out.println("Ascending order: " + Arrays.toString(ascend_a));
        System.out.println("Descending order: " + Arrays.toString(descend_b));

        float abx = 20.01f;
    }
}