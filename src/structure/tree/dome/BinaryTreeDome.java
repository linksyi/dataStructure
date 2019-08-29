package structure.tree.dome;

/**
 * @author My.ZuoY
 * @date 2019-08-29 11:22
 * 二叉树
 *  普通二叉树 由于没有规则就没写新增
 */
public class BinaryTreeDome<T> {


    private Node<T> node;


    public void beforeOrder(){
        this.node.beforeOrder();
    }

    public void midOrder(){
        this.node.beforeOrder();
    }

    public void afterOrder(){
        this.node.beforeOrder();
    }


    public static void main(String[] args) {
        BinaryTreeDome<String> demo = new BinaryTreeDome<>();
        demo.node = new Node<>();
        demo.node.data = "a";

        demo.node.left = new Node<>();
        demo.node.left.data = "b";
        demo.node.right = new Node<>();
        demo.node.right.data = "c";

        demo.node.left.left = new Node<>();
        demo.node.left.left.data = "d";
        demo.node.left.right = new Node<>();
        demo.node.left.right.data = "e";
        demo.node.right.left = new Node<>();
        demo.node.right.left.data = "f";
        demo.node.right.right = new Node<>();
        demo.node.right.right.data = "g";

        demo.afterOrder();
    }
}

class Node<T>{
    T data;
    Node<T> left;
    Node<T> right;

    /**
     * 前置遍历
     */
    public void beforeOrder(){
        System.out.println(this.data);

        if(this.left != null){
            this.left.beforeOrder();
        }

        if(this.right != null){
            this.right.beforeOrder();
        }

    }

    /**
     * 中置遍历
     */
    public void midOrder(){
        if(this.left != null){
            this.left.midOrder();
        }

        System.out.println(this.data);

        if(this.right != null){
            this.right.midOrder();
        }
    }

    /**
     * 后置遍历
     */
    public void afterOrder(){
        if(this.left != null){
            this.left.afterOrder();
        }

        if(this.right != null){
            this.right.afterOrder();
        }

        System.out.println(this.data);

    }
}
