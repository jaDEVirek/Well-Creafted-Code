import java.util.Arrays;

public class SortingEx4 {

    public static void main(String[] args) {
        int[] unsorted = { 32, 23, 45, 87, 92, 31, 19 };

        System.out.println(Arrays.toString(insertSort(unsorted)));
    }


    public static int[] insertSort(int []arr){

        for (int i = 1; i <arr.length ; i++) {
            final int actual = arr[i];
            int j = i;
            while(j>0 && arr[j-1] > actual){
                arr[j]= arr[j-1];
                j--;
            }
            arr[j]= actual;
        }
        return arr;
    }

}
