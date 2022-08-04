package leetcode.editor.cn;

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数组 数学 👍 240 👎 0

public class DaYinCong1daoZuiDaDeNweiShuLcof{
    public static void main(String[] args) {
        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    /**
     * 这个题目的真实版本应该是大数打印，这个时候会超出int型的容载上限,所以把函数签名的返回从int[]改成String
     *
     * 可以使用字符串来生成数字，这样就不会收到大小的限制，但是字符串的迭代数字很麻烦，
     * 可以使用全排列的思想用来迭代生成数字：
     *      首先固定高位，然后向低位迭代，同时要记得过滤高位的0
     *      举例：当n = 2时，先固定十位0-9，按次序开始递归 固定个位0-9,终止的时候添加数字字符串
     *
     *      如何过滤高位的0，确定一个左边界每次将nums添加到res的时候添加范围是nums[start:]
     *      举例：当n = 2时，1-9的时候左边界是1， 10-99时左边界是0
     *      每当输出数字的位数为9的时候，则下一个数字的左边界要升位（左边界在下标上内减一）
     */
    StringBuilder res;
    int nine = 0, start, n;
    //nine记录当前出现过9的位数，用来控制左边界的更新
    //start左边界，从最右边开始往高位更新
    //n一共要生成n组数，每一位都要排列0-9
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n) {
        //如果是需要int[]的返回，
        // 可以把ans换成int[]型， 长度可以通过求幂得到，增加一个int count来记录下标位置
        // 在append的位置换成ans[count++] = Integer.parsrInt(s);
        // 参数列表，函数返回都记得换
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs(0);//从0位开始递归
        res.deleteCharAt(res.length() - 1);//过滤最后一个逗号
        return res.toString();
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);//对一组数进行切片然后转换
            if(!s.equals("0"))
                res.append(s + ",");
            if(n - start == nine) //左边界控制更新
                start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}