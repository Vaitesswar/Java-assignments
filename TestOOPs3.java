import java.util.Scanner;

class Person {

    int age;
    String name;

    Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public void getIntro() {
        System.out.println("I am " + name);
    }

}

public class TestOOPs3 {

    public static void canOrCannotVote(Person person) {
        if (person.age > 21) {
            System.out.println("You can vote.");
        } else {
            System.out.println("You cannot vote.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please key in your age.");
        int age = sc.nextInt();
        System.out.println("Please key in your name.");
        String name = sc.next();

        Person person = new Person(age, name);
        canOrCannotVote(person);
    }
}
