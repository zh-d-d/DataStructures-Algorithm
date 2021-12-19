package com.zhangdd.kmp;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/12/18
 */
public class KMPAlgorithmExample {

    public static void main(String[] args) {
        KMPAlgorithmExample example = new KMPAlgorithmExample();

        String source = "BBC ABCDAB ABCDABCDABDE";
        String target = "ABCDABD";

        System.out.println(example.match(source, target, example.matchTable(target)));
    }

    private int match(String source, String target, int[] matchTable) {
        int sourceIndex = 0;
        int targetIndex = 0;
        int matchNum = 0;

        while (sourceIndex < source.length() && targetIndex < target.length()) {

            char sourceChar = source.charAt(sourceIndex);
            char targetChar = target.charAt(targetIndex);
            if (sourceChar == targetChar) {
                sourceIndex++;
                targetIndex++;
                matchNum++;
            } else {
                if (matchNum == 0) {
                    sourceIndex = sourceIndex - targetIndex + 1;
                } else {
                    //移动位数= 已匹配的字符数 - 对应的部分匹配值
                    //即 (matchNum - matchTable[matchNum - 1])
                    sourceIndex = sourceIndex - targetIndex + (matchNum - matchTable[matchNum - 1]);
                }
                targetIndex = 0;
                matchNum = 0;
            }
        }
        int resultIndex = -1;
        if (targetIndex == target.length()) {
            resultIndex = sourceIndex - targetIndex;
        }

        return resultIndex;
    }


    /**
     * 获取目标串的部分匹配表
     */
    private int[] matchTable(String targetStr) {

        int[] result = new int[targetStr.length()];
        for (int i = 0; i < targetStr.length(); i++) {
            String[] prefix = getPrefix(targetStr.substring(0, i + 1));
            String[] suffix = getSuffix(targetStr.substring(0, i + 1));

            int comEleLength = 0;
            for (String value : prefix) {
                for (String s : suffix) {
                    if (value.equals(s) && value.length() > comEleLength) {
                        comEleLength = value.length();
                        break;
                    }
                }
            }

            result[i] = comEleLength;
        }
        return result;
    }

    /**
     * 获取字符串前缀
     */
    private String[] getPrefix(String str) {
        if (null == str || str.length() == 0) {
            return new String[0];
        }

        String[] result = new String[str.length() - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = str.substring(0, i + 1);
        }
        return result;
    }

    /**
     * 获取字符串后缀
     */
    private String[] getSuffix(String str) {
        if (null == str || str.length() == 0) {
            return new String[0];
        }
        String[] result = new String[str.length() - 1];
        for (int i = 1; i < str.length(); i++) {
            result[i - 1] = str.substring(i);
        }
        return result;
    }
}
