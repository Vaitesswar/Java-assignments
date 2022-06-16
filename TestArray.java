// Array - collection of similar items

public class TestArray {
    public static void main(String[] args){
        int x = 10;
        int[] numbers = {1,2,3,4,5,6}; // indexing starts at 0.

        for (int i = 0; i < numbers.length; i += 1){
            System.out.println(numbers[i] + " and position is " + i);
        }
    }
}
