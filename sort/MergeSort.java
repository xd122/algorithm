import java.util.Arrays;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-06
 * Package : PACKAGE_NAME
 * ProjectName: algorithm
 * Describe : 归并排序
 * ========================================================================================
 */
public class MergeSort {
    // 辅助数组 用于每个小区间的数据比较
    public int[] aux;

    public MergeSort(int[] aux) {
        this.aux = new int[aux.length];
    }

    public void sort(int[] arr, int low, int high) {
        // 递归出口
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        // 排序索引较低区间
        sort(arr, low, mid);
        // 排序索引较高区间
        sort(arr, mid + 1, high);
        // 合并2个区间
        merge(arr, low, mid, high);
    }

    /**
     * @param arr  输入数据
     * @param low  头
     * @param mid  中间 分割区间
     * @param high 高位地址
     */
    public void merge(int[] arr, int low, int mid, int high) {
        int key = low;
        int first = low;
        int second = mid + 1;
        for (; key <= high; key++) {
            aux[key] = arr[key];
        }
        for (key = low; key <= high; key++) {
            if (first > mid) {
                // 低半区没有数据 之后从高半区增长
                arr[key] = aux[second++];
            } else if (second > high) {
                // 高半区没有数据 之后从低半区增长
                arr[key] = aux[first++];
            }
            // 双指针归并
            else if (aux[first] > aux[second]) {
                arr[key] = aux[second];
                second++;
            } else {
                arr[key] = aux[first];
                first++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -1, 4, 9, 4, 5, 6, 0};
        new MergeSort(arr).sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
