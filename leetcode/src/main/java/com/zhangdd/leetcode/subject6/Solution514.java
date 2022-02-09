package com.zhangdd.leetcode.subject6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution514 {
    /**
     * 动态规划
     *
     * 最值问题，而且有比较明显的特征，首先是找最小操作次数，然后，每次可以向左向右转
     *
     * 明确状态 + 选择，状态，也就是 需要哪些部分才能完整描述出当前场面；对于这个题，首先要知道当前圆盘指针指在哪个位置，下一个目标字符是什么(目标串还有哪些字符没处理)
     * 而选择就是，逆时针 还是 顺序针，
     *      另外，假如 下一个目标字符x在圆盘上出现多次，那么无论是逆时针还是顺时针，都会有多个选择x1，x2，
     *          这种情况不能说哪个近x1，就转哪个x1，说不定下一个字符就在x2的隔壁呢，你现在选了x1，那么下一次就要转更远的距离
     *      所以需要把后续的情况计算出来，再比较，做出选择
     *   这样的话，相当于回溯，因此需要备忘录提高效率, 自定向下的动态规划 + 备忘录
     *
     * dp[i][j] 表示 当前转盘指针指向的是rings[i],需要处理的字符是key[j...]，完成目标所需的最少操作步数
     *          当 j = key.length 时，说明处理完了。
     * dp[i][j] = Math.min(顺时针转到某个keys[j]，逆时针转到某个keys[j]) + 1(按下按钮，算1次操作)
     * @param ring
     * @param key
     * @return
     */
    // 需要记录转盘上的每个字符在转盘上的索引。
    HashMap<Character, List<Integer>> charToIndex;
    // 备忘录。
    int[][] memo;

    /**
     执行用时：7 ms,在所有 Java 提交中击败了88.06%的用户
     内存消耗：41.6 MB, 在所有 Java 提交中击败了10.87%的用户
     通过测试用例：
     303 / 303
     */
    public int findRotateSteps(String ring, String key) {
        int ringLen = ring.length(), keyLen = key.length();
        // 需要记录转盘上的每个字符在转盘上的索引。
        charToIndex = new HashMap<>();
        for (int i = 0; i < ringLen; ++i) {
            charToIndex.putIfAbsent(ring.charAt(i), new ArrayList<>());
            charToIndex.get(ring.charAt(i)).add(i);
        }
        // 备忘录。
        // 既然每一次dp是先通过变量得到结果，再给memo赋值，而不是迭代更新memo(如memo=min(memo,cur)等)，那么memo初始值为0即可。不需要初始化为MAX
        memo = new int[ringLen][keyLen];

        // 初始，指针在12:00方向，记为0位置，j=0.代表需要处理的字符为key[0...完]
        return dp(ring, 0, key, 0);
    }

    private int dp(String ring, int i, String key, int j) {
        // key已经处理完了，不用操作。返回 0
        if (j == key.length()) {
            return 0;
        }
        // 已计算过
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        // 这个字符出现在圆盘上这些位置
        List<Integer> indexes = charToIndex.get(key.charAt(j));
        // 圆盘上所有可取的位置，选择操作次数最少
        int res = Integer.MAX_VALUE;
        // 对于每一个可能位置，当前位置是 i
        // 注意 for循环内部递归调用了dp函数，而dp函数里面会对memo的值进行判断，所以这里不能边遍历，边更新memo[i][j]，否则会导致for循环没有正确执行完
        // 需要用一个变量记录每次的结果，选择最小值，for循环结束后再赋值给memo[i][j]
        // 既然是通过变量的方式给memo赋值，而不是迭代更新，那么memo初始值为0即可。不需要初始化为MAX
        for (Integer index : indexes) {
            // 如果是顺时针转过去，需要 abs(index - i) 次, 注意需要加 abs，否则从 0 位置转到 6位置怎么算
            // 如果是逆时针转过去，圆盘嘛，肯定互相对称， ringLen - abs(index - i)
            // 选择次数少的方向，
            int step = Math.abs(index - i);
            step = Math.min(step, ring.length() - step);
            // 剩余的步数
            int left = dp(ring, index, key, j + 1);
            // 选择这个位置一共要操作
            int cur = step + left + 1;
            // 在多个位置中选择最小的那个
            res = Math.min(res, cur);
        }
        // 更新备忘录
        memo[i][j] = res;
        return memo[i][j];
    }
}
