package leetcode.editor.cn;
import java.util.*;
//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
// Related Topics 贪心 数组 双指针 👍 3518 👎 0

public class ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        /**
         * 双指针
         * 一头一尾，小的那个往中间找
         * 过程中比较最大值
         */
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
//            int capticy = (right - left) * Math.min(height[left], height[right]);
//            ans = Math.max(ans, capticy);
//            if (height[left] <= height[right])
//                left++;
//            else
//                right--;
            //上述注释语句可以优化,速度提升还是非常明显的
            ans = height[left] <= height[right] ?
                    Math.max(ans, (right - left) * height[left++]) :
                    Math.max(ans, (right - left) * height[right--]) ;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}