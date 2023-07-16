package cpay_2;

public class Solution_3 {

    public static int[] mergeSort(int[] arr, int n) {
        if (n == 1) return arr;

        int mid = n / 2;
        int leftSize = n % 2 > 0 ? mid + 1 : mid;
        int rightSize = mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        int[] total = new int[n];
        for (int i = 0; i < n; i++) {
            total[i] = arr[n-1-i];
        }
        for (int i = 0; i < leftSize; i++) {
            left[i] = total[i];
        }
        for (int i = leftSize; i < n; i++) {
            right[i - leftSize] = total[i];
        }
        return merge(mergeSort(left, leftSize), mergeSort(right, rightSize));
    }

    public static int[] merge(int[] left, int [] right) {
        int len = left.length + right.length;
        int arr[] = new int[len];
        int index = 0;
        for (int i = 0; i < left.length; i++) {
            arr[index++] = left[i];
        }
        for (int i = 0; i < right.length; i++) {
            arr[index++] = right[i];
        }
        return arr;
    }

    public static int[] solution(int[] arr) {
        int answer[] = mergeSort(arr, arr.length);
        return answer;
    }
}
