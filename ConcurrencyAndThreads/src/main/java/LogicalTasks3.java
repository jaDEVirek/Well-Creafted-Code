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
        System.out.println(firstNonRepeatable("swwfiiss", false));
        permutations("123");
        String str2 = "Testowo";
        System.out.println(str2.hashCode());
        final String substring = str2.substring(0, 3);
        System.out.println(substring.hashCode());
        str2=substring + "s";
        final String t = substring.concat("t");
        System.out.println(str2.hashCode());
        System.out.println(substring);
        System.out.println(str2);
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

        if (!ismap) {


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
            return characterQueue.peek()
                    .toString();
        } else {
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

    private static int[] bubbleSort(int[] arr) {
        final int length = arr.length;
        boolean changed = false;
        for (int i = 0; i < length - 1; i++) {
            int curr = arr[i];
            int next = arr[i + 1];
            if (curr > next) {
                arr[i] = next;
                arr[i + 1] = curr;
                changed = true;
            }
        }
        return changed ? bubbleSort(arr) : arr;
    }

    public static void permutations(String str) {
        permutate("", str);
    }

    private static void permutate(String prev, String str) {
        int last = str.length();
        if(last == 0){
            System.out.println("Permutation:  "+prev );

        }else
        for (int i = 0; i < last; i++) {
           permutate(prev+str.charAt(i),str.substring(0,i) + str.substring(i+1,last));
        }
    }
}
