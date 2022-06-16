package TestObjectClassMethods;

class ClassA{

    public void method1 (){
        System.out.println("Class A");
    }

    public void method2 (){}

    public static void method3 (){}

    public static void method4 (){
        System.out.println("Class A");
    }
}

class ClassB extends ClassA{

    //public static void method1 (){} // Static method cannot override instance method.

    public void method2(){
        System.out.println("Class B");
    }

    //public void method3 (){} // Instance method cannot override static method.

    public static void method4 (){
        System.out.println("Class B");
    }
}

public class TestOverrideHide {

    public static void main(String[] args){
        ClassA classA = new ClassA();
        ClassA classB = new ClassB();
        classA.method4();
        classB.method2();
        classB.method4();
    }


}
