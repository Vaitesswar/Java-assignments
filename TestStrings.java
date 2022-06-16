import java.util.Locale;

public class TestStrings {

    public static void main(String[] args) {

        String name = "U S Vaitesswar"; // String is a class.

        System.out.println(name);
        System.out.println(name.equals("vaitesswar"));
        System.out.println(name.substring(6)); // starting index
        System.out.println(name.charAt(6));
        System.out.println(name.toLowerCase(Locale.ROOT));
        System.out.println(name.toUpperCase(Locale.ROOT));
        System.out.println(name.substring(6,10)); // range
        System.out.println(name.length());
        System.out.println(name.concat("Baba"));
        System.out.println(name.contains("h"));
        System.out.println(name.endsWith("war"));
        System.out.println(name.indexOf("a"));
        System.out.println(name.lastIndexOf("s"));
        System.out.println(name.replace("e","b"));

        String record = "101,Rajesh,12345,New york";
        String[] array = record.split(",");
        for (String element:array){
            System.out.println(element);
        }

    }
}