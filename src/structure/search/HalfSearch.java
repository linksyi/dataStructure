package structure.search;

/**
 * @author My.ZuoY
 * @date 2019-08-27 10:09
 * 折半查找
 */
public class HalfSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        HalfSearch halfSearch = new HalfSearch();
        System.out.println(halfSearch.halfSearch(arr, 0, arr.length - 1, 0));
    }

    /**
     *
     * @param arr 有序数组
     * @param left  左索引
     * @param right 右索引
     * @param value 需要查找的值
     * @return  返回值所在下标，-1没找到
     */
    public int halfSearch(int[] arr, int left, int right, int value) {
        if(left>right){
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] < value) {
            return halfSearch(arr,mid+1,right,value);
        }else if(arr[mid] > value){
            return halfSearch(arr,left,mid-1,value);
        } else{
            return mid;
        }
    }
}
