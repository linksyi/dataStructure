package structure.tree.avltree;

/**
 * @author My.ZuoY
 * @date 2019-09-12 13:08
 * 平衡二叉树
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        AVLTreeDemo avlTreeDemo = new AVLTreeDemo();
//        avlTreeDemo.add(4);
//        avlTreeDemo.add(3);
//        avlTreeDemo.add(6);
//        avlTreeDemo.add(5);
//        avlTreeDemo.add(7);
//        avlTreeDemo.add(8);

        avlTreeDemo.add(2);
        avlTreeDemo.add(1);
        avlTreeDemo.add(6);
        avlTreeDemo.add(5);
        avlTreeDemo.add(7);
        avlTreeDemo.add(3);
        avlTreeDemo.midOrder();
        System.out.println(avlTreeDemo.node.leftHeight());
        System.out.println(avlTreeDemo.node.rightHeight());
    }
    private Node node;

    public void midOrder() {
        if (node == null) {
            throw new RuntimeException("当前二叉树为空无法遍历");
        }
        node.midOrder();
    }

    /**
     * 新增节点
     *
     * @param value
     */
    public void add(int value) {
        Node newNode = new Node(value);
        //如果树为空则放置顶级节点
        if (node == null) {
            node = newNode;
        } else {
            node.add(newNode);
        }
    }

    public void remove(int value) {
        //没有节点
        if (node == null) {
            return;
        }
        //寻找需要删除的节点与其父节点 诺为顶级节点则两个值相同
        Node removeNode = node.sortNode(value);
        //没有找到节点
        if (removeNode == null) {
            return;
        }
        Node parent = node.sortParent(removeNode);
        if (removeNode == node) {
            //只存在顶级节点
            if (removeNode.left == null && removeNode.right == null) {
                //代码进入这里说明只有顶级节点
                this.node = null;
                return;
            }

            //只存在顶级节点与一个子节点
            if ((node.left != null && node.right == null) || (node.right != null && node.left == null)) {
                this.node = node.left == null ? node.right : node.left;
                return;
            }
        }
        //删除节点
        removeNode.removeNode(parent, removeNode);
    }
}

class Node {
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
     * 左旋转
     */
    private void leftRevolve() {
        //创建一个新的节点，值为根节点的值
        Node newNode = new Node(this.value);
        //将新节点的右子节点的值指向树的右子节点的左子节点
        newNode.right = this.right.left;
        //将新节点的左子节点的值指向树的左子节点
        //这样就已经将值选装好了，等待重新赋值
        newNode.left = this.left;
        //将根节点的值赋值成右子节点
        this.value = right.value;
        //将右子节点的指向改成右子节点的右子节点，这时右子节点已为空引用将会被垃圾回收给回收
        this.right = this.right.right;
        //将根节点的左子节点的引用改成新创建的节点,完成旋转
        this.left = newNode;
    }
    /**
     * 右旋转
     */
    private void rightRevolve() {
        //创建一个新的节点，值为根节点的值
        Node newNode = new Node(this.value);
        //将新节点的左子节点的值指向树的左子节点的右子节点
        newNode.left = this.left.right;
        //将新节点的右子节点的值指向树的右子节点
        //这样就已经将值选装好了，等待重新赋值
        newNode.right = this.right;
        //将根节点的值赋值成左子节点
        this.value = left.value;
        //将左子节点的指向改成左子节点的左子节点，这时左子节点已为空引用将会被垃圾回收给回收
        this.left = this.left.left;
        //将根节点的右子节点的引用改成新创建的节点,完成旋转
        this.right = newNode;
    }

    /**
     * 左子树高度
     * @return
     */
    public int leftHeight() {
        if(left == null) {
            return 0;
        }
        return left.height();
    }

    /**
     * 右子树高度
     * @return
     */
    public int rightHeight() {
        if(right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * 统计数高度
     * @return
     */
    private int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height())+1;
    }

    /**
     * 中置遍历
     */
    void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.midOrder();
        }
    }

    Node(int value) {
        this.value = value;
    }

    /**
     * 二叉排序树新增
     *
     * @param node 待新增节点
     */
    public void add(Node node) {
        //判断节点放置左节点还是右节点
        if (this.value > node.value) {
            //判断当前节点是否有子节点，有则递归下一个节点，没有则放置左节点
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            //判断当前节点是否有子节点，有则递归下一个节点，没有则放置右节点
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        //判断是否要进行左旋转
        if (rightHeight() - leftHeight()  > 1) {
            //判断是否要进行双旋转
            if (right != null && leftHeight() - rightHeight() > 1) {
                right.rightRevolve();
            }
            leftRevolve();
        }
        //判断是否要进行右旋转
        if (leftHeight() - rightHeight() > 1) {
            //判断是否要进行双旋转
            if (left != null && leftHeight() -rightHeight()  > 1) {
                left.leftRevolve();
            }
            rightRevolve();
        }
    }


    private void remove(int value) {
        removeNode(sortParent(sortNode(value)), sortNode(value));
    }

    /**
     * 通过值寻找节点
     *
     * @param value 节点值
     * @return 返回节点 如果为null表示树种没该值节点
     */
    Node sortNode(int value) {
        if (this.value == value) {
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
     *
     * @param node 子节点
     * @return 如果传入节点为顶级节点则返回顶级节点否则返回父级节点
     */
    Node sortParent(Node node) {
        if (this == node) {
            return this;
        } else if (this.value > node.value) {
            if (this.left == node) {
                return this;
            } else {
                return this.left.sortParent(node);
            }
        } else {
            if (this.right == node) {
                return this;
            } else {
                return this.right.sortParent(node);
            }
        }
    }

    /**
     * 删除节点
     *
     * @param parent 父级节点
     * @param node   待删除节点
     */
    void removeNode(Node parent, Node node) {
        //判断成立说明node为叶子节点
        if (node.left == null && node.right == null) {
            //判断删除的叶子节点是其父节点的左子节点还是右子节点
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            //判断成立说明node有两个子节点
        } else if (node.left != null && node.right != null) {
            //诺node有两个子节点有两种删法，寻找左子树中最大的值或，或右子树最小的值
            node.value = sortRightMax(node);
            //判断成立说明node只有一个子节点
        } else {
            //将node的子节点替代node节点
            if (parent.left == node) {
                parent.left = node.left == null ? node.right : node.left;
            } else {
                parent.right = node.left == null ? node.right : node.left;
            }
        }
    }

    /**
     * 寻找某节点寻找右子树最大值
     *
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
