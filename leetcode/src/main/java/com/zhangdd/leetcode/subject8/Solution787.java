package com.zhangdd.leetcode.subject8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution787 {
    HashMap<Integer, List<int[]>> indegree;
    int src, dst;
    // 备忘录
    int[][] memo;
    public static void main(String[] args) {
        Solution787 solution787 = new Solution787();
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
    }

    /**
     执行用时：7 ms,
     在所有 Java 提交中击败了40.45%的用户
     内存消耗：42 MB,
     在所有 Java 提交中击败了11.27%的用户
     通过测试用例：
     50 / 50
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst,
                                 int K) {
        // 将中转站个数转化成边的条数
        K++;
        this.src = src;
        this.dst = dst;
        // 初始化备忘录，全部填⼀个特殊值
        memo = new int[n][K + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -888);
        }
        indegree = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            // 记录谁指向该节点，以及之间的权重
            indegree.putIfAbsent(to, new LinkedList<>());
            indegree.get(to).add(new int[]{from, price});
        }
        return dp(dst, K);
    }
    // 定义：从 src 出发，k 步之内到达 s 的最短路径权重
    int dp(int s, int k) {
        // base case
        if (s == src) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        // 查备忘录，防⽌冗余计算
        if (memo[s][k] != -888) {
            return memo[s][k];
        }
        // 初始化为最⼤值，⽅便等会取最⼩值
        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)) {
            // 当 s 有⼊度节点时，分解为⼦问题
            for (int[] v : indegree.get(s)) {
                int from = v[0];
                int price = v[1];
                // 从 src 到达相邻的⼊度节点所需的最短路径权重
                int subProblem = dp(from, k - 1);
                // 跳过⽆解的情况
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        // 存⼊备忘录
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }
}
