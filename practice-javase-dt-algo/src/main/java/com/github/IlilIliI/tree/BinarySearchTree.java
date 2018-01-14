package com.github.IlilIliI.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leinl
 * @Description:http://www.cnblogs.com/gaochundong/p/binary_search_tree.html BinaryTree: 二叉树
 * (1).二叉树（Binary Tree）是一种特殊的树类型，其每个节点最多只能有两个子节点.
 * (2).完全二叉树和满二叉树:
 * <p/>
 * 完全二叉树（Complete Binary Tree）：
 * 深度为 h，有 n 个节点的二叉树,当且仅当其每一个节点都与深度为 h 的满二叉树中，
 * 序号为 1 至 n 的节点对应时，称之为完全二叉树。
 * A complete binary tree is a binary tree in which every level, except possibly the last,
 * is completely filled, and all nodes are as far left as possible.
 * <p/>
 * 满二叉树（Full Binary Tree）：
 * 一棵二叉树深度为 h，且有 2h - 1 个节点称之为满二叉树。
 * A full binary tree is a tree in which every node other than the leaves has two children.
 * <p/>
 * (3).二叉查找树（BST：Binary Search Tree）
 * 是一种特殊的二叉树，它改善了二叉树节点查找的效率。
 * 二叉查找树有以下性质：对于任意一个节点 n，
 * 其左子树（left subtree）下的每个后代节点（descendant node）的值都小于节点 n 的值；
 * 其右子树（right subtree）下的每个后代节点的值都大于节点 n 的值。
 * <p/>
 * (4).自平衡的二叉搜索树:
 * (A).AVL tree
 * (B).红黑树
 * @create 2018/01/14
 * @Modified By:
 **/

public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * 构造树节点
     *
     * @param <T>
     */
    static class Node<T> {
        T value;
        Node left;
        Node right;

        Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }
    }

    //树的根节点
    private Node<T> root;

    //树节点数
    private int count;

    /**
     * 树是否为空
     *
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 树大小
     *
     */
    public int size() {
        return count;
    }

    /**
     * 向树中插入一个新节点
     *
     */
    public void add(T value) {
        //递归实现
        root = recInsert(root, value);
        //非递归实现
        //root = nonRecInsert(root,value);
    }

    /**
     * 查找树中是否有value值节点
     *
     * @param value
     * @return true表示存在该节点, false反之
     */
    public boolean contains(T value) {
        //递归查找
        //return recContains(root,value);
        //非递归查找
        return nonRecContains(root, value);
    }

    /**
     * 递归方式的前序遍历: 中 -> 左 -> 右
     */
    public void recPreOrder() {
        //可以传入集合来保存遍历的值
        recPreOrder(root);
    }

    /**
     * 前序非递归遍历
     */
    public void noRecPreOrder() {
        //可以传入集合来保存遍历的值
        noRecPreOrder(root);
    }


    /**
     * 递归方式的中序遍历: 左 -> 中 -> 右
     */
    public void inPreOrder() {
        //可以传入集合来保存遍历的值
        inPreOrder(root);
    }

    /**
     * 中序非递归遍历
     */
    public void noRecInPreOrder() {
        nonRecInPreorder(root);
    }


    /**
     * 递归方式的后序遍历: 左 -> 中 -> 右
     */
    public void postPreOrder() {
        //可以传入集合来保存遍历的值
        postPreOrder(root);
    }

    /**
     * 后序非递归遍历
     */
    public void noRecPostPreOrder() {
        nonRecPostPreorder(root);
    }

    @Override
    public String toString() {
        levelOrder(root);
        return "";
    }

    /**
     * 广度优先遍历:一层一层遍历
     */
    public void levelOrder(){
        levelOrder(root);
    }

    /**
     * 找最大值
     * @return
     */
    public T findMax(){
        assert (root != null);
        Node<T> maximum = findMaximum(root);
        return maximum.value;
    }

    /**
     * 最小值
     * @return
     */
    public T findMin(){
        assert (root != null);
        Node<T> minimum = findMinimum(root);
        return minimum.value;
    }

    /**
     * 删除最小节点
     * @return
     */
    public T removeMin(){
        Node<T> node  = removeMin(root);
        // TODO: 2018/1/14  
        return null;
    }


    //****************************************************
    //*                       私有方法                    *
    //****************************************************

    /**
     * 递归实现:
     * 以node为根节点的二叉树,插入以value为值的节点,返回新树的根节点
     *
     * @param node
     * @param value
     */
    private Node<T> recInsert(Node<T> node, T value) {

        //assert node.value.compareTo(value) != 0

        if (node == null) {
            count++;
            return new Node<T>(value);
        }
        //往左
        if (value.compareTo(node.value) < 0) {
            node.left = recInsert(node.left, value);
            //往右
        } else if (value.compareTo(node.value) > 0) {
            node.right = recInsert(node.right, value);
        }

        return node;
    }

    /**
     * 非递归实现:
     * 向以node为根节点的树中插入新节点,返回新树的根节点
     *
     * @param node
     * @param value
     * @return
     */
    private Node<T> nonRecInsert(Node<T> node, T value) {

        //assert node.value.compareTo(value) != 0

        //若空树,直接构造新节点返回
        if (node == null) {
            count++;
            return new Node<T>(value);
        }

        //记录根,方便返回
        Node<T> rootTemp = node;

        while (node != null) {

            if (value.compareTo(node.value) < 0) {
                //如果左子树空了,直接添加左子树
                if (node.left == null) {
                    node.left = new Node(value);
                    break;
                }
                //不空继续循环
                node = node.left;

            } else if (value.compareTo(node.value) > 0) {
                if (node.right == null) {
                    node.right = new Node(value);
                    break;
                }
                node = node.right;
            }
        }
        count++;
        return rootTemp;
    }

    /**
     * 递归方式查找树中是否存在value的节点
     *
     * @return true存在, false不存在
     */
    private boolean recContains(Node<T> node, T value) {

        if (node == null) {
            return false;
        }

        if (node.value.compareTo(value) == 0) {
            return true;
        } else if (value.compareTo(node.value) < 0) {
            return recContains(node.left, value);
        } else {
            return recContains(node.right, value);
        }
    }

    /**
     * 非递归方式查找树中是否存在value的节点
     *
     * @param node
     * @param value
     * @return true存在, false不存在
     */
    private boolean nonRecContains(Node<T> node, T value) {

        if (node == null) {
            return false;
        }
        while (node != null) {
            if (value.compareTo(node.value) < 0) {
                node = node.left;
            } else if (value.compareTo(node.value) > 0) {
                node = node.right;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 递归查找值为value的Node节点
     *
     * @param node
     * @param value
     * @return null表示未找到该节点
     */
    private Node<T> recSearch(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.value) < 0) {
            return recSearch(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            return recSearch(node.right, value);
        } else {
            return node;
        }
    }

    /**
     * 非递归查找值为value的Node节点
     *
     * @param node
     * @param value
     * @return null表示未找到该节点
     */
    private Node<T> nonRecSearch(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        while (node != null) {
            if (value.compareTo(node.value) < 0) {
                node = node.left;
            } else if (value.compareTo(node.value) > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     *  递归前序遍历
     * @param node
     */
    private  void recPreOrder(Node<T> node){
        if(node != null){
            //前序
            System.out.print(node.value + "\t");
            recPreOrder(node.left);
            recPreOrder(node.right);
        }
    }

    /**
     *  递归中序遍历
     * @param node
     */
    private  void inPreOrder(Node<T> node){
        if(node != null){
            //中序
            System.out.print(node.value + "\t");
            inPreOrder(node.left);
            inPreOrder(node.right);
        }
    }

    /**
     *  递归后序遍历
     * @param node
     */
    private  void postPreOrder(Node<T> node){
        if(node != null){
            postPreOrder(node.left);
            postPreOrder(node.right);
            //后序
            System.out.print(node.value + "\t");
        }
    }

    /**
     * 前序非递归遍历: 中 -> 左 ->右
     *      前序遍历会先遍历自己再左孩子最后右孩子,
     *      利用栈来保存右孩子再左孩子最后自己,
     *      最后依次出栈即可.
     * @param root
     */
    private void noRecPreOrder(Node<T> root) {

        //assert node != null
        if (root == null){
            return ;
        }
        ArrayDeque<Node<T>> stack = new ArrayDeque<Node<T>>();
        stack.addFirst(root);
        while (!stack.isEmpty()){
            Node<T> tNode = stack.pollFirst();
            System.out.println(tNode.value + "\t");
            if (tNode.left != null){
                stack.addFirst(tNode.left);
            }
            if (tNode.right != null){
                stack.addFirst(tNode.right);
            }
        }
    }

    /**
     * 中序非递归遍历: 左 -> 中 -> 右
     *
     *    需要借用栈stack和一个标记变量isOver,isOver用来标记栈空退出循环
     *    (1).首先如果当前节点A不为null,将当前节点入栈
     *    (2).再访问当前节点A的左孩子,如果A的左孩子不为null,执行(1),否则执行(3)
     *    (3. 将栈中当前栈顶节点出栈,判断栈是否为空(isOver = true),如果栈为空,退出循环,否则执行(4)
     *    (4).打印当前出栈节点的值,并把该节点的右孩子作为当前节点A看待,执行(1)
     *
     * @param root
     */
    private void nonRecInPreorder(Node<T> root){
        ArrayDeque<Node<T>> stack = new ArrayDeque<Node<T>>();
        //当前正在访问的节点
        Node<T> currentNode = root;
        //标记变量,用来标记栈空
        boolean isOver = false;
        while (!isOver){
            //从当前节点向左孩子方向访问
            if (currentNode != null){
                stack.addFirst(currentNode);
                //有左孩子,往左继续
                currentNode = currentNode.left;
            }else{
                //栈空了,停止循环
                if (stack.isEmpty()){
                    isOver = true;
                }else{
                    //栈不空,出栈栈顶元素(到这里说明该节点没有左边或右孩子了)
                    Node<T> tNode = stack.pollFirst();
                    System.out.println(tNode.value + "\t");
                    //当前循环节点变成tNode的右孩子
                    currentNode = tNode.right;
                }
            }
        }
    }

    /**
     *  后续非递归遍历: 左 -> 右 -> 中
     *      树从上自下遍历时,先左后右最后中会导致 中 的位置丢失
     *      可以采用prev作为中位置的标记,curr表示当前正在访问的节点,Stack栈记录所访问的节点
     *
     *      始终需要注意的prev和curr的对应关系,
     *      prev.left = curr, 表示prev为父亲节点,curr为左孩子 且 curr!=null时 入栈curr的左孩子
     *      prev.right = curr, prev为父亲节点,curr为右孩子 且curr != null时 入栈curr的右孩子
     *      curr.left = prev, 树从上往下遍历又回溯到了根,此时刚好curr为根,prev为根的左孩子,入栈根的右孩子
     * @param root
     */
    private void nonRecPostPreorder(Node<T> root){

        //assert root != null
        if (root == null){
            return;
        }
        ArrayDeque<Node<T>> stack = new ArrayDeque<Node<T>>();
        stack.addFirst(root);
        //记录上一个节点
        Node<T>  prev = null;
        while (!stack.isEmpty()){
            //当前访问的节点
            Node<T> curr = stack.peekFirst();
            //prev == null成立表示第一次刚开始从根节点遍历
            //prev.left == curr 左孩子不为空
            //prev.right == curr右孩子不为空
            if (prev == null || prev.left == curr || prev.right == curr){
                //从上到下遍历树,如果curr当前节点有左或右子树,将其左或右子树入栈,否则弹出
                if (curr.left != null){
                    stack.addFirst(curr.left);
                }else if(curr.right != null){
                    stack.addFirst(curr.right);
                }
             //树从上往下遍历又回溯到了根,也就是左子树遍历完了,刚好转到根的右子树进行遍历
            }else if(curr.left == prev){
                if (curr.right != null){
                    stack.addFirst(curr.right);
                }
            //curr节点是叶子节点了,出栈使curr逐渐从子退到根
            }else{
                System.out.println(curr.value + "\t");
                stack.pollFirst();
            }
            prev = curr;
        }
    }

    /**
     *  广度优先遍历:层序遍历
     *     需要借用队列来储存节点:
     *     (1).判断队列不为空时,出队列节点打印
     *     (2).并该出队列节点的左孩子和右孩子先后压入队列中
     *     (3).再次执行(1)
     * @param root
     */
    private void levelOrder(Node<T> root) {

        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        //先将根压入队列
        queue.add(root);
        while (!queue.isEmpty()){
            Node<T> remove = queue.remove();
            System.out.println(remove.value + "\t");
            if (remove.left != null){
                queue.add(remove.left);
            }

            if (remove.right != null){
                queue.add(remove.right);
            }
        }
    }

    private Node<T> findMaximum(Node<T> node){

        //assert isEmpty() > 0

        if (node.right == null){
            return node;
        }
        return  findMaximum(node.right);
    }

    private Node<T> findMinimum(Node<T> node){

        //assert isEmpty() > 0

        if (node.left == null){
            return node;
        }
        return  findMaximum(node.left);
    }

    /**
     * 删除最小节点
     * @param node
     * @return
     */
    private Node<T> removeMin(Node<T> node) {

        if (node.left == null){
            // TODO: 2018/1/14  
            return null;
        }
        return null;
    }
}
