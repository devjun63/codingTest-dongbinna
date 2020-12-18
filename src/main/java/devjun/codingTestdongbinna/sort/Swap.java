package devjun.codingTestdongbinna.sort;

public class Swap {
    public int[] swapIntvalue(int[] arr){
        int temp = arr[0];
        arr[0] =  arr[1];
        arr[1] = temp;
        return arr;
    }
}
