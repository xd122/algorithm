import java.util.Arrays;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-02
 * Package : PACKAGE_NAME
 * ProjectName: algorithm
 * Describe : 堆排序
 * ========================================================================================
 */
public class HeapSort {
    public int[] data;

    public HeapSort(int[] data) {
        this.data = data;
    }

    /**
     * 交换
     *
     * @param head 要交换的位置1
     * @param tail 要交换的位置2
     */
    public void swap(int head, int tail) {
        int tmp = data[head];
        data[head] = data[tail];
        data[tail] = tmp;
    }

    /**
     * 调整堆结构 堆的数据结构： 在完全二叉树的基础上 具备：根节点 大于或者小于左右节点
     *
     * @param index  从那个节点开始调整
     * @param length 带调整数组长度
     */
    public void adjustHeap(int index, int length) {
        int left = (index << 1) + 1;
        int right = left + 1;
        int max = left;
        if (left > length) {
            return;
        }
        if (right <= length && data[right] > data[left]) {
            max = right;
        }
        // 多层结构的二叉树，需要进行逐层的调整
        if (data[max] > data[index]) {
            swap(max, index);
            adjustHeap(max, length);
        }
    }

    public void sort() {
        // 利用数组下标 数据的索引下标天然具备堆的数据结构性质
        int len = data.length - 1;
        // 第一个非叶子节点开始遍历
        int comeFirst = (len - 1) >> 1;
        // 建堆过程
        for (int point = comeFirst; point >= 0; point--) {
            adjustHeap(point, len);
        }
        // 在已经建好的堆 进行调整
        for (int point = len; point > 0; point--) {
            swap(0, point);
            adjustHeap(0, point - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3, 0};
        new HeapSort(arr).sort();
        System.out.println(Arrays.toString(arr));
    }
}
