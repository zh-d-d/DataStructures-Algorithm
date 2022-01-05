package com.zhangdd.kmp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author mcq on 2022/01/05
 */
public class SlideWindowExample {
    Map<Character, Integer> needs = new HashMap<Character, Integer>();
    Map<Character, Integer> window = new HashMap<Character, Integer>();

    public static void main(String[] args) {
        SlideWindowExample slideWindow = new SlideWindowExample();
        System.out.println("EBBANCF"+":"+"ABC"+"-"+slideWindow.minWindow("EBBANCF","ABC"));
    }

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && needs.containsKey(s.charAt(r))) {
                window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                System.out.print("check() "+ansL+":"+ansR+"--"+l+":"+r+"\t");
                if (needs.containsKey(s.charAt(l))) {
                    window.put(s.charAt(l), window.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
            System.out.println(ansL+":"+ansR+"--"+l+":"+r);
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = needs.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (window.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
