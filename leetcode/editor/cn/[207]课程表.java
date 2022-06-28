package leetcode.editor.cn;

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1320 👎 0

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule{
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> edges;
    int [] visited;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
         * 核心操作是寻找拓扑排序。
         * 广度优先遍历，求是否存在拓扑排序
         * 基础思路
         * 建立一个数组，索引表示课程，值表示这个点在图中的入度（需要先修的入度。 为0则表示先修已经结束可以学习了）
         * 建立一个队列，将当前可以学习的课程加入队列中；建立一个结果记录学习过的课程
         *      比如先学习C1，C1出队。结果加1，则以C1为先修课程的入度全部减一，出现入度为0的值也入队。然后再出队一个，结果加1；
         *      重复上面
         */


        /**
         * 深度优先遍历解法
         * 使用栈来存储已经搜索完的节点
         * 最后从栈顶到栈底就是一种拓扑排序
         */
        visited = new int[numCourses];
        edges = new ArrayList<>();
        //边集合进行初始化，
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        //对课程关系进行遍历，info[0]是要学习的课程, info[1]是要先修的课程
        //遍历结束之后，edges中保存了若干个list， 每个list都是一条边，从一个节点指向另一个节点
        for (int[] info : prerequisites) {
            //取出edges中要对应预修课程的那条边，在后面加入要学习的课程，完成对应info0->info1
            edges.get(info[1]).add(info[0]);
        }
        //每个科目都开始准备DFS一次
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;

    }
    public void dfs(int u) {
        visited[u] = 1;//标记正在搜索
        for (int v : edges.get(u)) {//搜索所有以u开始的边
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {//当标识为假时（已经沿一条路径搜索结束），则停止DFS
                    return ;
                }
            } else if (visited[v] == 1){//点已经时搜索中的点了
                valid = false;
                return ;
            }
        }
        visited[u] = 2;//标记为已搜索完
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}