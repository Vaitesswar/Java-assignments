class Parent {
    Parent(){}

    /// Overloading method within same class
    public void myIntro(int x) {
        System.out.println("Parent");
    }

    public void myIntro1(int x, int y) {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    Child(){}
    /// Overrides method from parent class
    public void myIntro(int x) {
        System.out.println("Child");
    }


    /// Overloading method across parent-child classes
    public void myIntro(int x, int y, int z) {
        System.out.println("Child");
    }

}

public class TestOOPs8 {

    public static void main(String[] args){
        Child child = new Child();
        child.myIntro(5); /// Overrides method from parent class
        Parent child1 = new Child();
        child1.myIntro(10); /// Overrides method from parent class
        Parent child2 = new Parent();
        child2.myIntro(15); /// Calls parent class
        Parent child3 = new Parent();
        child3.myIntro1(15,30); /// Overloading method across parent-child classes
    }
}