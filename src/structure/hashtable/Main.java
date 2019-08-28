package structure.hashtable;

import structure.hashtable.demo.HashTableDome;

/**
 * @author My.ZuoY
 * @date 2019-08-28 17:03
 */
public class Main {

    public static void main(String[] args) {
        HashTableDome hashTableDome = new HashTableDome();
        hashTableDome.put("123","123");
        hashTableDome.put("321","321");
        hashTableDome.put("23","23");
        hashTableDome.list();
    }
}
