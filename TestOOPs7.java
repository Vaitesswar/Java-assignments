// inheritance <- parent-child relationship
//

import java.util.Random;

class Calculator2 {

    private int x; /// variable x (attribute of object)
    private int y;

    /// Constructor overloading (Many constructors (initialization) for the same class)
    public Calculator2(){}

    public Calculator2(int x, int y) { /// value to set for variable x.
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int add(int a, int b){
        int sum = a + b;
        return sum;
    }

    public int subtract(int a, int b){
        int out = a - b;
        return out;
    }

}

class SciCalculator extends Calculator2 { /// Inheritance

    private int z;

    SciCalculator(){}

    SciCalculator(int x, int y, int z){ // values to be assigned
        super(x,y); // variables x and y from parent object
        this.z = z;
    }

    public void areaCalc(){
        System.out.println("Advanced area calculation ");
    }
}

public class TestOOPs7 {

    public static void main(String[] args){
        Calculator2 calculator = new Calculator2();
        SciCalculator calculator1 = new SciCalculator();
        System.out.println(calculator.add(1,2));
        System.out.println(calculator1.add(5,10));
        calculator1.areaCalc();

        Random rand = new Random();
        int computer = rand.nextInt(3);
        System.out.println(computer);

    }
}
