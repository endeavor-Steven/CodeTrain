package leetcode.editor.cn;
import java.util.*;
//如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的： 
//
// 
// n >= 3 
// 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2} 
// 
//
// 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。 
//
// （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 
//是 [3, 4, 5, 6, 7, 8] 的一个子序列） 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入: arr = [1,2,3,4,5,6,7,8]
//输出: 5
//解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
// 
//
// 示例 2： 
//
// 
//输入: arr = [1,3,7,11,12,14,18]
//输出: 3
//解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 1000 
// 
// 1 <= arr[i] < arr[i + 1] <= 10^9 
// 
// 
// Related Topics 数组 哈希表 动态规划 👍 313 👎 0

public class LengthOfLongestFibonacciSubsequence{
    public static void main(String[] args) {
        Solution solution = new LengthOfLongestFibonacciSubsequence().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        /**
         * 1、动态规划
         * 定义：
         *      int dp[i][j] , 表示以每个下标对的元素作为最后两个数字的斐波那契子序列的最大长度。
         *      初始时都是2
         *      这就存在一个 < i 的值使 nums[k] + nums[i] = nums[j]。
         *      于是思路就变成了找n[j]-n[i]
         * 状态：
         *      dp[i][j] = max(dp[i][j], dp[k][i] + 1);      nums[k] + nums[i] = nums[j]    0 <= k < i
         */
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i); //添加所有值和索引进入hashmap
        }

        int[][] dp = new int[len - 1][len];      //数列特性，第一个数最大只能是倒数第二位
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = 2;   //已经确定两个值可以默认是2
            }
        }
        int maxLen = 0;
        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int k = map.getOrDefault(arr[j] - arr[i], -1);
                if (k >= 0) {
                    dp[i][j] = Math.max(dp[k][i] + 1, dp[i][j]);
                }
                maxLen = Math.max(dp[i][j], maxLen);
            }
        }
        return maxLen = maxLen > 2 ?  maxLen : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}