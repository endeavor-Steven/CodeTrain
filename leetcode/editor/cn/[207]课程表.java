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
        /**
         * 换句话说 就是 判断有向图中是否有环。
         *      有环就无法完成，无环才可以
         *
         *
         * 借助一个标志列表 flags，用于判断每个节点 i （课程）的状态：
         *      i = 0, i点还没有启动过
         *      i =-1, i点第一次经过，但是没有回溯(被别的节点启动的DFS)
         *      i = 1, i点第二次经过，已经完成回溯(被当前节点启动的DFS)
         * 枚举每个点的时候，如果出现了环可以剪枝直接返回最终结果
         *
         * 具体的DFS流程：
         *      来到一个节点visit[i] = 1,递归所有凌相邻边
         *      visit[i] = -1, 则已经被其他节点搜过了。不要再重复搜索了，可以剪枝return true;
         *      visit[i] =  1, 则表示已经被本节点搜过了。但是此时依旧访问到了，那么就是有环return false且终止
         */

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] visit = new int[numCourses];      //// v[0]为搜索，v[-1]别的点搜索过，v[1]本点搜索过
            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < numCourses; i++)            ////把包含所有课程的课程数量都加进去，然后准备找出所有的后继课程情况
                edges.add(new ArrayList<>());
            for(int[] prerequisite : prerequisites)
                edges.get(prerequisite[1]).add(prerequisite[0]);//构建相邻关系  索引是预修课，值是后继课
            for (int i = 0; i < numCourses; i++) {
                if (!dfs(edges, visit, i))
                    return false;
            }
            return true;
        }
        public boolean dfs(List<List<Integer>> edges, int[] visit, int i ) {
            if (visit[i] == 1)
                return false;
            if (visit[i] == -1)
                return true;
            visit[i] = 1;
            for (int j  : edges.get(i)) {//把预修为i的课取出来。换句话说就是通过i指向j
                if(!dfs(edges, visit, j))//对下一个点进行dfs
                    return false;
            }
            visit[i] = -1;//标记为被别的点搜索过了
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}