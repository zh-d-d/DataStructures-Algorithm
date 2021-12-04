package com.zhangdd.huffmancode;

import java.util.*;


/**
 * @author zhangdd on 2021/11/28
 */
public class HuffmanCode {


    private final Map<Byte, String> code = new HashMap<>();


    /**
     * 对源数据字节数组进行压缩，压缩的规则按照指定的编码表，得到压缩后的字节数据
     */
    public byte[] zip(byte[] rawData, Map<Byte, String> codeTable) {
        StringBuilder builder = new StringBuilder();
        for (byte b : rawData) {
            String str = codeTable.getOrDefault(b, "");
            if (str.length() == 0) {
                throw new RuntimeException(String.format("在码表中没有找到%c对应的编码", b));
            }
            builder.append(str);
        }
        //将 builder包装的0，0 每8位为一组，放到一个byte数组中

        //计算下每8个一组，需要的数组长度
        int len = (builder.length() + 7) / 8;
        byte[] encipherData = new byte[len];

        String str;
        for (int i = 0; i < builder.length(); i += 8) {

            if ((i + 8) <= builder.length()) {
                str = builder.substring(i, i + 8);
            } else {
                str = builder.substring(i);
            }
            encipherData[i / 8] = (byte) Integer.parseInt(str, 2);
        }

        return encipherData;
    }

    /**
     * 将一个byte 转成一个二进制字符串
     *
     * @param flag 是否需要补高位的标志
     * @param b    需要转换的byte
     */
    private String byte2String(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        //得到tem对应的二进制补码
        String str = Integer.toBinaryString(temp);

        return flag ? str.substring(str.length() - 8) : str;
    }

    public byte [] unzip(byte[] zipData, Map<Byte, String> codeTable) {

        //对压缩数据进行展开操作
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < zipData.length; i++) {
            byte b = zipData[i];
            //最后一个需要补高位
            boolean flag = (i == zipData.length - 1);

            builder.append(byte2String(!flag, b));
        }

        //从编码表里查询展开得到的数据
        List<Byte> resultDataByte = new ArrayList<>();

        Map<String, Byte> convertCodeTable = new HashMap<>();
        codeTable.forEach((k, v) -> convertCodeTable.put(v, k));


        for (int i = 0; i < builder.length(); ) {
            int count = 1;
            String str;
            while (true) {
                if (i + count <= builder.length()) {
                    str = builder.substring(i, i + count);
                } else {
                    str = builder.substring(i);
                }
                Byte matchResult = convertCodeTable.get(str);
                if (null != matchResult) {
                    resultDataByte.add(matchResult);
                    break;
                }
                count++;
            }
            i += count;
        }

        byte[] result = new byte[resultDataByte.size()];
        for (int i = 0; i < resultDataByte.size(); i++) {
            result[i] = resultDataByte.get(i);
        }
        return result;
    }


    /**
     * 构建码表
     */
    public Map<Byte, String> buildHuffmanCode(Node root) {
        if (null == root) {
            return null;
        }

        buildHuffmanCode(root.left, 0, new StringBuilder());

        buildHuffmanCode(root.right, 1, new StringBuilder());

        return code;
    }

    private void buildHuffmanCode(Node node, int element, StringBuilder codeElement) {
        if (null == node) {
            return;
        }
        StringBuilder temp = new StringBuilder(codeElement);
        temp.append(element);
        if (null != node.data) {
            code.put(node.data, temp.toString());
            return;
        }
        buildHuffmanCode(node.left, 0, temp);
        buildHuffmanCode(node.right, 1, temp);
    }


    /**
     * 构造赫夫曼树
     */
    public Node buildHuffmanTree(List<Node> nodes) {
        if (nodes.isEmpty()) {
            throw new RuntimeException("构造赫夫曼树节点不能为空");
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.remove(0);
            Node rightNode = nodes.remove(0);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    public static class Node implements Comparable<Node> {

        private final Byte data;
        private final int weight;

        private Node left;
        private Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
