package structure.search;

/**
 * @author My.ZuoY
 * @date 2019-08-27 09:38
 * 线性查找
 */
public class OrderSearch {
    public static void main(String[] args) {
        OrderSearch orderSearch = new OrderSearch();
        int[] arr = {2,4,5,6,7,8,9,10};;
        System.out.println(orderSearch.orderSearch(arr, 5));
    }


    /**
     *
     * @param arr 数组
     * @param value 查询的值
     * @return 返回下标，没找到返回-1
     */
    public int orderSearch(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
