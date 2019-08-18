package structure.sorting;

import java.util.Arrays;

/**
 * @author My.ZuoY
 * @date 2019-08-18 20:57
 * 选择排序
 * 时间复杂度最好 O(n^2)  最坏  O(n^2)
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10000000);
        }
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
        arr[insertIndex+1] = insertVal;
        }
    }
}
