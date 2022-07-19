package leetcode.editor.cn;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1504 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        /**
         * 方法一：
         * 1、对二维数组进行排序,然后准备一次判断各个区间的左右端点情况
         * 2、新组的左端点，要是在旧组的右端点后，则未重复，
         * 3、否则有，将新组的右端点更新到旧组的右端点，即完成一个新旧组的合并
         *
         */
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if(ans.size() == 0 || ans.get(ans.size() - 1)[1] < left) {
                ans.add(new int[] {left, right}) ;
            } else {
                //list支持直接覆盖更新
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], right);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}