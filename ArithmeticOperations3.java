public class ArithmeticOperations3 {
    public static void add(float a, float b){
        float result = a + b;
        System.out.println(result);
    }

    public static void subtract(float a, float b){
        float result = a - b;
        System.out.println(result);
    }

    public static void multiply(float a, float b){
        float result = a * b;
        System.out.println(result);
    }

    public static void divide(float a, float b){
        float result = a/b;
        System.out.println(result);
    }

    public static void main(String[] args) {
        float x = 10;
        float y = 50;
        add(x,y);
        subtract(x,y);
        multiply(x,y);
        divide(x,y);
    }
}
