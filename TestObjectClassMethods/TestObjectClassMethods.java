package TestObjectClassMethods;

import java.util.Objects;

class Person{
    private int ssn;
    private String name;

    public Person(int ssn, String name) {
        this.ssn = ssn;
        this.name = name;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    @Override
    public String toString() { /// String representation of the object.
        return "Person{" +
                "ssn=" + ssn +
                ", name='" + name + '\'' +
                '}';
    }
     */

    // Specifically telling the program to compare based on the properties of the objects.
    // Compulsory since 2 different objects may have same hashcode. Hence, hashcode alone is not sufficient for comparison.
    // Are 2 objects equivalent?
    @Override // Overriding means replacing an existing method. That is why output for comparison changes.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return ssn == person.ssn && Objects.equals(name, person.name);
    }

    @Override // Overriding means replacing an existing method.  That is why output for comparison changes.
    public int hashCode() { // Specifically telling the program to hash based on ssn and name (stored in same container).
        return Objects.hash(ssn, name);
    }

}

public class TestObjectClassMethods {
    public static void main(String[] args) {
        Person p1 = new Person(101, "USV");
        Person p2 = new Person(101, "USV");
        System.out.println(p1); // Without toString enabled, hashCode is shown (hashing: data structure) Hashing is for searching efficiency.
        System.out.println(p2);
        int x = 50;
        String y = String.valueOf(x);
        int z = Integer.valueOf(y);
        float a = Float.valueOf(z);
        System.out.println(y + " " + y.getClass().getSimpleName());
        System.out.println(z + " " + ((Object)z).getClass().getSimpleName()); /// .getClass().getSimpleName() works only for objects
        System.out.println(z + " " + ((Object)a).getClass().getSimpleName());
        System.out.println(p1.equals(p2)); /// Comparing objects literally (point of comparison can be modified by equals function)
        System.out.println(p1.toString().equals(p2.toString())); /// Comparing string representation of objects
    }

}
