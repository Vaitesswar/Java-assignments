public class SummativeSums {

    public static int arrayAddition(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] array1 = { 999, -60, -77, 14, 160, 301 };
        int[] array2 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120,
                         130, 140, 150, 160, 170, 180, 190, 200, -99 };
        int sum = arrayAddition(array);
        int sum1 = arrayAddition(array1);
        int sum2 = arrayAddition(array2);
        System.out.println("#1 Array Sum: " + sum);
        System.out.println("#2 Array Sum: " + sum1);
        System.out.println("#3 Array Sum: " + sum2);
    }
}
