public class TestArray2 {
    public static void main(String[] args) {

        System.out.println(" ");
        System.out.println("Falling stars");
        for (int i = 5; i > 0; i -= 1){
            StringBuilder str = new StringBuilder();
            for (int j = 1; j <= i; j += 1){
                str.append("*");
            }
            System.out.println(str);

        }
        System.out.println(" ");
        System.out.println("Rising stars");
        for (int i = 1; i <= 5; i += 1){
            StringBuilder str = new StringBuilder();
            for (int j = 1; j <= i; j += 1){
                str.append("*");
            }
            System.out.println(str);


        }

        System.out.println(" ");
        System.out.println("Christmas Tree");
        int[] array = {6,5,4,3,2,1,5,5,5};
        for (int i : array) {
            StringBuilder str = new StringBuilder();
            for (int j = 1; j <= i; j += 1) {
                str.append(" ");
            }
            for (int j = 1; j <= 13 - 2 * i; j += 1) {
                str.append("*");
            }
            for (int j = 1; j <= i; j += 1) {
                str.append(" ");
            }
            System.out.println(str);
        }
    }
}
