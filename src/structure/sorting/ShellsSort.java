package structure.sorting;

import java.util.Arrays;

/**
 * @author My.ZuoY
 * @date 2019-08-21 09:12
 * 希尔排序
 */
public class ShellsSort {
    public static void main(String[] args) {
//        int[] arr = new int[10000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int)(Math.random() * 10000000);
//        }
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        Long start = System.currentTimeMillis();
        ShellsSort shellsSort = new ShellsSort();
//        shellsSort.exchange(arr);
        shellsSort.displacement(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(System.currentTimeMillis() - start);
    }


    /**
     * 交换法
     *
     * @param arr 待排序数组
     */
    public void exchange(int[] arr) {
        //每次取数组长度的一半去做插入排序
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            //循环数组
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                /**
                 * i - gap >= 0 防止数组越界
                 * arr[i] < arr[i - gap]判断数组是否需要排序
                 */
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //交换法
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                    //继续判断之间的元素
                    j -= gap;
                }
            }
        }
    }

    /**
     * 移位法
     *
     * @param arr 待排序数组
     */
    public void displacement(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {

                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
