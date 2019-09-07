package structure.tree.binarysorttree;

/**
 * @author My.ZuoY
 * @date 2019-09-07 17:21
 * 二叉排序树
 */
public class BinarySortTree {
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
//        binarySortTree.add(7);
//        binarySortTree.add(3);
//        binarySortTree.add(10);
//        binarySortTree.add(12);
//        binarySortTree.add(5);
//        binarySortTree.add(1);
//        binarySortTree.add(9);
//        binarySortTree.add(2);
//        binarySortTree.add(4);

        binarySortTree.add(2);
        binarySortTree.add(1);
        binarySortTree.remove(2);
        binarySortTree.midOrder();


    }
    private Node node;

    public void midOrder(){
        if (node == null) {
            throw new RuntimeException("当前二叉树为空无法遍历");
        }
        node.midOrder();
    }

    /**
     * 新增节点
     * @param value
     */
    public void add(int value){
        Node newNode=new Node(value);
        //如果树为空则放置顶级节点
        if (node == null) {
            node = newNode;
        }else{
            node.add(newNode);
        }
    }

    public void remove(int value) {
        //没有节点
        if(node == null){
            return;
        }
        //寻找需要删除的节点与其父节点 诺为顶级节点则两个值相同
        Node removeNode = node.sortNode(value);
        //没有找到节点
        if (removeNode == null) {
            return;
        }
        Node parent = node.sortParent(removeNode);
        if (removeNode == node ) {
            //只存在顶级节点
            if(removeNode.left == null && removeNode.right == null) {
                //代码进入这里说明只有顶级节点
                this.node = null;
                return;
            }

            //只存在顶级节点与一个子节点
            if ((node.left != null && node.right == null) || (node.right != null && node.left == null)) {
                this.node = node.left == null?node.right : node.left;
                return;
            }
        }
        //删除节点
        removeNode.removeNode(parent, removeNode);
    }
}

class Node{
    private int value;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 中置遍历
     */
    void midOrder(){
        if(this.left != null){
            this.left.midOrder();
        }

        System.out.println(this);

        if(this.right != null){
            this.right.midOrder();
        }
    }

    Node(int value) {
        this.value = value;
    }

    /**
     * 二叉排序树新增
     * @param node 待新增节点
     */
    public void add(Node node){
        //判断节点放置左节点还是右节点
        if (this.value > node.value) {
            //判断当前节点是否有子节点，有则递归下一个节点，没有则放置左节点
            if (this.left == null) {
                this.left = node;
            }else{
                this.left.add(node);
            }
        }else{
            //判断当前节点是否有子节点，有则递归下一个节点，没有则放置右节点
            if (this.right == null) {
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
    }


    private void remove(int value) {
        removeNode(sortParent(sortNode(value)),sortNode(value));
    }

    /**
     * 通过值寻找节点
     * @param value 节点值
     * @return 返回节点 如果为null表示树种没该值节点
     */
    Node sortNode(int value){
        if(this.value == value){
            return this;
        } else if (this.value > value) {
            if (this.left == null) {
                return null;
            }
            return this.left.sortNode(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.sortNode(value);
        }
    }

    /**
     * 通过子节点寻找父节点
     * @param node 子节点
     * @return 如果传入节点为顶级节点则返回顶级节点否则返回父级节点
     */
    Node sortParent(Node node){
        if (this == node) {
            return this;
        } else if (this.value > node.value) {
            if (this.left == node) {
                return this;
            }else{
                return this.left.sortParent(node);
            }
        } else {
            if (this.right == node) {
                return this;
            }else{
                return this.right.sortParent(node);
            }
        }
    }

    /**
     *  删除节点
     * @param parent 父级节点
     * @param node 待删除节点
     */
    void removeNode(Node parent, Node node) {
        //判断成立说明node为叶子节点
        if(node.left == null && node.right == null){
            //判断删除的叶子节点是其父节点的左子节点还是右子节点
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            //判断成立说明node有两个子节点
        }else if (node.left != null && node.right != null){
            //诺node有两个子节点有两种删法，寻找左子树中最大的值或，或右子树最小的值
            node.value = sortRightMax(node);
            //判断成立说明node只有一个子节点
        }else{
            //将node的子节点替代node节点
            if (parent.left == node) {
                parent.left = node.left == null? node.right : node.left;
            } else {
                parent.right = node.left == null? node.right : node.left;
            }
        }
    }

    /**
     * 寻找某节点寻找右子树最大值
     * @param node 某节点
     * @return 右子树最大值
     */
    private int sortRightMax(Node node) {
        Node temp = node.left;
        //寻找最大值
        while (temp.right != null) {
            temp = temp.right;
        }
        remove(temp.value);
        return temp.value;
    }
}





