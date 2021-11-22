import java.util.Arrays;
import java.util.stream.Collectors;

public class SortingEx4 {

    public static void main(String[] args) {
        int[] unsorted = { 32, 23, 45, 87, 92, 31, 19 };

        System.out.println(Arrays.toString(insertSort(unsorted)));

        int[] data = { 8, 7, 2, 1, 0, 9, 6 };
        System.out.println("Unsorted Array");
        String toChange = "Unsorted Array";
        System.out.println(Arrays.toString(quickSort(data)));

        final String collect = Arrays.stream(toChange.split(" "))
                .map(SomeSolutionsEx2::reverseString)
                .collect(Collectors.joining(" "));
        System.out.println(collect);
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

    public static int[] quickSort(int arr[]){
        int low= 0;
        int high = arr.length-1;
        qSort(arr,low,high);
        return arr;
    }

    private static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            final int i = partionArr(arr, low, high);
            qSort(arr,low,i-1);
            qSort(arr,i+1,high);
        }
    }

    private static int partionArr(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;

        for (int j = low; j <high ; j++) {
            if(arr[j] <= pivot){
                int temp = arr[i+1];
                arr[i+1]= arr[j];
                arr[j]=temp;
                i++;
            }
        }
        i++;
        int moved= arr[i];
        arr[i]= arr[high];
        arr[high]=moved;
        return i;
    }



}
