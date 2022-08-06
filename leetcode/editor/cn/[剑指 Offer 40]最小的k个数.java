package leetcode.editor.cn;
import java.util.*;
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 469 👎 0

import java.util.Arrays;

public class ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
//        Arrays.sort(arr);
        quickSrot(arr, 0, arr.length - 1);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public static void quickSrot(int[] arr, int left, int right) {
        if (left < right) {
            int i = left, j = right, tmp = arr[i];
            while (i < j) {
                while (i < j && tmp <= arr[j])
                    --j;
                if (i < j)
                    arr[i++] = arr[j];
                while (i < j && tmp > arr[i])
                    ++i;
                if (i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = tmp;
            quickSrot(arr, left, i - 1);
            quickSrot(arr, i + 1, right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}