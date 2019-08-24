package structure.sorting;

import java.util.Arrays;

/**
 * @author My.ZuoY
 * @date 2019-08-24 12:38
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10000000);
        }
//        int[] arr = {2, 4, 6, 1, 7, 8, 3, 9};
        QuickSort quicksort = new QuickSort();
        Long start = System.currentTimeMillis();
        quicksort.quickSort(arr, 0, arr.length - 1);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int left, int right) {
        //使用第一个值做起点，先找到最小的值，放置第一位
        int pivot = arr[left];
        //左坐标
        int start = left;
        //右坐标
        int end = right;
        while (start < end) {
            //找需要替换的值，没找到，右坐标向左移一步
            while ((start < end) && (arr[end] > pivot)) {
                end--;
            }
            //找需要替换的值，没找到，左坐标向右移一步
            while ((start < end) && (arr[start] < pivot)) {
                start++;
            }
            //如果两个值相等，左坐标移动，否则两个元素替换位置
            if ((arr[start] == arr[end]) && (start < end)) {
                start++;
            } else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        //如果循环中的左坐标大于起始左坐标，则递归起始左坐标与左坐标-1之间的元素排序
        if (start - 1 > left) {
            quickSort(arr, left, start - 1);
        }
        //如果循环中的右坐标小于起始右坐标，则递归起始右坐标+1与右坐标之间的元素排序
        if (end + 1 < right) {
            quickSort(arr, end + 1, right);
        }
    }
}
