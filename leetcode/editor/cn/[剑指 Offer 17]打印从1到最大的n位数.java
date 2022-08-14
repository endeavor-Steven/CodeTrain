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
     * 这个题目的真正需求应该是大数的打印，
     * 这个时候会超出int型的容载上限,所以把函数签名的返回从int[]改成String
     * 可以使用字符串来生成数字，这样就不会收到大小的限制，但是字符串的迭代数字很麻烦
     *
     *      1.可以使用全排列的方法来通过递归生成数字的 String 列表：
     *      首先固定高位，然后向低位递归。当最低位（个位）被固定了，就添加数字的字符串
     *      举例：当n = 2时，先固定 十位的 0-9，按次序开始递归 固定个位 0-9,终止的时候添加数字字符串
     *      即十位0时，排列固定个位0-9；...；十位为9时排列固定各位0-9.每生成一个数就添加一个逗号
     *
     *      2.如何过滤高位的0，
     *      确定一个左边界每次将nums添加到res的时候添加范围是nums[start:]，这个start用来过滤为0的位数
     *      举例：当n = 2时，1-9的时候左边界是1， 10-99时左边界是0
     *      当输出的数字都是9的时候，左边界start就从右往左走一下
     *      数位长度 - 九出现的次数 = 左边界现在的位置 ==>>  n - nine = start
     *
     *  此题给的是int[]型的返回，如果使用大数的解法需要更改的地方如下
     *      1.替换原本的StringBuilder res ,重定义一个count用作index指针
     *      2.定义一个int[] ans = new int[Math.pow(10, n) - 1];//声明还是放到全局，但是初始化放到同一位置；
     *      3.在判断完了不是纯0的情况后面替换到原本的res.append，修改为ans[count++] = Integer.parseInt(s);
     *      其他照旧
     */
    StringBuilder res;   //结果集
    int nine = 0;        //nine记录当前出现过9的位数，用来控制左边界的更新
    int start;           //start左边界，从最右边开始往高位更新
    int n;               //n一共要生成n组数，每一位都要排列0-9
    char[] num;          // 定义长度为 n 的字符列表
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs(0);//从0位开始递归
        res.deleteCharAt(res.length() - 1);//过滤最后一个逗号
        return res.toString();
    }
    void dfs(int x) {
        if(x == n) {    // 终止条件：已固定完所有位。换句话说已经生成了一个数字是长度为n
            String s = String.valueOf(num).substring(start);// 拼接 过滤好了的 num 并添加至 res 尾部，使用逗号隔开
            if(!s.equals("0"))  //全零的情况九过滤了
                res.append(s + ",");
            if(n - start == nine) //左边界控制更新
                start--;
            return;
        }
        for(char i : loop) {
            if(i == '9')
                nine++;
            num[x] = i;     // 固定第 x 位为 i
            dfs(x + 1);  // 开启固定第 x + 1 位
        }
        nine--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}