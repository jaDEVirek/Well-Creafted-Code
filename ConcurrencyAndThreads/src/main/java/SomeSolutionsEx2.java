import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SomeSolutionsEx2 {


    public static void main(String[] args) {
        final int i = elFibbonaci(30);
        System.out.println(i);
        System.out.println(isPalindrome("BaooaB"));
        System.out.println(isPrime(7));
        System.out.println(isArmstrongNumb(153));
        System.out.println(reverseString("Alan"));
        final int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binaryFinderWithSort(ints, 6));

    }


    //trivial
    static int elFibbonaci(int n) {
        if (n == 2 || n == 1) {
            return 1;
        } else {
            return elFibbonaci(n - 1) + elFibbonaci(n - 2);
        }
    }

    static boolean isPrime(int numb) {
        if (numb == 0 || numb == 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(numb) + 1; i++) {
            if (numb % i == 0) return false;
        }
        return true;
    }

    static boolean isPalindrome(String str) {
        return IntStream.rangeClosed(0, str.length() / 2)
                .allMatch(t -> str.charAt(t) == str.charAt(str.length() - t - 1));
        //minus one at the end, because
    }

    static boolean isArmstrongNumb(int numb) {
        int total = 0;
        int digit;
        int save = numb;

        while (numb != 0) {
            digit = numb % 10;
            total = total + digit * digit * digit;
            numb /= 10;
        }
        System.out.println(numb);
        System.out.println(total);
        return total == save;
    }

    static String reverseString(String str) {

        final String collect = IntStream.range(0, str.length())
                .map(i -> str.length() - 1 - i)
                .mapToObj(idx -> String.valueOf(str.charAt(idx)))
                .collect(Collectors.joining());

        final char[] chars = str.toCharArray();
        final String secondCollect = IntStream.range(0, chars.length)
                .mapToObj(i -> String.valueOf(chars[chars.length - 1 - i]))
                .collect(Collectors.joining());
        System.out.println(secondCollect);
        System.out.println(secondCollect.equals(collect));
        return collect;
    }

    static int binaryFinderWithSort(int[] arr, int number) {
        Arrays.sort(arr);
        int less = 0;
        int tail = arr.length - 1;

        while (tail > less) {
            int mid = (less + tail) / 2;
            if (arr[mid] == number) {
                return mid; //return index of number
            } else if (arr[mid] < number) {
                less = mid + 1;   // cut left side
            } else if (arr[mid] > number) {
                tail = mid - 1;  // cut right side
            }
        }
        return -1; // not found
    }

    static boolean isAnagram(String str1, String str2) {
        final char[] chars1 = str1.toCharArray();
        final char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1,chars2) & !str1.equals(str2);
    }
}
