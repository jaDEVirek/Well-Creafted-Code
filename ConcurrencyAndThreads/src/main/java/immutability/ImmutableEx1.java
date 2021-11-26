package immutability;

import java.util.Collections;
import java.util.List;

public class ImmutableEx1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        String str1 = "Java";
        String str2 = new String("Java");
        String str3 = str2;
        System.out.println(str3);

        CloningExp cloningExp = new CloningExp("Wiktor",20,new Interest("Interes"));
        final int i = cloningExp.age.hashCode();
        System.out.println(i);
        System.out.println(cloningExp.hashCode());
        System.out.println(cloningExp.name.hashCode());
        final CloningExp cloningExp1 = new CloningExp(cloningExp);
        System.out.println(cloningExp1.name.hashCode());
        cloningExp1.name= "Tom";
        System.out.println(cloningExp.name);
        CloningExp cloningExp3 = (CloningExp) cloningExp1.clone();
        System.out.println(cloningExp3.name);
//        cloningExp3.name="Tom2";//
        System.out.println(cloningExp1.name);
        System.out.println(cloningExp3.name);
        System.out.println(cloningExp3 == cloningExp1);
        System.out.println(cloningExp3.name == cloningExp1.name);
        System.out.println(cloningExp1.interest.hashCode());
        System.out.println(cloningExp3.interest.hashCode());
        cloningExp3.interest.name="Zmiana";
        System.out.println(cloningExp1.interest.name);

    }

    private static class Interest {
        String name;

        public Interest(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    final class Address {
        /* street, city declaration */
        private final List<String> items1;
        private final List<String> items2;
        private final String street;
        private final String city;

        public Address(String street, String city, List<String> items1, List<String> items2) {
            this.street = street;
            this.city = city;
            this.items1 = Collections.unmodifiableList(items1); //immutable
            this.items2 = items2; //mutable
        }

        /* street, city getters */
        public List<String> getItems1() {
            return items1;
        }

        public List<String> getItems2() {
            return Collections.unmodifiableList(items2); // get as immutable
        }
    }

    static class CloningExp implements Cloneable {
        private String name;
        private Integer age;
        private Interest interest;

        public CloningExp(String name, Integer age, Interest interest) {
            this.name = name;
            this.age = age;
            this.interest = interest;
        }

        @Override public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
        //        @Override public Object clone() throws CloneNotSupportedException {
//            final CloningExp clone = (CloningExp) super.clone();
//           // clone.interest = new Interest(interest.getName());
//            return clone;
//        }

        /**
         * Wzorzec projektowy copy constructor to jedna z częściej wybieranych alternatyw dla klonowania obiektów. W tym wzorcu jeden z konstruktorów klasy przyjmuje obiekt, na podstawie którego inicjowany jest wewnętrzny stan obiektu. Nowo tworzony obiekt i obiekt przekazywany jako argument są zazwyczaj tego samego typu, jednak nie jest to wymóg.
         */
        public CloningExp(CloningExp copyCloning) {
            //kopiowanie płytkie (shallow copy),
            this.name = copyCloning.name;
            this.age = copyCloning.age;
            this.interest = copyCloning.interest; // shallow
            this.interest = new Interest(copyCloning.interest.name); // deep
        }
    }
}
