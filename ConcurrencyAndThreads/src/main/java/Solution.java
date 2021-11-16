import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        ArrayList<Integer> integers2 = new ArrayList<>(List.of(1,2,3,4,4,5,6,7,8));
        System.out.println(shift2(integers2,3,8));
    }


    public static List<Integer> shift(List<Integer> al, int possition, int value) {
        final Integer last = al.get(al.size() - 1);
        for (int i = al.size()-possition-2; i >= 0; --i)
                al.set(possition + i + 1, al.get(possition + i));
        al.set(possition,value);
        al.add(last);
        return al;
    }

    public static List<Integer> shift2(List<Integer> al, int possition, int value) {
        final Integer last = al.get(al.size() - 1);
        for (int i = al.size()-possition-2; i >= 0; --i)
            al.set(possition + i + 1, al.get(possition + i));
        al.set(possition,value);
        al.add(last);
        return al;
    }
}

