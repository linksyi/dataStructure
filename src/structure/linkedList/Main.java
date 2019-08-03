package structure.linkedList;

import structure.linkedList.Demo.DoubleLinkedListDemo;
import structure.linkedList.Demo.SingleChainDemo;

/**
 * @author: Mr.ZuoY
 * @create: 2019-07-21 20:07
 **/
public class Main {

    public static void main(String[] args) {
        DoubleLinkedListDemo<String> demo = new DoubleLinkedListDemo<>();
        demo.add("1");
        demo.add("2");
        demo.add("3");
        demo.add("4");
        demo.add("5");
        demo.printlnAll();

    }
}
