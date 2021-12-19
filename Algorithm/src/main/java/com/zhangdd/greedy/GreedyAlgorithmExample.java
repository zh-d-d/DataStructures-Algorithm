package com.zhangdd.greedy;

import java.time.temporal.ValueRange;
import java.util.*;

/**
 * @author zhangdd on 2021/12/19
 */
public class GreedyAlgorithmExample {

    private Set<String> allAreas = new HashSet<String>() {{
        add("北京");
        add("上海");
        add("天津");
        add("广州");
        add("深圳");
        add("成都");
        add("杭州");
        add("大连");
    }};


    public static void main(String[] args) {
        GreedyAlgorithmExample example = new GreedyAlgorithmExample();
        List<String> select = example.select(example.buildBroadcast(), example.allAreas);

        System.out.println(select);
    }


    private List<String> select(Map<String, Set<String>> broadcast, Set<String> allAreas) {
        List<String> result = new ArrayList<>();

        while (!allAreas.isEmpty()) {
            String tmpKey = null;

            int maxMatchSize = 0;

            Set<Map.Entry<String, Set<String>>> entries = broadcast.entrySet();
            for (Map.Entry<String, Set<String>> item : entries) {
                Set<String> tmpValue = new HashSet<>(item.getValue());
                tmpValue.retainAll(allAreas);
                if (tmpValue.size() > maxMatchSize) {
                    maxMatchSize = tmpValue.size();
                    tmpKey = item.getKey();
                }
            }

            if (null != tmpKey) {
                result.add(tmpKey);
                allAreas.removeAll(broadcast.get(tmpKey));
            }
        }

        return result;
    }

    /**
     * 构造广播电台基础信息
     */
    private Map<String, Set<String>> buildBroadcast() {
        Map<String, Set<String>> broadcast = new HashMap<>();

        broadcast.put("k1", new HashSet<String>() {{
            add("北京");
            add("上海");
            add("天津");
        }});

        broadcast.put("k2", new HashSet<String>() {{
            add("广州");
            add("北京");
            add("深圳");
        }});

        broadcast.put("k3", new HashSet<String>() {{
            add("成都");
            add("上海");
            add("杭州");
        }});

        broadcast.put("k4", new HashSet<String>() {{
            add("上海");
            add("天津");
        }});

        broadcast.put("k5", new HashSet<String>() {{
            add("杭州");
            add("大连");
        }});

        return broadcast;
    }
}
