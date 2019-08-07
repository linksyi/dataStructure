package structure.recursion;

/**
 * @author My.ZuoY
 * @date 2019-08-05 21:51
 * 通过递归完成在迷宫中寻找位置
 */
public class Maze {
    private int[][] mazeArr = new int[8][8];
    public Maze(){
        maze();
    }

    /**
     * 数组元素为1表示墙，数组元素为2表示行走路线，数组元素为-1表示已行走走不通，数组元素为0表示还没行走的方格
     * 怎么定义迷宫的墙可以自己定义
     */
    private void maze(){
        for(int i = 0; i < mazeArr.length; i++){
            mazeArr[0][i] = 1;
            mazeArr[7][i] = 1;
        }
        for (int i = 1; i < mazeArr.length - 1; i++){
            mazeArr[i][0] = 1;
            mazeArr[i][7] = 1;
        }
    }

    public void test(){
        for (int i = 0; i < mazeArr.length; i++) {
            for (int j = 0; j < mazeArr[i].length ; j++) {
                System.out.print(mazeArr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param i 当前纵坐标
     * @param j 当前横坐标
     */
    public void walk(int i,int j){
        if(mazeArr[6][6] == 2){
            return;
        }
        mazeArr[i][j] = 2;
        if(judge(i-1,j)){
            walk(i-1, j);
        }else if(judge(i,j+1)){
            walk(i,j+1);
        }else if(judge(i+1,j)){
            walk(i+1,j);
        }else if(judge(i,j-1)){
            walk(i,j-1);
        }else{
            mazeArr[i][j] = -1;
        }
    }

    public boolean judge(int i,int j){
        return mazeArr[i][j] == 0;
    }
}
