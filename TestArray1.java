public class TestArray1 {

    public static void main(String[] args) {
        String[] names = {"USV", "USV2", "UMA", "SWOMY"}; // indexing starts at 0.
        String a = "abs";

        for (int i = 0; i < names.length; i += 1) {
            System.out.println(names[i] + " and position is " + i + a);
        }
    }
}
