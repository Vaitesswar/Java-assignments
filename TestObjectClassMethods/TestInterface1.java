package TestObjectClassMethods;

import java.time.LocalDateTime;

interface dateTime {

    void reportDateTime();
}

class Singapore implements dateTime{

    Singapore(){};

    public void reportDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }
}

class London implements dateTime{

    London(){};

    public void reportDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }
}

class India implements dateTime{

    India(){};

    public void reportDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }
}

public class TestInterface1 {

    public static void main(String[] args){
        India india = new India();
        London london = new London();
        Singapore singapore = new Singapore();
        india.reportDateTime();
        london.reportDateTime();
        singapore.reportDateTime();
    }
}
