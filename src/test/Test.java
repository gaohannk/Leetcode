package test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Math.PI;

public class Test {
    public static void main(String[] args) {
        List l = new ArrayList();
        l.add("1");
        l.add(1);
        System.out.println(l.get(0) instanceof Object);
        System.out.println(l.get(1) instanceof Object);

        System.out.println(LocalDate.now().toString());
        System.out.println(new SimpleDateFormat("yyyy-mm-dd").format(new Date()));
        System.out.println(PI);
        System.out.println("abc".getClass().getSimpleName());
        System.out.println("abc".getClass().getSimpleName());
        System.out.println("abc".substring(3,1));
        try{
            System.out.println("A");
            throw new Error();
        }catch (Exception e){
            System.out.println("B");
        }finally {
            System.out.println("C");
        }

    }

}
