public class ArithmeticOperations {

    public static float add(float a, float b){
        return a + b;
    }

    public static float subtract(float a, float b){
        return a - b;
    }

    public static float multiply(float a, float b){
        return a * b;
    }

    public static float divide(float a, float b){
        return a/b;
    }

    public static void main(String[] args) {
        float x = 10;
        float y = 50;
        System.out.println(add(x,y));
        System.out.println(subtract(x,y));
        System.out.println(multiply(x,y));
        System.out.println(divide(x,y));
    }
}