package structure.recursion.demo;

/**
 * @author My.ZuoY
 * @date 2019-08-07 20:33
 * 递归解决八皇后问题
 */
public class EightQueen {
    /**
     * 一共多少个皇后
     */
    private final int max = 8;
    /**
     * 一共有多少个结果
     */
    public int num = 0;
    /**
     * 结果，定义成一维数组是因为下标可以代表行，元素代表纵坐标的值，从而将二维数组省略成一维数组
     */
    private int[] result = new int[max];

    /**
     * 判断棋能否下在当前位置
     *
     * @param n 代表当前下的是第几个棋
     * @return
     */
    private boolean judge(int n) {
        //判断这枚旗前面的所有旗
        for (int i = 0; i < n; i++) {
            /**
             * result[i] == result[n] 判断是否在同一列
             * Math.abs(i - n) == Math.abs(result[i] - result[n])  判断是否在同一斜线
             */
            if (result[i] == result[n] || Math.abs(i - n) == Math.abs(result[i] - result[n])) {
                return false;
            }
        }
        return true;
    }

    public void run(int n) {
        if (n == max) {
            print();
            num++;
            return;
        }

        for (int i = 0; i < max; i++) {
            result[n] = i;
            if (judge(n)) {
                run(n + 1);
            }
        }
    }

    /**
     * 打印结果
     */
    private void print() {
        for (int i = 0; i < result.length; i++) {
            if (i != result.length - 1) {
                System.out.print(result[i] + " ，");
            } else {
                System.out.print(result[i]);
            }
        }
        System.out.println();
    }

}
