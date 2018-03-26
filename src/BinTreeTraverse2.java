import java.util.LinkedList;
import java.util.List;

/**
 * 将一个数组放进二叉树并进行遍历
 */
public class BinTreeTraverse2 {
    private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static List<Node>  nodeList = null;

    /**
     * 内部类：节点
     */
    private static class Node{
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData){
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    /**
     * 通过LinkedList将数组转为树
     *
     * 对于有左右节点健全的二叉树 父节点个数是    总节点数/2-1
     * 父节点始终比子节点少一个  后面每当一个子节点成为父节点，父节点数会加1，子节点数也会加1
     *
     * 从0开始的连续序列，平衡二叉树的左孩子节点是 parentIndex*2 + 1
     * 从0开始的连续序列，平衡二叉树的右孩子节点是 parentIndex*2 + 2
     * 从1开始的连续序列，平衡二叉树的左孩子节点是 parentIndex*2
     * 从1开始的连续序列，平衡二叉树的右孩子节点是 parentIndex*2 + 1
     */
    public void creatBinTree(){
        nodeList = new LinkedList<Node>();
        //将一个数组的值依次转化为节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        //对前lastParentIndex-1个父节点按照父节点和孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length/2-1; parentIndex++) {
            //左孩子
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex*2 + 1);
            //右孩子
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex*2 + 2);
        }
        //最后一个父节点：最后一个父节点可能没有右孩子，单独处理
        int lastParentIndex = array.length / 2 -1;
        //左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex*2 + 1);
        //右孩子，数组长度为奇数时才建立右孩子
        if(array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex*2 + 2);
        }
    }

    /**
     * 先序遍历
     *
     */
    public static void preOrderTraverse(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历
     *
     */
    public static void inOrderTraverse(Node node) {
        if(node == null) {
            return;
        }
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    /**
     * 后序遍历
     *
     */
    public static void postOrderTraverse(Node node) {
        if(node == null) {
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinTreeTraverse2 binTree = new BinTreeTraverse2();
        binTree.creatBinTree();
        Node root = nodeList.get(0);

        System.out.println("前序遍历");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历");
        postOrderTraverse(root);
        System.out.println();

    }

}
