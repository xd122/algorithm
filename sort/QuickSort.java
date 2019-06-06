import java.util.Arrays;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-05
 * Package : PACKAGE_NAME
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */
public class QuickSort {
    public int[] data;

    public QuickSort(int[] data) {
        this.data = data;
    }

    public void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    /**
     * 分治思想
     * 0、前后指针不相遇
     * 1、从后向前扫描 找到第一个小于等于基准位置；
     * 2、从前向后骚面，找到第一个大于基准的位置
     * 3、交换 前后位置的数据
     * 4、前后指针相遇：交换基准位置的数值和prePoint位置的值
     * 5、从prePoint 分成2个部分递归计算
     *
     * @param start 起始位置
     * @param end   结束位置
     */
    public void sort(int start, int end) {
        // 防止数组越界以及递归出口
        if (start > end) {
            return;
        }
        // 基准值
        int reference = data[start];
        int prePoint = start;
        int backPoint = end;
        while (prePoint != backPoint) {
            // 从后开始，注意边界和判断条件 只有前后扫描的时候更改指针的变化
            while (data[backPoint] > reference && prePoint < backPoint) {
                backPoint--;
            }
            while (data[prePoint] <= reference && prePoint < backPoint) {
                prePoint++;
            }
            if (prePoint < backPoint) {
                // 不做指针的更新，以免出现死循环
                swap(prePoint, backPoint);
            }
        }
        // 交换基准值
        swap(start, prePoint);

        sort(start, prePoint - 1);
        sort(prePoint + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9, 0};
        new QuickSort(arr).sort(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
