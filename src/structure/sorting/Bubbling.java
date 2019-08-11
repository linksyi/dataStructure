package structure.sorting;

import java.util.Arrays;

/**
 * @author My.ZuoY
 * @date 2019-08-10 16:00
 *  冒泡排序
 *  时间复杂度最好 O(n)  最坏  O(n^2)
 */
public class Bubbling {

    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10000000);
        }
        Bubbling bubbling = new Bubbling();
        bubbling.bubbling1(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    private void bubbling(int[] arr){
        int temp;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                num++;
                if(arr[i] > arr[j]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println(num);
    }


    private void bubbling1(int[] arr){
        int temp;
        int num = 0;

        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length -1 -i; j++) {
                num++;
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(num);
    }
}
