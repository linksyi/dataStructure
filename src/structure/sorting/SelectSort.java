package structure.sorting;

import java.util.Arrays;

/**
 * @author My.ZuoY
 * @date 2019-08-10 22:10
 * 选择排序
 * 时间复杂度最好 O(n^2)  最坏  O(n^2)
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10000000);
        }
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void selectSort(int[] arr){

        for (int i = 0; i < arr.length -1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(min > arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }
            if(min != arr[i]){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
