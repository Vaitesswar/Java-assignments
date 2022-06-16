public class HelloMyWorld2 {
    // creating function
    public static void addition(int a, int b){
        int result = a + b;
        System.out.println(result);
    }

    public static void main(String[] args){
        int x = 20; // variable named 'x' contains a value of 20.
        x = 30; // reassignment
        int y = 90;
        // calling function
        addition(x,y);
        addition(5,10);
    }
}
