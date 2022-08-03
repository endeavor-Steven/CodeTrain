package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 646 👎 0

public class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {
//hot100的79题
    public boolean exist(char[][] board, String word) {
        //回溯2，此方法各项开销优于1
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (DFS(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    boolean DFS(char[][] board, char[] words, int x, int y, int curr) {
        if ( x >= board.length || x < 0 || y < 0 || y >= board[0].length || board[x][y] != words[curr])
            return false;
        if (curr == words.length - 1)
            return true;
        board[x][y] = '\0';
        boolean tackRes =
                DFS(board, words, x + 1, y, curr + 1) ||
                        DFS(board, words, x - 1, y, curr + 1) ||
                        DFS(board, words, x, y + 1, curr + 1) ||
                        DFS(board, words, x, y - 1, curr + 1);
        board[x][y] = words[curr];
        return tackRes;
    }
}
class Solution {
    public boolean exist(char[][] board, String word) {
        /**
         * 方法一：回溯，时间开销大，空间开销小
         * uesd[][]用来标识当前位置是否使用过
         * 回溯出口，长度达到则成功，出现不匹配则失败
         * 枚举四种动作，更新后的位置，在合理范围内进行回溯递归，逐层回归递归结果
         */
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];//默认是false

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = check(board, i, j, used, word, 0);
                if (flag)
                    return true;
            }
        }
        return false;
    }
    public boolean check(char[][] board, int i, int j, boolean[][] used, String word, int k) {
        if (board[i][j] != word.charAt(k))
            return false;
        if (k == word.length() - 1)
            return true;
        used[i][j] = true;
        boolean ans = false;
        int[][] actions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] action : actions) {
            int newI = i + action[0], newJ = j + action[1];
            if (0 <= newI && newI < board.length && 0 <= newJ && newJ < board[0].length) {
                if (!used[newI][newJ]) {
                    boolean flag = check(board, newI, newJ, used, word, k+1);
                    if (flag) {
                        ans = true;
                        break;
                    }
                }
            }
        }
        used[i][j] = false;
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}