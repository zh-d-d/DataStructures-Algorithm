package com.zhangdd.kmp;

/**
 * @author zhangdd on 2021/12/18
 * <p>
 * 暴力匹配算法
 */
public class ViolenceMatchExample {

    public static void main(String[] args) {
        String source = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";

        String target = "尚硅谷你尚硅你";

        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        int i = 0;
        int j = 0;
        int resultIndex = -1;
        while (i < sourceArray.length && j < targetArray.length) {
            if (sourceArray[i] == targetArray[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == targetArray.length) {
            resultIndex = i - j;
        }

        System.out.println("匹配到的目标位置是:" + resultIndex);
    }
}
