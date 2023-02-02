package com.zhangdd.leetcode.problem.part02.problem0146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhangdd on 2023/2/2
 *
 * <a href="https://leetcode.cn/problems/lru-cache/description/">题目描述</a>
 */
public class Solution146 {

    class LRUCache {
        private int capacity;

        private Map<Integer, Integer> data;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            data = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (data.containsKey(key)) {
                int value = data.get(key);

                //保证最近使用的放到一端
                data.remove(key);
                data.put(key, value);

                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (data.containsKey(key)) {

                //保证最新的放到一端
                data.remove(key);
                data.put(key, value);

            } else {
                while (data.size() >= this.capacity) {
                    //删除第一个元素
                    data.remove(data.entrySet().iterator().next().getKey());
                }
                data.put(key, value);
            }
        }
    }
}
