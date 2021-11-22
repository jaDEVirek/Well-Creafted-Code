package immutability;

import java.util.Collections;
import java.util.List;

public class ImmutableEx1 {

    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = new String("Java");
        String str3 = str2;
        System.out.println(str3);
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
            this.items1 = Collections.unmodifiableList(items1);
            this.items2 = items2;
        }

        /* street, city getters */
        public List<String> getItems1() {
            return items1;
        }

        public List<String> getItems2() {
            return Collections.unmodifiableList(items1);
        }
    }

    public class DeepClone extends Object implements Cloneable {
        @Override public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
