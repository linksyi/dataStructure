package structure.recursion;

import structure.recursion.demo.EightQueen;
import structure.recursion.demo.Maze;

/**
 * @author My.ZuoY
 * @date 2019-08-05 22:04
 */
public class Main {

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.run(0);
        System.out.println("一共的结果数量:"+eightQueen.num);
    }
}
