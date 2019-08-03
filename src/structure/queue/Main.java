package structure.queue;

import structure.queue.demo.AnnularQueueDemo;

public class Main {

    public static void main(String[] args) {
        AnnularQueueDemo<Integer> queueDemo = new AnnularQueueDemo<>();
        queueDemo.add(10);
        queueDemo.add(20);
        queueDemo.add(30);
        queueDemo.add(40);
        queueDemo.getdata();
        queueDemo.getdata();
        queueDemo.getdata();
        queueDemo.add(60);
        queueDemo.add(70);
        queueDemo.printQueue();
    }
}
