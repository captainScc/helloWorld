/**
 * 冒泡跟选择排序的时间复杂度都是n^2  空间复杂度为O(1)
 * 快排的时间复杂度为n*logn  空间复杂度为O(n*logn)
 */
public class SortAlgorithms {
   static int[] arr = {6,3,5,7,9,4};

    public static void main(String[] args) {
        SortAlgorithms sortAlgorithms = new SortAlgorithms();
//        sortAlgorithms.bubboSort(arr);
//        sortAlgorithms.selectSort(arr);
        sortAlgorithms.quickSort(arr);
    }

    /**
     * 冒泡排序
     * 相邻元素两两比较，大的往后放，一轮比较结束，最大值出现在最大索引处
     */
    public void bubboSort(int[] arr){
        int length = arr.length;
        for (int i = 1; i < length; i++) {//外层
            for (int j = 0; j < length-i; j++) { //内层
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for (int a: arr) {
            System.out.print(a + "  ");
        }

    }

    /**
     * 选择排序
     * 从第一个元素依次往后比较，晓得往前放，一轮结束，最小值出现在最小索引处
     */
    public void selectSort(int[] arr){
        int length = arr.length;
        for (int i = 0; i < length-1; i++) {//外层
            for (int j = i+1; j < length; j++) { //内层
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for (int a: arr) {
            System.out.print(a + "  ");
        }

    }


    /**
     * 快排
     * 原理：选第一个元素为标准，与最后一个比较，大于标准不处理，小于标准互换；再与没比较的第一个元素比较
     * 一轮比较结束，将原数组分成了以标准为节点的大小两部分
     * 将两部分分别使用快排
     */
    public void quickSort(int[] a){

    }




    /**
     * 二分查找
     */


    /**
     * 将数组包装成二叉树，并遍历(LinkedList)
     */






}
