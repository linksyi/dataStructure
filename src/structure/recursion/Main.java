package structure.recursion;

import structure.recursion.demo.Maze;

/**
 * @author My.ZuoY
 * @date 2019-08-05 22:04
 */
public class Main {

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.walk(1, 1);
        maze.print();
    }
}
