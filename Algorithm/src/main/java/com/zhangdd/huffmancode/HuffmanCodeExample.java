package com.zhangdd.huffmancode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangdd on 2021/11/28
 */
public class HuffmanCodeExample {

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        Map<Byte, Integer> strInfo = new HashMap<>();
        byte[] rawByteData = str.getBytes();
        //原数据字节大小
        System.out.println(rawByteData.length);
        for (int i = 0; i < rawByteData.length; i++) {
            Integer byteCount = strInfo.getOrDefault(rawByteData[i], 0);
            strInfo.put(rawByteData[i], ++byteCount);
        }
        List<HuffmanCode.Node> strNodes = strInfo.entrySet()
                .stream().map(item -> new HuffmanCode.Node(item.getKey(), item.getValue()))
                .collect(Collectors.toList());

        HuffmanCode huffman = new HuffmanCode();
        HuffmanCode.Node huffmanTree = huffman.buildHuffmanTree(strNodes);

        Map<Byte, String> huffmanCode = huffman.buildHuffmanCode(huffmanTree);
        //赫夫曼编码表
//        System.out.println(huffmanCode);
        byte[] zipData = huffman.zip(rawByteData, huffmanCode);
        //压缩后数据的字节大小
        System.out.println(zipData.length);

//        for (int i = 0; i < zipData.length; i++) {
//            System.out.println(zipData[i]);
//        }

        byte[] unzipData = huffman.unzip(zipData, huffmanCode);

        System.out.println(new String(unzipData));

    }
}
