package structure.sorting;

import java.util.Arrays;

/**
 * @author My.ZuoY
 * @date 2019-08-25 19:15
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10000000);
        }
//        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6, 0};
        int[] temp = new int[arr.length];
        long start = System.currentTimeMillis();
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
        System.out.println(System.currentTimeMillis() - start);
    }


    /**
     * 先将数组分开然后在排序合并
     *
     * @param arr   待排序数组
     * @param left  左索引
     * @param right 右索引
     * @param temp  临时数组
     */
    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left > right || arr.length <= 1 || temp.length < arr.length) {
            return;
        }
        int mid = (left + right) / 2;

        if (left < right) {
            //向左分解
            mergeSort(arr, left, mid, temp);
            //向右分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, right, mid, temp);
        }
    }

    /**
     * 将分好的数组合并然后放入临时数组temp
     *
     * @param arr   数组
     * @param left  左坐标
     * @param right 右坐标
     * @param mid   中间值
     * @param temp  临时数组
     */
    public void merge(int[] arr, int left, int right, int mid, int[] temp) {
        //初始化值 start左数组起始索引  end右数组起始索引  tempIndex临时组数索引
        int start = left;
        int end = mid + 1;
        int tempIndex = 0;

        //将数组赋进临时数组
        while (start <= mid && end <= right) {
            if (arr[start] <= arr[end]) {
                temp[tempIndex] = arr[start];
                start++;
                tempIndex++;
            } else {
                temp[tempIndex] = arr[end];
                end++;
                tempIndex++;
            }
        }

        //将剩余数依次方静临时数组
        while (start <= mid) {
            temp[tempIndex] = arr[start];
            start++;
            tempIndex++;
        }
        while (end <= right) {
            temp[tempIndex] = arr[end];
            end++;
            tempIndex++;
        }

        //将临时数组赋进原始数组中
        tempIndex = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[tempIndex];
            tempIndex++;
            tempLeft++;
        }
    }
}
