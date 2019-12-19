package test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List l = new ArrayList();
        l.add("1");
        l.add(1);
        System.out.println(l.get(0) instanceof Object);
        System.out.println(l.get(1) instanceof Object);

    }

}
