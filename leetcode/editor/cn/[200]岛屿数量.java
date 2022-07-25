package leetcode.editor.cn;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1769 👎 0

public class NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        /**
         * 方法一：DFS
         * 思路：把二维网格看成一张表格，竖直或者水平相邻的1之间有边。
         * 线性扫描二维网格，如果一个节点包含1，则以其为启动点进行深度优先遍历，
         * 在DFS过程中，每个访问过的节点被标记为0。（DFS的目的）
         * DFS启动的次数就是岛屿的数量
         */
        if (grid == null || grid.length == 0)
            return 0;
        int rows = grid.length, cols = grid[0].length;
        int islandNum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    ++islandNum;
                    DFS(grid, i, j);
                }
            }
        }
        return islandNum;

    }
    public static void DFS(char[][] grid, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;//溢出条件
        }
        grid[row][col] = '0';//可以手动把遍历过的节点重置为0
        DFS(grid, row - 1, col);
        DFS(grid, row + 1, col);
        DFS(grid, row, col - 1);
        DFS(grid, row, col + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}