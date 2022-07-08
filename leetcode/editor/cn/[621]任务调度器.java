package leetcode.editor.cn;

//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个
//单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。 
//
// 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的 最短时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 示例 2： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 0
//输出：6
//解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//诸如此类
// 
//
// 示例 3： 
//
// 
//输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//输出：16
//解释：一种可能的解决方案是：
//     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待
//命) -> (待命) -> A
// 
//
// 
//
// 提示： 
//
// 
// 1 <= task.length <= 10⁴ 
// tasks[i] 是大写英文字母 
// n 的取值范围为 [0, 100] 
// 
// Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 👍 946 👎 0

import java.util.Arrays;

public class TaskScheduler{
    public static void main(String[] args) {
        Solution solution = new TaskScheduler().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        if (tasks.length == 1)
            return 1;
        //天才的思路， 抄来了就是我的了

        //首先，把task散列化到一个数组中（这思想其实是map），index对应字母序列， 值统计出现次数
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i] - 'A'] += 1;
        }
        //然后对map进行排序，这样子就能知道出现最多的数字的是多少个,也就是map[25]。
        Arrays.sort(map);

        //然后我们可以根据最大数字量来确定一种排列情况
        //比如n = 2, 高频字符是A且出现三次, 那么最有排序应该是Axx Axx A,
        //基于最有排序的情况可以得到执行时间和高频字符数量 来判断 最优长度的 逻辑
        int minLen = (n + 1) * (map[25] - 1) + 1;

        //然后来判断各种插入情况，我们的目的就是往x的位置来插入数据
        //1、如果剩下任务数量和A是相同的，比如ABx ABx AB,这个时候只增加了一次长度
        //2、如果剩下任务数量小于A， 则之间往x的区域插入就好了，不改变长度
        //换言之，会增加最优长度的情况只有1
        for (int i = 24; i >= 0 ;i--) {
            if (map[i] == map[25])
                ++minLen;
        }
        //然后判断一下，在上面的最优排序预留的位置插入情况
        //1、如果还没插满，比如上面预留的X， 就直接往里面放就好了，上面的情况包括了
        //2、如果插满了， 那就涉及到长度的变化。
        //      按照上面的例子ABC ABC ， 任意两个相同值之间间隔最小为n， 索引是大于等于n+1的，这个是大于冷却时间的。
        //换言之，插满的情况下，最短的排序情况应该就是task.length
        //      不能插满则取最有排列（包括预占）
        return Math.max(minLen, tasks.length);


        //如果刚好能插满，此时如果还多字母没插入，那么按照刚才的方式插入，在任意插满区间（这里是ABC）后面按序插入剩余元素，
        // 比如ABCD ABCD发现D之间距离至少为n+1，肯定满足冷却条件，此时不会申请额外的长度，此时长度最小就是tasks.size(),
        // 否则是minlen
        //举例子：A*6;B*6;C*5;D*4;E*3;F*2;n=2;
        //1、minlen=5*2+6=16;
        //2、AXX AXX AXX AXX AXX A          A=6
        //3、ABX ABX ABX ABX ABX AB         B=A=6因此minlen+=1;
        //4、ABC ABC ABC ABC ABC AB         C=A-1，刚好插满了
        //5、ABCD ABCD ABCD ABCD ABC AB     此时把D往后插入，同样满足冷却要求，此时长度超过了minlen，但这个时候每个字母之间都没有空位置
        //6、ABCDE ABCDE ABCDE ABCD ABCD ABCD ABC AB        插入E的时候同样不会多出多的空位
        //7、ABCDEF ABCDEF  ABCDE  ABCD ABCD ABCD ABC AB    插入F时不会多出空位置，长度刚好等于tasks.size()；
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}