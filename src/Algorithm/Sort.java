package Algorithm;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {1,9,2,0,4,1,8,3};

//        Sort.bubbleSort(arr);
//        Sort.bubbleSort2(arr);
//        Sort.selectionSort(arr);AA
//        Sort.insertSort(arr);
        Sort.quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(x ->System.out.print(String.valueOf(x)+' '));
        System.out.println();
    }
    //-----------------------------时间复杂度为O(nlogn)----------------------------------//

    /**
     * 快速排序：
     * 1.从数组中取出一个数，称之为基数（pivot）
     * 2.遍历数组，将比基数大的数字放到它的右边，比基数小的数字放到它的左边。遍历完成后，数组被分成了左右两个区域
     * 3.将左右两个区域视为两个数组，重复前两个步骤，直到排序完成
     *本算法采用双指针算法
     * 时间复杂度为O(nlogn);空间复杂度为O(1)
     */
    public static void quickSort(int[] arr,int start,int end){
        //边界条件：如果分区内的少于2个，则退出递归
        if (end - start < 2 ) return;
        //将数组分区，并获得中间值的下标
        int middle =  partition(arr,start,end);
        //对左边区域快速排序
        quickSort(arr,start,middle - 1);
        //对右边区域快速排序
        quickSort(arr,middle + 1,end);

    }

    private static int partition(int[] arr,int start,int end){
        //选取第一个元素为基数
        int pivot = arr[start];
        //从第二个元素开始分区
        int left = start + 1;
        int right = end;
        while (left < right){
            // 找到第一个大于基数的位置
            while (left < right && arr[left] <= pivot) left++;
            // 找到第一个小于基数的位置
            while (left < right && arr[right] >= pivot) right--;
            // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
            if (left < right){
                swap(arr,left,right);
                left++;
                right--;
            }
        }

        // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
        if (left == right && arr[right] > pivot) right--;
        // 将基数和轴交换
        swap(arr,start,right);
        return right;
    }


    //-----------------------------时间复杂度为O(n^2)----------------------------------//
    /**
     * 插入排序：
     * 交换法：将未排序的后面为排序集合的第一个，插入到前面有序集合中，在插入的过程中不断与前一个元素交换直到找到合适的位置
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static void insertSort(int[] arr){
        int n  = arr.length;
        //从第二个数开始
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j-1] > arr[j]){
                    swap(arr,j-1,j);
                }
            }
        }

    }

    /**
     * 选择排序思想：每经过一轮比较，找后部分最小元素的下标，将其和后部分第一个元素交换顺序。
     * 该算法不稳定
     */
    public static void selectionSort(int[] arr){
        int minIndex; //记录最小元素的下标
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
        }
    }

    /**
     * 冒泡排序改进版：如果一轮比较中没有发生过交换，则立即停止排序，因为此时剩余数字一定已经有序了。
     */
    public static void bubbleSort2(int[] arr){
        boolean isSwap = true;
        for (int i = 0; i < arr.length; i++) {
            if (!isSwap) break;
            isSwap = false;
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    isSwap = true;
                }
            }
        }
    }

    /**
     * 冒泡排序的思想：从数组头部开始，相邻的两个元素比较交换，将最大或最小的元素逐个放到数组的尾部
     * 该方法将大的元素放到数组尾部
     * 时间复杂度O(n^2),空间复杂度O(1)
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0;i < arr.length;i++){
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    //保证右边的数字最大
                    swap(arr,j,j+1);
            }
        }

    }


    /**
     * 交换顺序
     */
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
