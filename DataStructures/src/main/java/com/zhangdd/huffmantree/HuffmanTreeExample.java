package com.zhangdd.huffmantree;

/**
 * @author zhangdd on 2021/11/28
 */
public class HuffmanTreeExample {

    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTree huffmanTree = new HuffmanTree();
        HuffmanTree.Node treeNode = huffmanTree.buildHuffmanTree(arr);

        huffmanTree.priOrder(treeNode);
    }
}
