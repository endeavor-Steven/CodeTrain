package leetcode.editor.cn;

//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 👍 256 👎 0

public class GouJianChengJiShuZuLcof{
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        /**
         * L和R两个数组，位置i的时候分别表示左右两边的乘积
         */
        if(a.length == 0)
            return a;
        int[] L = new int[a.length];
        L[0] = 1;
        int[] R = new int[a.length];
        R[a.length-1] = 1;
        for (int i = 1; i < a.length; i++) {
            L[i] = L[i-1] * a[i-1];
        }
        for (int i = a.length-2; i >= 0; i--) {
            R[i] = R[i+1] * a[i+1];
        }
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}