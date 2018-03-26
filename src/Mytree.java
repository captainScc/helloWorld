import java.util.LinkedList;

public class Mytree {
    //定义节点类
    //将数组转化为节点
    //给节点赋值
    //遍历

    class Node{
        private Node leftChild;
        private Node rightChild;
        int data;

        public Node(int data) {
            this.leftChild = null;
            this.rightChild = null;
            this.data = data;
        }
    }

    int[] arr = {1,2,3,4,5,6,7,8,9};

    static LinkedList<Node> nodeList = new LinkedList<>();

    public void makeTree(){
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            nodeList.add(node);
        }

        //父节点个数为length/2+1个
        //前length/2个完整节点
            for (int parentIndex = 0; parentIndex < arr.length / 2-1; parentIndex++) {
                nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
                nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
            }

            nodeList.get(arr.length/2-1).leftChild = nodeList.get((arr.length/2-1)*2+1);

        if(arr.length%2 == 1) {
            nodeList.get(arr.length/2-1).rightChild = nodeList.get((arr.length/2-1)*2+2);
        }
    }

        //遍历
        public void preOut(Node node){
            if(node == null) {
                return;
            }
            System.out.print(node.data+" ");
            preOut(node.leftChild);
            preOut(node.rightChild);
        }


    public static void main(String[] args) {
        Mytree mytree = new Mytree();
        mytree.makeTree();
        mytree.preOut(nodeList.get(0));
    }
}
