import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LogicalTasks3 {


    public static void main(String[] args) {
//        System.out.println(reverseNumber(6));
//        System.out.println(firstNonRepeatable("swiss"));
        char ch = 'x';
        System.out.println(ch - 'a');
//        final Character swiss = usingMap("swiss");
//        System.out.println(swiss);
        System.out.println(firstNonRepeatable("swwiiss",false));
    }


    static int reverseNumber(int number) {
        int temp = 0;
        int reversed = 0;
        if (number == 0) {
            return 0;
        }
        while (number > 0) {
            temp = number % 10;
            reversed = reversed * 10 + temp;
            number /= 10;
        }
        return reversed;
    }

    static String firstNonRepeatable(String str, boolean ismap) {

       if(!ismap){


        int charsNumb[] = new int[25];
        Queue<Character> characterQueue = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            characterQueue.add(ch);

            charsNumb[ch - 'a']++; //increase index for character ch it will be 'value' - 97

            while (!characterQueue.isEmpty()) {
                if (charsNumb[characterQueue.peek() - 'a'] > 1) {
                    characterQueue.remove();
                } else {
                    break;
                }
            }
        }
           assert characterQueue.peek() != null;
           return characterQueue.peek().toString();
       }else{
           return usingMap(str);
       }
    }

    private static String usingMap(String str) {
        return String.valueOf(str.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get());
    }



}
