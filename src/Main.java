import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[]sortArr = {5, 1, 4, 10, 56, 2, 7, 11, 0, 7, 13};
        heapSort(sortArr);
        System.out.println(Arrays.toString(sortArr));
    }
    private static void change(int[]sortArr, int i, int j){
        int temp = sortArr[i];
        sortArr[i] = sortArr[j];
        sortArr[j]=temp;
    }
    private static void heapify(int[]sortArr, int i, int n){
        int left = 2*i+1;
        int right = 2*i+2;
        int large = i;
        if (left<n && sortArr[left]>sortArr[i]){
            large = left;
        }
        if (right<n && sortArr[right]>sortArr[large]){
            large = right;
        }
        if (large != i){
            change(sortArr, i, large);
            heapify(sortArr, large, n);
        }
    }
    public static void heapSort(int[]sortArr){
        int n = sortArr.length;
        int i = n/2-1;
        while (i >= 0){
            heapify(sortArr, i--, n);
        }
        while (n > 0){
            int top = sortArr[0];
            sortArr[0] = sortArr[n-1];
            heapify(sortArr, 0, n-1);
            sortArr[n-1] = top;
            n--;
        }
    }
}